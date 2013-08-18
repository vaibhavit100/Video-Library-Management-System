<%@ page import='java.util.*,javax.servlet.http.HttpSession' %>
 <%@ page import="bean.Person" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile Info</title>
</head>
<body>
<div id="home1">
		<jsp:include page="home.jsp"></jsp:include>
	</div>
	
<hr>
<br><br><br><br><br><br><br><br><br><br>
<%
Person per= (Person)session.getAttribute("per1");
%>


<div align=center>


<font size="5" color="">Personal Information:</font>
<br><br><br>
<form name="form1" method="post"  action="updateperson.jsp"  onSubmit="">

<table border="1">
<tr>
<th>
Account Information
</th>
</tr>

<tr>
<th><div class="form-row"><span class="label">  First Name</span></th><td><input type="text" name="fname" value="<%=per.getFirstname()%>" readonly="readonly"/> </div></td>
</tr>

<tr>
<th><div class="form-row"><span class="label">  Last Name</span></th><td><input type="text" name="lname" value="<%=per.getLastname()%>" readonly="readonly"/> </div></td>
</tr>


<tr>
<th><div class="form-row"><span class="label">  Membership Type</span></th><td><input type="text" name="memid" value="<%=per.getType()%>" readonly="readonly"/> </div></td>
</tr>



<tr>
<th><div class="form-row"><span class="label">  Membership Id</span></th><td><input type="text" name="memid" value="<%=per.getMemberid()%>" readonly="readonly"/> </div></td>
</tr>


	


<tr>
<th>
Home Address
</th>
</tr>

<tr>
<th><div class="form-row"><span class="label">  Address</span></th><td><input type="text" name="address" value="<%=per.getAddress()%>" readonly="readonly"/> </div></td>
</tr>


<tr>
<th><div class="form-row"><span class="label">  City</span></th><td><input type="text" name="city" value="<%=per.getCity()%>" readonly="readonly"/> </div></td>
</tr>



<tr>
<th><div class="form-row"><span class="label">  State</span></th><td><input type="text" name="state" value="<%=per.getState()%>" readonly="readonly"/> </div></td>
</tr>


<tr>
<th><div class="form-row"><span class="label">  ZipCode</span></th><td><input type="text" name="zipcode" value="<%=per.getZipcode()%>" readonly="readonly"/> </div></td>
</tr>


<tr>
<th><div class="form-row"><span class="label">  Country</span></th><td><input type="text" name="country" value="<%=per.getCountry()%>" readonly="readonly"/> </div></td>
</tr>



<tr>
<th><div class="form-row"><input class="submit"  type="submit" value="Edit"/> </div></th>
</tr>

</table>




</form>
</div>
</body>
</html>