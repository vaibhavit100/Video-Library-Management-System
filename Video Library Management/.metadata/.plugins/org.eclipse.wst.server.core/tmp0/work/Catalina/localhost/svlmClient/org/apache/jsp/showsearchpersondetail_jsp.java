/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.30
 * Generated at: 2013-02-20 21:01:26 UTC
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

public final class showsearchpersondetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
//@ page errorPage="errorpage.jsp" 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Person Search Result</title>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("function validateRadio()\r\n");
      out.write("{\r\n");
      out.write("\tvar chk=0;\r\n");
      out.write("\tfor (var i=0; i < document.form1.searchpersondetail.length; i++)\r\n");
      out.write("\t   {\r\n");
      out.write("\t   if (document.form1.searchpersondetail[i].checked)\r\n");
      out.write("\t      {\r\n");
      out.write("\t      chk++;\r\n");
      out.write("\t      }\r\n");
      out.write("\t   }\r\n");
      out.write("\tif(chk==0){\r\n");
      out.write("\t\talert(\"Please select a row to check movie issue details !!!\");\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
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
      out.write("<div id=\"navbar1\">\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "adminhome.jsp", out, false);
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<h1 align=\"center\">Video Library Management</h1>\r\n");
      out.write("<h2 align=\"center\" >Search Result</h2>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<form name=\"form1\"  method=\"post\"  action=\"MovieIssue\"  onSubmit=\"\">\r\n");
      out.write("\r\n");
      out.write("\r\n");


Person obj[]= (Person[])session.getAttribute("perobj");
String search[]= (String[])session.getAttribute("search");

System.out.println("length is"+search.length);
System.out.println("Object is"+obj[0]);
if(obj[0]!=null)
{
	System.out.println(obj[0].getFirstname());

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table border==\"0\" align=\"center\">\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("Your Search Result is\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<th>PersonId</th>\r\n");
      out.write("<th>FirstName</th>\r\n");
      out.write("<th>LastName</th>\r\n");
      out.write("<th>Membership Type</th>\r\n");
      out.write("<th>Address</th>\r\n");
      out.write("<th>City</th>\r\n");
      out.write("<th>State</th>\r\n");
      out.write("<th>ZipCode</th>\r\n");
      out.write("<th>Country</th>\r\n");
      out.write("<th>Membership Id</th>\r\n");
      out.write("\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

//System.out.println()
for (int i=0;obj[i]!=null;i++) 
{

      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<td><input type=\"radio\" name=\"searchpersondetail\" VALUE=\"");
      out.print(obj[i].getMemberid());
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(obj[i].getPersonid());
      out.write(" <BR>\r\n");
      out.write(" </td>\r\n");
      out.write("<td>");
      out.print(obj[i].getFirstname());
      out.write("</td>\r\n");
      out.write("<td>");
      out.print(obj[i].getLastname());
      out.write("</td>\r\n");
      out.write("<td>");
      out.print(obj[i].getType());
      out.write("</td>\r\n");
      out.write("<td>");
      out.print(obj[i].getAddress());
      out.write("</td>\r\n");
      out.write("<td>");
      out.print(obj[i].getCity());
      out.write("</td>\r\n");
      out.write("<td>");
      out.print(obj[i].getState());
      out.write("</td>\r\n");
      out.write("<td>");
      out.print(obj[i].getZipcode());
      out.write("</td>\r\n");
      out.write("<td>");
      out.print(obj[i].getCountry());
      out.write("</td>\r\n");
      out.write("<td>");
      out.print(obj[i].getMemberid());
      out.write("</td>\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write(" ");

}

      out.write("\r\n");
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write(" ");

 }

if(obj[0]!=null)
{


      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" <table>\r\n");
      out.write(" <tr>\r\n");
      out.write(" <td>\r\n");
      out.write("<div class=\"form-row\"><input class=\"submit\"  type=\"Submit\" value=\"Movie Issued\"/> </div>\r\n");
      out.write("</td>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

 }
else
{

      out.write("\r\n");
      out.write("\r\n");
      out.write("<h1 align=\"right\">No matching result found</h1>\r\n");

}



      out.write("\r\n");
      out.write(" \r\n");
      out.write("<td>\r\n");
      out.write("<div class=\"form-row\"><input class=\"button\" type=\"button\" value=\"Modify Search\" onclick=\"JavaScript:window.location='searchpersondetail.jsp';\">  </div>\r\n");
      out.write("</td>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
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