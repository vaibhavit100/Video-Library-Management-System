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
 * Servlet implementation class searchController
 */
@WebServlet("/searchController")
public class searchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchController() {
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
		
		System.out.println("in search controller------------>");
		HttpSession session=request.getSession(true);
		VideoLibraryManagementProxy a=new VideoLibraryManagementProxy();
		a.setEndpoint("http://localhost:8080/svlm/services/VideoLibraryManagement");
		String moviename=request.getParameter("moviename");
		String moviebanner=request.getParameter("moviebanner");;
		String category=request.getParameter("category");
		String reldate=request.getParameter("reldate");
		String[] inter=new String[100050];
		Movie[] movie=new Movie[100050];
		System.out.println(""+moviename);
		System.out.println(""+moviebanner);
		System.out.println(""+category);
		System.out.println(""+reldate);
		String[] res=a.searchMovie(moviename, moviebanner, category, reldate);
		StringTokenizer x;
		
		//HttpSession session=request.getSessin(true);
		System.out.println("Content check first string----------->"+res[0]);
		for(int i=0;res[i]!=null;i++)
		{
			
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
		session.setAttribute("serializedObjects", movie);
		String destination="displayMovies.jsp";
		response.sendRedirect(destination);
	}
}
