package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
 * Servlet implementation class creditcard
 */
@WebServlet("/creditcard")
public class creditcard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VideoLibraryManagementProxy proxy = new VideoLibraryManagementProxy();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public creditcard() {
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
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		HttpSession session=request.getSession(true);
		String cardnum=request.getParameter("user");
		String cvv=request.getParameter("cvv");
		if(cardnum!=null && cvv!=null)
		{
		Pattern p = Pattern.compile("[^0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(cardnum);
		boolean b = m.find();
		
		Pattern p1 = Pattern.compile("[^0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m1 = p1.matcher(cvv);
		boolean b1 = m1.find();

		if ((b||b1) || (cardnum.length()!=16||cvv.length()!=3))
		{
			if(b|| (cardnum.length()!=16))
			session.setAttribute("carde", "enter correct card number");
			if(b1||(cvv.length()!=3))
				session.setAttribute("cvve", "enter correct cvv number");
		   response.sendRedirect("creditcard.jsp");
		   
		}
		else 
		{
			proxy.setEndpoint("http://localhost:8080/svlm/services/VideoLibraryManagement");
			String morder[]=new String[10];
			String qdone;
			int k=0;
			int cost=0;
			moviecart a=(moviecart)session.getAttribute("mcart");
			List<moviecart> a1=a.getItems();
			for(int i=0;i<a1.size();i++)
			{
				moviecart a2=new moviecart();
				a2=a1.get(i);
				morder[i]=a2.getMovid()+"#"+a2.getCopiesno();
				System.out.println("################"+a2.getCopiesno());
				cost=cost+Integer.parseInt(a2.getCopiesno())*5;
			}
			Calendar currentDate = Calendar.getInstance();
			  SimpleDateFormat formatter= 
			  new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 String dateNow = formatter.format(currentDate.getTime());
			// Date todaysDate = (Date) new java.util.Date();
			// String dateNow = formatter.format(todaysDate);
Person person=(Person) session.getAttribute("per1");
		String memid=person.getMemberid();
			qdone=proxy.simpletableupdation(cardnum,cvv,memid, morder, dateNow);
			if(qdone.equals("false"))
				response.sendRedirect("payment.jsp");
			else
			{
				a.getItems().clear();
				session.setAttribute("transid", qdone);
				session.setAttribute("totalcost", "ur credit card is charged "+cost);
				response.sendRedirect("success.jsp");
			}
		}
		}

		

	}

}