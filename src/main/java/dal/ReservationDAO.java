package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import bo.Reservation;

public class ReservationDAO {
	private static final String TABLE_NAME = " reservations ";

	private static final String SELECT = "SELECT * FROM " + TABLE_NAME;
	private static final String INSERT = "INSERT INTO " + TABLE_NAME
			+ " (id_restaurant, id_client, date, heure, etat) VALUES (?,?,?,?,?)";
	private static final String SELECT_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
	private static final String UPDATE = "UPDATE " + TABLE_NAME + " SET etat = ? WHERE id = ?";
	private static final String DELETE = "DELETE FROM" + TABLE_NAME + " WHERE id = ?";

	private Connection cnx;

	public ReservationDAO() throws DALException {
		cnx = ConnectionProvider.getConnection();
	}

	public List<Reservation> selectAll() throws DALException {
		List<Reservation> reservations = new ArrayList<>();
		// alt + shift + r pour renommer partout

		try {
			PreparedStatement ps = cnx.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Reservation reservation = new Reservation();
				reservation.setId(rs.getInt("id"));
				reservation.setIdRestaurant(rs.getInt("id_restaurant"));
				reservation.setIdClient(rs.getInt("id_client"));
				reservation.setIdTable(rs.getInt("id_client"));
				reservation.setDateResa(rs.getDate("date").toLocalDate());
				reservation.setHeureResa(rs.getTime("heure").toLocalTime());
				reservation.setEtat(rs.getString("etat"));

				reservations.add(reservation);
			}
		} catch (SQLException e) {
			throw new DALException("Impossible de recuperer les informations", e);
		}
		return reservations;
	}

	public void insert(Reservation reservation) throws DALException {
		try {
			// L'ajout de RETURN_GENERATED_KEYS permet de récupérer l'id généré par la base
			PreparedStatement ps = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, reservation.getIdRestaurant());
			ps.setInt(2, reservation.getIdClient());
			ps.setDate(3,Date.valueOf(reservation.getDateResa()));
			ps.setTime(4, Time.valueOf(reservation.getHeureResa()));
			ps.setString(5, reservation.getEtat()); // Par défaut lors de la créaton de la réservation elle est en attente
			ps.executeUpdate();

			// Le bloc suivant permet de faire la récupération de l'id
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) { // Va chercher dans le resultat, la première ligne
				int id = rs.getInt(1); // plus précisément, le int à la première colonne
				reservation.setId(id);
			}
		} catch (SQLException e) {
			throw new DALException("Impossible d'inserer les donnees.", e);
		}
	}

	public Reservation selectById(int id) throws DALException {
		Reservation reservation = null;
		try {
			PreparedStatement ps = cnx.prepareStatement(SELECT_BY_ID);
			ps.setInt(1, id); // Remplace le '?' numero 1 par la valeur de l'id
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				reservation = new Reservation();
				reservation.setId(rs.getInt("id"));
				reservation.setIdRestaurant(rs.getInt("id_restaurant"));
				reservation.setIdClient(rs.getInt("id_client"));
				reservation.setIdTable(rs.getInt("id_client"));
				reservation.setDateResa(rs.getDate("date").toLocalDate());
				reservation.setHeureResa(rs.getTime("heure").toLocalTime());
				reservation.setEtat(rs.getString("etat"));
			}
			if (reservation == null)
				throw new DALException("Aucun reservation ne porte cet ID", null);
		} catch (SQLException e) {
			throw new DALException("Impossible de recuperer les informations pour l'id " + id, e);
		}
		return reservation;
	}

	public void update(Reservation reservation) throws DALException {
		try {
			PreparedStatement ps = cnx.prepareStatement(UPDATE);
			ps.setString(1, reservation.getEtat());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Impossible de mettre a jour les informations pour l'id " + reservation.getId(), e);
		}
	}

	public void delete(int id) throws DALException {
		try {
			PreparedStatement ps = cnx.prepareStatement(DELETE);
			ps.setInt(1, id);
			int nbLignesSupprimees = ps.executeUpdate();
			if (nbLignesSupprimees == 0) {
				throw new DALException("Echec de suppression du reservation d'id " + id, null);
			}
		} catch (SQLException e) {
			throw new DALException("Impossible de supprimer le reservation d'id " + id, e);
		}
	}
}
