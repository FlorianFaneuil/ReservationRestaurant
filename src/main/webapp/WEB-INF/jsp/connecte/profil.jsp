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
	<!-- cpuleur palette F9EFDB beige 
doree EBD9B4
vert 9DBC98
bleu 638889 -->

	<%@ include file="../fragments/navbar.jspf"%>

	<div class="titreProfil">
		<h2>Bienvenue dans votre Profil</h2>
	</div>


	<main>

		<fieldset>
			<legend>
				<h3>Vos Informations personnelles</h3>
			</legend>

			<div class="formulaireProfil">


				<div class="gaucheForm">
					<h2>Nom</h2>
					<h2>Prenom</h2>
					<h2>Email</h2>
					<h2>Mot de passe</h2>
				</div>

				<div class="droiteForm">
					<!-- 				Informations qui viennent de connexion
 -->


					<h2>${idClient}</h2>
					<h2>${nomClient}</h2>
					<h2>${prenomClient}</h2>
					<h2>${emailClient}</h2>
					<h2>${passwordClient}</h2>
				</div>
			</div>
		</fieldset>
		<div class="containerBouton">
			<form action="modifierProfil" method="GET">
				<input type="hidden" name="id" value="${idClient }" /> <input
					class="inputBoutton" type="submit" value="Modifier">
			</form>

			<form action="supprimerProfil" method="POST">
				<input type="hidden" name="id" value="${idClient }" /> <input
					class="inputBoutton" type="submit" value="Supprimer" />
			</form>

			<form action="afficherMessages" method="POST">
				<input class="inputBoutton" type="submit" value="Messages" />
			</form>
		</div>

	</main>

</body>
</html>