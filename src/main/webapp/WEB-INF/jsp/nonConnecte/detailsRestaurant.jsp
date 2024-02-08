<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Details du Restaurant</title>
<link href="css/styleDetailsRestaurant.scss" rel="stylesheet">
</head>
<body>
<%@ include file="../fragments/navbar.jspf"%>
	<div>
		<c:choose>
			<c:when test="${empty restaurant.imageRestaurantUrl}">
				<div class="card-category"
					style="background-image: linear-gradient(rgba(0, 0, 0, 0.3), rgba(0, 0, 0, 0.3)),url(${pageContext.request.contextPath}/images/defautimagerestaurant.jpg)">
					${restaurant.nom}
				</div>
			</c:when>
			<c:otherwise>
				<div class="card-category"
					style="background-image: linear-gradient(rgba(0,0,0,0.3), rgba(0,0,0,0.3)), url(${restaurant.imageRestaurantUrl})">
					${restaurant.nom}
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	<div class="container">
		<div class="top">
			<div class="top-left-image">
				 <img src="${pageContext.request.contextPath}/images/entree01.jpg" alt="Une photographies de diverses entrées">
			</div>
			<div class="top-right-text">
				<div class="presentation">
				<p id="texte-presentation"> ${restaurant.nom} sera heureux de vous acueillir au <br> ${restaurant.adresse} de ${restaurant.heureOuverture} à ${restaurant.heureFermeture}</p>
				</div>
				<div class="entrees">
					<h1>Entrées</h1>
					<c:forEach var="plat" items="${plats}">
						<c:if test="${plat.categorie == 'ENTREE'}">
							<p>${plat.nom} ${plat.description} ${plat.prix}€</p>
						</c:if>
					</c:forEach>
				</div>
				<div class="plats">
					<h1>Plats</h1>
					<c:forEach var="plat" items="${plats}">
						<c:if test="${plat.categorie == 'PLAT'}">
							<p>${plat.nom} ${plat.description} ${plat.prix}€</p>
						</c:if>
					</c:forEach>		
				</div>
			</div>
		</div>
		<div class="bottom">
			<div class="bottom-left-text">
				<div class="desserts">
					<h1>Desserts</h1>
					<c:forEach var="plat" items="${plats}">
						<c:if test="${plat.categorie == 'DESSERT'}">
							<p>${plat.nom} ${plat.description} ${plat.prix}€</p>
						</c:if>
					</c:forEach>
				</div>
				<div class="boissons">
					<h1>Boissons</h1>
					<c:forEach var="plat" items="${plats}">
						<c:if test="${plat.categorie == 'BOISSON'}">
							<p>${plat.nom} ${plat.description} ${plat.prix}€</p>
						</c:if>
					</c:forEach>
				</div>
			</div>
			<div class="bottom-right-image">
				 <img src="${pageContext.request.contextPath}/images/boissons01.jpg" alt="Une photographies de diverses boissons">
			</div>
		</div>
		<div class="flex-item-buttons">
	    <form action="accueil" method="GET">
	      <input type="submit" value="Retour à la liste des restaurants" />
	    </form>
	
	
	    <form id="bouton-reserver" action="private/reservationTable" method="GET">
	      <input type="hidden" value="${restaurant.id}" name="restaurant.id" />
	      <input type="hidden" value="${restaurant.heureOuverture}"
	        name="heureOuverture" /> <input type="hidden"
	        value="${restaurant.heureFermeture}" name="heureFermeture" /> <input
	        type="submit" value="Reserver une table" />
	    </form>
	
	    <form action="private/envoyerMessage" method="GET">
	      <input type="submit" value="Envoyer un message" />
	    </form>
	  </div>
	</div>

</body>
</html>
