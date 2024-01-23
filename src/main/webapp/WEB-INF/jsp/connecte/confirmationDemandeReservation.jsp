<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reserver une table</title>
</head>
<body>
<%@ include file="../fragments/navbar.jspf" %>
<h1>Votre demande de réservation a été prise en compte</h1>

<p>Reservation ${reservation.id} pour une table au restaurant : <strong>${restaurant.nom}</strong></p>
<p>Date ${reservation.dateResa}</p>
<p>Heure ${reservation.heureResa}</p>
<p>Pour ${nombrePlaces} personnes</p>
<p>Votre réservation est ${reservation.etat}</p>


	<form action="../accueil" method="GET">
		<input type="submit" value="Retour à la liste des restaurants" />
	</form>

</body>
</html>