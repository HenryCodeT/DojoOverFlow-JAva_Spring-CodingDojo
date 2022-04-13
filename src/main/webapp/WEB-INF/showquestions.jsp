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
	<h1 class="text-center">Questions Dashboard</h1>
	<div class="col-8 mx-auto">
		<table class="table table-dark table-striped">
			<thead class="thead-light">
				<tr>
					<th scope="col">Questions</th>
					<th scope="col">Tags</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="question" items="${questions}">
					<tr>
						<td>
							<a href="/questions/${question.id}">${question.question}"</a>
						</td>
						<td>
							<c:forEach var="subject" items="${question.tags}">
								${subject.subject}
							</c:forEach>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>	
		<a class="btn btn-warning text-end" href="questions/new">New Question</a>
	</div>
	<!--Bootstrap -->
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>