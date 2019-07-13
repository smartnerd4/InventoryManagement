<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="/WEB-INF/css/header.css"%>
<html>
<head>
<title>Onboard Employees</title>
</head>
<style>
<%@ include file="/WEB-INF/css/body.css"%>
<body>
	<div style="text-align: center">
		<h1>Onboard Employees</h1>
		<form modelAttribute="" action="" method="post">

			<div class="form-group">
				<label for="name">Enter Employee-name:</label> <input path="name" type="text"
					class="form-control" id="name" placeholder="Enter Employee-name"
					name="name">
			</div>
			<button id="button" type="submit" class="btn btn-primary">Login</button>
		</form>
	</div>
</body>
</html>
<%@ include file="/WEB-INF/css/footer.css"%>