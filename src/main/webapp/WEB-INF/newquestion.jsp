<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title> Titulo </title>
	<!-- Bootstrap -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- Estilos Locales -->
	<link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
	<h1 class="text-center">New Question</h1>
	<div class="container">
		<h1 class="display-2">What is your Question?</h1>
		
		<form action="/questions/create" method="POST">
		    <p>
		        <label class="col-sm-2 col-form-label">Question:</label>
		        <errors name="question"/>
		        <input class="form-control col-sm-6" name="question"/>
		    </p>
		     <p>
		        <label class="col-sm-2 col-form-label">Tags:</label>
		        <errors name="subject"/>
		        <input class="form-control col-sm-6" name="subject"/>
		    </p>
		    		 
		    <input type="submit" class="btn btn-warning" value="Submit"/>
		</form> 
		<a class="btn btn-primary" href="/">home</a>
	</div>

	<!-- jQuery (No necesario en Bootstrap 5) -->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<!--Bootstrap -->
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<!-- Javascript Local -->
	<script src="/js/app.js"></script>
</body>
</html>