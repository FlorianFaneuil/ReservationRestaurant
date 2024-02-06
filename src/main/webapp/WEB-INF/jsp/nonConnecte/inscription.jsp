<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%@ include file="../fragments/navbar.jspf"%>
	<h1>Inscription</h1>
	<form action="inscription" method="post">
		<div>
			<input type="text" id="nom" name="nom" placeholder="nom" required>
		</div>

		<div>
			<input type="text" id="prenom" name="prenom" placeholder="prenom"
				required>
		</div>
		<div>
			<input type="email" id="email" name="email" placeholder="email"
				required>
		</div>
		<div>
			<input type="password" id="password" name="password"
				placeholder="mot pass" required>
		</div>
		<input type="submit" value="inscription">


	</form>
</body>
</html>