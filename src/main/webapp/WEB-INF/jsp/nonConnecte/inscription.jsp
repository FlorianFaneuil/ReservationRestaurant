<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
<link rel="stylesheet" href="/ReservationRestaurant/css/inscription.css">
</head>
<body>
	<%@ include file="../fragments/navbar.jspf"%>
	<div class="container1">

		<div class="container">
			<h1>Inscription</h1>
			<form method="post" action="inscription">
				<div>
					<input type="text" name="prenom" placeholder="prenom" id="prenom"
						required>
				</div>
				<div>
					<input type="text" name="nom" placeholder="Nom" id="nom" required>
				</div>
				<div>
					<input type="email" name="email" placeholder="Email" id="email"
						required>
				</div>
				<div class="password-group">
					<input type="password" name="password" placeholder="Mot de passe"
						id="password" required>
						<span class="password-eye" onclick="togglePasswordVisibility()"></span>
				</div>

				<div class="error-message">

					<c:forEach var="erreur" items="${errors}">
				 <div>
                            <div><img src="/ReservationRestaurant/img/erreur.png" alt=""></div>
                            <div>${erreur}</div>
                        </div>

				</c:forEach>

				</div>
				
				<input type="submit" value="Inscription">
			</form>
			<div>
				<a href="connexion">Si vous avez déjà un compte, connectez-vous
					ici</a>
			</div>
		</div>
	</div>
	
	<script src="/ReservationRestaurant/javascript/afficherCacherPS.js"></script>

</body>
</html>