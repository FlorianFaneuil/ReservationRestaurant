<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification Profil</title>
</head>
<body>


	<h2>Modifier le Profil</h2>
	<form action="modifierProfil" method="POST">
		<input type="hidden" name="id" value="${contact.id }" /> <input
			type="text" name="nom" placeholder="nom" value="${contact.nom }">
		<input type="text" name="prenom" placeholder="prenom "
			value="${contact.prenom }"> <input type="text" name="email"
			placeholder="email" value="${contact.email }"> <input
			type="text" name="password" placeholder="mot de passe"
			value="${contact.password }"> <input type="submit"
			value="Valider">
	</form>



</body>
</html>