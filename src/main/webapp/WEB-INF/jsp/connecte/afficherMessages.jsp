<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Affichage des messages</title>
<link href="../css/styleAfficherMessage.css" rel="stylesheet">
<link href="../css/styleGeneral.scss" rel="stylesheet">
</head>
<body>
	<%@ include file="../fragments/navbar.jspf"%>
	<div class="titreProfil">
		<h2>Messages envoyés</h2>
	</div>
	<main>
		<fieldset>
			<legend>
				<h3>Vos messages envoyés</h3>
			</legend>
			<div class="containerMessage">
			
				<c:forEach  var="messages" items="${messages}">
				<div class="affichage1message">
					<h2 class="styleTitre">${messages.titre}</h2>
					<h3 class="styleMessage">${messages.contenu}</h3>
					</div>
				</c:forEach>
				
				</div>
				
</body>
</html>