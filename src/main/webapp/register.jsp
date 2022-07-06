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
	<hr>
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

	<c:choose>

		<c:when test="${sessionScope.user != null}">

			<!--<c:set var="userMgmt" scope="page" value="${sessionScope.user}" /> -->

			<div class="container">
				<div class="jumbotron">

					<h4>Flyaway Booking Registration</h4>
					<div class="card">
						<div class="card-body">
							<form action="RegistrationController" method="post">

								<div class="row mb-3">

									<label for="flightId" class="col-sm-2 col-form-label">Flight
										Id</label>

									<div class="col-sm-10">
										<input type="text" class="form-control" name="flightId"
											value="${requestScope.flightIdToBook}" readonly />
									</div>
								</div>
								
								<div class="row mb-3">

									<label for="passengerNum" class="col-sm-2 col-form-label">Passenger#</label>

									<div class="col-sm-10">
										<input type="text" class="form-control" name="passengerNum"
											value="${requestScope.passengerNum}" readonly />
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
								<hr>
								<div class="row mb-3">

									<label for="passengerId" class="col-sm-2 col-form-label">Passenger
										Id</label>

									<div class="col-sm-10">
										<input type="text" class="form-control" name="passengerId"
											placeholder="Enter Passenger ID number" required />
									</div>
								</div>

								<div class="row mb-3">

									<label for="firstname" class="col-sm-2 col-form-label">Passenger
										Firstname</label>

									<div class="col-sm-10">
										<input type="text" class="form-control input-sm"
											name="firstname" aria-label="default input"
											placeholder="Enter passenger firstname" required />
									</div>
								</div>

								<div class="row mb-3">

									<label for="lastname" class="col-sm-2 col-form-label">Passenger
										Lastname</label>

									<div class="col-sm-10">
										<input type="text" class="form-control input-sm"
											name="lastname" aria-label="default input"
											placeholder="Enter passenger lastname" required />
									</div>
								</div>

								<div class="row mb-3">

									<label for="pemailId" class="col-sm-2 col-form-label">Passenger
										Email</label>

									<div class="col-sm-10">
										<input type="email" class="form-control input-sm"
											name="pemailId" aria-label="default input"
											placeholder="Enter passenger email id" required />
									</div>
								</div>

								<hr>

								<label class="col-sm-2 col-form-label"></label>

								<button type="submit" class="btn btn-primary">Register</button>
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