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
 * Servlet implementation class MovieController
 */
@WebServlet("/MovieController")
public class MovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieController() {
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
		System.out.println("in MOVIE controller------------>");
		VideoLibraryManagementProxy a=new VideoLibraryManagementProxy();
		a.setEndpoint("http://localhost:8080/svlm/services/VideoLibraryManagement");
		String memberid=request.getParameter("memid");
		System.out.println("MEMBER ID ISS--->"+memberid);
		String count=a.movieCount(memberid);
		HttpSession session=request.getSession(true);
		session.setAttribute("moviecount", count);
		response.sendRedirect("displayMovieCount.jsp");
		System.out.println("In Controller displaying movie count---------->"+count);
	}

}
