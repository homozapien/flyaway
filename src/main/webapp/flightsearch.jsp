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

	<c:choose>

		<c:when
			test="${sessionScope.scheduleList != null && not empty sessionScope.scheduleList}">

			<button class="btn btn-dark" onclick="history.back()">Go
				Back</button>
			<hr>

			<div class="container">
				<div class="jumbotron">
					<h2>FlyAway Customer Flight Search</h2>

					<div class="card">
						<div class="card-body">

							<form action="FlightSearchController" method="post"
								class='form-horizontal' role="form">

								<div class="row mb-3">

									<label for="deptCity" class="col-sm-2 col-form-label">Departure
										City </label>

									<div class="col-sm-10">
										<div class="col-sm-10">
											<input type="text" class="form-control input-sm"
												name="deptCity" placeholder="Flight Departure City "
												required />
										</div>
									</div>
								</div>
								<div class="row mb-3">

									<label for="deptCntry" class="col-sm-2 col-form-label">Departure
										Country </label>

									<div class="col-sm-10">
										<div class="col-sm-10">
											<input type="text" class="form-control input-sm"
												name="deptCntry" placeholder="Flight Departure Country "
												required />
										</div>
									</div>
								</div>

								<div class="row mb-3">

									<label for="destCity" class="col-sm-2 col-form-label">Destination
										City </label>

									<div class="col-sm-10">
										<div class="col-sm-10">
											<input type="text" class="form-control input-sm"
												name="destCity" placeholder="Flight Destination City "
												required />
										</div>
									</div>
								</div>
								<div class="row mb-3">

									<label for="destCntry" class="col-sm-2 col-form-label">Destination
										Country</label>

									<div class="col-sm-10">
										<div class="col-sm-10">
											<input type="text" class="form-control input-sm"
												name="destCntry" placeholder="Flight Destination Country "
												required />
										</div>
									</div>
								</div>

								<div class="row mb-3">

									<label for="numOfPassengers" class="col-sm-2 col-form-label">Passenger#
									</label>
									<div class="col-sm-10">
										<div class="col-sm-10">
											<input type="text" class="form-control input-sm"
												name="numOfPassengers" min="1"
												placeholder="Number of Passengers " required />
										</div>
									</div>
								</div>

								<div class="row mb-3">

									<label for="travelDate" class="col-sm-2 col-form-label">Travel
										Date </label>

									<div class="col-sm-10">
										<div class="col-sm-10">
											<input type="date" id="travelDate" name="travelDate"
												placeholder="Select Date of Travel " required>


										</div>
									</div>
								</div>

								<div class="form-group row">
									<label class="col-sm-2 col-form-label"></label>
									<div class="col-sm-7">
										<button type="submit" class="btn btn-primary">Search</button>
										<input class="btn btn-secondary" type="reset" value="Reset">
									</div>
								</div>
							</form>
						</div>
					</div>

				</div>
			</div>

			<hr>

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
									</tr>
								</thead>
								<c:forEach items="${sessionScope.scheduleList}" var="schedule">
									<tr>
										<td>${schedule.flightId}</td>
										<td><a href="airlinePopUp.jsp">${schedule.airline.id}</a></td>
										<td>${schedule.getCityAirportDept().getCity()}</td>
										<td>${schedule.getCityAirportDept().getCountry()}</td>
										<td>${schedule.getCityAirportDest().getCity()}</td>
										<td>${schedule.getCityAirportDest().getCountry()}</td>
										<td>${schedule.availableDate}</td>
										<td>${schedule.numOfConnections}</td>
										<td>${schedule.ticketPrice}</td>
									</tr>

								</c:forEach>

							</table>
						</div>
					</div>

				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="container">

				<div class="card">
					<div class="card-body">
						<div class="row mb-3">
							<div class="alert alert-danger">
								<p>Error! Flight Search can't proceed.</p>
								<p>Administrator has not created any flight schedules! Try
									again later</p>
							</div>
						</div>


						<div class="row mb-3">
							<a href="customer.jsp" class="btn btn-primary stretched-link">Customer
								Home</a>
						</div>

					</div>
				</div>
			</div>
		</c:otherwise>
	</c:choose>


</body>
</html>