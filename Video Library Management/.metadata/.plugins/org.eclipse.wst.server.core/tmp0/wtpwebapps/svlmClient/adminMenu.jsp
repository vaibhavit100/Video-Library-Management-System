<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="javax.servlet.http.HttpSession;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrator Menu</title>
</head>
<body>
<center>

<% 
   session.setAttribute("addmovmsg","msg");
   session.setAttribute("updatemovmsg","msg");
   session.setAttribute("delmovmsg","msg");
%>
<b>Administrator Menu!!!
<br>
<br>
Please Select from below options:</b>

<form id="allPerson" method="post" action="allPerson">
<div class="form-row"><input class="submit" type="submit" value="List all Persons"> </div>
</form>

<form id="premiumMember" method="post" action="premiumMember">
<div class="form-row"><input class="submit" type="submit" value="List Premium Members"> </div>
</form>

<form id="simpleMember" method="post" action="simpleMember">
<div class="form-row"><input class="submit" type="submit" value="List Simple Members"> </div>
</form>

<form id="addMovie" method="post" action="addMovie.jsp">
<div class="form-row"><input class="submit" type="submit" value="Add Movies"> </div>
</form>

<form id="updateMovie" method="post" action="updateMovie.jsp">
<div class="form-row"><input class="submit" type="submit" value="Update a Movie"> </div>
</form>

<form id="delMovie" method="post" action="delMovie.jsp">
<div class="form-row"><input class="submit" type="submit" value="Delete Movies"> </div>
</form>

<form id="searchMovie" method="post" action="searchMovie.jsp">
<div class="form-row"><input class="submit" type="submit" value="Search Movies"> </div>
</form>
</center>
</body>
</html>