<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Envoyer un message</title>
</head>
<body>

	<h1>Envoyer un message</h1>
	<form action="envoyerMessage" method="POST">
		<div>
			<input type="text" placeholder="titre" name="titre" />
		</div>
		<div>
			<input type="text" placeholder="contenu" name="contenu" />
		</div>
		<div>
			<input type="number" placeholder="id_client" name="id_client" min="0" />
		</div>
		<div>
			<input type="number" placeholder="id_employe" name="id_employe"
				min="0" max="2" />
		</div>

		<input type="submit" value="Envoyer le message" />
		</div>
	</form>

	<a href="../accueil">Retour à l'accueil</a>
</body>
</html>