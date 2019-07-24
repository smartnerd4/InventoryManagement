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
		<form modelAttribute="Offer" action="generateofferletter"
			method="post">

			<div class="form-group">
				<label for="ename">Employee Name:</label> <input path="ename"
					type="text" class="form-control" id="ename" name="ename" autofocus
					required pattern="[a-zA-Z ]*"
					title="Employeename cannot contain special characters/numbers">
			</div>
			<div class="form-group">
				<label for="doj">Date of Joining:</label> <input path="doj"
					type="date" class="form-control" id="doj" name="doj" ut path="doj"
					type="date" class="form-control" id="doj" required
					oninvalid="this.setCustomValidity('DOJ cannot be empty')"
					oninput="setCustomValidity('')">
			</div>
			<div class="form-group">
				<label for="ctc">Cost to Company:</label> <input path="ctc"
					type="text" class="form-control" id="ctc" name="ctc" required>
			</div>
			<div class="form-group">
				<label for="role">Role:</label> <select path="role" type="text"
					class="form-control" id="role" name="role">
					<option value="Employee">Employee</option>
					<option value="Managers">Managers</option>
					<option value="Developer">Developer</option>
					<option value="Marketing">Marketing</option>
				</select>
			</div>
			<div class="form-group">
				<label for="bs">Basic Salary:</label> <input type="number"
					class="form-control" id="bs" name="basicsalary" value="0.4" />*CTC
			</div>
			<div class="form-group">
				<label for="hra">HRA:</label> <input type="number"
					class="form-control" id="hra" name="hra" value="0.24" />*CTC
			</div>
			<div class="form-group">
				<label for="pf">PF:</label> <input type="number"
					class="form-control" id="pf" name="pf" value="0.048" />*CTC
			</div>
			<div class="form-group">
				<label for="sd">Standard Deduction:</label> <input type="number"
					class="form-control" id="sd" name="standarddeduction" value="0.04" />*CTC
			</div>
			<div class="form-group">
				<label for="lta">LTA:</label> <input type="number"
					class="form-control" id="lta" name="lta" value="0.02" />*CTC
			</div>
			<button id="button" type="submit" class="btn btn-primary">Generate
				Offer Letter</button>
			</br> ${m} </br> <a href="download/pdf/${name}">Download File </a>
		</form>
	</div>
</body>
</html>
<%@ include file="/WEB-INF/css/footer.css"%>