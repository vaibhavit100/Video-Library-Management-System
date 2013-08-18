<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="javax.servlet.http.HttpSession" %>
<%@ page language="java" import= "bean.sMemberbean"%> 
<%@ page language="java" import="java.util.*,java.lang.*" %> 
<%@ page language="java" import="java.util.ArrayList,java.lang.*" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple Members</title>
</head>
<body>
<a href="adminMenu.jsp"><b>Admin Home</b></a>
<table align="center" border="1">
<tr>
Simple Member Information
</tr>

<tr>
<th>Personid</th>
<th>FirstName</th>
<th>LastName</th>
<th>Address</th>
<th>City</th>
<th>State</th>
<th>Zipcode</th>
<th>Membership Id</th>
<th>Country</th>
</tr>
<%
sMemberbean a[];
a=(sMemberbean[])session.getAttribute("sMemberobj");
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
<br>
</body>
</html>