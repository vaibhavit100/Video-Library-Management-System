package client;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.VideoLibraryManagementProxy;

import java.util.StringTokenizer;

import bean.Person;
import bean.movielist;


/**
 * Servlet implementation class signUp
 */
@WebServlet("/returnlistController")


public class returnlistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VideoLibraryManagementProxy proxy=new VideoLibraryManagementProxy(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public returnlistController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		proxy.setEndpoint("http://localhost:8080/svlm/services/VideoLibraryManagement");
		
		response.setContentType("text/html");
		
		try
		{
			
			System.out.println("hi----------------------------------------------------------------------------------> !!!");
			      
		
		String d;
		HttpSession session=request.getSession(true);
		Person person=(Person) session.getAttribute("per1");
		String memid=person.getMemberid();
		String qdone;
	
		System.out.println("Haiiiiiiiiiiiiiiiiiiiiiiiiiii");
		qdone= proxy.returnmovofmember(memid);
		System.out.println("return");
		
		int i;
	
		
		
		StringTokenizer x,y,z;
	
		System.out.println(qdone);
		
			
			x=new StringTokenizer(qdone,",");
			String b[]=new String[10000];
			int j=0;
			while(x.hasMoreTokens())
			{
				b[j]=x.nextToken();
				System.out.println("var is  totallllllllll.........."+b[j]);
				j++;
			}
			movielist a[]=new movielist[10000];
			for(i=0;i<10000;i++)
			{
				a[i]=new movielist();
			}
			
			int p=0;int k=0;String tid,movl,movn,c;
			while(b[p]!=null)
			{
			y=new StringTokenizer(b[p],"#");
			
			
			while(y.hasMoreTokens())
			{
				tid=y.nextToken();
				System.out.println("var is tid .........."+tid);
				a[p].setTid(tid);
				movl=y.nextToken();
				System.out.println("var is mid&count*movname.........."+movl);
				a[p].setMovname(movl);
				
			}
			p++;
			}
			
			
			System.out.println("hi----------------------------------------------------------------------------------> !!!");
		
		session.setAttribute("movlistobj", a);
		response.sendRedirect("return.jsp");
		}
		
		catch(Exception e)
		{
			e.getStackTrace();
		}
		
	}

}