package client;

import java.io.*;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.VideoLibraryManagementProxy;



import java.io.IOException;

/**
 * Servlet implementation class MovieIssue
 */
@WebServlet("/MovieIssue")
public class MovieIssue extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VideoLibraryManagementProxy proxy= new VideoLibraryManagementProxy();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieIssue() {
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
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		try
		{
			
			response.setContentType("text/html");
			
			String memid=request.getParameter("searchpersondetail");

			if(memid!=null)
			{
			System.out.println("Member id is:"+memid);
			String persondetails=proxy.personDetail(memid);
			session.setAttribute("perdetails", persondetails);
			session.setAttribute("mid",memid);

		
			String result=proxy.movieIssue(memid);
			session.setAttribute("res", result);
			
				if(result.substring(0,4).equals("false"))
				{
				out.println(result.substring(6));
				//out.println("\nInvalid username and password\n");
				//out.println("\n <a href=\"SignIn.jsp\"><br>Try Login Again</a>");
				//out.println("\n <a href=\"SignUp.jsp\"><br>Click here to Register</a>");

				}

				else
				{
				
				response.sendRedirect("movieissue.jsp");
				}
			
		}
				else
					out.println("Please Select atlease one row");
			out.println("\n <a href=\"personprofile.jsp\"><br>Back to Search</a>");

			
			
			
			
			
			}
		
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
			
	}
	
}
