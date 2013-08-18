<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function a()
{
	if(document.myForm.moviename.value=="" && document.myForm.moviebanner.value=="" && document.myForm.category.value=="" && document.myForm.reldate.value=="")
		{
		alert("fill atleast one field");
		myForm.moviename.focus();
		return false;
		}

}
</script>
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
<body>
<div id="navbar2">
		<jsp:include page="home.jsp"></jsp:include>
</div>

<div align="center">

<br><br><br><br><br><br><br><br>
<form name=myForm method="post" action=rentsearch onsubmit="return a()">
<p align="right">


</p><br><br>
<h2>Search for the movies Which want to rent</h2>
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
</div>

</body>
</html>