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
	<h1>PROFIL</h1>
	</div>

	
	<main>
	<div class="carteInforProfil">
	<div class="titreInforPerso">
	<h2>Vos Informations personnelles</h2>
	</div>
	<div>
	<div class="infoProfil">
		<h2>Nom : ${client.nom}</h2>
		<h2>Prénom : ${client.prenom}</h2>
		<h2>Email: ${client.email}</h2>
		</div>
		</div>
	</div>
	
	
	<div class="formulaireProfil">
		<form action="modifierProfil" method="GET">
			<%--  <input type="hidden" name="id" value="${client.id }" /> --%>
			<input type="submit" value="Modifier">
		</form>

		<form action="supprimerProfil" method="POST">
			<%-- 			<input type="hidden" name="id" value="${client.1 }" />
 --%>
			<input  type="submit" value="Supprimer" />
		</form>

		<form action="afficherMessages" method="POST">
			<input type="submit" value="Messages" />
		</form>

	</div>
	</main>

</body>
</html>