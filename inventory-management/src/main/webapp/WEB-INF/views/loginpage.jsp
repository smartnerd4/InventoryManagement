<%@ include file="/WEB-INF/css/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Smartnerd Login</title>
</head>
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
</style>

<body>
	<div style="text-align: center">
		<h1>LOGIN PAGE</h1>
		<form modelAttribute="login" action="login" method="post">

			<div class="form-group">
				<label for="name">Username:</label> <input path="name" type="text"
					class="form-control" id="name" placeholder="Enter Username"
					name="name">
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label> <input path="password"
					type="password" class="form-control" id="pwd"
					placeholder="Enter Password" name="password">
			</div>
			<button id="button" type="submit" class="btn btn-primary">Login</button>
		</form>
		${message}
	</div>
</body>
</html>