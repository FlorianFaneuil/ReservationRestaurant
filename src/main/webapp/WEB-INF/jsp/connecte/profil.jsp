<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon profil</title>
<link href="../css/styleProfil.css" rel="stylesheet">
</head>
<body>


	<%@ include file="../fragments/navbar.jspf"%>

	<div class="titreProfil">
	<h1>PROFIL</h1>
	</div>

	
	<main>
	<div class="carteInforProfil">
	<h2>Vos Informations personnelles</h2>
	<br>
		<h3>Nom : ${client.nom}</h3>
		<h3>Prénom : ${client.prenom}</h3>
		<h3>Email: ${client.email}</p>
		<h3>Id : ${client.id}</p>
	</div>
	
	
	<div class="formulaireProfil">
		<form action="modifierProfil" method="GET">
			<%--  <input type="hidden" name="id" value="${client.id }" /> --%>
			<input class="bouttonCRUDProfil" type="submit" value="Modifier">
		</form>

		<form action="supprimerProfil" method="POST">
			<%-- 			<input type="hidden" name="id" value="${client.1 }" />
 --%>
			<input class="bouttonCRUDProfil" type="submit" value="Supprimer" />
		</form>

		<form action="afficherMessages" method="POST">
			<input class="bouttonCRUDProfil" type="submit" value="Messages" />
		</form>

	</div>
	</main>

</body>
</html>