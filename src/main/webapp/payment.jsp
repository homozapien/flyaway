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

					<h4>Flyaway Payment Registration</h4>
					<div class="card">
						<div class="card-body">
							<form action="RegistrationController" method="get">
							
							 <div class="row mb-3">

									<label for="bookingRef" class="col-sm-2 col-form-label">Booking
										Reference</label>

									<div class="col-sm-10">
										<input type="text" class="form-control input-sm"
											name="bookingRef" aria-label="default input" value="${requestScope.booking.getBookingId()}"
											readonly />
									</div>
								</div>

								<div class="row mb-3">

									<label for="flightId" class="col-sm-2 col-form-label">Flight
										Id</label>

									<div class="col-sm-10">
										<input type="text" class="form-control" name="flightId"
											value="${requestScope.flightId}" readonly />
									</div>
								</div>
								
								<div class="row mb-3">

									<label for="bookedBy" class="col-sm-2 col-form-label">Booked
										By</label>

									<div class="col-sm-10">
										<input type="text" class="form-control" name="bookedBy"
											value="${sessionScope.user.getEmailId()}" readonly />
									</div>
								</div>
																
								<div class="row mb-3">

									<label for="passengerId" class="col-sm-2 col-form-label">Passenger
										Id</label>

									<div class="col-sm-10">
										<input type="text" class="form-control" name="passengerId" value="${requestScope.passenger.getPassengerId()}"
											readonly />
									</div>
								</div>
								<hr>
								 <div class="row mb-3">

									<label for="ticketPrice" class="col-sm-2 col-form-label">Total Charge
										</label>

									<div class="col-sm-10">
										<input type="text" class="form-control input-sm"
											name="ticketPrice" aria-label="default input" value="${requestScope.totalCharge}"
											readonly  />
									</div>
								</div>
								
								<div class="row mb-3">

									<label for="creditCard" class="col-sm-2 col-form-label">Credit Card#
										</label>

									<div class="col-sm-10">
										<input type="text" class="form-control input-sm"
											name="creditCard" aria-label="default input" placeholder="Enter credit card"
											 required/>
									</div>
								</div>
								
								<hr>

								<label class="col-sm-2 col-form-label"></label>

								<button type="submit" class="btn btn-primary">Make Payment</button>
								<input class="btn btn-secondary" type="reset" value="Reset">

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