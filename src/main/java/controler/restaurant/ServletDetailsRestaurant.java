package controler.restaurant;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import bll.BLLException;
import bll.CarteBLL;
import bll.PlatBLL;
import bll.RestaurantBLL;
import bo.Carte;
import bo.Plat;
import bo.Restaurant;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletDetailsRestaurant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RestaurantBLL restaurantBll;
	private CarteBLL carteBll;
	private PlatBLL platBll;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH'h'mm");
	
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			restaurantBll = new RestaurantBLL();
			carteBll = new CarteBLL();
			platBll = new PlatBLL();
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}  

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Etape 1 : recuperer les parametres
		String idStr = request.getParameter("id");
		// Etape 2 : passage dans le bon type
		int id = Integer.parseInt(idStr);
		// Etape 3 : exploitation des parametres par le bll
		try {
			Restaurant restaurant = restaurantBll.selectById(id);
			Carte carte = carteBll.selectByIdRestaurant(id);
			List<Plat> plats = platBll.selectByIdCarte(carte.getId());
			
			
			LocalTime heureOuvertureLocalTime = restaurant.getHeureOuverture();
			LocalTime heureFermetureLocalTime = restaurant.getHeureFermeture();
			
			String heureOuverture = heureOuvertureLocalTime.format(formatter);
			String heureFermeture = heureFermetureLocalTime.format(formatter);
			
			// Etape 4 : ajout des attributs a la requete
			
			request.setAttribute("heureOuverture", heureOuverture);
			request.setAttribute("heureFermeture", heureFermeture);
			request.setAttribute("restaurant", restaurant);
			request.setAttribute("carte", carte);
			request.setAttribute("plats", plats);
					
		} catch (BLLException e) {
			e.printStackTrace();
		}
		// Etape 5 : redirection vers la jsp
		request.getRequestDispatcher("/WEB-INF/jsp/nonConnecte/detailsRestaurant.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
