<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="/WEB-INF/css/header.css"%>
<html>
<head>
<title>Business Card</title>
</head>
<%@ include file="/WEB-INF/css/body.css"%>
<body>
	<div class="form">
		<h1>Generate Business Card</h1>
		<form modelAttribute="BusinessCardModel" action="" method="post">

				<label>Name:</label> <input type="text" placeholder="Enter Employeename"
					name="name" autofocus required pattern="[a-zA-Z ]*"
					title="Employeename cannot contain special characters/numbers"></input><br>
				
				<label>Designation:</label><input type="text" placeholder="Enter Designation"
					name="designation" required></input><br>
					
					  <label>Phone Number: </label><input type="text" placeholder="Enter Phone Number" name="phoneNumber" required
                required pattern="[0-9]{10}"
					title="Phone Number must contain ten-digit number"></input><br>
					
				<label>E-Mail:</label><input type="email" placeholder="Enter E-Mail"
					name="email" required></input><br>	
					
					<button id="button" type="submit" class="btn btn-primary">Generate Business Card</button><br>
			<h3>${msg}<br><a href="download/card/${name}">${view}</a></h3>
					
			</div>
		</form>
</body>
</html>
<%@ include file="/WEB-INF/css/footer.css"%>