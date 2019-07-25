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
		<div class="form">
		<h1>LOGIN PAGE</h1>
		<form modelAttribute="login" action="loginpage" method="post">

			<label>Username: </label><input type="text" placeholder="Enter Username" name="name"
				autofocus required pattern="[a-zA-Z ]*"
				title="Username cannot contain special characters/numbers"></input><br>

			<label>Password: </label><input type="password" placeholder="Enter Password"
				name="password" required
				oninvalid="this.setCustomValidity('Password cannot be empty')"
				oninput="setCustomValidity('')"></input>

			<div class="form"><button id="button" type="submit" class="btn btn-primary">Login</button></div>
		</form>
		${message}
	</div>

</body>
</html>
<%@ include file="/WEB-INF/css/footer.css"%>