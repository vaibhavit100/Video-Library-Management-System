package client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.VideoLibraryManagementProxy;



/**
 * Servlet implementation class addMovie
 */
public class addMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	VideoLibraryManagementProxy proxy = new VideoLibraryManagementProxy();
    public addMovie() {
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
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		System.out.println("Add Movie !!!");
		
		try{
			
			proxy.setEndpoint("http://localhost:8080/svlm/services/VideoLibraryManagement");
			
			String movname = request.getParameter("movname");
			String movbanner = request.getParameter("movbanner");
			String reldate = request.getParameter("releasedate");
			String category = request.getParameter("category");
			String noofcopies = request.getParameter("noofcopies");
			
			
			int mcopies= Integer.parseInt(noofcopies);
			
			String result = proxy.createMovies(movname, movbanner, category, reldate, mcopies);
			
			if (result.equals("true")){
				String str="Movie Added Sucessfully !!!";
				System.out.println(str);
				session.setAttribute("addmovmsg",str);
			}else{
				System.out.println("------------------result-------"+result);
				
				session.setAttribute("msg",result);
			}
			response.sendRedirect("addMovie.jsp");
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}

}
