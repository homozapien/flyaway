<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="mybootstrap.jsp"%>
</head>
<body>
	<div class="container">

		<h2>Flyaway Login Portal</h2>
		<div class="card">
			<div class="card-body">
				<form action="LoginController" method="get">

					<div class="row mb-3">

						<label for="email" class="col-sm-2 col-form-label">Email</label>

						<div class="col-sm-10">
							<input type="email" class="form-control" name="email"
								placeholder="Enter Login Email" />
						</div>
					</div>

					<div class="row mb-3">
						<label for="password" class="col-sm-2 col-form-label">Password</label>

						<div class="col-sm-10">
							<input type="password" name="password"
								placeholder="Enter password" />

						</div>
					</div>

					<!--  <div class="row mb-3">
						<label class="col-sm-2 col-form-label">TypeOfUser</label> -->
					<fieldset class="row mb-3">
					
                       <legend class="col-form-label col-sm-2 pt-0">User Type</legend>	

						<div class="col-sm-10">

							<div class="form-check">							
									 <label class="form-check-label">
									     <input class="form-check-input" type="radio" name="typeOfUser" id="adminRadioBttn" value="Admin">Administrator 	
									</label> 
								</div>	
								<div class="form-check">
									<label class="form-check-label">
									     <input class="form-check-input" type="radio" name="typeOfUser" id="custRadioBttn" value="Customer">Customer 	
									</label>
							</div>
						</div>
					<!--  /div -->
					</fieldset>
					
					<hr>
               <div class="row mb-3">
                 <label class="col-sm-2 col-form-label"></label>
                 <div class="col-sm-10">
					<button type="submit" class="btn btn-primary">Submit</button>
					<input class="btn btn-secondary" type="reset" value="Reset">
					</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

</html>