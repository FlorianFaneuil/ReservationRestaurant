<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reserver une table</title>
<link href="${pageContext.request.contextPath }/css/styleReservationTable.scss"
	rel="stylesheet">
</head>
<body>
	<%@ include file="../fragments/navbar.jspf"%>
	<div class=container1>
		<div class="container">
			<h1>Réserver une table</h1>


			<form action="reservationTable" method="POST">
				<input type="hidden" value="${restaurantId}" name="restaurant.id" />
				<input type="hidden" value="EN ATTENTE" name="etat" /> <input
					type="hidden" value="${heureOuverture}" name="heureOuverture" /> <input
					type="hidden" value="${heureFermeture}" name="heureFermeture" />
				<div>
					<input type="date" name="date" />
				</div>
				<div>
					<p>Heure d'ouverture : ${heureOuverture}</p>
					<input type="time" name="heure" />
					<p>Heure de fermeture : ${heureFermeture}</p>
				</div>
				<div>
					<input type="number" placeholder="Nombre de places"
						name="nombrePlaces" min="1" max="20" />
				</div>
				<div class="erreur">
					<span>${erreur.erreurDate}</span>
				</div>
				<div class="erreur">
					<span>${erreur.erreurHeureAnterieure}</span>
				</div>
				<div class="erreur">
					<span>${erreur.erreurHeurePosterieure}</span>
				</div>
				<div class="erreur">
					<span>${erreur.erreurNombrePlaces}</span>
				</div>
				<div class="erreur">
					<span>${dateTimeErreur}</span>
				</div>
				<div class="center">
					<input class="boutons" type="submit"
						value="Faire une demande de réservation" />
				</div>
			</form>
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