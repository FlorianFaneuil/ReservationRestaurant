package bo;

public class Employe {

	private int id;
	private Restaurant restaurant;
	private String nom;
	private String prenom;
	private String email;
	private String password;

	public Employe() {
	}

	public Employe(Restaurant restaurant, String nom, String prenom, String email, String password) {
		this.restaurant = restaurant;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
	}

	public Employe(int id, Restaurant restaurant, String nom, String prenom, String email, String password) {

		this.id = id;
		this.restaurant = restaurant;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
