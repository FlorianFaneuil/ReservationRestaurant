<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon profil</title>
<link href="../css/styleProfil.css" rel="stylesheet">
<link href="../css/styleGeneral.scss" rel="stylesheet">

</head>
<body>
	<%@ include file="../fragments/navbar.jspf"%>
	<h1 class="titre">Profil</h1>
	<div class="container1">
		<div>
			<h3>Bienvenue dans votre Profil</h3>
		</div>

		<div class="fomEtbouton">
			<div class="formulaireProfil">

				<div class="gaucheForm">
					<p>Nom</p>
					<p>Prenom</p>
					<p>Email</p>
				</div>

				<div class="droiteForm">
					<p>${nomClient}</p>
					<p>${prenomClient}</p>
					<p>${emailClient}</p>
				</div>
			</div>


			<div class="containerBouton">

				<form action="modifierProfil" method="GET">
					<input type="hidden" name="id" value="${idClient }" /> <input
						class="inputBoutton" type="submit" value="Modifier">
				</form>

				<form action="supprimerProfil" method="POST">
					<input type="hidden" name="id" value="${idClient }" /> <input
						class="inputBoutton" type="submit" value="Supprimer" />
				</form>

				<div></div>

			</div>
		</div>

		<div class="messageEtResa">
			<div>
				<h3>Vous desirez consulter vos messages envoyés ?</h3>
			</div>
			<form class="bouttonmessage" action="afficherMessages" method="POST">
				<input class="inputBoutton" type="submit" value="Mes messages" />
			</form>

			<div class="containerResa">
				<h3>Voici vos reservations</h3>
				<h1>Votre demande de réservation a été prise en compte</h1>
				<div class="texte">
					<c:forEach items="${reservations}" var="reservation">

						<p>
							Pour une table au restaurant : <strong>${reservation.idRestaurant}</strong>
						</p>
						<p>Le ${reservation.dateResa}</p>
						<p>A ${reservation.heureResa}</p>
						<p>Pour ${reservation.nombrePlaces} personnes</p>
						<p>
							Votre réservation est <strong>${reservation.etat}</strong>
						</p>
					</c:forEach>
				</div>

			</div>
		</div>

	</div>

</body>
</html>