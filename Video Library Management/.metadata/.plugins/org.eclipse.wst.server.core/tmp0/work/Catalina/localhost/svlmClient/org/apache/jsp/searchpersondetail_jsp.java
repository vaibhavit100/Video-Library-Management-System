/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.30
 * Generated at: 2013-02-20 21:00:02 UTC
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

public final class searchpersondetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
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
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function validateSearchPerson()\r\n");
      out.write("{\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("    \r\n");
      out.write("\tif((document.form1.fname.value==\"\") && (document.form1.lname.value==\"\") && (document.form1.memid.value==\"\") && (document.form1.memtype.value==\"\") && (document.form1.address.value==\"\") &&  (document.form1.city.value==\"\") && (document.form1.state.value==\"\") && (document.form1.zipcode.value==\"\") && (document.form1.country.value==\"\"))\r\n");
      out.write("    {\r\n");
      out.write("     alert(\"At least one field should be non empty\");\r\n");
      out.write("      return false;\r\n");
      out.write("    }\r\n");
      out.write("       \t    \t    \t    \t    \t    \t\t\r\n");
      out.write("       \t    \t    \t    \t    \t    \t\t\r\n");
      out.write(" }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Search Person</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"navbar1\">\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "adminhome.jsp", out, false);
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<br><br><br><br><br><br><br><br><br>\r\n");
      out.write("\r\n");
      out.write("<h2 align=\"center\" >Search person</h2>\r\n");
      out.write("<br><br><br>\r\n");
      out.write("\r\n");


Person per= (Person)session.getAttribute("per1");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div align=\"center\">\r\n");
      out.write("<form name=\"form1\" method=\"post\"  action=\"SearchPersonDetail\" onSubmit=\"return validateSearchPerson()\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table border=\"0\" >\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<td><div class=\"form-row\"><span class=\"label\">  First Name</span></td><td><input type=\"text\" name=\"fname\"/> </div></td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<td><div class=\"form-row\"><span class=\"label\">  Last Name</span></td><td><input type=\"text\" name=\"lname\"/> </div></td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<td><div class=\"form-row\"><span class=\"label\">   MembershipId</span></td><td><input type=\"text\" name=\"memid\"/> </div></td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<td> \r\n");
      out.write("MemberType\r\n");
      out.write("</td>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<td>\r\n");
      out.write("<select name=\"memtype\">\r\n");
      out.write("<option value=\"\">Select</option>\r\n");
      out.write("<option value=\"simple\">Simple Member</option>\r\n");
      out.write("<option value=\"premium\">Premium Member</option>\r\n");
      out.write("</select>\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<td><div class=\"form-row\"><span class=\"label\">  Address</span></td><td><input type=\"text\" name=\"address\"/> </div></td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<td><div class=\"form-row\"><span class=\"label\">  City</span></td><td><input type=\"text\" name=\"city\"/> </div></td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<td><div class=\"form-row\"><span class=\"label\">  State</span></td><td><input type=\"text\" name=\"state\"/> </div></td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<td><div class=\"form-row\"><span class=\"label\">  ZipCode</span></td><td><input type=\"text\" name=\"zipcode\"/> </div></td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<td><div class=\"form-row\"><span class=\"label\">  Country</span></td><td><input type=\"text\" name=\"country\"/> </div></td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<td><div class=\"form-row\"><input class=\"submit\"  type=\"submit\" value=\"Search\" onSubmit=\"return validateSearchPerson()\"/> </div></td>\r\n");
      out.write("\r\n");
      out.write("<td><div class=\"form-row\"><input class=\"reset\"   type=\"reset\" value=\"Reset\"/> </div></td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("</form>\r\n");
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