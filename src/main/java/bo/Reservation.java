package bo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation {
	private int id;
	private int idRestaurant;
	private int idClient;
	private int idTable;
	private LocalDate dateResa;
	private LocalTime heureResa;
	private String etat;

	public Reservation() {
	}
	
	public Reservation(int idRestaurant, int idClient, LocalDate dateResa, LocalTime heureResa,
			String etat) {
		this.idRestaurant = idRestaurant;
		this.idClient = idClient;
		this.dateResa = dateResa;
		this.heureResa = heureResa;
		this.etat = etat;
	}

	
	public Reservation(int idRestaurant, int idClient, int idTable, LocalDate dateResa, LocalTime heureResa,
			String etat) {
		this.idRestaurant = idRestaurant;
		this.idClient = idClient;
		this.idTable = idTable;
		this.dateResa = dateResa;
		this.heureResa = heureResa;
		this.etat = etat;
	}

	public Reservation(int id, int idRestaurant, int idClient, int idTable, LocalDate dateResa, LocalTime heureResa,
			String etat) {
		this.id = id;
		this.idRestaurant = idRestaurant;
		this.idClient = idClient;
		this.idTable = idTable;
		this.dateResa = dateResa;
		this.heureResa = heureResa;
		this.etat = etat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdRestaurant() {
		return idRestaurant;
	}

	public void setIdRestaurant(int idRestaurant) {
		this.idRestaurant = idRestaurant;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public int getIdTable() {
		return idTable;
	}

	public void setIdTable(int idTable) {
		this.idTable = idTable;
	}

	public LocalDate getDateResa() {
		return dateResa;
	}

	public void setDateResa(LocalDate dateResa) {
		this.dateResa = dateResa;
	}

	public LocalTime getHeureResa() {
		return heureResa;
	}

	public void setHeureResa(LocalTime heureResa) {
		this.heureResa = heureResa;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

}
