<%@ include file="/WEB-INF/css/header1.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Offer Letter</title>
</head>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

input {
	width: 25%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 30%;
}
</style>

<body>
	<center>
		<h2>Generate Offer Letter</h2>

		<form modelAttribute="generateol" action="" method="post">
			Enter Employee-Name : <input type="text" path="ename"
				placeholder="Enter Employee-name" /> <br> Enter
			Date_of_Joining : <input type="date" path="doj"
				placeholder="Enter Date Of Joining" /> <br>
				Enter CTC : <input type="text" path="ctc"
				placeholder="Enter CTC" /> <br>
			<h4>
				Enter Role : <select name="role">
					<option value="employee">Employee</option>
					<option value="admin">Admin</option>
					<option value="other">Other</option>
			</h4>
			</select> <br><br>
			<button type="submit" value="submit">Generate Offer Letter</button>
		</form>
	</center>
</body>
</html>