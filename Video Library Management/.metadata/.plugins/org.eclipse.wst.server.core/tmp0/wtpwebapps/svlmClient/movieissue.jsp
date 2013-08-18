<%@ page import='java.util.*,javax.servlet.http.HttpSession' %>
 <%@ page import="bean.Person" %>
 <%@ page import='services.VideoLibraryManagementProxy'%>
<%@ page errorPage="errorpage.jsp" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person Details with Movie Issued</title>
</head>


<style>
td {
 border: solid 1px black;
}
tr{
 border: solid 1px black;
}
table{
border: solid 1px black;
}
</style>
<body>

<div id="navbar2">
		<jsp:include page="adminhome.jsp"></jsp:include>
	</div>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>



<%

Person per= (Person)session.getAttribute("per1");
%>


<form id="form1" method="post"  >

<% 
VideoLibraryManagementProxy proxy= new VideoLibraryManagementProxy();

String persondetails=session.getAttribute("perdetails").toString();

String result=session.getAttribute("res").toString();
System.out.println("Result is 000000000"+result);
String delimiter = "[$]";
String movname[] = result.split(delimiter);
String persondet[]=persondetails.split(delimiter);
System.out.println("Movie is 9888888888888"+movname[0]);

if (!(movname[0].equalsIgnoreCase("false")))
{
%>




<table  align="center">

<tr>
<th>Movie Issued with Person <%=persondet[1]%></th>
</tr>

<tr>
<td>
<%
for(int i=0;i<movname.length;i++)
{
%>
<%=movname[i]%>
<br>
<%
}

%>
</td>
</tr>

</table>
<%
}
else
{
%>
<h2 align="center">No Movie Issued With <%=persondet[1]%></h2>

<%
}

%>
</form>

</body>
</html>