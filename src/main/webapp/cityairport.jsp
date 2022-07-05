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
					<h2>FlyAway City Airport Admin Setup</h2>

					<div class="card">
						<div class="card-body">
							<form action="CityAirportController" method="post" class='form-horizontal' role="form">

								<div class="row mb-3">

									<label for="airportcode" class="col-sm-2 col-form-label">Airport
										Code</label>

									<div class="col-sm-10">
										<input type="text" class="form-control input-sm"
											name="airportcode" aria-label="default input"
											placeholder="Enter Unique Aiport Code " required />
									</div>
								</div>

								<div class="row mb-3">

									<label for="airportcity" class="col-sm-2 col-form-label">Airport
										City</label>

									<div class="col-sm-10">
										<input type="text" class="form-control input-sm"
											name="airportcity" placeholder="Enter Aiport City " required />
									</div>
								</div>

								<div class="row mb-3">

									<label for="airportcountry" class="col-sm-2 col-form-label">Airport
										Country</label>

									<div class="col-sm-10">
										<select class="form-select form-select-sm"
											name="airportcountry" aria-label=".form-select-sm example" required>
											<option selected>Open this select menu</option>
											<option value="USA">USA</option>
											<option value="Nigeria">Nigeria</option>
											<option value="India">India</option>
											<option value="France">France</option>
											<option value="UAE">UAE</option>
										</select>
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