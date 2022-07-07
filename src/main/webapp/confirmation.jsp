<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="mybootstrap.jsp"%>
</head>
<body>

	<c:if test="${requestScope.msg != null && not empty requestScope.msg}">
		<hr>
		<div class="container">
			<div class="card">
				<div class="card-body">

					<div class="row mb-3">
						<div class="alert alert-success">${requestScope.msg}</div>
					</div>

				</div>
			</div>
		</div>

	</c:if>

	<c:choose>

		<c:when test="${sessionScope.user != null}">

			<div class="container">
				<div class="jumbotron">

					<h4>Confirmed Booking Details</h4>
					<div class="card">
						<div class="card-body">
							
							<table class="table table-striped">

								<thead>
									<tr>
										<td>Booking Reference</td>
										<td>Flight Id</td>
										<td>Passenger#</td>
										<td>Booked By</td>
										<td>IsFlightConfirmed ?</td>
									</tr>
								</thead>
									<tr>
										<td>${requestScope.flightBooking.getBookingId()}</td>
										<td>${requestScope.flightBooking.getFlightSchedule().getFlightId()}</td>
										<td>${requestScope.flightBooking.getNumOfPassengers()}</td>
										<td>${requestScope.flightBooking.getBookedBy()}</td>
										<td>${requestScope.flightBooking.getIsFlightConfirmed()}</td>
										
									</tr>

							</table>
							
							
						</div>
					</div>
				</div>
			</div>
			<hr>
			<div class="container">
				<div class="jumbotron">

					<h4>Confirmed Booking Schedule</h4>
					<div class="card">
						<div class="card-body">
							
							<table class="table table-striped">

								<thead>
									<tr>
										<td>Flight Id</td>
										<td>Airline Id</td>
										<td>From</td>
										<td>To</td>
										<td>Connection#</td>
										<td>Ticket Price</td>
										<td>Departure Date</td>
									</tr>
								</thead>
									<tr>
										<td>${requestScope.flightSchedule.getFlightId()}</td>
										<td>${requestScope.flightSchedule.getAirline().getId()}</td>
										<td>${requestScope.flightSchedule.getCityAirportDept().getCode()}</td>
										<td>${requestScope.flightSchedule.getCityAirportDest().getCode()}</td>
										<td>${requestScope.flightSchedule.getNumOfConnections()}</td>
										<td>${requestScope.flightSchedule.getTicketPrice()}</td>
										<td>${requestScope.flightSchedule.getAvailableDate()}</td>
									</tr>

							</table>							
						</div>
					</div>
				</div>
			</div>
			<hr>

			<div class="container">
				<div class="jumbotron">
					<h4>Confirmed Passenger Details</h4>

					<div class="card">
						<div class="card-body">

							<table class="table table-striped">

								<thead>
									<tr>
									    <td>Booking Id</td>
										<td>Passenger Id</td>
										<td>Firstname</td>
										<td>Lastname</td>
										<td>Email Id</td>
										
									</tr>
								</thead>
								<c:forEach items="${requestScope.listOfPassengers}" var="passenger">
									<tr>
									    <td>${passenger.getFlightBooking().getBookingId()}</td>
										<td>${passenger.getPassengerId()}</td>
										<td>${passenger.getFirstname()}</td>
										<td>${passenger.getLastname()}</td>
										<td>${passenger.getEmailId()}</td>
									</tr>

								</c:forEach>

							</table>
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