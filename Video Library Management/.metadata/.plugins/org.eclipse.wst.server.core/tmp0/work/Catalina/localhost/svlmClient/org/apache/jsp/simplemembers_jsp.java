/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.30
 * Generated at: 2013-02-20 21:01:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import javax.servlet.http.HttpSession;
import bean.Person;
import services.VideoLibraryManagementProxy;

public final class simplemembers_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Simple Members</title>\r\n");
      out.write("</head>\r\n");
      out.write("<style>\r\n");
      out.write("td {\r\n");
      out.write(" border: solid 1px black;\r\n");
      out.write("}\r\n");
      out.write("tr{\r\n");
      out.write(" border: solid 1px black;\r\n");
      out.write("}\r\n");
      out.write("table{\r\n");
      out.write("border: solid 1px black;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<body>\r\n");
 
	
	VideoLibraryManagementProxy proxy= new VideoLibraryManagementProxy();

		//int i=0;
		try{
			//HttpSession session=request.getSession();
			proxy.setEndpoint("http://localhost:8080/svlm/services/VideoLibraryManagement");
			
			String input[];
			input=proxy.sMembers();
			
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
			session.setAttribute("sMemberobj", a);
			//response.sendRedirect("allPerson.jsp");
			
		}
		
		catch (Exception e){
			e.printStackTrace();
		}
		
		
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div id=\"navbar1\">\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "adminhome.jsp", out, false);
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("<br><br><br>\r\n");
      out.write("<div align=center>\r\n");
      out.write("\r\n");
      out.write("<br><br><br><br><br><br><br><br>\r\n");
      out.write("<font size=\"5\" color=\"\">Simple Members Information:</font>\r\n");
      out.write("<br><br><br><br>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

//VideoLibraryManagementProxy proxy= new VideoLibraryManagementProxy();

Person per= (Person)session.getAttribute("per");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table align=\"center\" border=\"1\" width=\"90%\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<th>Personid</th>\r\n");
      out.write("<th>FirstName</th>\r\n");
      out.write("<th>LastName</th>\r\n");
      out.write("<th>Address</th>\r\n");
      out.write("<th>City</th>\r\n");
      out.write("<th>State</th>\r\n");
      out.write("<th>Zipcode</th>\r\n");
      out.write("<th>Membership Id</th>\r\n");
      out.write("<th>Country</th>\r\n");
      out.write("</tr>\r\n");

Person a[];
a=(Person[])session.getAttribute("sMemberobj");
for(int i=0;a[i].getPersonid()!=null;i++)
{

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<td>\r\n");
      out.print(a[i].getPersonid());
      out.write("\r\n");
      out.write("</td>\r\n");
      out.write("<td>\r\n");
      out.print(a[i].getFirstname());
      out.write("\r\n");
      out.write("</td>\r\n");
      out.write("<td>\r\n");
      out.print(a[i].getLastname());
      out.write("\r\n");
      out.write("</td>\r\n");
      out.write("<td>\r\n");
      out.print(a[i].getAddress());
      out.write("\r\n");
      out.write("</td>\r\n");
      out.write("<td>\r\n");
      out.print(a[i].getCity());
      out.write("\r\n");
      out.write("</td>\r\n");
      out.write("<td>\r\n");
      out.print(a[i].getState());
      out.write("\r\n");
      out.write("</td>\r\n");
      out.write("<td>\r\n");
      out.print(a[i].getZipcode());
      out.write("\r\n");
      out.write("</td>\r\n");
      out.write("<td>\r\n");
      out.print(a[i].getMemberid());
      out.write("\r\n");
      out.write("</td>\r\n");
      out.write("<td>\r\n");
      out.print(a[i].getCountry());
      out.write("\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");

}

      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("<br>\r\n");
      out.write("<div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}