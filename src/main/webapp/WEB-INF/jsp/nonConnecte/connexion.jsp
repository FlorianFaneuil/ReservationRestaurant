<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
<link rel="stylesheet" href="/ReservationRestaurant/css/connexion.css">
</head>
<body>

	<%@ include file="../fragments/navbar.jspf"%>


	<div class="container1">
		<div class="container">
			<h1>Connexion</h1>
			<form method="post" action="connexion">
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
							<div>
								<img src="/ReservationRestaurant/img/icons8-erreur.svg" alt="">
							</div>
							<div>${erreur}</div>
						</div>

					</c:forEach>
				</div>

				<input type="submit" value="Connexion">
			</form>
			<div>
				<a href="inscription">Si vous n'avez pas de compte,
					inscrivez-vous ici</a>
			</div>
		</div>
	</div>
	<script src="/ReservationRestaurant/javascript/afficherCacherPS.js"></script>

</body>
</html>