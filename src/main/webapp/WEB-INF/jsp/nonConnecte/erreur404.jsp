<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Page non trouv�e</title>
    <link href="${pageContext.request.contextPath }/css/404erreur.css" rel="stylesheet">
</head>
<body>
    <div class="error-container">
        <img src="${pageContext.request.contextPath }/img/404Chat.png" alt="chat">
        <p>D�sol�, la page que vous recherchez est introuvable.</p>
        <a href="${pageContext.request.contextPath }/accueil">Retour � la page d'accueil</a>
    </div>
</body>
</html>
    