<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="javax.servlet.http.HttpSession" %>
<%@ page language="java" import= "bean.moviesbean"%> 
<%@ page language="java" import="java.util.*,java.lang.*" %> 
<%@ page language="java" import="java.util.ArrayList,java.lang.*" %>
    
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
function validateCheck()
{
	var chk=0;
	for (var i=0; i < document.delMovies.movid.length; i++)
	   {
	   if (document.delMovies.movid[i].checked)
	      {
	      chk++;
	      }
	   }
	if(chk==0){
		alert("Please select a movie to delete !!!");
		return false;
	}
}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Movie Search Result</title>
</head>
<body>

<div id="navbar1">
		<jsp:include page="adminhome.jsp"></jsp:include>
	</div>
	<br><br><br><br><br><br><br><br><br><br><br>
<center>
<b>Select the movies to Delete !!!</b>
<br>
<form name="delMovies" id="delMovies" onsubmit="" method="post" action="delMovie">
<table align="center" border="1">


<tr>
<th>Movie Id</th>
<th>Movie Name</th>
<th>Movie Banner</th>
<th>Release date</th>
<th>Category</th>
</tr>


<%
int i=0;
moviesbean a[];
a=(moviesbean[])session.getAttribute("movieobj");

if(a[i].getmovid()!=null){
for(i=0;a[i].getmovid()!=null;i++)
{
%>

<tr>
<td>
<input TYPE=checkbox name=movid VALUE=<%=a[i].getmovid()%>>
<%=a[i].getmovid()%>
</td>
<td>
<%=a[i].getmovname()%>
</td>
<td>
<%=a[i].getmovbanner()%>
</td>
<td>
<%=a[i].getreleasedate()%>
</td>
<td>
<%=a[i].getcategory()%>
</td>
</tr>

<%}}else{%>
<jsp:forward page="noResult2.jsp" /> 
<%}%>

</table>
<br>
<input class="submit" type="submit" value="Delete Selected" >
</form>
</center>
</body>
</html>