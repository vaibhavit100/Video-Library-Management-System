package client;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.VideoLibraryManagementProxy;

import bean.Person;
import bean.moviecart;



/**
 * Servlet implementation class rent
 */
@WebServlet("/rent")
public class rent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VideoLibraryManagementProxy proxy = new VideoLibraryManagementProxy();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rent() {
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
		String morder[]=new String[10];
		String qdone[];
		int k=0;
		moviecart a=(moviecart)session.getAttribute("mcart");
		List<moviecart> a1=a.getItems();
		for(int i=0;i<a1.size();i++)
		{
			moviecart a2=new moviecart();
			a2=a1.get(i);
			morder[i]=a2.getMovid()+"#"+a2.getCopiesno();
		}
		Calendar currentDate = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String curdate=dateFormat.format(currentDate.getTime());

Person person=(Person) session.getAttribute("per1");
		String memid=person.getMemberid();
		String type=person.getType();
		qdone=proxy.rentMovie(memid, morder,curdate );
		if(qdone[19]!=null&&!qdone[19].equals(""))
		{
			session.setAttribute("prob", qdone[19]);
			System.out.println("-----------------------"+qdone[19]);
			//response.sendRedirect("moviecart.jsp");
			k=1;
		}
		else if(qdone[18]!=null&&!qdone[18].equals(""))
		{
			session.setAttribute("prob",qdone[18]);
			response.sendRedirect("memexpired.jsp");
		}
		else
		{
			for(int j=0;qdone[j]!=null;j++)
			{
				System.out.println("entered hereeee-----------------");
				if(qdone[j].indexOf("cant")>=0)
				{
					session.setAttribute("prob",qdone[j]);
					k=1;
					System.out.println("entered here");
					break;
				}
				else
				{
					k=0;	
				}
			}
				
		}
	
		
		if(k==1)
		response.sendRedirect("moviecart.jsp");
		else if(k==0 && type.equals("simple"))
		{	//a.getItems().clear();
		response.sendRedirect("payment.jsp");
		}
		else if(k==0 && type.equals("premium"))
		{
			String qdone1="";
			Calendar currentDate1= Calendar.getInstance();
			  SimpleDateFormat formatter= 
			  new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			  String dateNow = formatter.format(currentDate1.getTime());

			qdone1=proxy.premiumtableupdation(memid, morder, dateNow);
			if(qdone1.equals("false"))
				response.sendRedirect("moviecart.jsp");
			else
			{
				a.getItems().clear();
				session.setAttribute("transid", qdone1);
				session.setAttribute("totalcost", "");
				response.sendRedirect("success.jsp");
			}
		}
	}

}