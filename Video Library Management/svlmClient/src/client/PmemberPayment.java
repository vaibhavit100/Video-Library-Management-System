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
 * Servlet implementation class PmemberPayment
 */
@WebServlet("/PmemberPayment")
public class PmemberPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VideoLibraryManagementProxy proxy= new VideoLibraryManagementProxy();
	Person perobj;
	Date date= new Date();
	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PmemberPayment() {
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
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		proxy.setEndpoint("http://localhost:8080/svlm/services/VideoLibraryManagement");
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		try
		{
		perobj=(Person)session.getAttribute("perobj");
		String mdate = sdf.format(date);
		String logintime = sdf.format(date);

		String pmemdetails=proxy.createMembers(perobj.getFirstname(),perobj.getLastname(),perobj.getType(),perobj.getAddress(),perobj.getCity(),perobj.getState(),perobj.getZipcode(),perobj.getMemberid(),mdate,perobj.getCountry(),perobj.getUsername(),perobj.getPassword(),logintime);
		//fname, lname, mtype, address, city, state, zipcode, memberid, mdate, country, user_name, password, logintime);

		if(pmemdetails.substring(0,4).equals("true"))
		{
			out.println("\n You have successfully registered in Video Library Management");

			out.println("\n <a href=\"SignIn.jsp\"><br>Go back to SignIn</a>");
		
		}	
		else
		{
			out.println(pmemdetails.substring(6));
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
			
	}
	
}