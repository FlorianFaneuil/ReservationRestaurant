package controler.profil;

import java.io.IOException;

import bll.BLLException;
import bll.ClientBLL;
import bo.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClientBLL clientBLL;

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			clientBLL = new ClientBLL();
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Etape 1 : recuperer les parametres
//		String idStr = request.getParameter("id");

//		if (idStr != null && !idStr.isEmpty()) {
		// Etape 2 : passage dans le bon type
//			int id = Integer.parseInt(idStr);

		// Etape 3 : exploitation des parametres par le bll
		try {
			Client client = clientBLL.selectById(1);

			// Etape 4 : ajout des attributs a la requete
			request.setAttribute("client", client);
		} catch (BLLException e) {
			e.printStackTrace();
		}

		// Etape 5 : redirection vers la jsp
		request.getRequestDispatcher("/WEB-INF/jsp/connecte/modifierProfil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Etape 1 : recuperer les parametres
//		String idStr = request.getParameter("id");
		String nomStr = request.getParameter("nom");
		String prenomStr = request.getParameter("prenom");
		String emailStr = request.getParameter("email");
		String passwordStr = request.getParameter("password");

//		if (idStr != null && !idStr.isEmpty()) {
		// Etape 2 : passage dans le bon type
//		int id = Integer.parseInt(idStr);

		// Etape 3 : exploitation des parametres par le bll
		try {
			// Je recupere mon contact en base de donnees
			Client clientAModifier = clientBLL.selectById(1);

			// Je mets a jour toutes ses informations (cote java)
			clientAModifier.setNom(nomStr);
			clientAModifier.setPrenom(prenomStr);
			clientAModifier.setEmail(emailStr);
			clientAModifier.setPassword(passwordStr);

			// J'enregistre ces modifications aupres de la base de donnees
			clientBLL.update(clientAModifier);
//			response.sendRedirect("details?id=" + 1);
		} catch (BLLException e) {
			e.printStackTrace();
			request.setAttribute("erreur", e);
		}
		response.sendRedirect("profil");
	}

	// Etape 4 : ajout des attributs a la requete

	// Etape 5 : redirection vers la jsp
}
