<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import='java.util.*,javax.servlet.http.HttpSession' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign-Up</title>
<style type="text/css">
body
{
text-align:center;
}
</style>


<script>
function validateSignUp()
{
    if(document.form1.fname.value=="")
    {
      alert("First Name shouldnot be left blank");
      document.form1.fname.focus();
      return false;
    }
    else if(document.form1.lname.value=="")
    {
      alert("Last Name shouldnot be left blank");
      document.form1.lname.focus();
      return false;
    }
    
    
    else if((document.form1.memid1.value=="") || (document.form1.memid2.value=="") || (document.form1.memid3.value==""))
    {
      alert("MemberId shouldnot be left blank");
      document.form1.memid.focus();
      return false;
    }
    

    
    
    
    
    else if(document.form1.uname.value=="")
    {
      alert("Email Id shouldnot be left blank");
      document.form1.uname.focus();
      return false;
    }
    
    
    else if (!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(form1.uname.value)))
    {
        alert("Invalid Email Id");
    	return false;
    }
    else if(document.form1.pwd.value=="")
    {
      alert("Password shouldnot be left blank");
      document.form1.pwd.focus();
      return false;
    }
    
    else if(document.form1.pwd2.value=="")
    {
      alert("Password shouldnot be left blank");
      document.form1.pwd2.focus();
      return false;
    }
    
    else if(document.form1.pwd1.value=document.form1.pwd2.value)
    {
      alert("Password  & Confirm Password should be same");
      document.form1.pwd2.focus();
      return false;
    }
    
    else if(document.form1.address.value=="")
    {
      alert("Address shouldnot be left blank");
      document.form1.address.focus();
      return false;
    }

    
    
    else if(document.form1.city.value=="")
    {
      alert("City shouldnot be left blank");
      document.form1.city.focus();
      return false;
    }
    
    
    else if(document.form1.state.value=="")
    {
      alert("State shouldnot be left blank");
      document.form1.state.focus();
      return false;
    }
    
    
    else if(document.form1.zipcode.value=="")
    {
      alert("Zipcode shouldnot be left blank");
      document.form1.zipcode.focus();
      return false;
    }
    
    
    else if(document.form1.country.value=="")
    {
      alert("Country shouldnot be left blank");
      document.form1.country.focus();
      return false;
    }
    
    


}
</script>




</head>

<%

%>

<body bgColor="#A9A9A9">
<div align="center">
<h1 align="center" >Video Library Management</h1>

<h2 align="center" >Register For New Account</h2>
<form name="form1" method="post"  action="SignUp" onSubmit="return validateSignUp()">
<table border="1">
<tr>
<th>
Account Information
</th>
</tr>
<tr>
<th><div class="form-row"><span class="label">  First Name*</span></th><td><input type="text" name="fname"/> </div></td>
</tr>

<tr>
<th><div class="form-row"><span class="label">  Last Name*</span></th><td><input type="text" name="lname"/> </div></td>
</tr>

<tr>
<th>
Membership Id*
</th>
<td>
<input type="text" name="memid1" size="3"  maxlength="3">
-<input type="text" name="memid2" size="2"  maxlength="2">
-<input type="text" name="memid3" size="4"  maxlength="4">
</td>
</tr>

<tr>
<th>
Membership Type*
</th>

<td>
<INPUT TYPE="radio" NAME="radios" VALUE="simple">Simple Members
<INPUT TYPE="radio" NAME="radios" VALUE="premium">Premium Members
</td>          
</tr>



<tr>
<th><div class="form-row"><span class="label">  User Name*</span></th><td><input type="text" name="uname"/> </div></td>
</tr>


<tr>
<th><div class="form-row"><span class="label">  Password*</span></th><td><input type="password" name="pwd"/> </div></td>
</tr>

<tr>
<th><div class="form-row"><span class="label">  Confirm Password*</span></th><td><input type="password" name="pwd2"/> </div></td>
</tr>

<tr>
<th>
Home Address
</th>
</tr>

<tr>
<th><div class="form-row"><span class="label">  Address*</span></th><td><input type="text" name="address"/> </div></td>
</tr>


<tr>
<th><div class="form-row"><span class="label">  City*</span></th><td><input type="text" name="city"/> </div></td>
</tr>



<tr>
<th><div class="form-row"><span class="label">  State*</span></th><td><input type="text" name="state"/> </div></td>
</tr>


<tr>
<th><div class="form-row"><span class="label">  ZipCode*</span></th><td><input type="text" name="zipcode"/> </div></td>
</tr>


<tr>
<th><div class="form-row"><span class="label">  Country*</span></th><td><input type="text" name="country"/> </div></td>
</tr>



<tr>
<th><div class="form-row"><input class="submit"  type="submit" value="Create Account"/> </div></th>

<th><div class="form-row"><input class="reset"   type="reset" value="Reset"/> </div></th>
</tr>

</table>

<h3 align="left" >Sorry,Member id already exists</h2>



</form>
</div>

</body>
</html>