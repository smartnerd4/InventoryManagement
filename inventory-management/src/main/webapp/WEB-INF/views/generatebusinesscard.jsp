<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="/WEB-INF/css/header.css"%>
<html>
<head>
<title>Onboard Employee</title>
</head>
<%@ include file="/WEB-INF/css/body.css"%>
<body>
	<div class="form">
		<h1>Generate Business Card</h1>
		<form modelAttribute="" action="" method="post">

				<label>Employee Name:</label> <input type="text" placeholder="Enter Employeename"
					name="employeeName" autofocus required pattern="[a-zA-Z ]*"
					title="Employeename cannot contain special characters/numbers"></input><br>
				
				<label>Designation:</label><input type="text" placeholder="Enter Designation"
					name="designation" required></input><br>
					
				<label>Phone Number:</label><input type="number" placeholder="Enter Phone Number"
					name="phoneNumber" required></input><br>
					
				<label>E-Mail:</label><input type="email" placeholder="Enter E-Mail"
					name="email" required></input><br>	
					
			<button id="button" type="submit" class="btn btn-primary">Generate Business Card</button><br>
			
			<br><strong>${msg}</strong><br><br>
					
			</div>
		</form>
</body>
</html>
<%@ include file="/WEB-INF/css/footer.css"%>