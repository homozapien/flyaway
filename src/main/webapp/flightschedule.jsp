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

			<button class="btn btn-dark" onclick="history.back()">Go
				Back</button>
			<hr>

			<div class="container">
				<div class="jumbotron">
					<h2>FlyAway Flight Scheduler</h2>

					<div class="card">
						<div class="card-body">
							<form action="FlightScheduleController" method="post"
								class='form-horizontal' role="form">

								<div class="row mb-3">

									<label for="flightId" class="col-sm-2 col-form-label">Flight
										Id </label>

									<div class="col-sm-10">
										<input type="text" class="form-control input-sm"
											name="flightId" aria-label="default input"
											placeholder="Enter Airline Flight Id " required />
									</div>
								</div>

								<div class="row mb-3">

									<label for="airlineId" class="col-sm-2 col-form-label">Airline
										Id</label>

									<div class="col-sm-10">
										<input type="text" class="form-control input-sm"
											name="airlineId" placeholder="Enter Airline Id " required />
									</div>
								</div>

								<div class="row mb-3">

									<label for="deptAirport" class="col-sm-2 col-form-label">Departure
										Airport </label>

									<div class="col-sm-10">
										<div class="col-sm-10">
											<input type="text" class="form-control input-sm"
												name="deptAirport" placeholder="Enter Flight Departure Airport code "
												required />
										</div>
									</div>
								</div>
								
								<div class="row mb-3">

									<label for="destAirport" class="col-sm-2 col-form-label">Destination
										Airport </label>

									<div class="col-sm-10">
										<div class="col-sm-10">
											<input type="text" class="form-control input-sm"
												name="destAirport" placeholder="Enter Flight Destination Airport code "
												required /> 
										</div>
									</div>
								</div>
								
								
								<div class="row mb-3">

									<label for="numOfConnections" class="col-sm-2 col-form-label">Flight Connections
										</label>

									<div class="col-sm-10">
										<div class="col-sm-10">
											<input type="text" class="form-control input-sm"
												name="numOfConnections" value="0"
												placeholder="Enter number 0f flight connections " required />
										</div>
									</div>
								</div>
								
								<div class="row mb-3">

									<label for="ticketPrice" class="col-sm-2 col-form-label">Ticket Price
										</label>

									<div class="col-sm-10">
										<div class="col-sm-10">
											<input type="text" class="form-control input-sm"
												name="ticketPrice"
												placeholder="Enter ticket price" required /> 
										</div>
									</div>
								</div>
								
								<div class="row mb-3">

									<label for="availableDate" class="col-sm-2 col-form-label">Available Date
										</label>

									<div class="col-sm-10">
										<div class="col-sm-10">
											<input type="date" id="availableDate" name="availableDate" placeholder="Select flight date " required >
                                                  
                                                
										</div>
									</div>
								</div>

								<div class="form-group row">
									<label class="col-sm-2 col-form-label"></label>
									<div class="col-sm-7">
										<button type="submit" class="btn btn-primary">Submit</button>
										<input class="btn btn-secondary" type="reset" value="Reset">
									</div>
								</div>
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