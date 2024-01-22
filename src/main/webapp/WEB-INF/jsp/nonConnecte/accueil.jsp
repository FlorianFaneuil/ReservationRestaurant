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
	<h1>ACCUEIL</h1>


	<c:forEach var="restaurant" items="${restaurants}">
		<div class="card-product">
			<img src="${restaurant.imageRestaurantUrl}" />
			<div class="card-product-infos">
				<h2>${restaurant.nom}</h2><br>
					<form action="detailsRestaurant" method="GET">
						<input type="hidden" name="id" value="${restaurant.id}" />
						<input type="submit" value="Voir ce restaurant" />
					</form>
			</div>
		</div>
	</c:forEach>

</body>
</html>