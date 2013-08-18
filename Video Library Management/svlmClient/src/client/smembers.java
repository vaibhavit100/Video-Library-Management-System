package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.VideoLibraryManagementProxy;


import bean.Person;
/**
 * Servlet implementation class smembers
 */
@WebServlet("/smembers")
public class smembers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VideoLibraryManagementProxy proxy=new VideoLibraryManagementProxy();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public smembers() {
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
		response.setContentType("text/html");
		String qdone[];
		Person a[]=new Person[200];
		try
		{
			HttpSession session=request.getSession(true);
			proxy.setEndpoint("http://localhost:8080/svlm/services/VideoLibraryManagement");
			qdone=proxy.sMembers();
			StringTokenizer temp;
			for(int i=0;qdone[i]!=null;i++)
			{
				a[i]=new Person();
				String var[]=new String[8];
				int k=0;
				temp=new StringTokenizer(qdone[i],"$");
				while(temp.hasMoreTokens())
				{
					var[k]=temp.nextToken();
					k++;
				}
				a[i].setFirstname(var[0]);
				a[i].setLastname(var[1]);
				a[i].setAddress(var[2]);
				a[i].setCity(var[3]);
				a[i].setState(var[4]);
				a[i].setZipcode(var[5]);
				a[i].setMemberid(var[6]);
				a[i].setCountry(var[7]);
			}
			session.setAttribute("smember", a);
			response.sendRedirect("smembers.jsp");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
