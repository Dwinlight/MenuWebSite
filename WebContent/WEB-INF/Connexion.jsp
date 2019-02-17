<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Connexion</title>
	<link rel="stylesheet" href="Connexion.css">
</head>
<body>
	<h1>Connexion : </h1>
	<div id="main">
	
		<form method="post">
  			 <p>
       			<label for="pseudo">Votre pseudo :</label>
       			<input type="text" name="pseudo" id="pseudo" />
       
       			<br />
       			
       			<label for="pass">Votre mot de passe :</label>
       			<input type="password" name="pass" id="pass" />
       			
       			<br />
       			
       			<input type="submit" value="Connexion" />
       
   			</p>
		</form>
		<a href="https://openclassrooms.com">Mot de passe ou pseudo oublié</a>
	</div>
</body>
</html>