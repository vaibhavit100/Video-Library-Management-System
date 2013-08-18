<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="navbar2">
		<jsp:include page="home.jsp"></jsp:include>
</div>
<div align="center">


<br><br><br><br><br><br><br><br><br><br><br>
<center><h2>Your Transaction is successful,Please keep transaction id <%=session.getAttribute("transid") %> for future references</h2></center>
<center><h2> <%=session.getAttribute("totalcost") %></h2></center>
</body>
</html>