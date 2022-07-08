<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../mybootstrap.jsp"%>
</head>
<body>

	<c:choose>

		<c:when test="${sessionScope.admin != null}">

			<button class="btn btn-dark" onclick="history.back()">Go
				Back</button>
			<hr>

			<div class="container">
				<div class="jumbotron">
					<h2>Admin Report Dashboard</h2>

					<!-- flightSchedules, airlines, airports -->

					<div class="card">
						<div class="card-body">

							<div class="row mb-3">

								<c:choose>
									<c:when test="${not empty airportList}">
										<div class="jumbotron">
											<h4>Available Airport</h4>
											<table class="table table-striped">

												<thead>
													<tr>
														<td>Code</td>
														<td>City</td>
														<td>Country</td>
													</tr>
												</thead>

												<c:forEach items="${airportList}" var="airport">
													<tr>
														<td>${airport.code}</td>
														<td>${airport.city}</td>
														<td>${airport.country}</td>

													</tr>

												</c:forEach>

											</table>
										</div>
									</c:when>
									<c:otherwise>
										<br>
										<div class="alert alert-info">No Airport currently
											available</div>
									</c:otherwise>
								</c:choose>

							</div>

							<div class="row mb-3">
								<c:choose>
									<c:when test="${not empty airlineList}">
										<div class="jumbotron">
											<h4>Available Airlines</h4>
											<table class="table table-striped">

												<thead>
													<tr>
														<td>Id</td>
														<td>Name</td>
													</tr>
												</thead>

												<c:forEach items="${airlineList}" var="airline">
													<tr>
														<td>${airline.id}</td>
														<td>${airline.name}</td>
													</tr>

												</c:forEach>

											</table>
										</div>
									</c:when>
									<c:otherwise>
										<br>
										<div class="alert alert-info">No Airline has been setup
											by admin</div>
									</c:otherwise>
								</c:choose>
							</div>

							<div class="row mb-3">
								<c:choose>
									<c:when test="${not empty scheduleList}">
										<div class="jumbotron">
											<h4>Available Schedules</h4>
											<table class="table table-striped">

												<thead>
													<tr>
														<td>Flight Id</td>
														<td>Airline Id</td>
														<td>Departure Airport</td>
														<td>Destination Airport</td>
														<td>Available Date</td>
														<td>Connections</td>
														<td>Ticket Price</td>
													</tr>
												</thead>
												<c:forEach items="${scheduleList}" var="schedule">
													<tr>
														<td>${schedule.flightId}</td>
														<td>${schedule.airline.id}</td>
														<td>${schedule.getCityAirportDept().getCode()}</td>
														<td>${schedule.getCityAirportDest().getCode()}</td>
														<td>${schedule.availableDate}</td>
														<td>${schedule.numOfConnections}</td>
														<td>${schedule.ticketPrice}</td>
													</tr>

												</c:forEach>

											</table>
										</div>
									</c:when>
									<c:otherwise>
										<br>
										<div class="alert alert-info">No Flight Schedule has
											been setup by admin</div>
									</c:otherwise>
								</c:choose>
							</div>
							<div class="row mb-3">
								<c:choose>
									<c:when test="${not empty flightBookingList}">
										<div class="jumbotron">
											<h4>All FlyAway Bookings</h4>
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

												<c:forEach items="${flightBookingList}" var="flightBooking">
													<tr>
														<td>${flightBooking.getBookingId()}</td>
														<td>${flightBooking.getFlightSchedule().getFlightId()}</td>
														<td>${flightBooking.getNumOfPassengers()}</td>
														<td>${flightBooking.getBookedBy()}</td>
														<td>${flightBooking.getIsFlightConfirmed()}</td>
													</tr>

												</c:forEach>

											</table>
										</div>
									</c:when>
									<c:otherwise>
										<br>
										<div class="alert alert-info">No Booking has been made
											in FlyAway portal</div>
									</c:otherwise>
								</c:choose>

							</div>
							<div class="row mb-3">
								<c:choose>
									<c:when test="${not empty passengerList}">
										<div class="jumbotron">
											<h4>All Booked Passenger Details</h4>
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
												<c:forEach items="${passengerList}" var="passenger">
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
									</c:when>
									<c:otherwise>
										<br>
										<div class="alert alert-info">No booked passenger
											details exit in FlyAway portal</div>
									</c:otherwise>
								</c:choose>
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