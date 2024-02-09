package controler;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import bll.BLLException;
import bll.RestaurantBLL;
import bo.Restaurant;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RestaurantBLL restaurantBll;
	private List<Restaurant> restaurants = null;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH'h'mm");

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			restaurantBll = new RestaurantBLL();
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			restaurants = restaurantBll.selectAll();
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		//Passage de l'heure d'ouverture formatée dans une HashMap pour pouvoir la récupérer dans la page d'accueil
		HashMap<Integer, String> restaurantOuverture = new HashMap<>();
		for (Restaurant restaurant : restaurants) {
			String heureOuvertureFormat = restaurant.getHeureOuverture().format(formatter);
			restaurantOuverture.put(restaurant.getId(), heureOuvertureFormat);
		}
		
		//Passage de l'heure de fermeture formatée dans une HashMap pour pouvoir la récupérer dans la page d'accueil
		HashMap<Integer, String> restaurantFermeture = new HashMap<>();
		for (Restaurant restaurant : restaurants) {
			String heureOuvertureFormat = restaurant.getHeureFermeture().format(formatter);
			restaurantFermeture.put(restaurant.getId(), heureOuvertureFormat);
		}
		
		request.setAttribute("restaurants", restaurants);
		request.setAttribute("restaurantOuverture", restaurantOuverture);
		request.setAttribute("restaurantFermeture", restaurantFermeture);
		request.getRequestDispatcher("/WEB-INF/jsp/nonConnecte/accueil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
