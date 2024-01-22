<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil / Index</title>
</head>
<body>
<h1>ACCUEIL</h1>


	<c:forEach var="restaurant" items="${restaurants }">
			<li>${restaurant.nom }</li>
	</c:forEach>

</body>
</html>