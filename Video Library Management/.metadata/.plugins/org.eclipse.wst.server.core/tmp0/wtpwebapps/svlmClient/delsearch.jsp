<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="navbar1">
		<jsp:include page="adminhome.jsp"></jsp:include>
	</div>
	<br><br><br><br><br><br><br><br><br><br><br>
<form name=myForm method="post" action= "delmoviesearch" onsubmit="">
<p align="right">


</p>
<h2>search for the movie u want to delete</h2>
<table>

<tr><td>Movie Name :</td>
<td><input type=text name="moviename" size=50  value="" /></td></tr>
<br/>
<tr><td>Movie Banner :</td>
<td><input type=text name="moviebanner" size=50></td></tr>
<br/>
<tr><td>Category :</td>
<td><input type=text name="category" size=50></td></tr>
<br/>
<tr><td>Release Date :</td>
<td><input type=text name="reldate" size=50  value="" /></td></tr>
<br/>
<tr><td><input type=submit value="Search"></td></tr>
</table>
<br/>

</form>

</body>
</html>