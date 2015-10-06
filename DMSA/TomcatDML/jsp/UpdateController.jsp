<%@page import="java.sql.*"%>
<%@page import="java.io.*" %>

<html>
<head>
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update</title>
</head>
<body>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","tiger");
PreparedStatement stat1 = con.prepareStatement("SELECT * FROM employee WHERE id=?");
String id = request.getParameter("id");
stat1.setString(1, id);
ResultSet result=stat1.executeQuery();
%>
<div class="container">
	<form action="/jsp/UpdateCommit.jsp" method="post" >
		<div class="jumbotron">
			<div class="row">
			<%while(result.next()){ %>
				<label for="id" class="col col-lg-2">ID</label>
				<div class="col col-lg-4">
					<input type="text" name="id" placeholder="Enter ID" required class="form-control" value="<%=result.getString("id")%>">
				</div>
				<label for="name" class="col col-lg-2">Name</label>
				<div class="col col-lg-4">
					<input type="text" name="name" placeholder="Enter Name" required class="form-control" value="<%=result.getString("name")%>">
				</div>
				<%} %>
			</div>
			<br>
			<input type="submit" value="Submit" class="btn btn-primary" name="submitbtn" id="submitbtn">
			<input type="reset" value="Reset" class="btn btn-primary" id="Reset Button">
		</div>
	</form>
</div>
</body>
</html>
