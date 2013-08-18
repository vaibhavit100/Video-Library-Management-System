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
<style>
td {
 border: solid 1px black;
}
tr{
 border: solid 1px black;
}
table{
border: solid 1px black;
margin-left: auto;
	margin-right: auto;
}
</style>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Person Information</title>
</head>
<body>
	<div id="navbar1">
		<jsp:include page="adminhome.jsp"></jsp:include>
	</div>
<br><br><br><br><br><br><br><br><br>
<div align="center">
<h1>All Member Information</h1>
<br><br><br>
<table align="center" border="1" width="90%">
<tr>

</tr>

<tr>
<th>Personid</th>
<th>FirstName</th>
<th>LastName</th>
<th>Member Type</th>
<th>Address</th>
<th>City</th>
<th>State</th>
<th>Zipcode</th>
<th>Membership Id</th>
<th>Country</th>
</tr>
<%
allPersonbean a[];
a=(allPersonbean[])session.getAttribute("allPersonobj");
for(int i=0;a[i].getPersonid()!=null;i++)
{
%>




<tr>
<td>
<%=a[i].getPersonid()%>
</td>
<td>
<%=a[i].getFirstname()%>
</td>
<td>
<%=a[i].getLastname()%>
</td>
<td>
<%=a[i].getType()%>
</td>
<td>
<%=a[i].getAddress()%>
</td>
<td>
<%=a[i].getCity()%>
</td>
<td>
<%=a[i].getState()%>
</td>
<td>
<%=a[i].getZipcode()%>
</td>
<td>
<%=a[i].getMemberid()%>
</td>
<td>
<%=a[i].getCountry()%>
</td>
</tr>

<%
}
%>
</table>
</div>
<br>
</body>
</html>