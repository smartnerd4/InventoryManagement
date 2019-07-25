<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="/WEB-INF/css/header.css"%>
<html>
<head>
<title>Add New Employee</title>
</head>
<%@ include file="/WEB-INF/css/body.css"%>
<body>
	<div class="form">
		<h1>Add New Employee</h1>
		<strong><h3>${emessage}</h3></strong>
		<form modelAttribute="addnewemp" action="addnewemployee" enctype="multipart/form-data" method="post">
			
				<label>Employee Name: </label><input type="text"
					placeholder="Enter Employeename" name="employeeName" autofocus required
					pattern="[a-zA-Z ]*"
					title="Employeename cannot contain special characters/numbers"></input>

				<label>Email ID: </label><input type="email" placeholder="Enter EmailID"
				 	name="employeeEmail" required></input><br>

				<label>Department: </label>
				<select type="number" name="deptID" required>
				<option></option>
				<option value="001">Research & Department</option>
				<option value="002">Installation & Planning</option>
				<option value="003">Sales & Marketing</option>
				<option value="004">Admin</option>
				<option value="005">HR</option>
				<option value="006">Finance</option>
				<option value="007">Procurement</option>
				<option value="008">Software Development</option>
				<option value="009">Sister Entities</option>
				<option value="010">Management</option>
				</select>	
					
				<label>Date of Joining: </label><input type="text" placeholder="Enter Date of Joining" name="doj" required
					oninvalid="this.setCustomValidity('DOJ cannot be empty')"
					oninput="setCustomValidity('')"></input><br>

				<label>Pan Number: </label><input type="text" placeholder="Enter Pan Number"
					name="panNumber" required></input>

				<label>Aadhar Number: </label><input type="number" placeholder="Enter Aadhar Number"
					name="aadharNumber" required></input><br>

				<label>Work Experience: </label><input type="number" placeholder="Enter Work Experience in yrs"
					name="workExperience" required></input>

				<label>Previous Organisation: </label><input type="text" placeholder="Enter Previous Organisation name"
					name="previousOrganisation" required></input><br>
				
				<label>Relev Date: </label><input type="text" placeholder="Enter Relev Date" name="relevDate" required
					oninvalid="this.setCustomValidity('Relevdate cannot be empty')"
					oninput="setCustomValidity('')"></input>

				<label>Reporting ID: </label><input type="text" placeholder="Enter ReportingID"
					name="reportingID" required></input><br>
			
				<label>Manager ID: </label><input type="text" placeholder="Enter ManagerID"
					name="managerID" required></input>

				<label>Highest Qualification:</label><input type="text" placeholder="Enter Highest Qualification"
					name="highestQualification" required></input><br>

				<label>City: </label><select type="number" name="city" required>
					<option></option>
					<option value="9">Hyderabad</option>
					<option value="8">Vishakapatnam</option>
					<option value="1">Amaravathi</option>
					<option value="2">Bangalore</option>
					<option value="4">Pune</option>
					<option value="3">Chennai</option>
					<option value="5">Mumbai</option>
					<option value="7">Others</option>
				</select>
				
				<label>Blood Group: </label><select type="text" name="bloodGroup" required>
					<option></option>
					<option value="A+">A+</option>
					<option value="A-">A-</option>
					<option value="B+">B+</option>
					<option value="B-">B-</option>
					<option value="O+">O+</option>
					<option value="O-">O-</option>
					<option value="AB+">AB+</option>
					<option value="AB-">AB-</option>
				</select><br>
                    
                <label>T-Shirt Size: </label><select type="text" name="tshirtSize" required>
                <option></option>
                <option value="XS">XS</option>
                <option value="S">S</option>
                <option value="M">M</option>
                <option value="L">L</option>
                <option value="XL">XL</option>
                <option value="XXl">XXL</option>
                <option value="XXXL">XXXL</option>
                </select>
                    
                <label>Emergency Address: </label><input type="text" placeholder="Enter Emergency Address"
                	name="emergencyAddress" required></input><br>

                <label>Permanent Address: </label> <input type="text" placeholder="Enter Permanent Address" 
                	name="permanentAddress" required></input>
                    

                <label>Place Of Reporting: </label><input type="text" placeholder="Enter Place of Reporting"
                	name="placeofReporting" required></input><br>
                   
                <label>Gender: </label><select type="text" name="gender" required>
                	<option></option>
                	<option value="Male">Male</option>
                	<option value="Female">Female</option>
                	</select>
                					       
                <label>Phone Number: </label><input type="number" placeholder="Enter Phone Number" name="phoneNumber" required></input><br>

            <label>Insert Your Photo:</label><input type = "file" name = "fileUpload" size = "50"></input>
				
			<button id="button" type="submit" class="btn btn-primary">Submit</button><br>
        </form>
    </div>
</body>
</html>
<%@ include file="/WEB-INF/css/footer.css"%>