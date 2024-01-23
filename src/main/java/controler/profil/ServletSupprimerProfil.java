package controler.profil;

import java.io.IOException;

import bll.BLLException;
import bll.ClientBLL;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletSupprimerProfil extends HttpServlet {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String idStr = request.getParameter("id");
//		int id = Integer.parseInt(idStr);
//		
		try {
			clientBLL.delete(1);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("../accueil");
//			request.getRequestDispatcher("/WEB-INF/jsp/nonConnecte/acceuil.jsp").forward(request, response);

	}

}
