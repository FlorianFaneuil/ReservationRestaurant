<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
				<div>
					<input type="password" name="password" placeholder="Mot de passe"
						id="password" required>
				</div>

				<p class="error-message">L’adresse e-mail ou le mot de passe que
					vous avez entré n’est pas valide. Veuillez réessayer.</p>

				<input type="submit" value="Inscription">
			</form>
			<div>
				<a href="connexion">Si vous avez déjà un compte, connectez-vous
					ici</a>
			</div>
		</div>
	</div>

</body>
</html>