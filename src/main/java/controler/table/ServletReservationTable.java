package controler.table;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

import bll.BLLException;
import bll.ReservationBLL;
import bll.RestaurantBLL;
import bo.Reservation;
import bo.Restaurant;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class ServletReservationTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationBLL reservationBll;
	private RestaurantBLL restaurantBll;
	private int idClient = 0;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH'h'mm");
	
       
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
        request.getRequestDispatcher("/WEB-INF/jsp/connecte/profil.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Etape 1 : recuperer les parametres
		String restaurantIdStr = request.getParameter("restaurant.id");
		String etatStr = request.getParameter("etat");
		String dateStr = request.getParameter("date");
		String heureStr = request.getParameter("heure");
		String nombrePlacesStr;
		if (request.getParameter("nombrePlaces").isBlank()) {
			nombrePlacesStr = "0";
		} else {
			nombrePlacesStr = request.getParameter("nombrePlaces");
		}
		// Etape 2 : passage dans le bon type
		int restaurantId = Integer.parseInt(restaurantIdStr);
		int nombrePlaces = Integer.parseInt(nombrePlacesStr);
		LocalDate dateResa = null;
		LocalTime heureResa = null;
		
		try {
			dateResa = LocalDate.parse(dateStr);
			heureResa = LocalTime.parse(heureStr);
			
			HttpSession session = request.getSession();
			idClient = (int) session.getAttribute("idClient");

			Restaurant restaurant = restaurantBll.selectById(restaurantId);
			request.setAttribute("restaurant", restaurant);
			
			Reservation reservation = reservationBll.insert(restaurant, idClient, dateResa, heureResa, etatStr, nombrePlaces);
			// Etape 4 : ajout des attributs a la requete
			
			//Passage de la LocalDate en Date puis passage en string dans le bon format jj/mm/aaaa via SimpleDateFormat
			Date LocalDatetoDateDateResa = Date.from(dateResa.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant());
			String convertDateResa = dateFormat.format(LocalDatetoDateDateResa);
			
			//Passage de l'heure LocalTime en string via DateTimeFormatter
			String convertHeureResa = heureResa.format(formatter);
			
			request.setAttribute("convertDateResa", convertDateResa);
			request.setAttribute("convertHeureResa", convertHeureResa);
			request.setAttribute("restaurant", restaurant);
			request.setAttribute("reservation", reservation);
			request.setAttribute("nombrePlaces", nombrePlaces);
			
			request.getRequestDispatcher("/WEB-INF/jsp/connecte/confirmationDemandeReservation.jsp").forward(request, response);
		} catch (DateTimeParseException e) {
			request.setAttribute("dateTimeErreur", "La date et/ou l'heure doivent être renseignées");
			
			// METTRE LES DONNEES ID RESTAURANT (ou tout le restaurant) ET LES HORRAIRES POUR LES CONSERVER A LA REDIRECTION
				restaurantIdStr = request.getParameter("restaurant.id");
				String heureOuvertureStr = request.getParameter("heureOuverture");
				String heureFermetureStr = request.getParameter("heureFermeture");
				restaurantId = Integer.parseInt(restaurantIdStr);
			 	request.setAttribute("heureOuverture", heureOuvertureStr);
			    request.setAttribute("heureFermeture", heureFermetureStr);
			    request.setAttribute("restaurantId", restaurantId);
				
			    request.getRequestDispatcher("/WEB-INF/jsp/connecte/reservationTable.jsp").forward(request, response);
			   
		} catch (BLLException e) {
			request.setAttribute("erreur", e);
			
			// METTRE LES DONNEES ID RESTAURANT (ou tout le restaurant) ET LES HORRAIRES POUR LES CONSERVER A LA REDIRECTION
			restaurantIdStr = request.getParameter("restaurant.id");
			String heureOuvertureStr = request.getParameter("heureOuverture");
			String heureFermetureStr = request.getParameter("heureFermeture");
			restaurantId = Integer.parseInt(restaurantIdStr);
		 	request.setAttribute("heureOuverture", heureOuvertureStr);
		    request.setAttribute("heureFermeture", heureFermetureStr);
		    request.setAttribute("restaurantId", restaurantId);
				
			request.getRequestDispatcher("/WEB-INF/jsp/connecte/reservationTable.jsp").forward(request, response);
		}	
	}
}

