<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="mybootstrap.jsp"%>
</head>
<body>

	<button class="btn btn-dark" onclick="history.back()">Go Back</button>

	<c:if test="${requestScope.msg != null && not empty requestScope.msg}">
		<hr>
		<div class="container">
			<div class="card">
				<div class="card-body">

					<div class="row mb-3">
						<div class="alert alert-danger">${requestScope.msg}</div>
					</div>

				</div>
			</div>
		</div>

	</c:if>

	<form action="BookingController" method="post" id="bookingForm"
		role="form">
		<input type="hidden" id="FlightIdToBook" name="FlightIdToBook">
		<c:if
			test="${requestScope.matchedFlightList != null && not empty requestScope.matchedFlightList}">

			<div class="container">
				<div class="jumbotron">
					<h4>Matching Flight(s) from Schedule </h4>

					<div class="card">
						<div class="card-body">

							<div class="row mb-3">

								<label for="numOfPassengers" class="col-sm-2 col-form-label">Passenger#
								</label>
								<div class="col-sm-10">
									<div class="col-sm-10">
										<input type="text" class="form-control input-sm"
											name="numOfPassengers" value="1"
											placeholder="Number of Passengers " required />
									</div>
								</div>
							</div>

							<div class="row mb-3">

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
											<td>Action</td>
										</tr>
									</thead>
									<c:forEach items="${requestScope.matchedFlightList}"
										var="schedule">
										<tr>
											<td>${schedule.flightId}</td>
											<td>${schedule.airline.id}</td>
											<td>${schedule.getCityAirportDept().getCode()}</td>
											<td>${schedule.getCityAirportDest().getCode()}</td>
											<td>${schedule.availableDate}</td>
											<td>${schedule.numOfConnections}</td>
											<td>${schedule.ticketPrice}</td>
											<td><button type="submit" class="btn btn-primary"
													onclick="document.getElementById('FlightIdToBook').value = '${schedule.flightId}';
										         document.getElementById('bookingForm').submit();">
													Book Me</button></td>
										</tr>

									</c:forEach>

								</table>
							</div>
						</div>
					</div>

				</div>
			</div>
		</c:if>
	</form>
</body>
</html>