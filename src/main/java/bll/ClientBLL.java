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

		BLLException blleException = new BLLException();

		if (nom.length() < 2) {
			blleException.ajouterErreur("Le nom du restaurant doit faire au moins 2 caractères");
		}

		if (nom.length() > 100) {
			blleException.ajouterErreur("Le nom doit faire maximum 100 caractères");
		}

		Client client = new Client(nom, prenom, email, password);
		try {
			 return clientDAO.insert(client);
		} catch (DALException e) {
			throw new BLLException("Echec de l'insertion", e);
		}
	}

}
