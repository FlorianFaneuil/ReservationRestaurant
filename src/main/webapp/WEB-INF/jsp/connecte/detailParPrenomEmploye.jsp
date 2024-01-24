<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details de l'empoye en recherchant avec son nom</title>
</head>
<body>
<h1>Details de l'employe ${employe.prenom}</h1>
<div>
		<h1>nom ${employe.nom}</h1>
		<h1>id ${employe.id}</h1>
		<p>Id Restaurant : ${employe.restaurant.id}</p>
		<p>Email: ${employe.email}</p>

	</div>

</body>
</html>