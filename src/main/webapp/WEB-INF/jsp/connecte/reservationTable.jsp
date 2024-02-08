<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reserver une table</title>
<link href="css/styleReservationTable.css" rel="stylesheet">
</head>
<body>
<%@ include file="../fragments/navbar.jspf" %>
<h1>Réserver une table</h1>


<form action="reservationTable" method="POST">
<input type="hidden" value="${restaurantId}" name="restaurant.id"/>
<input type="hidden" value="EN ATTENTE" name="etat"/>
		<div>
			<input type="date" name="date" />
			<span>${erreur.erreurDate}</span>
		</div>
		<div>
			<p>Heure d'ouverture :  ${heureOuverture}</p>
			<span>${erreur.erreurHeureAnterieure}</span>
			<input type="time" name="heure" />
			<span>${erreur.erreurHeurePosterieure}</span>
			<p>Heure de fermeture :  ${heureFermeture}</p>
		</div>
		<div>
			<input type="number" placeholder="Nombre de places" name="nombrePlaces" />
		</div>
		<div>
			<input type="submit" value="Faire une demande de réservation" />
		</div>
	</form>

	<form action="../accueil" method="GET">
		<input type="submit" value="Retour à la liste des restaurants" />
	</form>

</body>
</html>