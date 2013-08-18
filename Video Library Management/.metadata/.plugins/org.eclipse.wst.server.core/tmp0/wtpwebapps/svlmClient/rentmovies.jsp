<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="bean.Movie" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function a()
{
	
	var i1=0;
	var k=0;
		
	for(i1=0;document.getElementsByName("check"+i1).length!=0;i1++)
		{
			av=document.getElementsByName("check"+i1);
			if (av[0].checked)
			{
				k=k+1;
				v=document.getElementsByName("copy"+i1);
				if(mov(i1,parseInt(v[0].value)))
					{
					
					}
				else
					{
					return false;
					}
			} 
			
		}
	if(k==0)
		{
		window.alert("check atleast one checkbox");
		return false;
		}
	else
		{
		return true;
		}
	
}

function mov(a,b)
{
	var i1;
	av=document.getElementsByName("check"+a);
	var d="number"+a;
		if (av[0].checked) {
			v=document.getElementsByName("number"+a);
			   if(isNaN(v[0].value) ||v[0].value==0||v[0].value=="")
				   {
				   	window.alert("enter valid number");
				   	v[0].value="";
				   	v[0].focus();
				   	return false;
				   }
			   else if(parseInt(v[0].value)>b)
				   {
				   window.alert("that many number of copies are not avalable enter copies below "+b);
				   v[0].value="";
				   v[0].focus();
				   return false;
				   }
			   else
				   return true;
				   }
}
</script>
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
<div align="right">
<a href="rentsearch.jsp" > <font color="black">Go To Search Page</font></a></div>
<font size="5" color="">Available Movies :</font>

<br><br><br><br>

<%  
Movie temp;
Movie[] movie1=new Movie[200];
movie1=(Movie[]) session.getAttribute("serializedObjects1");
if(movie1!=null)
{
%>
	
<form name=myForm method="post" action= addtocartcontroller onsubmit="return a()">	
	<center><table border=1>
	
	<tr><th>S.No</th><th>check</th><th>movid</th><th>Movie Name </th><th>Movie Banner</th><th>Movie Category</th><th>Movie Release Date</th><th>copies Available</th><th>copies number</th></tr>
<%
int i,j;
for(i=0,j=1;movie1[i]!=null;i++,j++)
{%>

<tr>
<td><%=j %></td>
<td>
<input type="checkbox" name=<%="check"+i %> value="checked" />
</td>
<td><input type="text" name= <%="movid"+i %> value="<%=movie1[i].getMovid() %>" readonly="readonly" /></td>
<td><input type="text" name=<%="movname"+i %> value= "<%= movie1[i].getMovname() %>" readonly="readonly"/></td>
		
		<td><input type="text" name=<%="movbanner"+i %> value= "<%=movie1[i].getMovbanner() %>" readonly="readonly"/></td>
		<td><input type="text" name=<%="category"+i %> value="<%= movie1[i].getCategory() %>" readonly="readonly" /></td>
		<td><input type="text" name=<%="reldate"+i %> value= "<%=movie1[i].getRelesedate() %>" readonly="readonly" /></td>
			<td><input type="text" name=<%="copy"+i %> value="<%=movie1[i].getCopiesno() %>" readonly="readonly" /></td>
		<td><input type="text" name=<%="number"+i %> maxlength="25" value=""></input></td>
</tr>
<% 	

}
session.setAttribute("total", ""+i);
}
	
%>

</table></center>
<center>

<input type=submit value="add to cart"/></center>
</form>
</div>
</body>
</html>