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

import bean.moviecart;


/**
 * Servlet implementation class addtocartcontroller
 */
@WebServlet("/addtocartcontroller")
public class addtocartcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

    /**
     * @see HttpServlet#HttpServlet()
     */
    public addtocartcontroller() {
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
		VideoLibraryManagementProxy proxy=new VideoLibraryManagementProxy();
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String qdone;
		try
		{
			
			HttpSession session=request.getSession(true);
			proxy.setEndpoint("http://localhost:8080/svlm/services/VideoLibraryManagement");
			moviecart cart=new moviecart();
			String count=(String)session.getAttribute("total");
			int count1=Integer.parseInt(count);
			System.out.println("---------------------->"+count1);
			for(int i=0;i<count1;i++)
			{
				//System.out.println("-------------------------->"+request.getParameter("check"+i));
				if(request.getParameter("check"+i)!=null&&request.getParameter("check"+i).equals("checked"))
				{
					String mc=request.getParameter("number"+i);
					String mname=request.getParameter("movname"+i);
					String mbanner=request.getParameter("movbanner"+i);
					String mcate=request.getParameter("category"+i);
					String mreld=request.getParameter("reldate"+i);
					String mid=request.getParameter("movid"+i);				
					cart.setdetails(mid, mname, mbanner, mreld, mcate, mc);
				}
			}
			session.setAttribute("mcart", cart);
			response.sendRedirect("moviecart.jsp");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
