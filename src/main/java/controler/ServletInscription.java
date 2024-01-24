package controler;

import java.io.IOException;

import bll.BLLException;
import bll.ClientBLL;
import bo.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClientBLL clientBLL;
	Boolean estConnecte;

	@Override
	public void init() throws ServletException {

		try {
			clientBLL = new ClientBLL();
		} catch (BLLException e) {

			e.printStackTrace();
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/nonConnecte/inscription.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Client clientCreer = null;

		try {
			clientCreer = clientBLL.insert(nom, prenom, email, password);
			estConnecte = true;
//			request.getServletContext().setAttribute("idClient", clientCreer.getId());
//			request.getServletContext().setAttribute("nomClient", clientCreer.getNom());
//			request.getServletContext().setAttribute("prenomClient", clientCreer.getPrenom());
			request.getSession().setAttribute("idClient", clientCreer.getId());
			request.getSession().setAttribute("nomClient", clientCreer.getNom());
			request.getSession().setAttribute("prenomClient", clientCreer.getPrenom());
			request.getSession().setAttribute("estConnecte", estConnecte);
			


			response.sendRedirect("accueil");
		} catch (BLLException e) {

			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/jsp/nonConnecte/inscription.jsp").forward(request, response);
		}
	}

}
