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
		<h1>Onboard Employee</h1>
		<form modelAttribute="onboardemp" action="onboardemployee" method="post">

				<label>Employee Name:</label> <input type="text" placeholder="Enter Employeename"
					name="employeeName" autofocus required pattern="[a-zA-Z ]*"
					title="Employeename cannot contain special characters/numbers"></input><br>

			<button id="button" type="submit" class="btn btn-primary">Search</button><br>
			
			<br><strong>${msg}</strong><br><br>
			
				<table cellpadding="5" border="1">
					<tr class="TableHeader">
						<th>Employee ID</th>
						<th>Employee Name</th>
						<th>Employee Email</th>
						<th>Dept ID</th>
						<th>Date of Joining</th>
						<th>PAN Number</th>
						<th>Aadhaar Number</th>
						<th>Work Experience</th>
						<th>Previous Organisation</th>
						<th>Relev Date</th>
						<th>Reporting ID</th>
						<th>Manager ID</th>
						<th>Highest Qualification</th>
						<th>System Created Date</th>
						<th>System Last Modified Date</th>
						<th>QR-Code</th>
					</tr>
					<tr>
						<td><a href="download/img/${eid}">${eid}</a></td>
						<td>${ename}</td>
						<td>${eemail}</td>
						<td>${edeptid}</td>
						<td>${edoj}</td>
						<td>${epanno}</td>
						<td>${eaadno}</td>
						<td>${eworkexp}</td>
						<td>${eprevorg}</td>
						<td>${erelevdate}</td>
						<td>${erepid}</td>
						<td>${emanid}</td>
						<td>${ehighqual}</td> 
						<td>${esyscredate}</td>
						<td>${esyslastdate}</td>
						<td><img src="data:image/png;base64,${blob}" /></td>
					</tr>
				</table>
			</div>
		</form>
</body>
</html>
<%@ include file="/WEB-INF/css/footer.css"%>