package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.Employe;
import bo.Restaurant;

public class EmployeDAO {
	private static final String TABLE_NAME = "employes";
	private static final String SELECT_BY_ID = "SELECT * FROM employes WHERE id = ?";
	private static final String SELECT_BY_PRENOM = "SELECT * FROM employes WHERE prenom = ?";
	private static final String SELECT = "SELECT * FROM " + TABLE_NAME;
	private Connection cnx;

	public EmployeDAO() throws DALException {
		cnx = ConnectionProvider.getConnection();
	}

	public Employe selectById(int id) throws DALException {
		Employe employe = null;

		try {
			PreparedStatement ps = cnx.prepareStatement(SELECT_BY_ID);
			ps.setInt(1, id); // Remplace le '?' num�ro 1 par la valeur de l'id
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				employe = new Employe();
				Restaurant restaurant = new Restaurant();

				employe.setId(rs.getInt("id"));
				restaurant.setId(rs.getInt("id_restaurant"));
				employe.setNom(rs.getString("nom"));
				employe.setPrenom(rs.getString("prenom"));
				employe.setEmail(rs.getString("email"));
				employe.setPassword(rs.getString("password"));

			}
			if (employe == null)
				throw new DALException("Aucun carte ne porte cet ID", null);

		} catch (SQLException e) {
			throw new DALException("Impossible de recuperer les informations pour l'id " + id, e);
		}
		return employe;
	}

	public Employe selectByPrenom(String prenom) throws DALException {
		Employe employe = null;
		try {
			PreparedStatement ps = cnx.prepareStatement(SELECT_BY_PRENOM);
			ps.setString(1, prenom); // Remplace le '?' num�ro 1 par la valeur de l'id
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				employe = new Employe();
				Restaurant restaurant = new Restaurant();

				employe.setPrenom(rs.getString("prenom"));
				employe.setNom(rs.getString("nom"));
				employe.setId(rs.getInt("id"));
				restaurant.setId(rs.getInt("id_restaurant"));
				employe.setEmail(rs.getString("email"));
				employe.setPassword(rs.getString("password"));

			}
			if (employe == null)
				throw new DALException("Aucun employe ne porte ce nom", null);

		} catch (SQLException e) {
			throw new DALException("Impossible de recuperer les informations pour l'employe  " + prenom, e);
		}

		return employe;
	}
	 public List<Employe> selectAll() throws DALException {
	        List<Employe> employes = new ArrayList<>();

	        try {
	            PreparedStatement ps = cnx.prepareStatement(SELECT);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                Employe employe = new Employe();
	                Restaurant restaurant = new Restaurant();

	                employe.setId(rs.getInt("id"));
	                restaurant.setId(rs.getInt("id_restaurant"));
	                employe.setNom(rs.getString("nom"));
	                employe.setPrenom(rs.getString("prenom"));
	                employe.setEmail(rs.getString("email"));
	                employe.setPassword(rs.getString("password"));

	                employes.add(employe);
	            }
	        } catch (SQLException e) {
	            throw new DALException("Impossible de récupérer la liste des employés", e);
	        }

	        return employes;
	    }
	}


