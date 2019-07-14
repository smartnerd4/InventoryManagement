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
				<label for="ename">Username:</label> <input path="ename" type="text"
					class="form-control" id="ename" name="ename">
			</div>
			<div class="form-group">
				<label for="doj">Date of Joining:</label> <input path="doj"
					type="date" class="form-control" id="doj" name="doj">
			</div>
			<div class="form-group">
				<label for="ctc">Cost to Company:</label> <input path="ctc"
					type="text" class="form-control" id="ctc" name="ctc">
			</div>
			<div class="form-group">
				<label for="role">Role:</label>
				 <select  path="role" type="text" class="form-control" id="role" name="role">
  <option value="null">Select</option>
  <option value="Employee">Employee</option>
  <option value="Managers">Managers</option>
  <option value="Developer">Developer</option>
  <option value="Marketing">Marketing</option>
</select>
			</div>
<div class="form-group">
Save As : <input path="file" type="text" class="form-control" id="file" name="file" value="d:\\OfferLetter.pdf">

</div>

			<button id="button" type="submit" class="btn btn-primary">Generate Offer Letter</button>
		</form>
		${m}
	</div>
</body>
</html>
<%@ include file="/WEB-INF/css/footer.css"%>