<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="/WEB-INF/css/header.css"%>
<html>
<head>
<title>Onboard Employees</title>
</head>
<%@ include file="/WEB-INF/css/body.css"%>

<body>
	<div style="text-align: center">
		<h1>Onboard Employee</h1>
		<form modelAttribute="onboardemp" action="onboardemployee"
			method="post">

			<div class="form-group">
				<label for="ename">Employee Name:</label> <input path="name"
					type="text" class="form-control" id="name"
					placeholder="Enter Employeename" name="employee_Name" autofocus
					required pattern="[a-zA-Z ]*"
					title="Employeename cannot contain special characters/numbers"></input>
			</div>
			<button id="button" type="submit" class="btn btn-primary">Search</button>
			<div align="center">
			
			<br><strong>${msg}</strong><br><br>
			
				<table border="1" cellpadding="5">
					<tr>
						<th>Employee-ID</th>
						<th>Employee-Name</th>
						<th>Employee-Email</th>
						<th>Department-ID</th>
						<th>DOJ</th>
						<th>PAN-No</th>
						<th>Aadaar-No</th>
						<th>Work-Exp</th>
						<th>Previous-Organisation</th>
						<th>Relev-Date</th>
						<th>Reporting-ID</th>
						<th>Manager-ID</th>
						<th>Qualification</th>
						<th>SYS-Create-Date</th>
						<th>SYS-Last-Mod-Date</th>
					</tr>
					<tr>
						<td>${eid}</td>
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



					</tr>



				</table>
			</div>
		</form>
</body>
</html>
<%@ include file="/WEB-INF/css/footer.css"%>