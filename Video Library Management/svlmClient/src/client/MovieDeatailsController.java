package client;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Movie;

import services.VideoLibraryManagementProxy;

/**
 * Servlet implementation class MovieDeatailsController
 */
@WebServlet("/MovieDeatailsController")
public class MovieDeatailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieDeatailsController() {
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
		System.out.println("in MOVIE Details controller------------>");
		VideoLibraryManagementProxy a=new VideoLibraryManagementProxy();
		a.setEndpoint("http://localhost:8080/svlm/services/VideoLibraryManagement");
		String movieid1=request.getParameter("movieid1");
		String res=a.movieDetails(movieid1);
		String[] inter=new String[100];
		HttpSession session=request.getSession(true);
		StringTokenizer x;
		//HttpSession session=request.getSessin(true);
		System.out.println("Content check first string----------->"+res);
		
			Movie movie=new Movie();
			x=new StringTokenizer(res,"$");
			String temp;
			int j=1;
			while(x.hasMoreTokens())
			{
				
				
				temp=x.nextToken();
				switch(j)
				{
				case 1:
				{
					System.out.println("temp val in case--->"+temp);
					movie.setMovname(temp);
				}
				case 2:
				{
					movie.setMovbanner(temp);	
				}
				case 3:
				{
					movie.setCategory(temp);	
				}
				case 4:
				{
					movie.setRelesedate(temp);	
				}

				}
				System.out.println("temp values are .........."+temp);
				j++;
			}
		System.out.println("In movie details controller displayin Movie details-->");
		session.setAttribute("moviedetails", movie);
		response.sendRedirect("DisplayMovieDetails.jsp");
	}
	
	}


