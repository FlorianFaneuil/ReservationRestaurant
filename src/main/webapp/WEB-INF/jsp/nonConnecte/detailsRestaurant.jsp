<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Details du Restaurant</title>
<link href="css/styleDetailsRestaurant.css" rel="stylesheet">
</head>
<body>
<%@ include file="../fragments/navbar.jspf"%>
	
<div class="container">	
	<c:choose>
		<c:when test="${empty restaurant.imageRestaurantUrl}">
			<div class="card-category"
				style="background-image: linear-gradient(rgba(0, 0, 0, 0.3), rgba(0, 0, 0, 0.3)), url(https://images.france.fr/zeaejvyq9bhj/HhJZAq3Xe1JOXgeMfeEIu/66e8502f65dfaa1da542d8b785f22167/_X1A5062__s.jpg?w=1120&h=490&q=70&fl=progressive&fit=fill)">
				${restaurant.nom}
			</div>			
		</c:when>
		<c:otherwise>
			<div class="card-category"
				style="background-image: linear-gradient(rgba(0,0,0,0.3), rgba(0,0,0,0.3)), url(${restaurant.imageRestaurantUrl})">
				${restaurant.nom}
			</div>		
		</c:otherwise>
	</c:choose>
	<p>Adresse : ${restaurant.adresse}</p>
	<p>Heure d'ouverture : ${restaurant.heureOuverture}</p>
	<p>Heure de fermeture : ${restaurant.heureFermeture}</p>
	<p>Liste des plats :</p>
	<c:forEach var="plat" items="${plats}">
		<div>
			<p>CATEGORIE : ${plat.categorie}</p>
			<p>NOM : ${plat.nom}</p>
			<p>DESCRIPTION : ${plat.description}</p>
			<p>PRIX : ${plat.prix}€</p>
		</div>
	</c:forEach>



	<form action="accueil" method="GET">
		<input type="submit" value="Retour à la liste des restaurants" />
	</form>


	<form action="private/reservationTable" method="GET">
		<input type="hidden" value="${restaurant.id}" name="restaurant.id" />
		<input type="hidden" value="${restaurant.heureOuverture}"
			name="heureOuverture" /> <input type="hidden"
			value="${restaurant.heureFermeture}" name="heureFermeture" /> <input
			type="submit" value="Reserver une table" />
	</form>

	<form action="private/envoyerMessage" method="GET">
		<input type="submit" value="Envoyer un message" />
	</form>
</div>
</body>
</html>