<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import='java.util.*,javax.servlet.http.HttpSession' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="css/navmain1.css">
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign-In</title>
<style type="text/css">
body
{
text-align:center;
}
.styled-button-2 {
	-webkit-box-shadow:rgba(0,0,0,0.0.1) 0 1px 0 0;
	-moz-box-shadow:rgba(0,0,0,0.0.1) 0 1px 0 0;
	box-shadow:rgba(0,0,0,0.0.1) 0 1px 0 0;
	background-color:#191970;
	border:1px solid #29447E;
	font-family:'Lucida Grande',Tahoma,Verdana,Arial,sans-serif;
	font-size:12px;
	font-weight:700;
	padding:2px 6px;
	height:28px;
	color:#fff;
	border-radius:5px;
	-moz-border-radius:5px;
	-webkit-border-radius:5px
}
.boxBody
{
    background:	 #D3D3D3;
    border-top:2px solid #dde0e8;
    border-bottom:2px solid #dde0e8;
    padding:10px 30px;
    margin-left: 4%;
	margin-right: 70%;
	border-radius: 40px / 20px ;
}


</style>

<script>
function validateLogin()

{
	// var numbers = /^[0-9]+$/;  
    if(document.form1.user.value=="")
    {
      alert("User Name should not be left blank");
      document.form1.user.focus();
      return false;
    }
    else if(document.form1.pwd.value=="")
    {
      alert("Password should not be left blank");
      document.form1.pwd.focus();
      return false;
    }
    else if (!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(form1.uname.value)))
    {
        alert("UserName should be in E-Mail Foramt");
        document.form1.uname.focus();

    	return false;
    }
}
</script>


</head>
<body  background="Spiderman.jpg" >
<br>
<br>
<div align=left>
 &nbsp;&nbsp; &nbsp; &nbsp;<font size="6" color="#fff" >Video Library Management</font>
<br>
<br>
<br>
 &nbsp; &nbsp; <font size="6" color="#fff" align=left>Login</font>


<br><br><br><br><br>
</div>
<fieldset class="boxBody">
<br>
<div align=center>
<form name="form1" method="post"  action="SignInController" onSubmit="return validateLogin()">

<table>
<tr height="50">
<td><div class="form-row"><span class="label">  User Name*</span></td><td><input type="text" name="user"/> </td></div>
</tr>

<tr height="50">
<td><div class="form-row"><span class="label">  Password*</span></td><td><input type="password" name="pwd"/> </td></div>
</tr>

<tr height="50">
<td><div class="form-row"><input type="submit" class="styled-button-2" value="Login" > </div></td>
</form>
<td>


<form name=myForm method="post" action= "SignUp.jsp" onsubmit="">
<input type="submit" class="styled-button-2" value="Sign Up">
</form>
</td>
</tr>


</table>
</form>

<br>
</div>
</fieldset>





</frameset>

</body>
</html>