package bll;

import java.util.ArrayList;
import java.util.List;

public class BLLException extends Exception {
	private static final long serialVersionUID = 1L;
	private String erreurDate;
	private String erreurHeureAnterieure;
	private String erreurHeurePosterieure;
	private int nbErreurs = 0;
	

	private List<String> erreurs = new ArrayList<>();

	public BLLException(String message, Throwable cause) {
		super(message, cause);
	}

	public BLLException() {

	}

	public void ajouterErreur(String erreur) {
		erreurs.add(erreur);
	}

	public List<String> getErreurs() {
		return erreurs;
	}
	
	public String getErreurDate() {
		return erreurDate;
	}

	public void setErreurDate(String erreurDate) {
		nbErreurs++;
		this.erreurDate = erreurDate;
	}
	
	
	public String getErreurHeureAnterieure() {
		return erreurHeureAnterieure;
	}

	public void setErreurHeureAnterieure(String erreurHeureAnterieure) {
		nbErreurs++;
		this.erreurHeureAnterieure = erreurHeureAnterieure;
	}
	
	public String getErreurHeurePosterieure() {
		return erreurHeurePosterieure;
	}

	public void setErreurHeurePosterieure(String erreurHeurePosterieure) {
		nbErreurs++;
		this.erreurHeurePosterieure = erreurHeurePosterieure;
	}
	
	public int getNbErreurs() {
		return nbErreurs;
	}

	public void setNbErreurs(int nbErreurs) {
		this.nbErreurs = nbErreurs;
	}	
}