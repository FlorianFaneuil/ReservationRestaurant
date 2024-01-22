<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion ou Inscription</title>
</head>
<body>
	<h1>Connexion</h1>

	<h1>Inscription</h1>
	<%@ include file="../fragments/navbar.jspf"%>

	<form  method="post" action="connexion">
		<input type="email" name="email" placeholder="email"> 
		<input type="password" name="password" placeholder="password" >
		<input type="submit" value="connextion">
	</form>

</body>
</html>