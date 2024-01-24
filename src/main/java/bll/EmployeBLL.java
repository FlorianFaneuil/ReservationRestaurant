package bll;

import bo.Employe;
import dal.DALException;
import dal.EmployeDAO;

public class EmployeBLL {
	private EmployeDAO employeDAO;

	public EmployeBLL() throws BLLException, DALException {
		employeDAO = new EmployeDAO();
	}

	public Employe selectById(int id) throws BLLException {
		try {
			return employeDAO.selectById(id);
		} catch (DALException e) {
			throw new BLLException("Echec de la recuperation de l'employe d'id " + id, e);
		}
	}

	public Employe selectByPrenom(String nom) throws BLLException {
		try {
			return employeDAO.selectByPrenom(nom);
		} catch (DALException e) {
			throw new BLLException("Echec de la recuperation de l'employe de nom  " + nom, e);
		}
	}
}
