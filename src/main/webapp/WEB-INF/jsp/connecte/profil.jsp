<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon profil</title>
</head>
<body>
	<div>
		<h1>Votre profil</h1>
		<h1>Detail du contact ${client.id}</h1>
		<p>Nom : ${client.nom}</p>
		<p>Prénom : ${client.prenom}</p>
		<p>Email: ${contact.email}</p>

	</div>
	<div>


		<form action="modifierProfil" method="GET">
			<%--  <input type="hidden" name="id" value="${client.id }" /> --%>
			<input type="submit" value="Modifier">
		</form>

		<form action="supprimerProfil" method="POST">
			<%-- 			<input type="hidden" name="id" value="${client.1 }" />
 --%>
			<input type="submit" value="Supprimer" />
		</form>
		
		<form action="afficherMessages" method="POST">
		<input type="submit" value="Messages" />
		</form>
		



	</div>

</body>
</html>