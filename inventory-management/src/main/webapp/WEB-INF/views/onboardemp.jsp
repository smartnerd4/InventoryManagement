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
		<h1>Onboard Employees</h1>
		<form modelAttribute="Employee" action="onboardemp" method="post">

			<div class="form-group">
				<label for="EMP_NAME">Enter Employee-name:</label> <input path="name" type="text"
					class="form-control" id="name" placeholder="Enter Employee-name" name="employee_Name">
			</div>
			<button id="button" type="submit" class="btn btn-primary">Search</button>
			
		</form>
	</div>
	${eid}</hr>
	${ename}</hr>
	${eemail}</hr>
	${edid}</hr>
	${edoj}</hr>
	${epan}</hr>
	${eadar}</hr>
	${ewexp}</hr>
	${epro}</hr>
	${ereda}</hr>
	${erid}</hr>
	${emid}</hr>
	${esysDate}</hr>
	${esysLastDate}</hr>
	
	
</body>
</html>
<%@ include file="/WEB-INF/css/footer.css"%>