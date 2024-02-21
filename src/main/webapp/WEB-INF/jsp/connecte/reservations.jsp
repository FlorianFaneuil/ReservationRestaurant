<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reservations</title>
<link href="../css/styleAfficherReservation.css" rel="stylesheet">

</head>
<body>
	<%@ include file="../fragments/navbar.jspf"%>
	<h1>Vos Réservations</h1>
	<div class="texte">
		<div class="container1">




			<c:forEach items="${reservations}" var="reservation">
			<div class="container">
				<c:if test="${reservation.idClient eq idClient }">

					<p>
						Pour une table au restaurant : <strong>${reservation.idRestaurant}</strong>
					</p>
					<p>Le ${reservation.dateResa}</p>
					<p>A ${reservation.heureResa}</p>
					<p>Pour ${reservation.nombrePlaces} personnes</p>
					<p>
						Votre réservation est <strong>${reservation.etat}</strong>
					</p>
				</c:if>
				</div>

			</c:forEach>
		</div>

	</div>

</body>
</html>