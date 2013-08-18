<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="javax.servlet.http.HttpSession" %>
<%@ page language="java" import= "bean.moviesbean"%> 
<%@ page language="java" import="java.util.*,java.lang.*" %> 
<%@ page language="java" import="java.util.ArrayList,java.lang.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie Update</title>
</head>
<body>
<div id="navbar1">
		<jsp:include page="adminhome.jsp"></jsp:include>
	</div>
	<br><br><br><br><br><br><br><br><br><br><br><br>
<center>
<b>Update Movie!!!</b>
<br>
<form id="updateMovie" method="post" action="updateMovie2">
<table align="center" border="1">


<tr>
<th>Movie Field</th>
<th>Value</th>
</tr>

<%
int i=0;
moviesbean a[];
a=(moviesbean[])session.getAttribute("movieobj");
%>

<tr>
<td>Movie ID*: </td>
<td><input type="text" name="movid" value="<%=a[i].getmovid()%>" readonly/></td>
</tr>

<tr>
<td>Movie Name: </td>
<td><input type="text" name="movname" value="<%=a[i].getmovname()%>" maxlength="25"/></td>
</tr>

<tr>
<td>Movie Banner: </td>
<td><input type="text" name="movbanner" value="<%=a[i].getmovbanner()%>" maxlength="25"></td>
</tr>

<tr>
<td>Category: </td>
<td><input type="text" name="category" value="<%=a[i].getcategory()%>" maxlength="25"></td>
</tr>

<tr>
<td>Release Date: </td>
<td><input type="text" name="releasedate" value="<%=a[i].getreleasedate()%>" maxlength="10"></td>
</tr>


<tr>
<td>Number of Copies: </td>
<td><input type="text" name="noofcopies" value="<%=a[i].getnoofcopies()%>" maxlength="5"></td>
</tr>

</table>
<br>
<input class="submit" type="submit" value="Update" >
</form>
<br>
<br>
Note: "*" fields cannot be updated!!!
</center>

</body>
</html>