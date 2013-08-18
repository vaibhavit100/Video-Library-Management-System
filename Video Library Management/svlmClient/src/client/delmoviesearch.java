package client;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.VideoLibraryManagementProxy;



import bean.Movie;

/**
 * Servlet implementation class delmoviesearch
 */
@WebServlet("/delmoviesearch")
public class delmoviesearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VideoLibraryManagementProxy proxy=new VideoLibraryManagementProxy(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delmoviesearch() {
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
		HttpSession session=request.getSession(true);
		proxy.setEndpoint("http://localhost:8080/svlm/services/VideoLibraryManagement");
		String moviename=request.getParameter("moviename");
		String moviebanner=request.getParameter("moviebanner");;
		String category=request.getParameter("category");
		String reldate=request.getParameter("reldate");
		String[] inter=new String[100];
		Movie[] movie=new Movie[100];
		String[] res=proxy.searchMovie(moviename, moviebanner, category, reldate);
		StringTokenizer x;
		
		//HttpSession session=request.getSessin(true);
		System.out.println("Content check first string----------->"+res[0]);
		for(int i=0;res[i]!=null;i++)
		{
			
			x=new StringTokenizer(res[i],"$");
			String temp[]=new String[6];
			movie[i]=new Movie();
			int j=0;
			while(x.hasMoreTokens())
			{
				temp[j]=x.nextToken();
				j++;
			}
				
					movie[i].setMovid(temp[0]);
					movie[i].setMovname(temp[1]);
					movie[i].setMovbanner(temp[2]);	
					movie[i].setCategory(temp[3]);	
					movie[i].setRelesedate(temp[4]);	
				

				
		System.out.println("In controller displayin Movie details-->");
		for(int i1=0;temp[i1]!=null;i1++)
		{
		System.out.println(temp[i1]);
	
		}
	}
		session.setAttribute("serializedObjects2", movie);
		String destination="deletemovies.jsp";
		response.sendRedirect(destination);
	}

	}

