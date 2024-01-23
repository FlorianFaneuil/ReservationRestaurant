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

		System.out.println(email);
		System.out.println(password);

		try {

			Client client = clientBLL.SelectByEmailPassword(email, password);
			if (client != null) {
				response.getWriter().println("Login successful!");
			} else {
				response.getWriter().println("Login failed. ");
			}

		} catch (BLLException e) {
			// Gérez les exceptions de la logique d'affaires
			e.printStackTrace(); // À des fins de débogage
			System.out.println("erreur de connextion");
		}

//		if ("user@example.com".equals(email) && "password123".equals(password)) {
//			// Successful login
//			response.getWriter().println("Login successful!");
//		} else {
//			// Failed login
//			response.getWriter().println("Login failed. ");
//		}
	}
}
