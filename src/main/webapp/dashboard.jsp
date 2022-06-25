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

			<button class="btn btn-dark" onclick="history.back()">Go Back</button>
			<hr>

			<div class="container">
				<div class="jumbotron">
					<h2>FlyAway Admin Report Dashboard</h2>

					<div class="card">
						<div class="card-body">
						

								<div class="row mb-3">
                                  <h2>Show Airports Table Here</h2>
								</div>

								<div class="row mb-3">
                                     <h2>Show Airlines Table Here</h2>
								</div>

								<div class="row mb-3">
									<h2>Show Flight Schedule Table Here</h2>
								</div>
								<div class="row mb-3">
									<h2>Flight Bookings Table</h2>
								</div>
								<div class="row mb-3">
									<h2>Show Customers tables here</h2>
								</div>	
								<div class="row mb-3">

							<a href="admin.jsp" class="btn btn-primary stretched-link">Admin
								Home</a>
						</div>
							
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