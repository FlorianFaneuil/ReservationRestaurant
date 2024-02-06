<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
</head>
<body>

<%@ include file="../fragments/navbar.jspf"%>

	<h1>Connexion</h1>

	<form method="post" action="connexion">
		<div>
			<input type="email" name="email" placeholder="email" required>
		</div>
		<div>
			<input type="password" name="password" placeholder="password" required>
		</div>
		<c:if test="${estConnecte ==false}">
			<p>L’adresse e-mail ou le mot de passe que vous avez entré n’est
				pas valide. Veuillez réessayer.</p>
		</c:if>
		<input type="submit" value="connexion">
	</form>

   <div><a href="u">si vous n'avez pas encore de compte utilisateur</a></div>

	


</body>
</html>