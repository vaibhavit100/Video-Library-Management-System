<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import='java.util.*,javax.servlet.http.HttpSession' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>

function a(){
if(chn()){
f(exp()){
if(crn()){
if(cvvn()){


return true;
}}}}
return false;
}

function chn()
{
if(creditcardform.name1.value=="")
{
alert("Enter Card Holder Name ");
creditcardform.name1.focus();
return false;
}
else if(!(isNaN(creditcardform.name1.value)))
{
alert("Enter only character string for Card Holder Name ");
return false;
}
else
{

return true;

}
}
function crn()
{
	if(creditcardform.user.value=="")
	{
	alert("Enter Credit Card number");
	creditcardform.user.focus();
	return false;

	}
	else if((isNaN(creditcardform.user.value)))
	{
	alert("Enter digits for card number ");
	return false;}

	else if(creditcardform.user.value.length<16)
	{
	alert("Enter correct card number of 16 Digits");
	return false;
	}
	else if(creditcardform.user.value.length>16)
	{
	alert("Enter correct card number of 16 Digits");
	return false;
	}

	else
	{
	return true;
	}
	}
function cvvn()
{
	if(creditcardform.cvv.value=="")
	{
	alert("Enter CVV number");
	creditcardform.cvv.focus();
	return false;

	}
	else if((isNaN(creditcardform.cvv.value)))
	{
	alert("Enter digits for CVV ");
	return false;}

	else if(creditcardform.cvv.value<3)
	{
	alert("Enter CVV number of 3 Digits");
	return false;
	}
	else if(creditcardform.cvv.value.length>3)
	{
	alert("Enter CVVnumber of 3 Digits");
	return false;
	}

	else
	{
	return true;
	}
	}



function exp()
{
if(creditcardform.month.value=="")
{
alert("Enter Expiry Date month");
creditcardform.expdate.focus();
return false;
}

if(creditcardform.year.value=="")
{
alert("Enter Expiry Date year");
creditcardform.expdate.focus();
return false;
}

else
{

return true;

}
}

	</script>

</head>
<body>
<div id="navbar1">
		<jsp:include page="home.jsp"></jsp:include>
	</div>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<form id="creditcardform" method="post" action=creditcard onsubmit="return a()">
<center>
<table>
<tr><td>Seller Information</td>
<td> 
<select name='typeofcard'>
	<option value='id1'>Master</option>
	<option value='id2'>Debit</option>
	<option value='id3'>Credit</option>
</select>
</td>
</tr>

<tr>
<td>username</td>
<td><input type="text" name="name1" size="30"/></td>
</tr>

<tr>
<%

Date date= new Date();
int year=Calendar.getInstance().get(Calendar.YEAR);

%>



<td>
Card Expiry
</td>

<td>
Months
<select name="month">
<% for(int i=1;i<=12;i++) 
{
	
%>
<option value="<%=i%>"><%=i%></option>
<%
}
%>
</select>
Years
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
<td>Card Number</td>
<td><input type="text" name="user" size="16" maxlength="16"/></td>
</tr>

<%
String msg=(String)session.getAttribute("carde");
if(msg!=null && !msg.equals(""))
{
%>

<tr>
<td></td>
<td><p>enter correct number</p></td>
<td></td>
</tr>

<%}
%>

<tr>
<td>CVV Number</td> 
<td><input type="text" name="cvv" size="3" maxlength="3"/></td>
</tr>

<%
String msg1=(String)session.getAttribute("cvve");
if(msg1!=null && !msg1.equals(""))
{%>

<tr>
<td></td>
<td><p>enter correct cvv</p></td>
<td></td>
</tr>

<%}
%>

<tr>
<td></td>
<td><input class="submit" type="submit" value="confirm" /></td>
<td></td>
</tr>

</table>
</center>
</form>


</body>
</html>