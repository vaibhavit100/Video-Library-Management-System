package client;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Person;

import services.VideoLibraryManagementProxy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;

/**
 * Servlet implementation class signUp
 */
@WebServlet("/returnmovController")
public class returnmovController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VideoLibraryManagementProxy proxy=new VideoLibraryManagementProxy();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public returnmovController() {
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
		response.setContentType("text/html");
		String qdone;
		int i;
		try
		{
			
			   System.out.println("hi !!!");
				HttpSession session=request.getSession(true);
				Person person=(Person) session.getAttribute("per1");
				String memid=person.getMemberid();
			   String[] mn=new String[10000];
			   int[] t=new int[10000];
			   int[] mid=new int[10000];
			   int[] count=new int[10000];
			  // System.out.println(m);
			   int coun=(Integer)session.getAttribute("total");
				System.out.println("---------------------->"+coun);
				for( i=0;i<coun;i++)
				{
					System.out.println("------------------------------------------------------->>>>>>"+request.getParameter("check"+i));
					if(request.getParameter("check"+i)!=null && request.getParameter("check"+i).equals("checked"))
					{
			   System.out.println("entered iffffffffffffffffffff");
			   mn[i] = request.getParameter("movname"+i);
			   System.out.println(mn[i]);
			   mid[i]=Integer.parseInt(request.getParameter("movid"+i));
			   System.out.println(mid[i]);
			   t[i]=Integer.parseInt(request.getParameter("tid"+i));
			   System.out.println(t[i]);
			   count[i]=Integer.parseInt(request.getParameter("number"+i));
			   System.out.println("-------------------->"+count[i]);
			   System.out.println(mn[i]);
			   System.out.println(mid[i]);
			   System.out.println(t[i]);
			   System.out.println("-------------------->"+count[i]);
				   }
				   else
				   {System.out.println("i am in else");
					   //break;
				   }
			   
			   }
			  
			         DateFormat timef = new SimpleDateFormat("HH:mm:ss");
					 Date date1 = new Date();
					 System.out.println("------------------->"+timef.format(date1));
					 String time=timef.format(date1);
					 DateFormat datef = new SimpleDateFormat("yyyy/MM/dd");
					 Date date2 = new Date();
					 System.out.println("------------------->"+datef.format(date2));
					 String date=datef.format(date2);
					String retDateandTime=date+"$"+time;
					System.out.println("------------------->"+retDateandTime);
					String movname="",cou="",tid="",movids="";
					for(int j=0;j<10;j++)
					{if(mn[j]!=null)
					movname+=mn[j]+"$";
					if(count[j]!=0)
					cou+=count[j]+"#";
					if(t[j]!=0)
					tid+=t[j]+"$";
					if(mid[j]!=0)
						movids+=mid[j]+"$";
					}
					System.out.println("movie nameeeeeeeeeeee------------------->"+ movname);
					System.out.println("movie nameeeeeeeeeeee------------------->"+ movids);
					System.out.println("counttttttttttt------------------->"+ cou);
					System.out.println("tidddddddddddd------------------->"+ tid);
					
					
					proxy.setEndpoint("http://localhost:8080/svlm/services/VideoLibraryManagement");
		
		qdone= proxy.returnMovie(memid,movids,movname,cou,retDateandTime,tid);
		
		
		
		if(qdone.equals("true"))
		{
			//session.setAttribute("userSession",session);
			out.println("Return id successfull");
			String dest="home.jsp";
			response.sendRedirect(dest);
		}
		else
		{
			out.println(qdone.substring(6));
			out.println("\n<a href=\"signUp.jsp\"><br>Go back to sign up again</a>");
		}
		
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		
	}

}