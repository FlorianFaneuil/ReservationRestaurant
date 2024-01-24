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
				System.out.println(client.getId());
				System.out.println(client.getNom());
				System.out.println(client.getPrenom());
				request.getServletContext().setAttribute("idClient", client.getId());
				request.getServletContext().setAttribute("nomClient", client.getNom());
				request.getServletContext().setAttribute("prenomClient", client.getPrenom());
				request.getServletContext().setAttribute("estConnecte", estConnecte);
				request.getRequestDispatcher("/WEB-INF/jsp/nonConnecte/accueil.jsp").forward(request, response);

			} else {
				
				request.setAttribute("estConnecte", estConnecte);
				request.getRequestDispatcher("/WEB-INF/jsp/nonConnecte/connexion.jsp").forward(request, response);

			}

		} catch (BLLException e) {

			e.getMessage();

		}

	}
}
