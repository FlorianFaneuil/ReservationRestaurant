<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Affichage des messages</title>
</head>
<body>
	<h1>Affichage des messages</h1>


	<c:forEach var="messages" items="${messages}">
		<h2>${messages.titre}</h2>
		<h2>${messages.contenu}</h2>


	</c:forEach>
</body>
</html>