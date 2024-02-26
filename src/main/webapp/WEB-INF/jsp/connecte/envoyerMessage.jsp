<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Envoyer un message</title>
</head>
<link href="../css/styleEnvoyerMessage.css" rel="stylesheet">
<body>
	<%@ include file="../fragments/navbar.jspf"%>
	<div class="container1">
		<h1>Envoyer un message</h1>
		<form action="envoyerMessage" method="POST">
			<div>
				<input type="text" placeholder="titre" name="titre" />
			</div>
			<div>
				<textarea type="textarea" placeholder="contenu" name="contenu"></textarea>
			</div>
			<div>
				<input type="hidden" name="id_client" value="${idClient }" /> 
			</div>
			<div class="basForm">
				<h3>A quel employé voulez-vous envoyer ce message ?</h3>
				<select name="id_employe">
				<c:forEach items="${employes}" var="employe">
					<option value="${employe.id}">${employe.prenom}</option>
						</c:forEach>
					
				</select> <input type="submit" value="Envoyer le message" />
			</div>
		</form>

		<a href="../accueil">Retour à l'accueil</a>
	</div>
	
	
			<c:forEach items="${reservations}" var="reservation">

				<c:if test="${reservation.idClient eq idClient }">
					<div class="container">
						<p>
							Pour une table au restaurant : <strong>${reservation.idRestaurant}</strong>
						</p>
						<p>Le ${reservation.dateResa}</p>
						<p>A ${reservation.heureResa}</p>
						<p>Pour ${reservation.nombrePlaces} personnes</p>
						<p>
							Votre réservation est <strong>${reservation.etat}</strong>
						</p>
					</div>
				</c:if>


			</c:forEach>
</body>
</html>