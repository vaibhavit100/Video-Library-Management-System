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
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
    <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
    <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
    <link rel="stylesheet" href="/resources/demos/style.css" />
    <script>
    $(function() {
        $( "#datepicker" ).datepicker();
    });
    </script>
    <script>
function validateForm()
{
var x1=document.forms["addMovies"]["movname"].value;
if (x1==null || x1=="" || x1=="null" || x1=="Null" || x1=="NULL")
  {
  alert("Movie Name Cannot be Null");
  return false;
  }
var x2=document.forms["addMovies"]["movbanner"].value;
if (x2==null || x2=="" || x2=="null" || x2=="Null" || x2=="NULL")
  {
  alert("Movie Banner must be filled out");
  return false;
  }
var x3=document.forms["addMovies"]["category"].value;
if (x3==null || x3=="" || x3=="null" || x3=="Null" || x3=="NULL")
  {
  alert("Movie Category must be filled out");
  return false;
  }
var x4=document.forms["addMovies"]["releasedate"].value;
if (x4==null || x4=="" || x4=="null" || x4=="Null" || x4=="NULL")
  {
  alert("Movie release Date cannot be Null");
  return false;
  }
var x5=document.forms["addMovies"]["noofcopies"].value;
if (x5==null || x5=="" || x5=="null" || x5=="Null" || x5=="NULL")
  {
  alert("Please enter number of copies");
  return false;
  } 
	  var numbers = /^[0-9]+$/;  
	  if(x5.match(numbers))  
	  {  }  
	  else  
	  {  
	  alert("number of copies must be numeric"); 
	  return false;
  }
}
</script>
    

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add A Movie</title>
</head>
<body>

<center>

<%
String str = null;
str=session.getAttribute("addmovmsg").toString();

if (str.equals("msg")){}
else{
%>
<script type="text/javascript">
alert("<%=session.getAttribute("addmovmsg")%>");
</script>
<%	
}
%>


<div id="navbar1">
		<jsp:include page="adminhome.jsp"></jsp:include>
	</div>
	<br><br><br><br><br><br><br><br><br><br>
<br>
<font size="5" color="BLACK"><b>Add Movies </b></font>
<br>
<br>
<br>
<form id="addMovies" onsubmit="return validateForm()" method="post" action="addMovie">

<table align="center" border="1">

<tr>
<th>Field</th>
<th>Value</th>
</tr>

<tr>
<td>
Movie Name* 
</td>
<td>
<input type="text" name="movname" maxlength="25">
</td>
</tr>


<tr>
<td>
Movie Banner* 
</td>
<td>
<input type="text" name="movbanner" maxlength="25">
</td>
</tr>


<tr>
<td>
Category*
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

<tr>
<td>
Release Date*
</td>
<td>
<input type="text" name="releasedate" id="datepicker">
</td>
</tr>


<tr>
<td>
Copies*
</td>
<td>
<input type="text" name="noofcopies" maxlength="5">
</td>
</tr>

</table>
<br>
<input class="submit" type="submit" value="Add Movie" >
</form>
</center>
</body>
</html>