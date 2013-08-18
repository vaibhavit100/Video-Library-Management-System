package client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.VideoLibraryManagementProxy;


/**
 * Servlet implementation class delMovie
 */
@WebServlet("/delMovie")
public class delMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	VideoLibraryManagementProxy proxy = new VideoLibraryManagementProxy();
    public delMovie() {
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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String result=null;
		
		try{
			
			proxy.setEndpoint("http://localhost:8080/svlm/services/VideoLibraryManagement");
			
			
			String select[] = request.getParameterValues("movid");
			
			if (select != null && select.length != 0) 
			{
			   System.out.println("You have selected: ");
			        for (int i = 0; i < select.length; i++) 
			        {
			        	result = proxy.delMovies(select[i]);
			        	
			        	if(result.equals("deleted")){
			        		System.out.println(select[i]);
			        		String str="Movie Deleted Sucessfully !!!";
			        		System.out.println(str);
			        		
			        		session.setAttribute("delmovmsg",str);
			        	}
			        	else{
			        		System.out.println("ERROR !!!");
			        	}
			        	            	
		            }
			
			}
			else{
				System.out.println("No movies selected for deletion !!!");
			}
			
			response.sendRedirect("delMovie.jsp");
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
