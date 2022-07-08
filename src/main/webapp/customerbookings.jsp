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

		<c:when test="${sessionScope.user != null && requestScope.flightBookingList != null}">

			<div class="container">
				<div class="jumbotron">

					<h4> Bookings By Me</h4>
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
								<c:forEach items="${requestScope.flightBookingList}" var="flightBooking">
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