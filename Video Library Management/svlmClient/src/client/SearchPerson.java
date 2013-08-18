package client;

import java.io.*;
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
 * Servlet implementation class SearchPerson
 */
@WebServlet("/SearchPerson")
public class SearchPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VideoLibraryManagementProxy proxy= new VideoLibraryManagementProxy();
	Person perobj;


       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPerson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		proxy.setEndpoint("http://localhost:8080/svlm/services/VideoLibraryManagement");
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		try
		{
			String fname=request.getParameter("fname");
			//perobj.setFirstName(fname);
			String lname=request.getParameter("lname");
			//perobj.setLastName(lname);
			String mtype=request.getParameter("memtype");
			String memberid=request.getParameter("memid");
			//perobj.setMemberId(memberid);
		
					
			String address=request.getParameter("address");
			//perobj.setAddress(address);

			String city=request.getParameter("city");
			//perobj.setCity(city);


			String state=request.getParameter("state");
			//perobj.setState(state);

			String zipcode=request.getParameter("zipcode");
			//perobj.setZipCode(zipcode);

			String country=request.getParameter("country");
			//perobj.setCountry(country);
			
			//session.setAttribute("perobj", perobj);
			//String memdetails=proxy.createMembers(fname, lname, mtype, address, city, state, zipcode, memberid, mdate, country, email_id, password, logintime);
			String search_per[]=proxy.searchPerson(fname, lname, mtype, address, city, state, zipcode, memberid, country);
			
			//if(search_per!=null)
		//	{
				Person perobj[]= new Person[search_per.length];
			
				for(int i=0;search_per[i]!=null;i++)
				{
					perobj[i]=new Person();
				}
				//System.out.println("Length is"+ search_per.length);
			
				String delimiter = "[$]";

				for(int i=0;search_per[i]!=null;i++)
				{
					//System.out.println(search_per[i]);

					String per_det[] = search_per[i].split(delimiter);
					//perobj[i].setPersonId(per_det[0]);
					//System.out.println(per_det);
					/*System.out.println(per_det[0]);
					System.out.println(per_det[1]);
					System.out.println(per_det[2]);
					System.out.println(per_det[3]);
					System.out.println(per_det[4]);
					System.out.println(per_det[5]);
					System.out.println(per_det[6]);
					System.out.println(per_det[7]);
					System.out.println(per_det[8]);

					*/

					perobj[i].setPersonid(per_det[0]);

					perobj[i].setFirstname(per_det[1]);
					perobj[i].setLastname(per_det[2]);
					perobj[i].setType(per_det[3]);
					perobj[i].setAddress(per_det[4]);
					perobj[i].setCity(per_det[5]);
					perobj[i].setState(per_det[6]);
					perobj[i].setZipcode(per_det[7]);
					perobj[i].setMemberid(per_det[8]);
					perobj[i].setCountry(per_det[9]);
				}
			
			session.setAttribute("perobj", perobj);
			session.setAttribute("search", search_per);

			response.sendRedirect("showsearchperson.jsp");
			//}

		
				/*else
				{
					out.println("Error in Searching");
					response.sendRedirect("eror.jsp");
				}
				*/
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
			
	}
	
}