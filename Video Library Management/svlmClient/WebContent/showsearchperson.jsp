<%@ page import='java.util.*,javax.servlet.http.HttpSession' %>
 <%@ page import="bean.Person" %>
 <%@ page import='services.VideoLibraryManagementProxy'%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person Search Result</title>

<script>
function validateCheck()
{
	var chk=0;
	for (var i=0; i < document.form1.searchperson.length; i++)
	   {
	   if (document.form1.searchperson[i].checked)
	      {
	      chk++;
	      }
	   }
	if(chk==0){
		alert("Please select a person to delete !!!");
		return false;
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
<div id="navbar1">
		<jsp:include page="adminhome.jsp"></jsp:include>
	</div>
	<br><<br><br><br><br><br><br><br><br><br>
<h1 align="center">Video Library Management</h1>
<h2 align="center" >Search Result</h2>

<%

Person per= (Person)session.getAttribute("per");
%>

<form name="form1" method="post"  action="DeleteMember" onSubmit="">


<%

Person obj[]= (Person[])session.getAttribute("perobj");
String search[]= (String[])session.getAttribute("search");

System.out.println(search.length);
if(obj[0]!=null)
{
	
%>


<table border=="0" align="center">

<tr>
Your Search Result is
</tr>

<tr>
<th>PersonId</th>
<th>FirstName</th>
<th>LastName</th>
<th>Membership Type</th>
<th>Address</th>
<th>City</th>
<th>State</th>
<th>ZipCode</th>
<th>Country</th>
<th>Membership Id</th>
</tr>


<%
for (int i=0;obj[i]!=null;i++) 
{
%>

<tr>
<td><input type="checkbox" name="searchperson" VALUE="<%=obj[i].getMemberid()%>"> <%=obj[i].getPersonid()%> <BR>
 </td>
<td><%=obj[i].getFirstname()%></td>
<td><%=obj[i].getLastname()%></td>
<td><%=obj[i].getType()%></td>
<td><%=obj[i].getAddress()%></td>
<td><%=obj[i].getCity()%></td>
<td><%=obj[i].getState()%></td>
<td><%=obj[i].getZipcode()%></td>
<td><%=obj[i].getCountry()%></td>
<td><%=obj[i].getMemberid()%></td>
 </tr>
 
 <%
}
%>

</table>

 <%
 }

if(obj[0]!=null)
{

%>


<table>
<tr>

<td>
<div class="form-row"><input class="submit"  type="Submit" value="Delete"/> </div>
</td>



<%
 }
else
{
%>

<h1 align="center">No matching result found</h1>
<%
}

%>


<td>
<div class="form-row"><input class="button" type="button" value="Modify Search" onclick="JavaScript:window.location='searchperson.jsp';">  </div>
</td>



</tr>
</table>

</form>
</body>
</html>