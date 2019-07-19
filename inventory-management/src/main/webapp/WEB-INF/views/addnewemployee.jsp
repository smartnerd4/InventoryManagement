<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="/WEB-INF/css/header.css"%>
<html>
<head>
<title>Add New Employee</title>
</head>
<%@ include file="/WEB-INF/css/body.css"%>
<body>
	<div style="text-align: center">
		<h1>Add New Employee</h1>
		<form modelAttribute="addnewemp" action="addnewemployee" method="post">

			<div class="form-group">
				<label for="ename">Employee Name:</label> <input path="name"
					type="text" class="form-control" id="name"
					placeholder="Enter Employeename" name="employee_Name" autofocus required
					pattern="[a-zA-Z ]*"
					title="Employeename cannot contain special characters/numbers"></input>
			</div>
			<div class="form-group">
				<label for="emailid">Email ID:</label> <input path="emailid"
					type="email" class="form-control" id="emailid"
					placeholder="Enter EmailID" name="employee_Email" required></input>
			</div>
			<div class="form-group">
				<label for="deptid">Department ID:</label> <input path="deptid"
					type="number" class="form-control" id="deptid"
					placeholder="Enter DeptID" name="dept_Id" required></input>
			</div>
			<div class="form-group">
				<label for="doj">Date of Joining:</label> <input path="doj"
					type="date" class="form-control" id="doj" name="doj" required
					oninvalid="this.setCustomValidity('DOJ cannot be empty')"
					oninput="setCustomValidity('')"></input>
			</div>
			<div class="form-group">
				<label for="panno">Pan Number:</label> <input path="panno"
					type="number" class="form-control" id="panno"
					placeholder="Enter Pan Number" name="pan_Number" required></input>
			</div>
			<div class="form-group">
				<label for="aadno">Aadhar Number:</label> <input path="aadno"
					type="number" class="form-control" id="aadno"
					placeholder="Enter Aadhar Number" name="aadhar_Number" required></input>
			</div>
			<div class="form-group">
				<label for="workexp">Work Experience:</label> <input path="workexp"
					type="number" class="form-control" id="workexp"
					placeholder="Enter Work Experience in yrs" name="work_Experience" required></input>
			</div>
			<div class="form-group">
				<label for="prevorg">Previous Organisation:</label> <input
					path="prevorg" type="text" class="form-control" id="prevorg"
					placeholder="Enter Previous Organisation name" name="previous_Organisation" required></input>
			</div>
			<div class="form-group">
				<label for="relevdate">Relev Date:</label> <input path="relevdate"
					type="date" class="form-control" id="relevdate"
					placeholder="Enter Relev Date" name="relev_Date" required
					oninvalid="this.setCustomValidity('Relevdate cannot be empty')"
					oninput="setCustomValidity('')"></input>
			</div>
			<div class="form-group">
				<label for="reportingid">Reporting ID:</label> <input
					path="reportingid" type="number" class="form-control"
					id="reportingid" placeholder="Enter ReportingID" name="reporting_Id"
					required></input>
			</div>
			<div class="form-group">
				<label for="managerid">Manager ID:</label> <input path="managerid"
					type="number" class="form-control" id="managerid"
					placeholder="Enter ManagerID" name="manager_Id" required></input>
			</div>
			<div class="form-group">
				<label for="highqual">Highest Qualification:</label> <input
					path="highqual" type="text" class="form-control" id="highqual"
					placeholder="Enter Highest Qualification" name="education_Qualification" required></input>
			</div>

			<div class="form-group">
				<label for="city">City:</label> <select path="city" type="number"
					class="form-control" id="city" name="CITY">
					<option value="9">Hyderabad</option>
					<option value="8">Vishakapatnam</option>
					<option value="1">Amaravathi</option>
					<option value="2">Bangalore</option>
					<option value="4">Pune</option>
					<option value="3">Chennai</option>
					<option value="5">Mumbai</option>
					<option value="7">Others</option>
				</select>
			</div>
			<button id="button" type="submit" class="btn btn-primary">Submit</button>
		</form>
		${msg}
	</div>
</body>
</html>
<%@ include file="/WEB-INF/css/footer.css"%>