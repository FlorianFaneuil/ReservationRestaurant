package controler.message;

import java.io.IOException;
import java.util.List;

import bll.BLLException;
import bll.ClientBLL;
import bll.EmployeBLL;
import bll.MessageBLL;
import bo.Client;
import bo.Employe;
import bo.Message;
import dal.DALException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletEnvoyerMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MessageBLL messageBLL;
	private EmployeBLL employeBLL;

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			messageBLL = new MessageBLL();
			employeBLL = new EmployeBLL();
		} catch (BLLException | DALException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			List<Employe> employes = employeBLL.selectAllEmployes();
			request.setAttribute("employes", employes);

		} catch (Exception e) {
			request.setAttribute("erreur", "Erreur lors de la récupération des employés: " + e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("erreur.jsp");
			dispatcher.forward(request, response);

		}

		request.getRequestDispatcher("/WEB-INF/jsp/connecte/envoyerMessage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String titreStr = request.getParameter("titre");
		String contenuStr = request.getParameter("contenu");
		String id_clientStr = request.getParameter("id_client");

		String id_employeApars = request.getParameter("id_employe");

		int id_clientParse = 0;
		int id_employeParse = 0;

		try {
			id_clientParse = Integer.parseInt(id_clientStr);
			id_employeParse = Integer.parseInt(id_employeApars);
		} catch (NumberFormatException e) {
			e.printStackTrace();

		}

		Message messageCree = null;
		try {
			ClientBLL clientBLL = new ClientBLL();
			Client id_client = clientBLL.selectById(id_clientParse);

			EmployeBLL employeBLL = new EmployeBLL();
			Employe id_employe = employeBLL.selectById(id_employeParse);

			messageCree = messageBLL.insert(titreStr, contenuStr, id_client, id_employe);
			request.getRequestDispatcher("/WEB-INF/jsp/connecte/popUpMessageEnvoye.jsp").forward(request, response);

		} catch (BLLException | DALException e) {
			e.printStackTrace();
			request.setAttribute("erreur", e);
		}

	}
}
