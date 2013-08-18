<%@ page import='java.util.*,javax.servlet.http.HttpSession' %>
 <%@ page import="bean.Person" %>
 <%@ page import='services.VideoLibraryManagementProxy'%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Premium Members</title>
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
<% 
	
	VideoLibraryManagementProxy proxy= new VideoLibraryManagementProxy();

		//int i=0;
		try{
			//HttpSession session=request.getSession();
			proxy.setEndpoint("http://localhost:8080/svlm/services/VideoLibraryManagement");
			
			String input[];
			input=proxy.pMembers();
			
			Person a[]=new Person[input.length];
			
			for (int i=0;i<input.length;i++){
				a[i]= new Person();
			}
			
			StringTokenizer ST;
			
			for(int i=0;input[i]!=null;i++){
				ST = new StringTokenizer(input[i],"$");
				String b[]=new String[9];
				
				int j=0;
				
				while(ST.hasMoreTokens()){
					b[j]=ST.nextToken();
					System.out.println("Element is --->" + b[j]);
					j++;
				}
				a[i].setPersonid(b[0]);
				a[i].setFirstname(b[1]);
				a[i].setLastname(b[2]);
				a[i].setAddress(b[3]);
				a[i].setCity(b[4]);
				a[i].setState(b[5]);
				a[i].setZipcode(b[6]);
				a[i].setMemberid(b[7]);
				a[i].setCountry(b[8]);
				
			}
			session.setAttribute("pMemberobj", a);
			//response.sendRedirect("allPerson.jsp");
			
		}
		
		catch (Exception e){
			e.printStackTrace();
		}
		
		%>
		
		
<br><br><br>
<div align=center>

<br><br><br><br><br><br><br><br>
<font size="5" color="">Premium Members Information:</font>
<br><br><br><br>




<%
//VideoLibraryManagementProxy proxy= new VideoLibraryManagementProxy();

Person per= (Person)session.getAttribute("per");
%>





<table align="center" border="1" width="90%">

<tr>
<th>Personid</th>
<th>FirstName</th>
<th>LastName</th>
<th>Address</th>
<th>City</th>
<th>State</th>
<th>Zipcode</th>
<th>Membership Id</th>
<th>Country</th>
</tr>
<%
Person a[];
a=(Person[])session.getAttribute("pMemberobj");
for(int i=0;a[i].getPersonid()!=null;i++)
{
%>




<tr>
<td>
<%=a[i].getPersonid()%>
</td>
<td>
<%=a[i].getFirstname()%>
</td>
<td>
<%=a[i].getLastname()%>
</td>
<td>
<%=a[i].getAddress()%>
</td>
<td>
<%=a[i].getCity()%>
</td>
<td>
<%=a[i].getState()%>
</td>
<td>
<%=a[i].getZipcode()%>
</td>
<td>
<%=a[i].getMemberid()%>
</td>
<td>
<%=a[i].getCountry()%>
</td>
</tr>

<%
}
%>
</table>
<br>

<div></div>
</body>
</html>