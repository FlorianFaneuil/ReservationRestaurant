<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification Profil</title>
</head>
<link href="../css/styleModifierProfil.css" rel="stylesheet">
<link href="../css/styleGeneral.scss" rel="stylesheet">
<body>
	<%@ include file="../fragments/navbar.jspf"%>
	<h1>Modifier le Profil</h1>
	<div class="container1">

		<div>
			<h3>Modification de vos informations</h3>
		</div>
		<div>
			<form action="modifierProfil" method="POST">


				<div class="formulaireProfil">
					<input type="hidden" name="id" value="${contact.id }" />

					<div class="gaucheForm">
						<p>Nom</p>
						<p>Prenom</p>
						<p>Email</p>
						<p>Mot de passe</p>
					</div>
					<div class="droiteForm">
						<input class="inputInfo" type="text" name="nom"
							value="${nomClient}"> <input class="inputInfo"
							type="text" name="prenom" value="${prenomClient}"> <input
							class="inputInfo" type="text" name="email" value="${emailClient}">

						<input class="inputInfo" type="password" name="password"
							value="${passwordClient}">

						

					</div>
					<div class="dernierDivForm">
						
						<div><button class="buttonOeil" type="button" onclick="afficherMotDePasse()">
							<img src="${pageContext.request.contextPath}/img/oeil(1).png"
								alt="Icône de l'œil" height=20px>
						</button></div>

					</div>

				</div>
		</div>
		<div class="containerBoutonValider">

			<input class="inputBoutton" type="submit" value="Valider">

		</div>

		</form>
	</div>
	</div>
	<script>
		function afficherMotDePasse() {
			const inputPassType = document
					.querySelector("input[name='password']");
			inputPassType.type = inputPassType.type == "password" ? "text"
					: "password";

		}
	</script>





</body>
</html>