<%@page import="java.sql.*"%>
<%@page import="java.io.*" %>

<html>
<head>
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Entry</title>
</head>
<body>
<div class="container">
	<form action="/jsp/VerifyEntry.jsp" method="post" >
		<div class="jumbotron">
			<div class="row">
				<label for="id" class="col col-lg-2">ID</label>
				<div class="col col-lg-4">
					<input type="text" name="id" placeholder="Enter ID" required class="form-control">
				</div>
				<label for="name" class="col col-lg-2">Name</label>
				<div class="col col-lg-4">
					<input type="text" name="name" placeholder="Enter Name" required class="form-control">
				</div>
			</div>
			<br>
			<input type="submit" value="Submit" class="btn btn-primary" name="submitbtn" id="submitbtn">
			<input type="reset" value="Reset" class="btn btn-primary" id="Reset Button">
		</div>
	</form>
</div>
</body>
</html>
