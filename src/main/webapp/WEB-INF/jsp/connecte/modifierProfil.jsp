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

	<div class="titreProfil">
		<h2>Modifier le Profil</h2>
	</div>

	<main>


		<form action="modifierProfil" method="POST">
		  <fieldset>
		    <legend><h3>Modification de vos informations </h3></legend>
		
			<div class="formulaireProfil">
				<input type="hidden" name="id" value="${contact.id }" />

				<div class="gaucheForm">
					<h2>Nom</h2>
					<h2>Prenom</h2>
					<h2>Email</h2>
					<h2>Mot de passe</h2>
				</div>
				<div class="droiteForm">
					<input  class ="inputInfo" type="text" name="nom" 
						value="${contact.nom }"> <input  class ="inputInfo type="text" name="prenom"
						 value="${contact.prenom }"> <input class ="inputInfo
						type="text" name="email" 
						value="${contact.email }"> <input class ="inputInfo type="text"
						name="password" 
						value="${contact.password }">
						
				</div>
			</div>
			 </fieldset>
			
			<div class="containerBoutonValider">

				<input class="inputBoutton" type="submit" value="Valider">
			</div>
 

		</form>


	</main>
</body>
</html>