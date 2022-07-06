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

		<c:when test="${sessionScope.admin != null}">
		
		<c:set var = "userMgmt" scope = "page" value="${sessionScope.admin}" />

			<div class="container">
			<div class="jumbotron">

				<h4>Flyaway Admin Password Management</h4>
				<div class="card">
					<div class="card-body">
						<form action="PasswordMgmtController" method="post">

							<div class="row mb-3">

								<label for="email" class="col-sm-2 col-form-label">Email</label>

								<div class="col-sm-10">
									<input type="email" class="form-control" name="email" value="${userMgmt.getEmailId()}"
									readonly />
								</div>
							</div>

							<div class="row mb-3">
								<label for="currentpassword" class="col-sm-2 col-form-label">Current
									Password</label>

								<div class="col-sm-10">
									<input type="password" name="currentpassword"
										placeholder="Enter current password" required/>

								</div>
							</div>

							<div class="row mb-3">
								<label for="newpassword" class="col-sm-2 col-form-label">New
									Password</label>

								<div class="col-sm-10">
									<input type="password" name="newpassword"
										placeholder="Enter new password" required />

								</div>
							</div>

							<hr>

							<label class="col-sm-2 col-form-label"></label>

							<button type="submit" class="btn btn-primary">Submit</button>
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