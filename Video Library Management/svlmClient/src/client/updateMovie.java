package client;
import java.util.StringTokenizer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.VideoLibraryManagementProxy;

import bean.moviesbean;


/**
 * Servlet implementation class updateMovie
 */
@WebServlet("/updateMovie")
public class updateMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	VideoLibraryManagementProxy proxy = new VideoLibraryManagementProxy();
    public updateMovie() {
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
	
		int i;
		
		
		
		System.out.println("Update Movie !!!");

		try{
			
			HttpSession session=request.getSession();
			proxy.setEndpoint("http://localhost:8080/svlm/services/VideoLibraryManagement");
			String movname = request.getParameter("movname"); 
			System.out.println("Movie selected for update:" +movname);
			
			String input[];
			input=proxy.searchMovie(movname,null,null,null);
			
			
			moviesbean a[] = new moviesbean[input.length];
			
			
			for (i=0;i<input.length;i++){
				a[i]= new moviesbean();
			}
			
                StringTokenizer ST;
			
			for(i=0;input[i]!=null;i++){
				ST = new StringTokenizer(input[i],"$");
				String b[]=new String[6];
				
				int j=0;
				
				while(ST.hasMoreTokens()){
					b[j]=ST.nextToken();
					System.out.println("Element is --->" + b[j]);
					j++;
				}
				a[i].setmovid(b[0]);
				a[i].setmovname(b[1]);
				a[i].setmovbanner(b[2]);
				a[i].setreleasedate(b[3]);
				a[i].setcategory(b[4]);
				a[i].setnoofcopies(b[5]);
		
			}
			
			session.setAttribute("movieobj", a);
			response.sendRedirect("updateSearchResult2.jsp");
			
		}catch (Exception e){
			e.printStackTrace();
		}		
	}

}
