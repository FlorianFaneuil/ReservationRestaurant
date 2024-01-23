package bll;

import bo.Client;
import bo.Employe;
import bo.Message;
import dal.DALException;
import dal.MessageDAO;

public class MessageBLL {
	private MessageDAO messageDAO;

	public MessageBLL() throws BLLException {
		try {
			messageDAO = new MessageDAO();
		} catch (DALException e) {
			throw new BLLException("Echec de la connexion", e);
		}
	}

	public Message insert(String titre, String contenu, Client id_client, Employe id_employe) throws BLLException {
		/*
		 * Plein de contr�les certainement tres pertinents sur les donnees
		 */
		Message message = new Message(titre, contenu, id_client, id_employe);
		try {
			messageDAO.insert(message);
		} catch (DALException e) {
			throw new BLLException("Echec de l'insertion", e);
		}
		return message;
	}
}