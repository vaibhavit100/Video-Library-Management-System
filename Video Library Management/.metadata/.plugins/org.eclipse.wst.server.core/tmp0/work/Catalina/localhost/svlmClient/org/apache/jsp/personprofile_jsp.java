/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.30
 * Generated at: 2013-02-20 21:02:03 UTC
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

public final class personprofile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
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
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Profile Info</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"home1\">\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "home.jsp", out, false);
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("<hr>\r\n");
      out.write("<br><br><br><br><br><br><br><br><br><br>\r\n");

Person per= (Person)session.getAttribute("per1");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div align=center>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<font size=\"5\" color=\"\">Personal Information:</font>\r\n");
      out.write("<br><br><br>\r\n");
      out.write("<form name=\"form1\" method=\"post\"  action=\"updateperson.jsp\"  onSubmit=\"\">\r\n");
      out.write("\r\n");
      out.write("<table border=\"1\">\r\n");
      out.write("<tr>\r\n");
      out.write("<th>\r\n");
      out.write("Account Information\r\n");
      out.write("</th>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<th><div class=\"form-row\"><span class=\"label\">  First Name</span></th><td><input type=\"text\" name=\"fname\" value=\"");
      out.print(per.getFirstname());
      out.write("\" readonly=\"readonly\"/> </div></td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<th><div class=\"form-row\"><span class=\"label\">  Last Name</span></th><td><input type=\"text\" name=\"lname\" value=\"");
      out.print(per.getLastname());
      out.write("\" readonly=\"readonly\"/> </div></td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<th><div class=\"form-row\"><span class=\"label\">  Membership Type</span></th><td><input type=\"text\" name=\"memid\" value=\"");
      out.print(per.getType());
      out.write("\" readonly=\"readonly\"/> </div></td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<th><div class=\"form-row\"><span class=\"label\">  Membership Id</span></th><td><input type=\"text\" name=\"memid\" value=\"");
      out.print(per.getMemberid());
      out.write("\" readonly=\"readonly\"/> </div></td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<th>\r\n");
      out.write("Home Address\r\n");
      out.write("</th>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<th><div class=\"form-row\"><span class=\"label\">  Address</span></th><td><input type=\"text\" name=\"address\" value=\"");
      out.print(per.getAddress());
      out.write("\" readonly=\"readonly\"/> </div></td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<th><div class=\"form-row\"><span class=\"label\">  City</span></th><td><input type=\"text\" name=\"city\" value=\"");
      out.print(per.getCity());
      out.write("\" readonly=\"readonly\"/> </div></td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<th><div class=\"form-row\"><span class=\"label\">  State</span></th><td><input type=\"text\" name=\"state\" value=\"");
      out.print(per.getState());
      out.write("\" readonly=\"readonly\"/> </div></td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<th><div class=\"form-row\"><span class=\"label\">  ZipCode</span></th><td><input type=\"text\" name=\"zipcode\" value=\"");
      out.print(per.getZipcode());
      out.write("\" readonly=\"readonly\"/> </div></td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<th><div class=\"form-row\"><span class=\"label\">  Country</span></th><td><input type=\"text\" name=\"country\" value=\"");
      out.print(per.getCountry());
      out.write("\" readonly=\"readonly\"/> </div></td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<th><div class=\"form-row\"><input class=\"submit\"  type=\"submit\" value=\"Edit\"/> </div></th>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
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
