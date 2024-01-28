package controler;

import java.io.IOException;

import bll.BLLException;
import bll.ClientBLL;
import bo.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientBLL clientBLL;

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

		request.getRequestDispatcher("/WEB-INF/jsp/nonConnecte/connexion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Boolean estConnecte = false;
		

		try {

			Client client = clientBLL.SelectByEmailPassword(email, password);
			if (client != null) {
				estConnecte = true;
				request.getSession().setAttribute("idClient", client.getId());
				request.getSession().setAttribute("nomClient", client.getNom());
				request.getSession().setAttribute("premiereLettrenomClient", client.getNom().substring(0, 1).toUpperCase());			
				request.getSession().setAttribute("prenomClient", client.getPrenom());
				request.getSession().setAttribute("premiereLetttreprenomClient", client.getPrenom().substring(0, 1).toUpperCase());
				request.getSession().setAttribute("emailClient", client.getEmail());
				request.getSession().setAttribute("passwordClient", client.getPassword());		
				request.getSession().setAttribute("estConnecte", estConnecte);
				response.sendRedirect("accueil");

			} else {

				request.setAttribute("estConnecte", estConnecte);
				request.getRequestDispatcher("/WEB-INF/jsp/nonConnecte/connexion.jsp").forward(request, response);

			}

		} catch (BLLException e) {

			e.getMessage();

		}

	}
}
