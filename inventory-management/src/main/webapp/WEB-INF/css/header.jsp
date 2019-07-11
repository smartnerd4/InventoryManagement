<html>
<head>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #202C5F;
	font-family: Arial, Helvetica, sans-serif;
}

li {
	float: left;
}

li a, .dropbtn {
	display: inline-block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
	background-color: #FFC425;
	color: black;
}

li.dropdown {
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	text-align: left;
}

.dropdown-content a:hover {
	background-color: #f1f1f1;
}

.dropdown:hover .dropdown-content {
	display: block;
}
.right {
  float: right;
}
</style>
</head>
<body>

	<ul>
		<li><a href="#logo">Smartnerd</a></li>
		<li><a href="#admin">Admin</a></li>
		<li><a href="#humanresources">Human Resources</a></li>
		<li><a href="#products">Product Management</a></li>
		<div class="right">
			<li><a href="loginpage">Login</a></li>
			<li><a href="#about">About</a></li>
		</div>
	</ul>

</body>
</html>