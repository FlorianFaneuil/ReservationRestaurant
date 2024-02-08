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


<body>

<%@ include file="../fragments/navbar.jspf"%>
<h1 class="titre">Messages</h1>
<div class="container1">

	<div class="titreProfil">
		<h2>Messages envoyés</h2>
	</div>
	<div class="container">
	
	
		
			<div class="containerMessage">
			
			if ()
				<c:forEach  var="message" items="${messages}">
				<div class="affichage1message">
					<h2 class="styleTitre">${message.titre}</h2>
					<h3 class="styleMessage">${message.contenu}</h3>
					<h3 class="styleMessage">${message.employe.prenom}</h3>
					 
					</div>
				</c:forEach>
				</div>
				</div>
				
				<div class="containerBouton">
			    <a  class=inputBoutton1 href="../profil">Retour au Profil</a>
				</div>
								</div>
				
</body>
</html>