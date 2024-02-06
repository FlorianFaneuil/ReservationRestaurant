package controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ServletErreur404 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//response.sendRedirect("/WEB-INF/jsp/nonConnecte/erreur404.jsp");
		request.getRequestDispatcher("/WEB-INF/jsp/nonConnecte/erreur404.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
