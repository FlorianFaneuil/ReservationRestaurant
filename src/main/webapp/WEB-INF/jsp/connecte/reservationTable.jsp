<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reserver une table</title>
</head>
<body>

<h1>Réserver une table</h1>

IL FAUDRAIT AFFICHER LA LISTE DES TABLES LIBRES EN FONCTION DE LA DATE ET DE L'HEURE CHOISIE
DEMANDER DE CHOISIR UN NOMBRE DE PLACES DANS UN INTERVAL COMPRIS ENTRE 1 ET LE NOMBRE DE PLACE MAXIMAL DE/DES PLUS GRANDES TABLES.

<form action="private/reservationTable" method="POST">
		<div>
			<input type="date" name="date" />
			<span>${erreur.erreurDate }</span>
		</div>
		<div>
			<input type="time" name="heure" />
			<span>${erreur.erreurDate }</span>
		</div>
		<div>
			<input type="submit" value="Faire une demande de réservation" />
		</div>
	</form>

</body>
</html>