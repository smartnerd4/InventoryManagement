<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="/WEB-INF/css/header.css"%>
<html>
<head>
<title>Offer Letter</title>
</head>
<%@ include file="/WEB-INF/css/body.css"%>
<body>
	<div class="form">
		<h1>Offer Letter Generator</h1>
		<form modelAttribute="Offer" action="generateofferletter"
			method="post">

			<label>Employee Name: </label><input type="text"
				placeholder="Enter Employee Name" name="ename" autofocus required
				pattern="[a-zA-Z ]*"
				title="Employeename cannot contain special characters/numbers"></input><br>

			<label>Date of Joining: </label><input type="date" name="doj" required
				oninvalid="this.setCustomValidity('DOJ cannot be empty')"
				oninput="setCustomValidity('')"></input><br>
				
			<label>Cost to Company: </label><input type="number" name="ctc"
				placeholder="Enter CTC in Rupees" name="ctc" required></input><br>

			<label>Role: </label><select type="text" name="role" required>
				<option></option>
				<option value="Employee">Employee</option>
				<option value="Manager">Manager</option>
				<option value="Developer">Developer</option>
				<option value="Marketer">Marketer</option>
			</select><br>
			
			<label>Basic Salary: </label> <input type="number" name="basicsalary" value="0.4" required></input>*CTC<br>
				
			<label>HRA: </label><input type="number" name="hra" value="0.24" required></input>*CTC<br>
			
			<label>PF: </label><input type="number" name="pf" value="0.048" required></input>*CTC<br>
			
			<label>Standard Deduction: </label><input type="number" name="standarddeduction" value="0.04" required></input>*CTC<br>

			<label>LTA: </label><input type="number" name="lta" value="0.02" required></input>*CTC<br>

			<button id="button" type="submit" class="btn btn-primary">Generate Offer Letter</button><br>
			
			</br> ${m} </br> <a href="download/pdf/${name}">Download File</a>
		</form><br>
	</div>
</body>
</html>
<%@ include file="/WEB-INF/css/footer.css"%>