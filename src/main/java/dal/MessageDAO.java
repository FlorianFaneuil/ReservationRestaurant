package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bo.Message;

public class MessageDAO {
	private static final String INSERT = "INSERT INTO messages ( titre, contenu, id_client, id_employe) VALUES (?,?,?,?)";

	private Connection cnx;

	public MessageDAO() throws DALException {
		cnx = ConnectionProvider.getConnection();
	}

	public void insert(Message message) throws DALException {
		try {
			PreparedStatement ps = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, message.getTitre());
			ps.setString(2, message.getContenu());
			ps.setInt(3, message.getClient().getId());
			ps.setInt(4, message.getEmploye().getId());
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				message.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			throw new DALException("Impossible d'inserer le message oups.", e);
		}
	}
}
