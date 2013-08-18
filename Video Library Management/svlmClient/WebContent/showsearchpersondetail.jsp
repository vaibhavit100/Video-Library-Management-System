<%@ page import='java.util.*,javax.servlet.http.HttpSession' %>
 <%@ page import="bean.Person" %>
 <%@ page import='services.VideoLibraryManagementProxy'%>

<%//@ page errorPage="errorpage.jsp" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person Search Result</title>

<script>
function validateRadio()
{
	var chk=0;
	for (var i=0; i < document.form1.searchpersondetail.length; i++)
	   {
	   if (document.form1.searchpersondetail[i].checked)
	      {
	      chk++;
	      }
	   }
	if(chk==0){
		alert("Please select a row to check movie issue details !!!");
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

<h1 align="center">Video Library Management</h1>
<h2 align="center" >Search Result</h2>



<form name="form1"  method="post"  action="MovieIssue"  onSubmit="">


<%

Person obj[]= (Person[])session.getAttribute("perobj");
String search[]= (String[])session.getAttribute("search");

System.out.println("length is"+search.length);
System.out.println("Object is"+obj[0]);
if(obj[0]!=null)
{
	System.out.println(obj[0].getFirstname());
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
//System.out.println()
for (int i=0;obj[i]!=null;i++) 
{
%>

<tr>
<td><input type="radio" name="searchpersondetail" VALUE="<%=obj[i].getMemberid()%>"> <%=obj[i].getPersonid()%> <BR>
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
<div class="form-row"><input class="submit"  type="Submit" value="Movie Issued"/> </div>
</td>



<%
 }
else
{
%>

<h1 align="right">No matching result found</h1>
<%
}


%>
 
<td>
<div class="form-row"><input class="button" type="button" value="Modify Search" onclick="JavaScript:window.location='searchpersondetail.jsp';">  </div>
</td>




</tr>
</table>



</form>


</body>
</html>