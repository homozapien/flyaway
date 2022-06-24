<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="mybootstrap.jsp"%>
</head>
<body>

	<%
     String admin = (String)session.getAttribute("admin");
       if(admin==null)
           {
	          response.sendRedirect("index.jsp");
           }
           else 
           {
	           out.println("Welcome to Admin Home Page "+admin);	
           }
%>

	<h2>Welcome to FlyAway Admin Home Page</h2>

	<c:if test="${sessionScope.admin != null}">
		<!-- As a link -->
		<nav class="navbar navbar-light bg-light">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">Navbar</a>
			</div>
		</nav>

		<!-- As a heading -->
		<nav class="navbar navbar-light bg-light">
			<div class="container-fluid">
				<span class="navbar-brand mb-0 h1">Navbar</span>
			</div>
		</nav>

	</c:if>

</body>
</html>