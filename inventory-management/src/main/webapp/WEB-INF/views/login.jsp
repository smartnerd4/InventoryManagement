<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
</head>
<body>
	<h1>LOGIN PAGE</h1>
	<form action="#" th:action="@{/form}" th:object="${login}"
		method="post">
		<h2>
		<p>
			UserName: <input type="text" th:field="*{username}" />
		</p>
		<p>
			Password: <input type="password" th:field="*{password}" />
		</p>
		<p>
			<input type="submit" value="Submit" /> <input type="reset"
				value="Reset" />
		</p>
		</h2>
	</form>
</body>
</html>