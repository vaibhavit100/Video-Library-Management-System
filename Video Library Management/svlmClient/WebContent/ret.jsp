<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page language="java" import="javax.servlet.http.HttpSession" %>
     <%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="javax.servlet.http.HttpSession" %>
<%@ page language="java" import= "bean.movielist"%> 
     <%@ page language="java" import="java.util.*,java.lang.*" %> 
    <%@ page language="java" import="java.util.ArrayList,java.lang.*" %> 
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
    var i;
    function a(){

    	if(nc()){
    	

    	return true;
    	}
    	return false;
    	}
   
    /*function nc()
    {//for(i=0;i<10000;i++){
    if((f.check.value)!="checked")
    {
    alert("select atleast one");
    f.check.focus();
    return false;
    }
    else
    	{return true;}
    } */
</SCRIPT>
</HEAD>
<body onload="noBack();"
    onpageshow="if (event.persisted) noBack();" onunload="">

<div align="right">
<a href="Login.jsp"><font color="white">Logout</font></a>
</div>
<br><br><br><br>
<div align="center">
<font size="6" color="black"><u><b>Return Movies!!</b></u></font><br>

</div><br>
<hr>
<h2><u>Movies that are to be returned :</u></h2>

<% 

movielist temp;
movielist[] movie1;
movie1=(movielist[]) session.getAttribute("movlistobj");%>
<form name=f method="post" action="returnmovController" onsubmit=''>	
	<center><table border=1>
	

<%
int j=1;
%>	<tr><th>S.No</th><th>check</th><th>Transaction id</th><th>Movie id </th><th>Movie Name </th><th>copies number</th><th>Enter copies</th></tr>
<%int i;
for(i=0;movie1[i].getTid()!=null;i++)
{
%>
	<% 	StringTokenizer x,y,z;
	x=new StringTokenizer( movie1[i].getMovname(),"$");
			String b[]=new String[10];
			String c[]=new String[10];
			String m[]=new String[10];
			String c1[]=new String[10];
			String mid[]=new String[10];
			int k=0;
			while(x.hasMoreTokens())
			{
				b[k]=x.nextToken();
				System.out.println("var in jsp.........."+b[k]);
				y=new StringTokenizer( b[k],"*");
				while(y.hasMoreTokens())
				{
					c[k]=y.nextToken();
					System.out.println("var in  countandmovid jsp.........."+c[k]);
					m[k]=y.nextToken();
					System.out.println("var in movame jsp.........."+m[k]);
				}
				z=new StringTokenizer( c[k],"&");
				while(z.hasMoreTokens())
				{
					mid[k]=z.nextToken();
					System.out.println("var in  movid jsp.........."+mid[k]);
					c1[k]=z.nextToken();
					System.out.println("var in count jsp.........."+c1[k]);
				}
				k++;
			}	
			int m1=0;
			while(b[m1]!=null){%>
			<tr>
<td><%=j %></td>
<td>

<input type="checkbox" name=<%="check"+i %> value="checked" /></td>
			<td><input type="text" name= <%="tid"+i %> value=<%=movie1[i].getTid() %> readonly="readonly" /></td>
			<td><input type="text" name=<%="movid"+i %> value= <%= mid[m1] %> readonly="readonly" /></td>
			<td><input type="text" name=<%="movname"+i %> value= <%= m[m1] %> readonly="readonly" /></td>
			<td><input type="text" name=<%="count"+i %> value= <%= c1[m1] %> readonly="readonly" /></td>
		   
		    
<td><select name=<%="number"+i %>>
<% for(int k1=0;k1<=Integer.parseInt(c1[m1]);k1++)
{%>
<option value=<%=k1%>><%=k1%></option>
<% }%>
</select></td>
<%j++; m1++;
}
		

}
System.out.println("The value of j issssss"+j);
session.setAttribute("total", i);
%>

</table></center>
<center>

<input type=submit value="RETURN"/></center>
</form>

</body>
</html>
