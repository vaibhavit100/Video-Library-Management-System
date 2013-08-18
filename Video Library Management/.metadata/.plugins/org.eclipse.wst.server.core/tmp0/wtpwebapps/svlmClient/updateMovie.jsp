<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
}
</style>
<script>
function validateInput()
{


	var x1=document.forms["searchMovies"]["movname"].value;
	var x2=document.forms["searchMovies"]["movbanner"].value;
	var x3=document.forms["searchMovies"]["releasedate"].value;
	var x4=document.forms["searchMovies"]["category"].value;
	
	if (x1=="" && x2=="" && x3=="" && x4=="")
	  {
	  alert("Not all fields can be Null !!!");
	  return false;
	  }
}	
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Movie !!!</title>
</head>
<body>
<div id="navbar1">
		<jsp:include page="adminhome.jsp"></jsp:include>
	</div>
	<br><br><br><br><br><br><br><br><br><br><br><br>

<center>

<%
String str = null;
str=session.getAttribute("updatemovmsg").toString();

if (str.equals("msg")){}
else{
%>
<script type="text/javascript">
alert("<%=session.getAttribute("updatemovmsg")%>");
</script>
<%	
}
%>

<br>
<b>Search for Movie to be Updated !!!</b> 
<br>
<br>
<form id="searchMovies" onsubmit="return validateInput()" method="post" action="searchForUpdate">

<table align="center" border="1">

<tr>
<th>Field</th>
<th>Value</th>
</tr>

<tr>
<td>
Movie Name 
</td>
<td>
<input type="text" name="movname">
</td>
</tr>


<tr>
<td>
Movie Banner 
</td>
<td>
<input type="text" name="movbanner">
</td>
</tr>


<tr>
<td>
Release Date 
</td>
<td>
<input type="text" name="releasedate">
</td>
</tr>


<tr>
<td>
Category
</td>
<td>
<select name="category">
<option value="">Select Category</option>
<option value="Comedy">Comedy</option>
<option value="Drama">Drama</option>
<option value="Action">Action</option>
<option value="Romance">Romance</option>
</select>

</td>
</tr>

</table>
<br>
<input class="submit" type="submit" value="Search Movie" >
</form>


</center>
</body>
</html>