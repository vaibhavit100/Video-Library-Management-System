<%@ page import='java.util.*,javax.servlet.http.HttpSession' %>
  
  <%@ page import="services.VideoLibraryManagementProxy" %>
  <%@ page import="bean.Person" %>
  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<link rel="stylesheet" type="text/css" href="css/mainmenu1.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<%
VideoLibraryManagementProxy proxy= new VideoLibraryManagementProxy();

Person per= (Person)session.getAttribute("per1");
%>
<% 
   session.setAttribute("addmovmsg","msg");
   session.setAttribute("updatemovmsg","msg");
   session.setAttribute("delmovmsg","msg");
%>
<body bgColor="#A9A9A9">
<div id="photo">

	<ul class="navigation">

		<li><c:if test="${not empty user.firstName}">
				<h3>
					<c:out value="Welcome, ${user.firstName}"></c:out>
				</h3>
			</c:if>
			<p>
				<a href="adminhome.jsp">Home</a>
			</p></li>
		<li>
			<a href="allPerson">All Members</a>
			
			
			
		</li>
		<li>
			
				<a href="premiumMember">Premium Members</a>
				
			
		</li>
		<li>
			
			
				<a href="simpleMember">Simple Members</a>
			
		</li>
		<li>
			
			
				<a href="searchpersondetail.jsp">Search Member</a>
			
		</li>
		
		<li>
			
			
				<a href="searchperson.jsp">Delete Members</a>
			
		</li>
		<li>
			
			
				<a href="addMovie.jsp">Add Movies</a>
			
		</li>
		<li>
			
			
				<a href="delMovie.jsp">Delete Movies</a>
			
		</li>
		<li>
			
			
				<a href="updateMovie.jsp">Update Movies</a>
			
		</li>
		
		<li>
			
			
				<a href="searchMovie.jsp">Search Movie</a>
			
		</li>
		<li>
			
			
				<a href="signout.jsp">Sign Out</a>
			
		</li>
	</ul><br><br><br><br><br>
	

</div>
</body>



<% 
String db_time=(String)per.getLogintime();
//out.println("\n Your last loggedin time was "+time);
String username=per.getUsername();

Date date= new Date();
java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String finallogintime = sdf.format(date);

//String finallogintime=(String)session.getAttribute("logintime");

//user_list=(ArrayList)session.getAttribute("userlist");


String inst_logtime=proxy.updateLoggedInfo(username,finallogintime);

System.out.println(inst_logtime);

%>



<h3 align="center">Your last logged in time was <%=db_time%> </h3>
</html>