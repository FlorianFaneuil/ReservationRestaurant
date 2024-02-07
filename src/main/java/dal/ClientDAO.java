package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import bo.Client;

public class ClientDAO {
	private static final String TABLE_NAME = " clients ";
	private static final String SELECT_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
	private static final String UPDATE = "UPDATE " + TABLE_NAME
			+ " SET nom = ?, prenom = ?, email = ? , password = ?  WHERE id = 1";
	private static final String DELETE = "DELETE FROM" + TABLE_NAME + " WHERE id = ?";
	private static final String INSERT = "INSERT INTO " + TABLE_NAME
			+ " (nom, prenom, email, password) VALUES (?,?,?,?)";

	private static final String SELECT_BY_EMAIL_PASSWORD = "SELECT * FROM " + TABLE_NAME
			+ " WHERE email = ? AND password = ?";
	
	private static final String FIND_EMAIL = " SELECT COUNT(*) AS count FROM " + TABLE_NAME + " WHERE email = ?";

	private Connection cnx;

	public ClientDAO() throws DALException {
		cnx = ConnectionProvider.getConnection();
	}

	public Client selectById(int id) throws DALException {
		Client client = null;
		try {
			PreparedStatement ps = cnx.prepareStatement(SELECT_BY_ID);
			ps.setInt(1, id); // Remplace le '?' numero 1 par la valeur de l'id
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				client = new Client();
				client.setId(rs.getInt("id"));
				client.setNom(rs.getString("nom"));
				client.setPrenom(rs.getString("prenom"));
				client.setEmail(rs.getString("email"));
				client.setPassword(rs.getString("password"));

			}
			if (client == null)
				throw new DALException("Aucun client ne porte cet ID", null);
		} catch (SQLException e) {
			throw new DALException("Impossible de recuperer les informations pour l'id " + id, e);
		}
		return client;
	}

	public void update(Client client) throws DALException {
		try {
			PreparedStatement ps = cnx.prepareStatement(UPDATE);
			ps.setString(1, client.getNom());
			ps.setString(2, client.getPrenom());
			ps.setString(3, client.getEmail());
			ps.setString(4, client.getPassword());

			// ps.setInt(5, client.getId());

			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Impossible de mettre a jour les informations pour l'id " + client.getId(), e);
		}
	}

	public Client SelectByEmailPassword(String email, String password) throws DALException {
		Client client = null;
		try {
			PreparedStatement ps = cnx.prepareStatement(SELECT_BY_EMAIL_PASSWORD);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				client = new Client();
				client.setId(rs.getInt("id"));
				client.setNom(rs.getString("nom"));
				client.setPrenom(rs.getString("prenom"));
				client.setEmail(rs.getString("email"));
				client.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			throw new DALException("Impossible de recuper l'information pour l'email ", e);
		}
		return client;
	}

	public void delete(int id) throws DALException {
		try {
			PreparedStatement ps = cnx.prepareStatement(DELETE);
			ps.setInt(1, id);
			int nbLignesSupprimees = ps.executeUpdate();
			if (nbLignesSupprimees == 0) {
				throw new DALException("Echec de suppression du client d'id " + id, null);
			}
		} catch (SQLException e) {
			throw new DALException("Impossible de supprimer le client d'id " + id, e);
		}

	}

	public Client insert(Client client) throws DALException {
		try {
			// L'ajout de RETURN_GENERATED_KEYS permet de récupérer l'id généré par la base
			PreparedStatement ps = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, client.getNom());
			ps.setString(2, client.getPrenom());
			ps.setString(3, client.getEmail());
			ps.setString(4, client.getPassword());

			ps.executeUpdate();

			// Le bloc suivant permet de faire la récupération de l'id
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) { // Va chercher dans le resultat, la première ligne
				int id = rs.getInt(1); // plus précisément, le int à la première colonne
				client.setId(id);
			}
		} catch (SQLException e) {
			throw new DALException("Impossible d'inserer les donnees.", e);
		}
		return client;
	}
	
//	public Boolean emailExists(String email) throws DALException {
//		 boolean exists = false;
//		try {
//			
//			PreparedStatement ps = cnx.prepareStatement( FIND_EMAIL);
//			ResultSet rs = ps.executeQuery();
//			ps.setString(1, email);
//			
//			if (rs.next()) {
//                int count = rs.getInt("count");
//                exists = count > 0;
//            }
//			
//		} catch (SQLException e) {
//            throw new DALException("Erreur lors de la vérification de l'existence de l'email", e);
//        
//        }
//        
//        return exists;
//
//		}
	
	public Boolean emailExists(String email) throws DALException {
	    boolean exists = false;
	    try (PreparedStatement ps = cnx.prepareStatement(FIND_EMAIL)) {
	        ps.setString(1, email);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next() && rs.getInt(1) > 0) {
	                exists = true;
	            }
	        }
	    } catch (SQLException e) {
	        throw new DALException("Erreur lors de la vérification de l'existence de l'email", e);
	    }
	    return exists;
	}

	
	
	
	
	
	
	
	
}
