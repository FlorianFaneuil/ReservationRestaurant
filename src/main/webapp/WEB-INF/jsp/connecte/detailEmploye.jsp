<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page de details d'un employe</title>
</head>
<body>
	<h1>Page de details de l'employe ${employe.id}</h1>

	<div>
		<h1>Detail du contact ${employe.id}</h1>
		<p>Id Restaurant : ${employe.restaurant.id}</p>
		<p>Prénom : ${employe.prenom}</p>
		<p>Email: ${employe.email}</p>

	</div>
</body>
</html>