<%@page import="java.sql.*"%>
<%@page import="java.io.*" %>

<html>
<head>
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
<title>Delete</title>
</head>
<body>

<%
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","tiger");
PreparedStatement stat2 = con.prepareStatement("DELETE FROM employee WHERE id=?");
String id = request.getParameter("id");
stat2.setString(1, id);
stat2.executeUpdate();
PreparedStatement stat1 = con.prepareStatement("SELECT * FROM employee");
ResultSet result=stat1.executeQuery();
%>

<nav class="navbar navbar-inverse navbar-fixed-top" >
	<div class="container-fluid">
		<div class="navbar-header">
   		<a class="navbar-brand " href="#">MIT</a>
		</div>
      	<ul class="nav navbar-nav">
        	<li><a href="/jsp/ViewDatabase.jsp">View</a></li>
        	<li><a href="/jsp/DeleteEntry.jsp">Delete</a></li>
        	<li><a href="/jsp/NewEntry.jsp">New Entry</a></li>
        	<li><a href="/jsp/UpdateEntry.jsp">Update Entry</a></li>
      	</ul>
	</div>
</nav>
<br><br><br>
<h3>Student Profile</h3>
<div class="container">
	<table class="table table-bordered" id="mytable">
		 <thead>
		  <tr>
			<th>ID</th>		  
			<th>Name</th>
			</tr>
		</thead>
		<tbody>
		<% 
		while(result.next())
	{
		%>	
		 <tr>
		 <td><%=result.getString("id") %></td>
		  <td><%=result.getString("name") %></td>
		 </tr>
		<% 		
	}
		%>
		</tbody>
	</table>
</div>
</body>
</html>
