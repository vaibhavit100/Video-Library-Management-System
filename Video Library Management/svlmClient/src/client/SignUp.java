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
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VideoLibraryManagementProxy proxy= new VideoLibraryManagementProxy();
	//Person perobj= new Person();
	Person perobj= new Person();
	Date date= new Date();
	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("in sign up contollerrr--->");
		PrintWriter out=response.getWriter();
		String zipcode="";
		proxy.setEndpoint("http://localhost:8080/svlm/services/VideoLibraryManagement");
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		try
		{
			
			//Person perobj= (Person)session.getAttribute("per");

			String fname=request.getParameter("fname");
			perobj.setFirstname(fname);
			
			String lname=request.getParameter("lname");
			perobj.setLastname(lname);
			
			String mtype=request.getParameter("memtype");
			perobj.setType(mtype);

			String memberid1=request.getParameter("memid1");
			String memberid2=request.getParameter("memid2");
			String memberid3=request.getParameter("memid3");
			String memberid=memberid1+"-"+memberid2+"-"+memberid3;
			System.out.print(memberid);
			perobj.setMemberid(memberid);
			String user_name=request.getParameter("uname");
			perobj.setUsername(user_name);
			
			String password=request.getParameter("pwd1");
			perobj.setPassword(password);
			
			String address=request.getParameter("address");
			perobj.setAddress(address);

			String city=request.getParameter("city");
			perobj.setCity(city);


			String state=request.getParameter("state");
			perobj.setState(state);

			String zipcode1=request.getParameter("zipcode1");
			String zipcode2=request.getParameter("zipcode2");
			
			if(zipcode2.length()!=0)
			zipcode=zipcode1+"-"+zipcode2;

			else
				zipcode=zipcode1;
				
			
			perobj.setZipcode(zipcode);
			String country=request.getParameter("country");
			perobj.setCountry(country);
			
			String mdate = sdf.format(date);
			String logintime=sdf.format(date);

			session.setAttribute("perobj", perobj);
			
			out.println(mtype);
			if (mtype.equalsIgnoreCase("simple"))
			{
				String smemdetails=proxy.createMembers(fname, lname, mtype, address, city, state, zipcode, memberid, mdate, country, user_name, password, logintime);

				if(smemdetails.substring(0,4).equals("true"))
				{
					out.println("\n You have successfully registered in Video Library Management");

					out.println("\n <a href=\"SignIn.jsp\"><br>Go back to SignIn</a>");
				
				}	
				else
				{
					
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+smemdetails);
					out.println(smemdetails.substring(6));
				
					if(smemdetails.equalsIgnoreCase("duplicateid"))
					{
						String a="dupliid";
						session.setAttribute("duplicateid", a);
						response.sendRedirect("SignUp1.jsp");
						System.out.println("8888888888888888888888888888888888888888888888888888888888888");
					}
					if(smemdetails.equalsIgnoreCase("duplicateemail"))
					{
						String a1="dupliemail";
						session.setAttribute("duplicateemail",a1);
						response.sendRedirect("SignUp2.jsp");
					}
				}
				
			}
			
			
			
			else
				response.sendRedirect("pmempayment.jsp");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
			
	}
	
}