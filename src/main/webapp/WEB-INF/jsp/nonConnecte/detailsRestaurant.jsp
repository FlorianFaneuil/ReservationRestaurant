<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Details du Restaurant</title>
<link href="css/styleDetailsRestaurant.css" rel="stylesheet">
</head>
<body>
<%@ include file="../fragments/navbar.jspf" %>
<h1>Détails du Restaurant</h1>

<div class="card-category" style="background-image: linear-gradient(rgba(0,0,0,0.3), rgba(0,0,0,0.3)), url(${restaurant.imageRestaurantUrl})">
  ${restaurant.nom}
</div>
<div>
<p> Adresse : ${restaurant.adresse}</p> 
<p>Heure d'ouverture : ${restaurant.heureOuverture}</p> 
<p>Heure de fermeture : ${restaurant.heureFermeture}</p> 
<p>Liste des plats : A FAIRE</p> 
</div>

<form action="accueil" method="GET">
	<input type="submit" value="Retour à la liste des restaurants" />
</form>
	

	<form action="private/reservationTable" method="GET">
		<input type="hidden" value="${restaurant.id}" name="restaurant.id"/>
		<input type="hidden" value="${restaurant.heureOuverture}" name="heureOuverture"/>
		<input type="hidden" value="${restaurant.heureFermeture}" name="heureFermeture"/>
		<input type="submit" value="Reserver une table" />
	</form>
	
	
	<a href="private/envoyerMessage">Envoyer un message</a>
	

</body>
</html>