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

import bean.allPersonbean;


/**
 * Servlet implementation class custDetails
 */
@WebServlet("/custDetails")
public class custDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	VideoLibraryManagementProxy proxy = new VideoLibraryManagementProxy();
	
    public custDetails() {
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
		
		System.out.println("Customer Details!!!");
        int i;
		
		try{
			
			HttpSession session=request.getSession();
			proxy.setEndpoint("http://localhost:8080/svlm/services/VideoLibraryManagement");
			
			String movid = request.getParameter("movid"); 
			String movname = proxy.movieName(movid);
			
			System.out.println("Movie selected for profile:" +movname);

			session.setAttribute("Moviename", movname);
			
			String input[];
			input=proxy.movieProfile(movid);
			
			allPersonbean a[] = new allPersonbean[input.length];
			
			for (i=0;i<input.length;i++){
				a[i]= new allPersonbean();
			}
			
                StringTokenizer ST;
			
			for(i=0;input[i]!=null;i++){
				ST = new StringTokenizer(input[i],"$");
				String b[]=new String[4];
				
				int j=0;
				
				while(ST.hasMoreTokens()){
					b[j]=ST.nextToken();
					System.out.println("Element is --->" + b[j]);
					j++;
				}
				
				a[i].setMemberid(b[0]);
				a[i].setFirstname(b[1]);
				a[i].setLastname(b[2]);
				a[i].setType(b[3]);
			}
			
			session.setAttribute("movprofileobj", a);
			response.sendRedirect("searchMovieProfile2.jsp");
			
		}catch (Exception e){
			e.printStackTrace();
		}		
	}

}
