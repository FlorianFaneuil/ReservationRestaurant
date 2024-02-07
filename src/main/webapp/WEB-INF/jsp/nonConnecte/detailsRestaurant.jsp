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

	<c:choose>
		<c:when test="${empty restaurant.imageRestaurantUrl}">
			<div class="card-category"
				style="background-image: linear-gradient(rgba(0, 0, 0, 0.3), rgba(0, 0, 0, 0.3)),<img src="${pageContext.request.contextPath}/images/defautimagerestaurant.jpg"">
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
<%-- <div class="container">
	<div class = entete>
	    <div class="flex-item">
	      <p>${restaurant.adresse}</p>
	    </div>
	    <div class="flex-item">
	      <p>Ouverture : ${restaurant.heureOuverture} / Fermeture : ${restaurant.heureFermeture}</p>
	    </div>
	 </div>
	<div class="flex-item">
		<p>Carte :</p>
		<c:forEach var="plat" items="${plats}">
				<p>${plat.categorie}</p>
				<p>${plat.nom}</p>
				<p>${plat.description}</p>
				<p>${plat.prix}€</p>
		</c:forEach>
	</div>


  <div class="flex-item-buttons">
    <form action="accueil" method="GET">
      <input type="submit" value="Retour à la liste des restaurants" />
    </form>


    <form action="private/reservationTable" method="GET">
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

</div> --%>

	<div class="container">
		<div class="top">
			<div class="top-left-image">
				 <img src="${pageContext.request.contextPath}/images/entree01.jpg" alt="Une photographies de diverses entrées">
			</div>
			<div class="top-right-text">
				B
			</div>
		</div>
		<div class="bottom">
			<div class="bottom-left-text">
				C
			</div>
			<div class="bottom-right-image">
				 <img src="${pageContext.request.contextPath}/images/boissons01.jpg" alt="Une photographies de diverses boissons">
			</div>
		</div>
	</div>

</body>
</html>
