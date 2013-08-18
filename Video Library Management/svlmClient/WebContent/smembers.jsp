<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="bean.Person" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
<center>
<table border=1>
<tr><th>firstname</th><th>lastname</th><th>address</th><th>city</th><th>state</th><th>zipcode</th><th>memberid</th><th>country</th></tr>
<%
Person a[]=(Person[])session.getAttribute("smember");
for(int i=0;a[i]!=null;i++)
{
%>
<tr><td><%=a[i].getFirstname() %></td><td><%=a[i].getLastname() %></td><td><%=a[i].getAddress() %></td><td><%=a[i].getCity() %></td><td><%=a[i].getState() %></td><td><%=a[i].getZipcode() %></td><td><%=a[i].getMemberid() %></td><td><%=a[i].getCountry() %></td></tr>
<%
}
%>
</table>
</center>
</body>
</html>