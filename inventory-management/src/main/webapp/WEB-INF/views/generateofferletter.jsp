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
	<div style="text-align: center">
		<h1>Offer Letter Generator</h1>
		<form modelAttribute="generateol" action="generateofferletter"
			method="post">

			<div class="form-group">
				<label for="ename">Employee Name:</label> <input path="ename"
					type="text" class="form-control" id="ename"
					placeholder="Enter Employeename" name="ename" autofocus required
					pattern="[a-zA-Z ]*"
					title="Employeename cannot contain special characters/numbers"></input>
			</div>
			<div class="form-group">
				<label for="doj">Date of Joining:</label> <input path="doj"
					type="date" class="form-control" id="doj" required
					oninvalid="this.setCustomValidity('DOJ cannot be empty')"
					oninput="setCustomValidity('')"></input>
			</div>
			<div class="form-group">
				<label for="ctc">Cost to Company:</label> <input path="ctc"
					type="number" class="form-control" id="ctc"
					placeholder="Enter CTC in Rupees" name="ctc" required ></input>
			</div>
			<div class="form-group">
				<label for="role">Role:</label> <select path="role" type="text"
					class="form-control" id="role" name="role">
					<option value="Employee">Employee</option>
					<option value="Manager">Manager</option>
					<option value="Developer">Developer</option>
					<option value="Marketing">Marketing</option>
				</select>
			</div>

			<button id="button" type="submit" class="btn btn-primary">Generate
				Offer Letter</button>
		</form>
		${m}
	</div>
</body>
</html>
<%@ include file="/WEB-INF/css/footer.css"%>