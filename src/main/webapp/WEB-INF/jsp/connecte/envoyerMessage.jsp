<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Envoyer un message</title>
</head>
<link href="../css/styleEnvoyerMessage.css" rel="stylesheet">
<body>
	<%@ include file="../fragments/navbar.jspf"%>
<div class="container1">
	<h1>Envoyer un message</h1>
	<form action="envoyerMessage" method="POST">
		<div>
			<input type="text" placeholder="titre" name="titre" />
		</div>
		<div>
			<textarea type="textarea" placeholder="contenu" name="contenu" ></textarea>
		</div>
		<div>
			<input type="number" placeholder="id_client" name="id_client" min="0" />
		</div>
		<div class="basForm">
		<h3>A quel employé voulez-vous envoyer ce message ?</h1>
			<select name="id_employe">
				<option value="Sacha">Sacha</option>
				<option value="Poire">Poire</option>
			</select> <input type="submit" value="Envoyer le message" />
		</div>
	</form>

	<a href="../accueil">Retour à l'accueil</a>
	</div>
</body>
</html>