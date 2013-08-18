package client;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.VideoLibraryManagementProxy;

import bean.Person;

/**
 * Servlet implementation class SignIn
 */
@WebServlet("/signincont")
public class signincont extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VideoLibraryManagementProxy proxy= new VideoLibraryManagementProxy();
	Person perobj1= new Person();


    /**
     * @see HttpServlet#HttpServlet()
     */
    public signincont() {
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
		PrintWriter out =response.getWriter();
		response.setContentType("text/html");
		String fname_login;
		try
		{
			String user_name=request.getParameter("user");
			String password=request.getParameter("pwd");
			proxy.setEndpoint("http://localhost:8080/svlm/services/VideoLibraryManagement");

			fname_login=proxy.signIn(user_name,password);
			HttpSession session =request.getSession();
			
		
			
			/*if(fname_login.substring(0,5).equalsIgnoreCase("false"))
			{
				out.println(fname_login.substring(6));
				out.println("\nInvalid username and password\n");
				out.println("\n <a href=\"SignIn.jsp\"><br>Try Login Again</a>");
				out.println("\n <a href=\"SignUp.jsp\"><br>Click here to Register</a>");

			}*/
			
			if(!fname_login.substring(0,4).equalsIgnoreCase("false"))

			{
			String delimiter = "[$]";
			String custname[] = fname_login.split(delimiter);
		
			//user.add(custname[1]);
			//session.setAttribute("newuser", user);
			//out.println(user);
			//out.println("Login time"+custname[1]);
			
			out.println("User name"+custname[3]);
			out.println("Successfuly login"+custname[2]);
			out.println("Country is"+custname[9]);

			perobj1.setLogintime(custname[1]);
			perobj1.setUsername(custname[2]);
			perobj1.setFirstname(custname[3]);
			perobj1.setLastname(custname[4]);
			perobj1.setType(custname[5]);
			perobj1.setAddress(custname[6]);
			perobj1.setCity(custname[7]);
			perobj1.setState(custname[8]);
			perobj1.setZipcode(custname[9]);
			perobj1.setMemberid(custname[10]);
			perobj1.setCountry(custname[11]);
			
			session.setAttribute("per", perobj1);

			response.sendRedirect("home.jsp");
			//response.sendRedirect("updateperson.jsp");
			out.println("\n <a href=\"personprofile.jsp\"><br>Personr Profile</a>");
			out.println("\n <a href=\"searchperson.jsp\"><br>Search Personr</a>");
			out.println("\n <a href=\"updateperson.jsp\"><br>Update Person</a>");

			//session.setAttribute("fname",custname[1]);
			//session.setAttribute("username",custname[2]);
			//session.setAttribute("userlist",user);
		}

			else
			{
				
				out.println(fname_login.substring(6));
				out.println("\nInvalid username and password\n");
				out.println("\n <a href=\"SignIn.jsp\"><br>Try Login Again</a>");
				out.println("\n <a href=\"SignUp.jsp\"><br>Click here to Register</a>");

			}
			
		}
		
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
			
	}

}
