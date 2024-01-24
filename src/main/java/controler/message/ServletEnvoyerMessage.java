package controler.message;

import java.io.IOException;

import bll.BLLException;
import bll.ClientBLL;
import bll.EmployeBLL;
import bll.MessageBLL;
import bo.Client;
import bo.Employe;
import bo.Message;
import dal.DALException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletEnvoyerMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MessageBLL messageBLL;

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			messageBLL = new MessageBLL();
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/connecte/envoyerMessage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Etape 1 : Recuperer toutes les infos necessaires
		String titreStr = request.getParameter("titre");
		String contenuStr = request.getParameter("contenu");
		String id_clientStr = request.getParameter("id_client");
		
		
		String id_employeNom = request.getParameter("id_employe");

		// Etape 1 bis : vous pouvez vous assurer que vous recuperez bien les infos

		System.out.println(titreStr);
		System.out.println(contenuStr);
		System.out.println(id_clientStr);
		System.out.println(id_employeNom);

		// Etape 2 : Passer les infos dans les types appropries
		int id_clientParse = 0;
		int id_employeParse = 0;
//		LocalDate ddn = LocalDate.parse(ddnStr);
		try {
			id_clientParse = Integer.parseInt(id_clientStr);
			id_employeParse = Integer.parseInt(id_employeNom);
		} catch (NumberFormatException e) {
			e.printStackTrace();

		}
		// Etape 3 : Realiser le traitement associes a ces infos
		Message messageCree = null;
		try {
			ClientBLL clientBLL = new ClientBLL();
			Client id_client = clientBLL.selectById(id_clientParse);

			EmployeBLL employeBLL = new EmployeBLL();
			Employe id_employe = employeBLL.selectById(id_employeParse);
//	        Employe id_employe = employeBLL.selectByNom(id_employeNom);


			messageCree = messageBLL.insert(titreStr, contenuStr, id_client, id_employe);
			request.getRequestDispatcher("/WEB-INF/jsp/connecte/popUpMessageEnvoye.jsp").forward(request, response);
//			response.sendRedirect("details?id=" + contactCree.getId());// vers une servlet
		} catch (BLLException | DALException e) {
			e.printStackTrace();
			request.setAttribute("erreur", e);
		}

		// Etape 4 : Ajout des attributs eventuels a la requete

		// Etape 5 : Redirection
		// Redirige vers la servlet d'affichage des details d'un contact
		// Puisque le traitement pour afficher le detail d'un contact est deja realise
		// dans cette Servlet
	}
}
