<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="/WEB-INF/css/header0.css"%>
<html>
<head>
<title>Smartnerd Login</title>
</head>
<%@ include file="/WEB-INF/css/body.css"%>
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
<%@ include file="/WEB-INF/css/footer.css"%>