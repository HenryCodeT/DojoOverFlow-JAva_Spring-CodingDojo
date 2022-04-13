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
</head>
<body>
	<div class="container">
		<h1 class="display-2"><c:out value="${question.question}"/></h1>
		<a class="btn btn-primary" href="/">home</a>
		<h5>Tags: 
			<c:forEach var="subject" items="${question.tags}">
				<div class="border border-dark m-2 d-inline-block">
					${subject.subject}
				</div>
			</c:forEach>
		</h5>
		<div class="row">
			<table class="table table-striped section_one">
			  <thead class="thead-light">
			    <tr>
			      <th scope="col">Answers</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach var="answer" items="${answers}" >
			    <tr>
			      <td><c:out value="${answer.answer}"/></td>
			    </tr>
			    </c:forEach>
			  </tbody>
			</table>
			<div class="section_two"></div>
			<h5>Add your Answer:</h5>
			<div></div>
			<form action="/questions/${question.id}/answer" method="POST" >
				<div>
		        	<label class="col-md-6 col-form-label" >Answer:</label>
		        	<input class="form-control col-md-6" name="answer"/> 
				</div>				
		    	<input type="submit" class="btn btn-warning" value="Answer It!"/>
			</form>
		</div> 
	</div>
	<!--Bootstrap -->
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>