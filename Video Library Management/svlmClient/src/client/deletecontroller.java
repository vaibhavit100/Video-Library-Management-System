package client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.VideoLibraryManagementProxy;
/**
 * Servlet implementation class deletecontroller
 */
@WebServlet("/deletecontroller")
public class deletecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VideoLibraryManagementProxy proxy=new VideoLibraryManagementProxy();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletecontroller() {
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
		System.out.println("entered hereeeeeeeeeeeeeeeeeeeeeeeeeeee");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String qdone;
		try
		{
			
			HttpSession session=request.getSession(true);
			proxy.setEndpoint("http://localhost:8080/svlm/services/VideoLibraryManagement");
			String movid=request.getParameter("delid");
			System.out.println("---------------------------->"+movid);
			qdone=proxy.delMovies(movid);
			if(qdone.equals("deleted"))
				response.sendRedirect("deletesuccess.jsp");
			else
				response.sendRedirect("deletemovies.jsp");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
