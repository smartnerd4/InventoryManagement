<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/css/header.css"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<%@ include file="/WEB-INF/css/body.css"%>
<body>
	<form modelAttribute="excel" action="addnewemployee"
		enctype="multipart/form-data" method="post">
		<label>Enter the table name: </label><input type="text" placeholder="Enter the table name" name="tbname" autofocus required
					title="Table name cannot be empty"></input><br>
				<label>Enter the no of rows: </label><input id="nr" type="tb" placeholder="Enter the no of rows" name="tbnumrows" autofocus required
					title="Table row cannot be empty"></input><br><div id="container">
					</div><br>
					
		<label>Browse Your File:</label><input type="file" name="file" required></input> <br>
		<button id="button" type="submit" class="btn btn-primary">Submit</button>
		<br>
		<script type="text/javascript">
		document.getElementById("nr").onchange = function() {
			myFunctioncal()
	    
		};

		function myFunctioncal() {
		 var number = document.getElementById("nr").value;

    for (i=0;i<number;i++){

        var input = document.createElement("input");
        input.type = "text";
        container.appendChild(input);
        container.appendChild(document.createElement("br"));
   
    }
		}
		</script>
	</form>
</body>
</html>
<%@ include file="/WEB-INF/css/footer.css"%>