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
 * Servlet implementation class updateMovie2
 */
@WebServlet("/updateMovie2")
public class updateMovie2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	VideoLibraryManagementProxy proxy = new VideoLibraryManagementProxy();
    public updateMovie2() {
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
		try{
			String movid=request.getParameter("movid");
			String movname=request.getParameter("movname");
			String movbanner= request.getParameter("movbanner");
			String category = request.getParameter("category");
			String releasedate=request.getParameter("releasedate");
			String noofcopies= request.getParameter("noofcopies");
			
			System.out.println("Update Selected 2 : "+movname+":" + movbanner + ":"+category+":"+noofcopies+":"+releasedate);
			proxy.setEndpoint("http://localhost:8080/svlm/services/VideoLibraryManagement");
			String result=proxy.updateMinfo(movid, movname, movbanner, category,releasedate,noofcopies);
			
			System.out.println("Update result:"+result);
			
			if (result.equals("true")){
				String str="Movie Updated Sucessfully !!!";
				System.out.println(str);
				session.setAttribute("updatemovmsg",str);
			}else{
				session.setAttribute("updatemovmsg","Error !!! Please try again...");
			}
			
			response.sendRedirect("updateMovie.jsp");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
