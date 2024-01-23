package controler.message;

import java.io.IOException;

import bll.BLLException;
import bll.ClientBLL;
import bll.MessageBLL;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletAfficherMessages extends HttpServlet {
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
		request.getRequestDispatcher("/WEB-INF/jsp/connecte/afficherMessages.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
