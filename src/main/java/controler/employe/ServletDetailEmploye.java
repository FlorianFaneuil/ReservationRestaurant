package controler.employe;

import java.io.IOException;

import bll.BLLException;
import bll.EmployeBLL;
import bo.Employe;
import dal.DALException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletDetailEmploye extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeBLL employeBll;

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			employeBll = new EmployeBLL();
		} catch (BLLException | DALException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Récupération des paramètres
//		String idStr = request.getParameter("id");
//
//		// 2. Passage des paramètres dans le type voulu
//		int id = Integer.parseInt(idStr);

		// 3. Exploitation des paramètres par le bll
		Employe employe = null;
		try {
			employe = employeBll.selectById(1);
		} catch (BLLException e) {
			e.printStackTrace();
		}

		// 4. Ajout des attributs éventuels à ma request
		request.setAttribute("employe", employe);

		// 5. Redirection vers la JSP choisie
		request.getRequestDispatcher("/WEB-INF/jsp/connecte/detailEmploye.jsp").forward(request, response);
	}
}
