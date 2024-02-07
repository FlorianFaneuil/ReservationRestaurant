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

			<form action="afficherMessages" method="POST">
				<input class="inputBoutton" type="submit" value="Messages" />
			</form>
		</div>

	</div>
	</div>

</body>
</html>