package client;
import java.sql.*;
import java.util.StringTokenizer;

public class MovieCon {
	static Connection con; 
	static String url; 
	static String URL ="jdbc:mysql://localhost:3306/svlm";
	static String username= "root" ;
	static String password = "soumya";
	public static Connection getConnection() 
	{ 
		
		try
		{
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con=DriverManager.getConnection(URL,username,password);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	//	log.info("Exit from getConnection in DataBaseConnection");
		
		return con;
	}
	
	
	
	
	public String createMovies(String moviename, String moviebanner, String Category, String reldate, int mcopies)
	{
		Connection conn = getConnection();
		System.out.println("------------>"+moviename);
		System.out.println("------------>"+moviebanner);
		System.out.println("------------>"+Category);
		System.out.println("------------>"+reldate);
		System.out.println("------------>"+mcopies);
		
		
		String result="";
		int rowcount;
		try
		
		{
			
			 PreparedStatement stmt=conn.prepareStatement("INSERT INTO movies(movname,movbanner,relesedate,category,copiesno) VALUES(?,?,?,?,?)");
			 stmt.setString(1,moviename);
			 stmt.setString(2,moviebanner);
			 stmt.setString(3,reldate);
			 stmt.setString(4,Category);
			 stmt.setInt(5,mcopies);
			rowcount=stmt.executeUpdate();
		
			if(rowcount>0)
			{
				result="true";
				System.out.println("Data inserted successfully");
			}
			else
			{
				result="false:Data can be inserted into database";
			}
		}
		catch(Exception e)
		{

			
			e.getStackTrace();
		}
		return result;
		
	}
	public String returnmovofmember(String memberid)
	{
		String tid[];
		tid=new String[10000];
		String mn[];
		mn=new String[10000];
		int i=0;
		String result="";
		try
		{System.out.println("start");
			Connection conn = getConnection();
			String a="pending";String b="rented";
			PreparedStatement stmt= conn.prepareStatement("SELECT tranid FROM transactions WHERE memberid=? && transtatus=?");
			
			stmt.setString(1,memberid);
			stmt.setString(2,a);
			java.sql.ResultSet rs =  stmt.executeQuery();
			
			while(rs.next())
			{System.out.println("the transaction iddddddddddddddddddd");
				
				tid[i]=rs.getString(1);
				System.out.println("--------------------->>>"+tid[i]);
				i++;
				}
			int j=0;
			while(tid[j]!=null)
			{
				PreparedStatement stmt1= conn.prepareStatement("SELECT movid FROM `transactiondetails` WHERE `tranid`=? && status=?");
				stmt1.setString(1,tid[j]);
				stmt1.setString(2,b);
				String m="";
				java.sql.ResultSet rs1 =  stmt1.executeQuery();
				int k=0;
				mn[j]=tid[j]+"#";
				while(rs1.next())
				{
					System.out.println("the movie iddddddddddddddddddd");
					
					m=rs1.getString(1);
					mn[j]+=m+"&";
					PreparedStatement stmt3= conn.prepareStatement("SELECT quantity FROM `transactiondetails` WHERE `movid`=? && `tranid`=?");
					stmt3.setString(1,m);
					stmt3.setString(2,tid[j]);
					java.sql.ResultSet rs3 =  stmt3.executeQuery();
					while(rs3.next())
					{
	mn[j]+=rs3.getString(1)+"*";
					}
					PreparedStatement stmt2= conn.prepareStatement("SELECT movname FROM `movies` WHERE `movid`=? ");
					stmt2.setString(1,m);
					java.sql.ResultSet rs2 =  stmt2.executeQuery();
					while(rs2.next())
					{
	mn[j]+=rs2.getString(1)+"$";
					}
				}
				System.out.println("--------------------->>>"+mn[j]);
				j++;
			}
			int o=0;
			while(mn[o]!=null)
			{
			result+=mn[o]+",";
			o++;
			System.out.println("---------------------------");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	public String[] pMembers()
	{
		String result[];
		result=new String[10000];
		int i=0;
		
		try
		{
			Connection conn = getConnection();
			String a="premium";
			PreparedStatement stmt= conn.prepareStatement("SELECT personid,firstname,lastname,address,city,state,zipcode,memberid FROM `person` WHERE `type`='"+a+"'");
			
			
			java.sql.ResultSet rs =  stmt.executeQuery();
			
			while(rs.next())
			{System.out.println("the product iddddddddddddddddddd"+rs.getString(1));
				
				result[i]=rs.getString(1)+"   "+rs.getString(2)+"   "+rs.getString(3)+"   "+rs.getString(4)+"   "+rs.getString(5)+"   "+rs.getString(6)+"   "+rs.getString(7)+"   "+rs.getString(8);
				System.out.println("--------------------->>>"+result[i]);
				i++;
				}
				
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	
	}
	 String returnMovie (String memberid, String movieid, String moviename,String count,String dat, String tid)
	 {
		 String result=null;
		 
		 StringTokenizer v,y,z,o,p2;
		 o=new StringTokenizer(dat,"$");
			String date=null;
			while(o.hasMoreTokens())
			{
				date=o.nextToken();
				System.out.println("var is.........."+date);
				String time=o.nextToken();
				System.out.println("var is.........."+time);
			}
				
				z=new StringTokenizer(tid,"$");
				 int b[]=new int[10];
				int j=0;
				
				while(z.hasMoreTokens())
				{
					b[j]=Integer.parseInt(z.nextToken());
					System.out.println("var is.........."+b[j]);
					j++;
				}
				y=new StringTokenizer(moviename,"$");
				String a[]=new String[10];
				int k=0;
				while(y.hasMoreTokens())
				{
					a[k]=y.nextToken();
					System.out.println("var is.........."+a[k]);
					k++;
				}
				v=new StringTokenizer(count,"#");
				int c[]=new int[10];
				int u=0;
				while(v.hasMoreTokens())
				{
					c[u]=Integer.parseInt(v.nextToken());
					System.out.println("var is.........."+c[u]);
					u++;
				}
				p2=new StringTokenizer(movieid,"$");
				int d1[]=new int[10];
				int h=0;
				while(p2.hasMoreTokens())
				{
					d1[h]=Integer.parseInt(p2.nextToken());
					System.out.println("var is.........."+d1[h]);
					h++;
				}
			
		 for(int g=0;g<10;g++)
		 {
		 try
			{  
			 if(c[g]!=0 && a[g]!=null && b[g]!=0)
			 
			{
			    int q=c[g];String m=null;
				Connection conn = getConnection();
				PreparedStatement stmt= conn.prepareStatement("SELECT type FROM `person` WHERE `memberid`=?");
				String x="premium";
				stmt.setString(1,memberid);
				java.sql.ResultSet rs =  stmt.executeQuery();
				while(rs.next())
				{m=rs.getString(1);}
					if(m==x)
					{int p=0;
					PreparedStatement stmt2= conn.prepareStatement("SELECT moviesno FROM premium_member WHERE pmemberid=?");
					stmt2.setString(1,memberid);
					java.sql.ResultSet rs2 =  stmt2.executeQuery();
					while(rs2.next())
					{
						p=rs2.getInt(1);
						System.out.println(p);
					}
						
					
					PreparedStatement stmt1= conn.prepareStatement("UPDATE premium_member SET moviesno=? WHERE pmemberid=?");
						stmt1.setInt(1,(p-q));
						stmt1.setString(2,memberid);
						int rs1 =  stmt1.executeUpdate();
											
						System.out.println("premium table updated successfully");
					}
					else
					{
						int p=0;
						PreparedStatement stmt4= conn.prepareStatement("SELECT moviesno FROM simple_member WHERE smemberid=?");
						stmt4.setString(1,memberid);
						java.sql.ResultSet rs4 =  stmt4.executeQuery();
						while(rs4.next())
						{
							p=rs4.getInt(1);
							System.out.println("simple movie count"+p);
						}
						System.out.println("the count issssssssssss"+q);
						int p1=p-q;
						System.out.println("the new count"+p1);
							
						PreparedStatement stmt3= conn.prepareStatement("UPDATE simple_member SET moviesno=? WHERE smemberid=?");
							stmt3.setInt(1,p1);
							stmt3.setString(2,memberid);
							int rs3 =  stmt3.executeUpdate();
							
							System.out.println("simple table updated successfully");
					}
				
				PreparedStatement stmt5= conn.prepareStatement("SELECT date FROM transactions WHERE memberid=? && tranid=?");
				stmt5.setString(1,memberid);
				stmt5.setInt(2,b[g]);
				java.sql.ResultSet rs5 =  stmt5.executeQuery();
				String d=null;Long l=null;
				while(rs5.next())
				{
					 d=rs5.getString(1);
					 System.out.println("the issue date is ................."+d);
				}
					PreparedStatement stmt6= conn.prepareStatement("SELECT DATEDIFF(?,?)");
					stmt6.setString(1,date);
					stmt6.setString(2,d);
					java.sql.ResultSet rs6 =  stmt6.executeQuery();
					while(rs6.next())
					{
						 l=rs6.getLong(1);
						 System.out.println("date diff is---------------->"+l);
					}
				
				PreparedStatement stmt7= conn.prepareStatement("SELECT amount FROM payment WHERE paydate=?");
				stmt7.setString(1,d);
				java.sql.ResultSet rs7 = stmt7.executeQuery();	
				String am=null;
				while(rs7.next())
				{
					am=rs7.getString(1);
					System.out.println("amount is ------------------------->"+am);
				}
				PreparedStatement stmt8= conn.prepareStatement("UPDATE simple_member SET balancedue=? WHERE smemberid=?");
				Long ma=(long)((1.5)*l);
				Long x1=Long.parseLong(am);
				stmt8.setLong(1,(x1-ma));
				stmt8.setString(2,memberid);
				int rs8 =  stmt8.executeUpdate();
				System.out.println("balance updatedddddddd"+(x1-ma));
				String mn=a[g];int mid=0;
				PreparedStatement stmt11= conn.prepareStatement("SELECT movid FROM movies  WHERE movname=?");
				stmt11.setString(1,mn);
				java.sql.ResultSet rs11 =  stmt11.executeQuery();
				while(rs11.next())
				{
					 mid=rs11.getInt(1);
					 System.out.println("movie ID----------------------------"+mid);
				}
				PreparedStatement stmt10= conn.prepareStatement("SELECT quantity FROM transactiondetails  WHERE movid=? && tranid=?");
				stmt10.setInt(1,mid);
				stmt10.setInt(2,b[g]);
				int qq=0;String k1="returned";String k2="rented";
				java.sql.ResultSet rs10 = stmt10.executeQuery();
				while(rs10.next())
				{
					 qq=rs10.getInt(1);
					 System.out.println("the qqqqqqqqqqq"+qq);
				}
				PreparedStatement stmt9= conn.prepareStatement("UPDATE transactiondetails SET quantity=(quantity-?),status=?  WHERE movid=? && tranid=?");
				stmt9.setInt(1,(q));
				if((q-qq)==0)
				stmt9.setString(2,k1);
				else
				stmt9.setString(2,k2);	
				stmt9.setInt(3,mid);
				stmt9.setInt(4,b[g]);
				int rs9 =  stmt9.executeUpdate();int q1=0;
				String k3="completed";String k4="pending";
				System.out.println("transactiondetails updated successfullyyyyyyyyyyy");
				
				PreparedStatement stmt15= conn.prepareStatement("SELECT quantity FROM transactiondetails  WHERE tranid=?");
				
				stmt15.setInt(1,b[g]);
				
				java.sql.ResultSet rs15 = stmt15.executeQuery();
				while(rs15.next())
				{
					 q1+=rs15.getInt(1);
					 
				}
				PreparedStatement stmt13= conn.prepareStatement("UPDATE transactions SET transtatus=?  WHERE  tranid=?");
				if((q1)==0)
				stmt13.setString(1,k3);
				else
				stmt13.setString(1,k4);	
				stmt13.setInt(2,b[g]);
				int rs13=  stmt13.executeUpdate();
				System.out.println("transactions updated successfullyyyyyyyyyyy");
				PreparedStatement stmt14= conn.prepareStatement("UPDATE movies SET noofcopies=(noofcopies+?)  WHERE  movid=?");
				
				stmt14.setInt(1,q);
				
				stmt14.setInt(2,d1[g]);	
				
				int rs14=  stmt14.executeUpdate();
				System.out.println("movies updated successfullyyyyyyyyyyy");
				PreparedStatement stmt12=conn.prepareStatement("INSERT INTO audit(memberid,tranid,movid,quantity,date,status,paidamount) VALUES(?,?,?,?,?,?,?)");
				 stmt12.setString(1,memberid);
				 stmt12.setInt(2,b[g]);
				 stmt12.setInt(3,mid);
				 stmt12.setInt(4,q);
				 stmt12.setString(5,dat);
				 if((qq-q)==0)
				 stmt12.setString(6,k1);
				 else
				 stmt12.setString(6,k2);	 
				 stmt12.setLong(7,ma);
				int rowcount1=stmt12.executeUpdate();
				if(rowcount1>0)
				{
					result="true";
					System.out.println("Data inserted successfully");
				}
				else
				{
					result="false:Data can be inserted into database";
				}
			
				}
				
			else
			{
				
			}
			}
		 catch(Exception e)
			{
				e.printStackTrace();
			}
		 }
		 
	 return result;
	 }

}	


