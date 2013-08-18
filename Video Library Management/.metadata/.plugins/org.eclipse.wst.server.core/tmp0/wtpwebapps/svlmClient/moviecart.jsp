<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="bean.moviecart" %>
    <%@ page language="java" import="java.util.*,java.lang.*" %> 
    <%@ page language="java" import="java.util.ArrayList,java.lang.*" %> 
    <jsp:useBean id="movcart" scope="session" class="bean.moviecart" />
    
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
<div id="navbar2">
		<jsp:include page="home.jsp"></jsp:include>
	</div>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<%
if(session.getAttribute("prob")!=null)
{
%>
<%=session.getAttribute("prob")%>
<center><p color="red"> go to back and make changes to shopping cart and proceed</p></center>
<center><a href="rentmovies.jsp">click chere to make changes</a></center>
<br/>

<%} %>
<%
String movid=request.getParameter("movid");
if(movid!=null)
movcart.rmList(movid);	
%>

<%
moviecart a2=(moviecart)session.getAttribute("mcart");
movcart=a2;
List<moviecart> a=a2.getItems();
for(int i=0,j=1;i<a.size();i++,j++)
{
	moviecart a1=new moviecart();
	a1=a.get(i);

%>
<center><table border=1>
	
	<tr><th>S.No</th><th>movid</th><th>Movie Name </th><th>Movie Banner</th><th>Movie Category</th><th>Movie Release Date</th><th>copies number</th></tr>
	<tr>
<td><%=j %></td>
<td><input type="text" name= <%="movid"+i %> value="<%=a1.getMovid() %>" readonly="readonly" /></td>
<td><input type="text" name=<%="movname"+i %> value= "<%=a1.getMovname() %>" readonly="readonly" /></td>
		
		<td><input type="text" name=<%="movbanner"+i %> value= "<%=a1.getMovbanner() %>" readonly="readonly" /></td>
		<td><input type="text" name=<%="category"+i %> value="<%= a1.getCategory() %>" readonly="readonly" /></td>
		<td><input type="text" name=<%="reldate"+i %> value= "<%=a1.getRelesedate() %>" readonly="readonly" /></td>
			
		<td><input type="text" name=<%="number"+i %> value="<%=a1.getCopiesno() %>" readonly="readonly" ></input></td>
</tr>
</table></center>
<center>

<form action="moviecart.jsp">
<input type="submit" value="remove from cart"  />
<input type="hidden" value=<%=a1.getMovid() %> name="movid"/>
</form>

</center>
<%} %>
<%session.setAttribute("mcart",movcart); %>
<form name="rentform" method="post" action=rent>
<input type="submit" value="rent items"/>
</form>
</body>
</html>