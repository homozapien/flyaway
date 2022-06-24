<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="mybootstrap.jsp"%>
</head>
<body>

	<c:choose>

		<c:when test="${sessionScope.admin != null}">

			<button onclick="history.back()">Go Back</button>
			<hr>

			<div class="container">
				<div class="jumbotron">
					<h2>FlyAway City Airport Admin Setup</h2>

					<div class="card">
						<div class="card-body">
							<form action="CityAirportController" method="post">
							
							
							
							</form>
						</div>
					</div>

				</div>
			</div>
		</c:when>
		<c:otherwise>
			<%
	          response.sendRedirect("index.jsp");
         %>
		</c:otherwise>
	</c:choose>


</body>
</html>