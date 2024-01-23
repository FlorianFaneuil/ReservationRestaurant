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
			throw new BLLException("Echec de la recuperation du composant d'id " + id, e);
		}
	}
}
