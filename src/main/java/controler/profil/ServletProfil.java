package controler.profil;

import java.io.IOException;

import bll.BLLException;
import bll.ClientBLL;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientBLL clientBLL;
//	private ReservationBLL reservationBll;
//	List<Reservation> reservation = null;

	@Override
	public void init() throws ServletException {
		super.init();
		try {
//			reservationBll = new ReservationBLL();
			clientBLL = new ClientBLL();
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//			throws ServletException, IOException {
//		try {
//			reservation = reservationBll.selectAll();
//		} catch (BLLException e) {
//			e.printStackTrace();
//		}
//		request.setAttribute("reservations", reservation);
//		System.out.println("reservations : " + reservation);
//		
		// 5. Redirection vers la JSP choisie
		request.getRequestDispatcher("/WEB-INF/jsp/connecte/profil.jsp").forward(request, response);
	} // GererContactPro/src/main/webapp/WEB-INF/jsp/contact

}
