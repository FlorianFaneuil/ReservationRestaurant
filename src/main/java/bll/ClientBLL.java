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

	public void delete(int id) throws BLLException {
		try {
			clientDAO.delete(id);
		} catch (DALException e) {
			throw new BLLException("Echec de la suppression du client d'id" + id, e);
		}
	}
}
