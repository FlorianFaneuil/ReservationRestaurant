<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil / Index</title>
<link href="css/styleAccueil.css" rel="stylesheet">
</head>
<body>
	<%@ include file="../fragments/navbar.jspf"%>
	<h1>ACCUEIL</h1>


	<c:forEach var="restaurant" items="${restaurants}">
		<div class="card-product">
			<c:choose>
				<c:when test="${empty restaurant.imageRestaurantUrl}">
					<img
						src="https://images.france.fr/zeaejvyq9bhj/HhJZAq3Xe1JOXgeMfeEIu/66e8502f65dfaa1da542d8b785f22167/_X1A5062__s.jpg?w=1120&h=490&q=70&fl=progressive&fit=fill"
						alt="Image du restaurant">
				</c:when>
				<c:otherwise>
					<img src="${restaurant.imageRestaurantUrl}"
						alt="Image du restaurant">
				</c:otherwise>
			</c:choose>
			<div class="card-product-infos">
				<h2>${restaurant.nom}</h2>
				<br>
				<form action="detailsRestaurant" method="GET">
					<input type="hidden" name="id" value="${restaurant.id}" /> <input
						type="submit" value="Voir ce restaurant" />
				</form>
			</div>
		</div>
	</c:forEach>

</body>
</html>
${restaurant.imageRestaurantUrl}
