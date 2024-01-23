<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reserver une table</title>
</head>
<body>
<%@ include file="../fragments/navbar.jspf" %>
<h1>Votre demande de réservation a été prise en compte</h1>




	<form action="../accueil" method="GET">
		<input type="submit" value="Retour à la liste des restaurants" />
	</form>

</body>
</html>