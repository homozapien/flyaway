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

				<div class="card">
					<div class="card-body">
						<div class="row mb-3">
							<div class="alert alert-success">Success! Well done its submitted.</div>								
						</div>
						<div class="row mb-3">
							<a href="DataloaderController" class="btn btn-primary stretched-link">Dashboard</a>
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