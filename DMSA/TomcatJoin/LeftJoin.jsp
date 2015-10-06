<%@page import="java.sql.*"%>
<%@page import="java.io.*" %>

<html>
<head>
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
<title>Profile</title>
</head>
<body>

<%
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","tiger");
PreparedStatement stat1 = con.prepareStatement("select a.id,a.name,b.dep from employee a left join dept b on a.id=b.id");
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
			<th>Department</th>
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
		<td><%=result.getString("dep") %></td>
		 </tr>
		<% 		
	}
		%>
		</tbody>
	</table>
</div>
</body>
</html>
