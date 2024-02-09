package controler.profil;

import java.io.IOException;
import java.util.List;

import bll.BLLException;
import bll.ReservationBLL;
import bo.Reservation;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AfficherReservations extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationBLL reservationBll;
	List<Reservation> reservation = null;

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			reservationBll = new ReservationBLL();
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			reservation = reservationBll.selectAll();
		} catch (BLLException e) {
			e.printStackTrace();
		}
		System.out.println("reservations : " + reservation);
		request.setAttribute("reservations", reservation);
	

		request.getRequestDispatcher("/WEB-INF/jsp/connecte/reservations.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
