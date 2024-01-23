package controler.profil;

import java.io.IOException;

import bll.BLLException;
import bll.ClientBLL;
import bo.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class ServletProfil extends HttpServlet {
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
//		// 1. Récupération des paramètres
//		String idStr = request.getParameter("id");
//
//		// 2. Passage des paramètres dans le type voulu
//		int id = Integer.parseInt(idStr);

		// 3. Exploitation des paramètres par le bll
		Client client = null;
		try {
			client = clientBLL.selectById(1);
		} catch (BLLException e) {
			e.printStackTrace();
		}

		// 4. Ajout des attributs éventuels à ma request
		request.setAttribute("client", client);

		// 5. Redirection vers la JSP choisie
		request.getRequestDispatcher("/WEB-INF/jsp/contact/profil.jsp").forward(request, response);
	} // GererContactPro/src/main/webapp/WEB-INF/jsp/contact

}
