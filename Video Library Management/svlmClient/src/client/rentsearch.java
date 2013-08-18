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
 * Servlet implementation class searchController
 */
@WebServlet("/rentsearch")
public class rentsearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VideoLibraryManagementProxy proxy=new VideoLibraryManagementProxy(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rentsearch() {
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
		
		HttpSession session=request.getSession(true);
		proxy.setEndpoint("http://localhost:8080/svlm/services/VideoLibraryManagement");
		String moviename=request.getParameter("moviename");
		String moviebanner=request.getParameter("moviebanner");;
		String category=request.getParameter("category");
		String reldate=request.getParameter("reldate");
		String[] inter=new String[10050];
		Movie[] movie=new Movie[10050];
		String[] res=proxy.searchMovie(moviename, moviebanner, category, reldate);
		StringTokenizer x;
		
		System.out.println("Content check first string----------->"+res[0]);
		for(int i=0;res[i]!=null;i++)
		{
			
			x=new StringTokenizer(res[i],"$");
			String temp[]=new String[7];
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
					movie[i].setCategory(temp[4]);	
					movie[i].setRelesedate(temp[3]);	
					movie[i].setCopiesno(temp[5]);

				
		System.out.println("In controller displayin Movie details-->");
		for(int i1=0;temp[i1]!=null;i1++)
		{
		System.out.println(temp[i1]);
	
		}
	}
		session.setAttribute("serializedObjects1", movie);
		String destination="rentmovies.jsp";
		response.sendRedirect(destination);
	}
}