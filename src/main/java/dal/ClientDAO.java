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
}
