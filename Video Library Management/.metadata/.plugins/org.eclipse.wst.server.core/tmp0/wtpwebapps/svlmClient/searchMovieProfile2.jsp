<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="javax.servlet.http.HttpSession" %>
<%@ page language="java" import= "bean.allPersonbean"%> 
<%@ page language="java" import="java.util.*,java.lang.*" %> 
<%@ page language="java" import="java.util.ArrayList,java.lang.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function validateForm()
{
var x1=document.forms["addMovies"]["movname"].value;
if (x1==null || x1=="" || x1=="null" || x1=="Null" || x1=="NULL")
  {
  alert("Movie Name cannot be Null");
  return false;
  }
}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Details !!!</title>
</head>
<body>
<div id="navbar1">
		<jsp:include page="adminhome.jsp"></jsp:include>
	</div>
	<br><br><br><br><br><br><br><br><br><br><br><br>
<center>
<b>Customer Details for Movie <%=session.getAttribute("Moviename")%>!!!</b>
<br>
<form id="movieProfile2"  onsubmit="return validateRadio()"method="post" action="searchMovie.jsp">
<table align="center" border="1">


<tr>
<th>Member ID</th>
<th>First Name</th>
<th>Last Name</th>
<th>Membership Type</th>
</tr>

<%
allPersonbean a[];
a=(allPersonbean[])session.getAttribute("movprofileobj");
for(int i=0;a[i].getMemberid()!=null;i++)
{
%>

<tr>
<td><input type="text" value="<%=a[i].getMemberid()%>" readonly/></td>

<td><input type="text" value="<%=a[i].getFirstname()%>" /></td>

<td><input type="text" value="<%=a[i].getLastname()%>"></td>

<td><input type="text" value="<%=a[i].getType()%>"></td>
</tr>

<% }%>
</table>
<br>
<input class="submit" type="submit" value="OK" >
</form>
<br>

</center>

</body>
</html>