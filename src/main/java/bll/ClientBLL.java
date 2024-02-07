package bll;

import bo.Client;
import dal.ClientDAO;
import dal.DALException;

public class ClientBLL {
	private ClientDAO clientDAO;

	public ClientBLL() throws BLLException {
		try {
			clientDAO = new ClientDAO();
		} catch (DALException e) {
			throw new BLLException("Echec de la connexion à la BLL client DAO oupsi", e);
		}
	}

	public Client selectById(int id) throws BLLException {
		try {
			return clientDAO.selectById(id);
		} catch (DALException e) {
			throw new BLLException("Echec de la recuperation du client d'id " + id, e);
		}
	}

	public Client update(Client client) throws BLLException {

		try {
			clientDAO.update(client);
		} catch (DALException e) {
			throw new BLLException("Echec de la mise a jour", e);
		}
		return client;
	}

	public Client SelectByEmailPassword(String email, String password) throws BLLException {
		try {
			return clientDAO.SelectByEmailPassword(email, password);
		} catch (DALException e) {
			throw new BLLException("Eche de l'autentification ", e);
		}
	}

	public void delete(int id) throws BLLException {
		try {
			clientDAO.delete(id);
		} catch (DALException e) {
			throw new BLLException("Echec de la suppression du client d'id" + id, e);
		}
	}

	public Client insert(String nom, String prenom, String email, String password) throws BLLException {

		BLLException bllException = new BLLException();

		if (nom.length() < 2 || nom.length() > 100) {
			bllException.ajouterErreur("Le nom doit faire entre 2 et 100 caractères");
		}

		if (prenom.length() < 2 || prenom.length() > 100) {
			bllException.ajouterErreur("Le prénom doit faire entre 2 et 100 caractères");
		}

		try {
			if (clientDAO.emailExists(email)) {
				bllException.ajouterErreur("L'email existe déjà dans la base de données");
				throw bllException;
			}
		} catch (DALException e) {
			throw new BLLException("Erreur lors de la vérification de l'existence de l'email", e);
		}

		Client client = new Client(nom, prenom, email, password);
		try {
			return clientDAO.insert(client);
		} catch (DALException e) {
			throw new BLLException("Echec de l'insertion", e);
		}
	}

}
