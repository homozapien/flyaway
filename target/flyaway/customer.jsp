<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="mybootstrap.jsp"%>
</head>
<body>

			<div class="container">
				<div class="jumbotron">
					<h2>FlyAway Customer Operations</h2>
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
							<td><a href="CustomerDataLoader">Search Flights</a></td>
							<td>Search for a flight from the schedules</td>
						</tr>

						<tr>
							<td><a href="CustomerBookingsController">My Bookings</a></td>									
							<td>Show My Bookings</td>
						</tr>
					<tbody>
				</table>
			</div>
	
</body>
</html>