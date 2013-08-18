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
 * Servlet implementation class DeleteMember
 */
@WebServlet("/DeleteMember")
public class DeleteMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VideoLibraryManagementProxy proxy= new VideoLibraryManagementProxy();
	//Person perobj;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMember() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out=response.getWriter();
		proxy.setEndpoint("http://localhost:8080/svlm/services/VideoLibraryManagement");
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		try
		{
			
			response.setContentType("text/html");
			//String delItem=request.getParameter("item");
			Person obj[]= (Person[])session.getAttribute("perobj");
			String result="";
			String delperson[]=request.getParameterValues("searchperson");
			//String result=proxy.delmember(memberid)
			for (int i=0;i<delperson.length;i++)
			{
			// index=ls.indexOf(delperson[i]);
				System.out.println(delperson[i]);
				result=proxy.delmember(delperson[i]);
				
				System.out.println(result.substring(0,4));

				//System.out.println(obj[i].getPersonId());
				//System.out.println(obj[i].getMemberId());

			
			}
			
			
			if(result.substring(0,4).equals("false"))
			{
				out.println(result.substring(6));
				//out.println("\nInvalid username and password\n");
				//out.println("\n <a href=\"SignIn.jsp\"><br>Try Login Again</a>");
				//out.println("\n <a href=\"SignUp.jsp\"><br>Click here to Register</a>");

			}

			else
			{
				
			response.sendRedirect("searchperson.jsp");
			}
			
			
		}
		
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
			
	}
	
}
