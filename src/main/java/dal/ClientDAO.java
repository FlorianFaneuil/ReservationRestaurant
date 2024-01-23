package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bo.Client;
import bo.Restaurant;
import dal.ConnectionProvider;
import dal.DALException;

public class ClientDAO {
	private static final String TABLE_NAME = " clients ";
	private static final String SELECT_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
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
}
