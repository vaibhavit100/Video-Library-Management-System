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


import bean.sMemberbean;



/**
 * Servlet implementation class simpleMember
 */
@WebServlet("/simpleMember")
public class simpleMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	VideoLibraryManagementProxy proxy = new VideoLibraryManagementProxy();
    public simpleMember() {
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
		int i=0;
		try{
			HttpSession session=request.getSession();
			proxy.setEndpoint("http://localhost:8080/svlm/services/VideoLibraryManagement");
			
			String input[];
			input=proxy.sMembers();
			
			sMemberbean a[]=new sMemberbean[input.length];
			
			for (i=0;i<input.length;i++){
				a[i]= new sMemberbean();
			}
			
			StringTokenizer ST;
			
			for(i=0;input[i]!=null;i++){
				ST = new StringTokenizer(input[i],"$");
				String b[]=new String[9];
				
				int j=0;
				
				while(ST.hasMoreTokens()){
					b[j]=ST.nextToken();
					System.out.println("Element is --->" + b[j]);
					j++;
				}
				a[i].setPersonid(b[0]);
				a[i].setFirstname(b[1]);
				a[i].setLastname(b[2]);
				a[i].setAddress(b[3]);
				a[i].setCity(b[4]);
				a[i].setState(b[5]);
				a[i].setZipcode(b[6]);
				a[i].setMemberid(b[7]);
				a[i].setCountry(b[8]);
				
			}
			session.setAttribute("sMemberobj", a);
			response.sendRedirect("simplemembers.jsp");
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}

}
