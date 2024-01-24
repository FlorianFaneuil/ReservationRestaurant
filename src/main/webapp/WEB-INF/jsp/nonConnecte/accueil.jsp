<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil / Index</title>
<link href="css/styleAccueil.scss" rel="stylesheet">
</head>
<body>
<%@ include file="../fragments/navbar.jspf"%>
<h1>Acceuil</h1>

<div class="container">
	<c:forEach var="restaurant" items="${restaurants}">
		<div class="blog-wrapper">
		  <div class="blog-card">
			<c:choose>
				<c:when test="${empty restaurant.imageRestaurantUrl}">
					<div class="card-img"><img src="https://images.france.fr/zeaejvyq9bhj/HhJZAq3Xe1JOXgeMfeEIu/66e8502f65dfaa1da542d8b785f22167/_X1A5062__s.jpg?w=1120&h=490&q=70&fl=progressive&fit=fill">
				      <h1>${restaurant.nom}</h1>
				    </div>
				</c:when>
				<c:otherwise>
					<div class="card-img"><img src="${restaurant.imageRestaurantUrl}">
				      <h1>${restaurant.nom}</h1>
				    </div>
				</c:otherwise>
			</c:choose>
			<div class="card-details"><p>Horaires</p></div>
		    <div class="card-details"><span><i class="fa fa-calendar"></i>${restaurant.heureOuverture}</span><span><i class="fa fa-heart"></i>${restaurant.heureFermeture}</span></div>
		    <div class="card-text"><p class="card-details">Venez savourer un excellent repas au ${restaurant.adresse}</p></div>
		    <div class="read-more">
		    	<form action="detailsRestaurant" method="GET">
					<input type="hidden" name="id" value="${restaurant.id}" /> <input
					type="submit" value="Voir ce restaurant" />
				</form>
		    </div>
		  </div>
		</div>
	</c:forEach>
</div>	
</body>
</html>