package controler.table;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import bll.BLLException;
import bll.ReservationBLL;
import bll.RestaurantBLL;
import bo.Reservation;
import bo.Restaurant;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ServletReservationTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationBLL reservationBll;
	private RestaurantBLL restaurantBll;
	private int idClient = 0;
       
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			restaurantBll = new RestaurantBLL();
			reservationBll = new ReservationBLL();
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String restaurantIdStr = request.getParameter("restaurant.id");
		String heureOuvertureStr = request.getParameter("heureOuverture");
		String heureFermetureStr = request.getParameter("heureFermeture");
		int restaurantId = Integer.parseInt(restaurantIdStr);
		request.setAttribute("heureOuverture", heureOuvertureStr);
		request.setAttribute("heureFermeture", heureFermetureStr);
		request.setAttribute("restaurantId", restaurantId);
		request.getRequestDispatcher("/WEB-INF/jsp/connecte/reservationTable.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Etape 1 : recuperer les parametres
		String restaurantIdStr = request.getParameter("restaurant.id");
		String etatStr = request.getParameter("etat");
		String dateStr = request.getParameter("date");
		String heureStr = request.getParameter("heure");
		String nombrePlacesStr = request.getParameter("nombrePlaces");
		
		// Etape 2 : passage dans le bon type
		int restaurantId = Integer.parseInt(restaurantIdStr);
		int nombrePlaces = Integer.parseInt(nombrePlacesStr);
		
		LocalDate dateResa = LocalDate.parse(dateStr);
		LocalTime heureResa = LocalTime.parse(heureStr);
		
		try {
			//HttpSession session = request.getSession();
			//idClient = (int) session.getAttribute("userId");
			idClient = 1;
			Restaurant restaurant = restaurantBll.selectById(restaurantId);
			request.setAttribute("restaurant", restaurant);
			
			Reservation reservation = reservationBll.insert(restaurant, idClient, dateResa, heureResa, etatStr);
			// Etape 4 : ajout des attributs a la requete
			request.setAttribute("restaurant", restaurant);
			request.setAttribute("reservation", reservation);
			request.setAttribute("nombrePlaces", nombrePlaces);
			request.getRequestDispatcher("/WEB-INF/jsp/connecte/confirmationDemandeReservation.jsp").forward(request, response);
		} catch (BLLException e) {
			request.setAttribute("erreur", e);
//		e.printStackTrace();
		
		request.getRequestDispatcher("/WEB-INF/jsp/connecte/reservationTable.jsp").forward(request, response);
		}	
	}
}

