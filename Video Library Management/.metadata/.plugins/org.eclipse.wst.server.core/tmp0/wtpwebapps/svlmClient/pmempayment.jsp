 <%@ page import='services.VideoLibraryManagementProxy'%>
 <%@ page import='java.util.*,javax.servlet.http.HttpSession' %>
 <%@ page import="bean.Person" %>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
<script>
function validatePayment()
{ 
	
    var numbers = /^[0-9]+$/;  

    if(document.form1.card1.value=="")
    {
      alert("Card Number shouldnot be left blank");
      document.form1.card1.focus();
      return false;
    }
    
    
    
    else if(!(document.form1.card1.value.match(numbers)))
    {
      alert("Card Number should be numeric only");
      document.form1.card1.focus();
      return false;
    }
    
    /*
    
    else if(document.form1.card1.value.length != 16)
    {
      alert("Card Number should be of 16 digit");
      document.form1.card1.focus();
      return false;
    }
    */
    
   
    
    
    else if(document.form1.CVVNumber.value=="")
    {
      alert("CVV Number shouldnot be left blank");
      document.form1.CVVNumber.focus();
      return false;
    }


    else if(document.form1.payeename.value=="")
    {
      alert("PayeeName shouldnot be left blank");
      document.form1.payeename.focus();
      return false;
    }



}
</script>


<body>
<h1 align="center">Video Library Management</h1>
<h2 align="center">Premium Member Gateway</h2>





<%
VideoLibraryManagementProxy proxy= new VideoLibraryManagementProxy();


%>


<%
//Person per= (Person)session.getAttribute("per");
Date date= new Date();
int year=Calendar.getInstance().get(Calendar.YEAR);
System.out.println(year);
%>







<h2 align="center">Payment Gateway</h2>

<form name="form1" method="post"  action="PmemberPayment"  onSubmit= "return validatePayment()">


<table border="1">
<tr>
<th>
 Card Number
</th><td></td><td></td><td></td><td></td>
<td>
<input type="text" name="card1" size="20"  maxlength="4">
</td>
<td>
-<input type="text" name="card2" size="20"  maxlength="4">
</td>
<td>
-<input type="text" name="card3" size="20"  maxlength="4">
</td>
<td>
-<input type="text" name="card4" size="20"  maxlength="4">
</td>
</tr>






<tr>
<th>
Card Expiry
</th><td></td><td></td><td></td><td></td>

<td>
Months
</td>
<td>
<select name="month">
<% for(int i=1;i<=12;i++) 
{
	
%>
<option value="<%=i%>"><%=i%></option>
<%
}
%>
</select>
</td>

<td>
Years
</td>
<td>
<select name="year">
<% for(int i=year;i<=year+10;i++) 
{
	
%>
<option value="<%=i%>"><%=i%></option>
<%
}
%>
</select>
</td>




</tr>




<tr>
<th>
CVV Number
<th><td></td><td></td><td></td><td></td>
<td>
<input type="password" name="CVVNumber" size="20" maxlength="3">
</td>
</tr>


<tr>
<th>
Name on Credit Card
</th><td></td><td></td><td></td><td></td>
<td>
<input type="text" name="payeename" size="20" maxlength="30">
</td>
</tr>

<tr>
<td>
<div class="form-row"><input class="submit"  type="submit" value="Submit"/> </div>
</td>
</tr>
</table>
</form>
</body>
</html>