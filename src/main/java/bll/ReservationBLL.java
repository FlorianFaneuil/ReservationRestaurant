package bll;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import bo.Reservation;
import bo.Restaurant;
import bo.Table;
import dal.DALException;
import dal.ReservationDAO;

public class ReservationBLL {

	private ReservationDAO dao;

	public ReservationBLL() throws BLLException {
		try {
			dao = new ReservationDAO();
		} catch (DALException e) {
			throw new BLLException("Echec de la connexion", e);
		}
	}

	public List<Reservation> selectAll() throws BLLException {
		try {
			return dao.selectAll();
		} catch (DALException e) {
			throw new BLLException("Echec de la recuperation des Reservations", e);
		}
	}

	public Reservation insert(Restaurant restaurant, int idClient, Table table, LocalDate dateResa, LocalTime heureResa, String etat)
			throws BLLException {

		BLLException blleException = new BLLException();

		if (dateResa.isBefore(LocalDate.now())) {
			blleException.ajouterErreur("La date de la reservation ne peut pas être anterieure a la date du jour");
		}

		if (heureResa.isBefore(restaurant.getHeureOuverture())) {
			blleException.ajouterErreur("L'heure de reservation ne peut pas etre anterieure a l'heure d'ouverture du restaurant");
		}
		
		if (heureResa.isAfter(restaurant.getHeureFermeture())) {
			blleException.ajouterErreur("L'heure de reservation ne peut pas etre posterieure a l'heure de fermeture du restaurant");
		}
		
		if (blleException.getErreurs().size() > 0) {
			throw blleException;
		}

		Reservation reservation = new Reservation(restaurant.getId(), idClient, table.getId(), dateResa, heureResa, etat);
		try {
			dao.insert(reservation);
		} catch (DALException e) {
			throw new BLLException("Echec de l'insertion", e);
		}
		return reservation;
	}

	public Reservation selectById(int id) throws BLLException {
		try {
			return dao.selectById(id);
		} catch (DALException e) {
			throw new BLLException("Echec de la recuperation de la reservation d'id " + id, e);
		}
	}

	public void update(Reservation reservation) throws BLLException {
		BLLException blleException = new BLLException();

		if (reservation.getEtat().isBlank() || reservation.getEtat().isEmpty()) {
			blleException.ajouterErreur("Vous devez selectionner un état : LIBRE / PRESENT / RESERVEE");
		}
		
		if (blleException.getErreurs().size() > 0) {
			throw blleException;
		}

		try {
			dao.update(reservation);
		} catch (DALException e) {
			throw new BLLException("Echec de la mise a jour", e);
		}
	}

	public void delete(int id) throws BLLException {
		try {
			dao.delete(id);
		} catch (DALException e) {
			throw new BLLException("Echec de la suppression", e);
		}
	}
}
