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
			
			<div class="container">
			<div class="jumbotron">
              <h2>FlyAway Administrative Operations</h2>    
            </div>

				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Operation Description</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><a href="changepassword.jsp">Change Password</a></td>
							<td>Password Management</td>
						</tr>
						<tr>

							<td><a href="cityairport.jsp">Airports</a></td>
							<td>Setup airports in cities in countries</td>
						</tr>
						<tr>
							<td><a href="airline.jsp">Airline</a></td>
							<td>Setup Airlines</td>
						</tr>

						<tr>
							<td><a href="flightschedule.jsp">Flight Schulde</a></td>
							<td>Setup Airlines flight Schedule</td>
						</tr>
						
						<tr>
							<td><a href="DataloaderController">Reporting Dashboard</a></td>
							<td>Show readonly reporting dashboard</td>
						</tr>					
						
					<tbody>
				</table>
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