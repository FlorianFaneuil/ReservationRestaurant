package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.Client;
import bo.Employe;
import bo.Message;

public class MessageDAO {
	private static final String SELECT = "SELECT messages.*, clients.*, employes.id as employe_id, employes.prenom as employe_prenom  " +
            "FROM messages " +
            "JOIN clients ON messages.id_client = clients.id " +
            "JOIN employes ON messages.id_employe = employes.id";


	private static final String INSERT = "INSERT INTO messages ( titre, contenu, id_client, id_employe) VALUES (?,?,?,?)";

	private Connection cnx;

	public MessageDAO() throws DALException {
		cnx = ConnectionProvider.getConnection();
	}

	public List<Message> selectAll() throws DALException {
		List<Message> messages = new ArrayList<>();

		try {
			PreparedStatement ps = cnx.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Message message = new Message();
				Employe employe = new Employe();
				Client client = new Client();

				message.setId(rs.getInt("id"));
				message.setTitre(rs.getString("titre"));
				message.setContenu(rs.getString("contenu"));
				
				// Client
                client.setId(rs.getInt("id_client"));

                // Employe
                employe.setId(rs.getInt("id_employe"));
             
                employe.setPrenom(rs.getString("employe_prenom"));
                
                message.setClient(client);
                message.setEmploye(employe);

				messages.add(message);
			}
		} catch (SQLException e) {
			throw new DALException("Impossible de récupération les informations", e);
		}
		return messages;
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
