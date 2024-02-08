package bo;

public class Message {
	private int id;
	private String titre;
	private String contenu;
	private Client client;
	private Employe employe;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Message() {
	}

	public Message(String titre, String contenu, Client client, Employe employe) {
		this.titre = titre;
		this.contenu = contenu;
		this.client = client;
		this.employe = employe;
	}

	public Message(int id, String titre, String contenu, Client client, Employe employe) {
		this.id = id;
		this.titre = titre;
		this.contenu = contenu;
		this.client = client;
		this.employe = employe;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", titre=" + titre + ", contenu=" + contenu + ", client=" + client + ", employe="
				+ employe + "]";
	}

}
