<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
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

<div id="home1">
		<jsp:include page="home.jsp"></jsp:include>
	</div>
<div align=center>
<br><br><br><br><br><br><br><br><br><br>
<form name=myForm method="post" action= "searchController" onsubmit="">
<font size="5" color="">Movie Search:</font>
<br><br><br><br>
<table>

<tr><td>Movie Name :</td>
<td><input type=text name="moviename" size=50  value="" /></td></tr>
<tr><td>Movie Banner :</td>
<td><input type=text name="moviebanner" size=50></td></tr>
<tr><td>Category :</td>
<td><input type=text name="category" size=50></td></tr>
<tr><td>Release Date :</td>
<td><input type=text name="reldate" size=50  value="" /></td></tr>

<tr><td><input type=submit value="Search"></td></tr>
</table>

</form>
</div>
</body>
</html>