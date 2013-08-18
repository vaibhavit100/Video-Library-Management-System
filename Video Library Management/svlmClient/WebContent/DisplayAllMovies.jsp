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
<body>
<div id="navbar">
		<jsp:include page="home.jsp"></jsp:include>
</div>

<%  
Movie temp;
Movie[] movie1=new Movie[200];
movie1=(Movie[]) session.getAttribute("allMovies");
%>
	

<div align=center>

<br><br><br><br><br><br><br><br>
<font size="5" color="">Movie List:</font>

<br><br><br><br>
	
	<table border="1" style="width: 80%;"  >
	
	<tr><td><b>S.No</b></td><td><b>Movie ID</b></td><td><b>Movie Name </b></td><td><b>Movie Banner</b></td><td><b>Movie Category</b></td><td><b>Movie Release Date</b></td><td><b>No of Copies</b></td></tr>
<% 
for(int i=0,j=1;movie1[i]!=null;i++,j++)
{%>
<tr>
<td><%=j %></td>
<td><%= movie1[i].getMovid() %></td>
<td><%= movie1[i].getMovname() %></td>
		
		<td><%=movie1[i].getMovbanner() %></td>
		<td><%= movie1[i].getCategory() %></td>
		<td><%=movie1[i].getRelesedate() %></td>
		<td><%=movie1[i].getNoofcopies() %></td>
		</tr>
<% 	
}
	
%>

</table></div>

</body>
</html>