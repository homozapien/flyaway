<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="mybootstrap.jsp"%>
</head>
<body>

			<button class="btn btn-dark" onclick="history.back()">Go
				Back</button>
			
		<c:if test="${requestScope.matchedFlightList != null && not empty requestScope.matchedFlightList}">			

			<div class="container">
				<div class="jumbotron">
					<h4>Available Flight Schedule List</h4>

					<div class="card">
						<div class="card-body">

							<table class="table table-striped">

								<thead>
									<tr>
										<td>Flight Id</td>
										<td>Airline Id</td>									
										<td>Depart City</td>
										<td>Depart Country</td>
										<td>Dest City</td>
										<td>Dest Country</td>
										<td>Available Date</td>
										<td>Connections</td>
										<td>Ticket Price</td>
										<td>Action</td>
									</tr>
								</thead>
								<c:forEach items="${requestScope.matchedFlightList}" var="schedule">
									<tr>
										<td>${schedule.flightId}</td>
										<td>${schedule.airline.id}</td>
										<td>${schedule.getCityAirportDept().getCity()}</td>
										<td>${schedule.getCityAirportDept().getCountry()}</td>
										<td>${schedule.getCityAirportDest().getCity()}</td>
										<td>${schedule.getCityAirportDest().getCountry()}</td>
										<td>${schedule.availableDate}</td>
										<td>${schedule.numOfConnections}</td>
										<td>${schedule.ticketPrice}</td>
										<td><button type="submit" class="btn btn-primary">Book Me</button></td>
									</tr>

								</c:forEach>

							</table>
						</div>
					</div>

				</div>
			</div>
		</c:if>
</body>
</html>