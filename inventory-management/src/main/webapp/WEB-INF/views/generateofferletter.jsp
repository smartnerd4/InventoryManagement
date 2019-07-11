<%@ include file="/WEB-INF/css/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Smartnerd</title>

<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

input[type=text], input[type=password] {
	width: 60%;
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
</head>
<body>
	<div style="text-align: center">
		<h1>Offer Letter</h1>
		<form modelAttribute="Offer" action="generateofferletter" method="post">

			<div class="form-group">
				<label for="ename">Username:</label> <input path="ename" type="text"
					class="form-control" id="ename" name="ename">
			</div>
 				<div class="form-group"> 
 				<label for="doj">Doj:</label> <input path="doj" type="date" 
 					class="form-control" id="doj" > 
 			</div> 
 			<div class="form-group"> 
 				<label for="ctc">ctc:</label> <input path="ctc" type="text"
 					class="form-control" id="ctc"> 
			</div> 
 			<div class="form-group"> 
 				<label for="role">role:</label> <input path="role" type="text" 
					class="form-control" id="role"> 
 			</div> 
			
			<button id="button" type="submit" class="btn btn-primary">Generate Offer Letter</button>
</form>
		${m}
	</div>
</body>
</html>