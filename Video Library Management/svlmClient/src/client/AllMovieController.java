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
 * Servlet implementation class AllMovieController
 */
@WebServlet("/AllMovieController")
public class AllMovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllMovieController() {
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
		// TODO Auto-generated  stub
		System.out.println("in  Get all MOVIE  controller------------>");
		VideoLibraryManagementProxy a=new VideoLibraryManagementProxy();
		a.setEndpoint("http://localhost:8080/svlm/services/VideoLibraryManagement");
		String movieid1=request.getParameter("movieid1");
		HttpSession session=request.getSession();
		String[] inter=new String[100050];
		Movie[] movie=new Movie[100050];
		String[] res=a.allMovies();
	StringTokenizer x;
		
		//HttpSession session=request.getSessin(true);
		System.out.println("Content check first string----------->"+res[0]);
		for(int i=0;res[i]!=null;i++)
		{
			System.out.println("New movie--------------->");
			x=new StringTokenizer(res[i],"$");
			String temp[]=new String[10];
			movie[i]=new Movie();
			int j=1;
			while(x.hasMoreTokens())
			{
				temp[j]=x.nextToken();
			switch(j)
				{
				case 1:                                                
				{                                                      
					          System.out.println("id :"+temp[j]);
					movie[i].setMovid(temp[j]);    
					break;
				}                                                      
				
				
				
				case 2:
			
				{
					System.out.println("name :"+temp[j]);
					movie[i].setMovname(temp[j]);break;
				}
				case 3:
				{              System.out.println("banner:"+temp[j]);
					movie[i].setMovbanner(temp[j]);	break;
				}
				case 4:
				{                     System.out.println("category :"+temp[j]);
					movie[i].setCategory(temp[j]);	break;
				}
				case 5:
				{     System.out.println("rel date:"+temp[j]);
					movie[i].setRelesedate(temp[j]);	break;
				}
				case 6:
				{System.out.println("no of copies"+temp[j]);
					movie[i].setNoofcopies(temp[j]);	break;
				}
			     case 7:  
			    	 
				{         System.out.println("rent amt :"+temp[j]); 
					movie[i].setRentamount(temp[j]);
				 	break;
				 }  
				}
				
			System.out.println("temp values are .........."+temp[j]);
				j++;
			}
		System.out.println("In controller displayin Movie details-->");
		for(int i1=0;temp[i1]!=null;i1++)
		{
		System.out.println(temp[i1]);
	
		}
	}
		session.setAttribute("allMovies", movie);
		String destination="DisplayAllMovies.jsp";
		response.sendRedirect(destination);
	}
	}


