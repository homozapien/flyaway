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
			<div class="alert alert-success">Success! Well done its
				submitted.</div>
		</c:when>
		<c:otherwise>
			<%
			response.sendRedirect("index.jsp");
			%>
		</c:otherwise>
	</c:choose>
</body>
</html>