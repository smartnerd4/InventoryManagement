<%@ page language="java" contentType="text/html;" isELIgnored="false"%>
<!-- 	charset=ISO-8859-1 pageEncoding="ISO-8859-1" -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="/WEB-INF/css/header.css"%>
<html>
<head>
<title>Offer Letter</title>
</head>
<%@ include file="/WEB-INF/css/body.css"%>
<body>
	<div class="form">
		<h1>Offer Letter Generator</h1>
		
				<h3>${m}<br><a href="download/pdf/${name}">${view}</a></h3>
		
		<form modelAttribute="Offer" action="generateofferletter"
			method="post">

			<label>Employee Name: </label><input type="text"
				placeholder="Enter Employee Name" name="ename" autofocus required
				pattern="[a-zA-Z ]*"
				title="Employeename cannot contain special characters/numbers"></input><br>

			<label>Date of Joining: </label><input type="date" name="doj"
				required oninvalid="this.setCustomValidity('DOJ cannot be empty')"
				oninput="setCustomValidity('')"></input><br> <label>Cost
				to Company: </label><input type="number" name="ctc"
				placeholder="Enter CTC in Rupees" name="ctc" required></input><br>

			<label>Role: </label><select type="text" name="role" required>
				<option value="">---Select a Role---</option>
				<option value="Employee">Employee</option>
				<option value="Manager">Manager</option>
				<option value="Developer">Developer</option>
				<option value="Marketer">Marketer</option>
			</select><br> <label>Basic Salary: </label> <input id="bs" type="number"
				name="basicsalary" value="0.4" required></input>*CTC<br> <label>HRA:
			</label><input id="hra" type="number" name="hra" value="0.24" required></input>*CTC<br>
			<label>PF: </label><input id="pf" type="number" name="pf"
				value="0.048" required></input>*CTC<br> <label>Standard
				Deduction: </label><input id="sd" type="number" name="standarddeduction"
				value="0.04" required></input>*CTC<br> <label>LTA: </label><input
				id="lta" type="number" name="lta" value="0.02" required></input>*CTC<br>

			<label>SpecialAllowance: </label><input id="sa" type="text" name="specialallowance"
				value="0.252" required></input>*CTC<br>
		<button id="button" type="submit" class="btn btn-primary">Generate Offer Letter</button><br>




		</form>
		<br>
	</div>
	<script type="text/javascript">
		document.getElementById("bs").onchange = function() {
			myFunctioncal()
		};
			document.getElementById("hra").onchange = function() {
			myFunctioncal()
		};
		document.getElementById("pf").onchange = function() {
			myFunctioncal()
		};
			document.getElementById("sd").onchange = function() {
			myFunctioncal()
		};
			document.getElementById("lta").onchange = function() {
			myFunctioncal()
		};
		

		function myFunctioncal() {
			var bs = document.getElementById("bs");
			var hra = document.getElementById("hra");
			var pf = document.getElementById("pf");
			var sd = document.getElementById("sd");
			var lta = document.getElementById("lta");
			var sa = document.getElementById("sa");
			var nbs = parseFloat(bs.value);
			var nhra = parseFloat(hra.value);
			var npf = parseFloat(pf.value);
			var nsd = parseFloat(sd.value);
			var nlta = parseFloat(lta.value);
			var t1 = nbs;
			var t2 = nhra + nsd + nlta;
			var t3 = t1 + t2;
			var t4 = npf;
			var t5 = t3 + t4
			var temp = 1 - t5;
			sa.value = temp;
		}		
	</script>
</body>
</html>
<%@ include file="/WEB-INF/css/footer.css"%>