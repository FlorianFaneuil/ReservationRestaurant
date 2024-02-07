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
		   <h3>Modification de vos informations </h3>
		</div><div>
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
					<input  class ="inputInfo" type="text" name="nom" 
						value="${nomClient}"> <input  class ="inputInfo type="text" name="prenom"
						 value="${prenomClient}"> <input class ="inputInfo
						type="text" name="email" 
						value="${emailClient}">
						 <input class ="inputInfo type="password"
						name="password" 
						value="${passwordClient}">
						
				</div>
			</div>
			</div>
			<div class="containerBoutonValider">

				<input class="inputBoutton" type="submit" value="Valider">



			</form>
		</div>
			</div>


</body>
</html>