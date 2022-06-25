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

			<button class="btn btn-dark" onclick="history.back()">Go Back</button>
			<hr>

			<div class="container">
				<div class="jumbotron">
					<h2>FlyAway Airline Administrative Setup</h2>

					<div class="card">
						<div class="card-body">
							<form action="AirlineController" method="post" class='form-horizontal' role="form">

								<div class="row mb-3">

									<label for="airlineid" class="col-sm-2 col-form-label">Airline Code</label>
									<div class="col-sm-10">
										<input type="text" class="form-control input-sm"
											name="airlineid" aria-label="default input"
											placeholder="Enter Unique Airline Identity number e.g. RISKY001, UNIQUE002, ALIEN003 " required />
									</div>
								</div>

								<div class="row mb-3">

									<label for="airlinename" class="col-sm-2 col-form-label">Airline Name
										</label>

									<div class="col-sm-10">
										<input type="text" class="form-control input-sm"
											name="airlinename" placeholder="Enter Airline Operational Name " />
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