<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reserver une table</title>
<link
	href="/ReservationRestaurant/css/styleConfirmationReservation.scss"
	rel="stylesheet">
</head>
<body>
	<%@ include file="../fragments/navbar.jspf"%>
	<div class="container1">
		<div class="container">
			<h1>Votre demande de réservation a été prise en compte</h1>
			<div class="texte">
				<p>
					Pour une table au restaurant : <strong>${restaurant.nom}</strong>
				</p>
				<p>Le ${convertDateResa}</p>
				<p>A ${convertHeureResa}</p>
				<p>Pour ${nombrePlaces} personnes</p>
				<p>
					Votre réservation est <strong>${reservation.etat}</strong>
				</p>
			</div>
			<div class="center">
				<form action="../accueil" method="GET">
					<input class="boutons" type="submit"
						value="Retour à la liste des restaurants" />
				</form>
			</div>
		</div>
	</div>
	<%@ include file="../fragments/footer.jspf"%>
</body>
</html>