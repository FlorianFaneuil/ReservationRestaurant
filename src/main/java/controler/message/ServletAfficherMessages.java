package controler.message;

import java.io.IOException;
import java.util.List;

import bll.BLLException;
import bll.MessageBLL;
import bo.Message;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletAfficherMessages extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MessageBLL messageBLL;
	private List<Message> messages = null;

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
		try {
			messages = messageBLL.selectAll();

		} catch (BLLException e) {
			e.printStackTrace();
		}
		request.setAttribute("messages", messages);

		request.getRequestDispatcher("/WEB-INF/jsp/connecte/afficherMessages.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
