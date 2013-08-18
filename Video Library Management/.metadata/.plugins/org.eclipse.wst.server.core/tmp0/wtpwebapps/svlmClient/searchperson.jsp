<%@ page import='java.util.*,javax.servlet.http.HttpSession' %>
 <%@ page import="bean.Person" %>
 <%@ page import='services.VideoLibraryManagementProxy'%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script>


function validateSearchPerson()
{
	
	//alert("hello");
	//var ind=document.form1.;
	// ind= document.form1.memtype.selectedindex;
	//sel_val=document.form1.memtype.options[ind].value;
	//alert("value"+sel_val);
	//if((document.form1.fname.value=="") && (document.form1.lname.value=="") && (document.form1.memid.value=="") && (document.form1.memtype.valu=="") && (document.form1.address.value=="") &&  (document.form1.city.value=="") && (document.form1.state.value=="") && (document.form1.zipcode.value=="") && (document.form1.country.value==""))
    
	if((document.form1.fname.value=="") && (document.form1.lname.value=="") && (document.form1.memid.value=="") && (document.form1.memtype.value=="") && (document.form1.address.value=="") &&  (document.form1.city.value=="") && (document.form1.state.value=="") && (document.form1.zipcode.value=="") && (document.form1.country.value==""))
    {
     alert("At least one field should be non empty");
      return false;
    }
       	    	    	    	    	    		
       	    	    	    	    	    		
 }


</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Person</title>



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
<br><br><br>
<div align=center>

<br><br><br><br><br><br>
<font size="5" color="">Search Person:</font>
<br><br><br><br>



<%

Person per= (Person)session.getAttribute("per");
%>



<form name="form1" method="post"  action="SearchPerson" onSubmit="return validateSearchPerson()">


<table border="0" align="center">

<tr>
<th><div class="form-row"><span class="label">  First Name</span></th><td><input type="text" name="fname"/> </div></td>
</tr>

<tr>
<th><div class="form-row"><span class="label">  Last Name</span></th><td><input type="text" name="lname"/> </div></td>
</tr>

<tr>
<th><div class="form-row"><span class="label">   MembershipId</span></th><td><input type="text" name="memid"/> </div></td>
</tr>



<tr>
<th> 
MemberType
</th>


<td>
<select name="memtype">
<option value="">Select</option>
<option value="simple">Simple Member</option>
<option value="premium">Premium Member</option>
</select>
</td>
</tr>


<tr>
<th><div class="form-row"><span class="label">  Address</span></th><td><input type="text" name="address"/> </div></td>
</tr>


<tr>
<th><div class="form-row"><span class="label">  City</span></th><td><input type="text" name="city"/> </div></td>
</tr>



<tr>
<th><div class="form-row"><span class="label">  State</span></th><td><input type="text" name="state"/> </div></td>
</tr>


<tr>
<th><div class="form-row"><span class="label">  ZipCode</span></th><td><input type="text" name="zipcode"/> </div></td>
</tr>


<tr>
<th><div class="form-row"><span class="label">  Country</span></th><td><input type="text" name="country"/> </div></td>
</tr>



<tr>
<th><div class="form-row"><input class="submit"  type="submit" value="Search" onSubmit="return validateSearchPerson()"/> </div></th>

<th><div class="form-row"><input class="reset"   type="reset" value="Reset"/> </div></th>
</tr>




</table>

</form></div>
</body>
</html>