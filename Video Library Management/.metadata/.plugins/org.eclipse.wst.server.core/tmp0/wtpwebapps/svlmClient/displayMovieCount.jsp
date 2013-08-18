<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="bean.Movie" %>
    <jsp:useBean id="movie" scope="session" class="bean.Movie" /> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<body bgcolor="">

<div align="right">
<a href="Login.jsp"/><font color="white">Logout</font></a></div>
<br><br><br><br>
<div align="center">
<font size="6" color="black"><u><b>Movie Details!!</b></u></font><br>

</div><br>



 


<hr>

<div align="right">
<a href="SearchMovie.jsp" /><font color="black">Go To Search Page</font></a></div>

<h2><u>Movie Count:</u></h2>
<body>
<%
String count=(String)session.getAttribute("moviecount");

%>
Movie Count : <%= count %>
</body>
</html>