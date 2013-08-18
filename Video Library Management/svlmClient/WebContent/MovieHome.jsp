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
		<jsp:include page="home.jsp"></jsp:include>
	</div>
<form name=myForm method="post" action= "MovieController" onsubmit="">

<h2>Movie Home!</h2>
<table>
<tr><td>Get Movie Count!<td></tr>
<tr height="100"><td>Mmeber Id :</td>
<td><input type=text name="memid" size=50  value="" /></td></tr>
<tr height="100"><td><input type=submit value="Get Count"></td></tr>
</form>
<form name=myForm1 method="post" action= "MovieDeatailsController" onsubmit="">

<tr height="100"><td>Get Movie Details!<td></tr>
<tr><td>Movie Id :</td>
<td><input type=text name="movieid1" size=50  value="" /></td></tr>


<tr height="100"><td><input type=submit value="Fetch"></td></tr>
</form>
<form name=myForm1 method="post" action= "AllMovieController" onsubmit="">

<tr><td>Get All Movies!<td></tr>




<tr><td><input type=submit value="Get All Movies List"></td></tr>
</table>
</form>
</body>
</html>