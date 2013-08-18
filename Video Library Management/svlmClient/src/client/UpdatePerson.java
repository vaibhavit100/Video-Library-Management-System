package client;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Person;

import services.VideoLibraryManagementProxy;

/**
 * Servlet implementation class UpdatePerson
 */
@WebServlet("/UpdatePerson")
public class UpdatePerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	VideoLibraryManagementProxy proxy= new VideoLibraryManagementProxy();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePerson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		proxy.setEndpoint("http://localhost:8080/svlm/services/VideoLibraryManagement");
		HttpSession session = request.getSession();
		Person per= (Person)session.getAttribute("per1");

		response.setContentType("text/html");
		try
		{
			String fname=request.getParameter("fname");
			String lname=request.getParameter("lname");
			String memberid=request.getParameter("memid");
			String address=request.getParameter("address");
			String city=request.getParameter("city");
			String state=request.getParameter("state");
			String zipcode=request.getParameter("zipcode");
			String country=request.getParameter("country");
			//perobj.setCountry(country);
			
			//session.setAttribute("perobj", perobj);
			//String memdetails=proxy.createMembers(fname, lname, mtype, address, city, state, zipcode, memberid, mdate, country, email_id, password, logintime);
			String update_per=proxy.updatePinfo(fname, lname, address, city, state, zipcode, memberid, country);
			
			System.out.println(update_per.substring(0,4));
			if(update_per.substring(0,4).equalsIgnoreCase("true"))
			{
				
				

							per.setUsername(fname);
							per.setFirstname(fname);
							per.setLastname(lname);
							per.setAddress(address);
							per.setCity(city);
							per.setState(state);
							per.setZipcode(zipcode);
							per.setMemberid(memberid);
							//System.out.println("88888888888888888888888--+"+perobj1.getMemberid());
							per.setCountry(country);
							
							response.sendRedirect("personprofile.jsp");

			}
			
			else
			{
			
				out.println(update_per.substring(6));

			}
		
		}
		
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
			
	}
}