package services;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DatabaseConnection {

	private static final String Null = null;
	//Connection con= null;
	static ResultSet rs,rs1,rs2,rs3,rs4,rs5,rs6,rs7,rs8,rs9,rs10,rs11,rs12,rs13;
	//private ConnectionPooling pooling ;
	Connection con = null;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/svlm1"; 
	//static ResultSet rs2;

	//Statement stmt;
	PreparedStatement stmt1=null,stmt2=null,stmt3=null,stmt4=null,stmt5=null,stmt6=null,stmt7=null,stmt8=null,stmt9=null,stmt10=null;
	
	PreparedStatement pstmt,pstmt1,pstmt2,pstmt3,pstmt4,pstmt5,pstmt6,pstmt7,pstmt8,pstmt9,pstmt10,pstmt11,pstmt12,pstmt13;
	
	DatabaseConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/svlm1","root","admin");

			 //pooling = new ConnectionPooling("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/svlm1", "root", "admin",100);

			//this.pooling = new ConnectionPooling("com.mysql.jdbc.Driver""jdbc:mysql://localhost:3306/svlm1","root","root",3);
			//con = pooling.getConnection();
			//this.con.setAutoCommit(false);
			//stmt=con.createStatement();
			if(!con.isClosed())
			{
				System.out.println("Successfully Connected");
			}
		}
		 
		catch(SQLException e)
		{
			
			e.printStackTrace();
		}
		
	/*	catch(InstantiationException e)
		{
			
			e.printStackTrace();

		}
		
		
		catch(IllegalAccessException e)
		{
			
			e.printStackTrace();

		}
		*/
		catch(ClassNotFoundException e)
		{
			
			e.printStackTrace();

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public String movieName(String movid)
	{
		String result=null;
		int mid= Integer.parseInt(movid);
		try {
			
			String query="SELECT movname FROM movies WHERE movid=?";

			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, mid);
			rs =  pstmt.executeQuery();
			
			while(rs.next())
			{			
			result=rs.getString(1);
			}
		//	//////if(con!=null)
			//	//pooling.returnConnection(con);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public String personDetail(String memberid)
	{
		int id;
		String personid,result="";
		//String fname,lastname,type,address,city,state,zipcode,country,moviename;
		int rowcount=0;
		//String person[]=new String[100];
		
			
		String  person="$";

			try
			{
			
			String query_per_memid="Select personid,firstname,lastname,type,address,city,state,zipcode,country from person WHERE memberid=? ";
			pstmt=con.prepareStatement(query_per_memid);
			pstmt.setString(1,memberid);
			
			rs = pstmt.executeQuery();


				while(rs.next())
				{
				//fname=rs.getString("firstname");
				//person=person + fname + "$";
				person=rs.getString(1)+"$"+rs.getString(2)+"$"+rs.getString(3)+"$"+rs.getString(4)+"$"+rs.getString(5)+"$"+rs.getString(6)+"$"+rs.getString(7)+"$"+rs.getString(8)+"$"+rs.getString(9);

				rowcount++;

				}
				
				if (rowcount>0)
				{
					result=person;
				}
				else
					result="false";
				//////if(con!=null)
					//pooling.returnConnection(con);
			}

	
			
		catch(SQLException e)
		{
			
			e.printStackTrace();

		}
	
		return result ;

	
	}
	public String movieIssue(String memberid)
	{
		int id;
		String personid,result="";
		String firstname,lastname,type,address,city,state,zipcode,country,moviename;
		int rowcount=0;
		//String person[]=new String[100];
		
			
		String  mov="$";

			try
			{
			
			String query_per_memid="Select m.movname from movies m,transactiondetails td,transaction t WHERE t.memberid=? AND td.tranid = t.tranid AND td.status='rented' AND m.movid=td.movid ";
			pstmt=con.prepareStatement(query_per_memid);
			pstmt.setString(1,memberid);
			
			rs = pstmt.executeQuery();


				while(rs.next())
				{
				moviename=rs.getString("movname");
				mov=mov + moviename + "$";
				rowcount++;

				}
				
				if (rowcount>0)
				{
					result=mov;
				}
				else
					result="false";
				//////if(con!=null)
					//pooling.returnConnection(con);
			}
			

	
			
		catch(SQLException e)
		{
			
			e.printStackTrace();

		}
		
		
return result ;


		
	}
	
	
	
	
	public String[] movieProfile(String movid)
	{
		int id=Integer.parseInt(movid);
		
		String  person_issue[] = null;

			try
			{
			String query="select t.memberid, p.firstname, p.lastname, p.type from transaction t,transactiondetails td, person p where t.tranid = td.tranid and t.memberid = p.memberid and td.movid=?;";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();

			person_issue=new String[100];
			
			System.out.println(rs.getMetaData().getColumnCount());
				
			    int i=0;
				while(rs.next())
				{	
				  person_issue[i]=rs.getString(1)+"$"+rs.getString(2)+"$"+rs.getString(3)+"$"+rs.getString(4);
				  i++;
				}
				//////if(con!=null)
					//pooling.returnConnection(con);
			}

	
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return person_issue ;
	}
	
	public String signIn(String username,String password)
	{

		
		String result="";
		int rowcount=0;
		try
		{
			String query="Select l.logintime,l.username,p.firstname,p.lastname,p.type,p.address,p.city,p.state,p.zipcode,p.country,p.memberid from login l,person p where username=? AND password=?  AND p.personid=l.personid ";


			String str="$";
			int db_personid=0;
			String db_logintime,db_firstname,db_address,db_city,db_state,db_zipcode,db_country,db_memberid,db_type;
		
			String db_uname="";
			
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
				
			while(rs.next())
			{
				db_logintime=rs.getString("logintime");
				str= str + db_logintime + "$";
				
				db_uname=rs.getString("username");
				str= str + db_uname + "$";
				
				db_firstname=rs.getString("firstname");
				str= str + db_firstname + "$";
				
				db_firstname=rs.getString("lastname");
				str= str + db_firstname + "$";
				db_type=rs.getString("type");
				str= str + db_type + "$";
				db_address=rs.getString("address");
				str= str + db_address + "$";
			
				db_city=rs.getString("city");
				str= str + db_city + "$";
				
				db_state=rs.getString("state");
				str= str + db_state + "$";
				
				db_zipcode=rs.getString("zipcode");
				str= str + db_zipcode + "$";
				
				db_memberid=rs.getString("memberid");
				str= str + db_memberid + "$";
				
				db_country=rs.getString("country");
				str= str + db_country + "$";
				
				//System.out.println(db_country);

				
				rowcount++;
			}
			

			
				if (rowcount==0)
				{
				result="false:Validation failed";
				}
		
				else
				{
					result=str;
					
				}
				//////if(con!=null)
					//pooling.returnConnection(con);
				}
					
					
				/*
					String query_fname="Select firstname from person where personid=? ";
					pstmt=con.prepareStatement(query_fname);
					pstmt.setInt(1, db_personid);
					rs = pstmt.executeQuery();
					String fname="";
					while(rs.next())
					{
						fname=rs.getString("firstname");
					}	
					
					
					result=fname;

				}	
					
					/*
					String query_type="Select type from person where personid=? ";
					pstmt=con.prepareStatement(query_type);
					pstmt.setInt(1, personid);
					rs = pstmt.executeQuery();
					String memtype="";
					while(rs.next())
					{
						memtype=rs.getString("type");
					}	
					
				
					if (memtype.equalsIgnoreCase("premium"))
					{
						result ="premium";
						
					}
					
					else
					{
						result ="premium";
					}
				*/
				
				
		
		
	
		
		catch(SQLException e)
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
			{  String d=null;Long l=null;Long ma=null;
			 if(c[g]!=0 && a[g]!=null && b[g]!=0)
			 
			{
			    int q=c[g];String m=null;
				//Connection conn = getConnection();
				PreparedStatement stmt= con.prepareStatement("SELECT type FROM `person` WHERE `memberid`=?");
				
				String x="premium";
				stmt.setString(1,memberid);
				java.sql.ResultSet rs =  stmt.executeQuery();
				System.out.println("------1");
				while(rs.next())
				{m=rs.getString(1);System.out.println("the typeeeeeeeeee"+m);}
					if(m.equalsIgnoreCase(x))
					{int p=0;
					System.out.println("................................................entered premium");
					PreparedStatement stmt2= con.prepareStatement("SELECT moviesno FROM premiummember WHERE pmemberid=?");
					stmt2.setString(1,memberid);
					java.sql.ResultSet rs2 =  stmt2.executeQuery();
					System.out.println("------2");
					while(rs2.next())
					{
						p=rs2.getInt(1);
						System.out.println(p);
					}
						
					
					PreparedStatement stmt1= con.prepareStatement("UPDATE premiummember SET moviesno=? WHERE pmemberid=?");
						stmt1.setInt(1,(p-q));
						stmt1.setString(2,memberid);
						int rs1 =  stmt1.executeUpdate();
											
						System.out.println("premium table updated successfully");
					}
					else
					{
						int p=0;
						PreparedStatement stmt4= con.prepareStatement("SELECT moviesno FROM simplemember WHERE smemberid=?");
						stmt4.setString(1,memberid);
						java.sql.ResultSet rs4 =  stmt4.executeQuery();
						System.out.println("------3");
						while(rs4.next())
						{
							p=rs4.getInt(1);
							System.out.println("simple movie count"+p);
						}
						System.out.println("the count issssssssssss"+q);
						int p1=p-q;
						System.out.println("the new count"+p1);
							
						PreparedStatement stmt3= con.prepareStatement("UPDATE simplemember SET moviesno=? WHERE smemberid=?");
							stmt3.setInt(1,p1);
							stmt3.setString(2,memberid);
							int rs3 =  stmt3.executeUpdate();
							System.out.println("------4");
							System.out.println("simple table updated successfully");
							String am=null;
							PreparedStatement stmt5= con.prepareStatement("SELECT date FROM transaction WHERE memberid=? && tranid=?");
							stmt5.setString(1,memberid);
							stmt5.setInt(2,b[g]);
							java.sql.ResultSet rs5 =  stmt5.executeQuery();
							System.out.println("------5");
							
							while(rs5.next())
							{
								 d=rs5.getString(1);
								 System.out.println("the issue date is ................."+d);
							}
							PreparedStatement stmt6= con.prepareStatement("SELECT DATEDIFF(?,?)");
							stmt6.setString(1,date);
							stmt6.setString(2,d);
							java.sql.ResultSet rs6 =  stmt6.executeQuery();
							System.out.println("------6");
							while(rs6.next())
							{
								 l=rs6.getLong(1);
								 System.out.println("date diff is---------------->"+l);
							}
							
							PreparedStatement stmt7= con.prepareStatement("SELECT amount FROM payment WHERE paydate=?");
							stmt7.setString(1,d);
							java.sql.ResultSet rs7 = stmt7.executeQuery();
							System.out.println("------7");
							
							while(rs7.next())
							{
								am=rs7.getString(1);
								System.out.println("amount is ------------------------->"+am);
							}
							PreparedStatement stmt8= con.prepareStatement("UPDATE simplemember SET balancedue=? WHERE smemberid=?");
							 ma=(long)((1.5)*l);
							Long x1=Long.parseLong(am);
							stmt8.setLong(1,(x1-ma));
							stmt8.setString(2,memberid);
							int rs8 =  stmt8.executeUpdate();
							System.out.println("------8");
							
							System.out.println("balance updatedddddddd"+(x1-ma));
					}
				
				
					
					
				String mn=a[g];int mid=0;
				System.out.println("mov nameeeeeeeeeeee is---------->"+mn);
				PreparedStatement stmt11= con.prepareStatement("SELECT movid FROM movies  WHERE movname=?");
				stmt11.setString(1,mn);
				java.sql.ResultSet rs11 =  stmt11.executeQuery();
				System.out.println("------9");
				while(rs11.next())
				{
					 mid=rs11.getInt(1);
					 System.out.println("movie ID----------------------------"+mid);
				}
				PreparedStatement stmt10= con.prepareStatement("SELECT quantity FROM transactiondetails  WHERE movid=? && tranid=?");
				stmt10.setInt(1,mid);
				stmt10.setInt(2,b[g]);
				int qq=0;String k1="returned";String k2="rented";
				java.sql.ResultSet rs10 = stmt10.executeQuery();
				System.out.println("------10");
				while(rs10.next())
				{
					 qq=rs10.getInt(1);
					 System.out.println("the qqqqqqqqqqq"+qq);
				}
				PreparedStatement stmt9= con.prepareStatement("UPDATE transactiondetails SET quantity=(quantity-?),status=?  WHERE movid=? && tranid=?");
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
				
				PreparedStatement stmt15= con.prepareStatement("SELECT quantity FROM transactiondetails  WHERE tranid=?");
				
				stmt15.setInt(1,b[g]);
				
				java.sql.ResultSet rs15 = stmt15.executeQuery();
				System.out.println("------11");
				while(rs15.next())
				{
					 q1+=rs15.getInt(1);
					 System.out.println("q1 vallllllllll"+q1);
					 
				}
				PreparedStatement stmt13= con.prepareStatement("UPDATE transaction SET transtatus=?  WHERE  tranid=?");
				if((q1)==0)
				stmt13.setString(1,k3);
				else
				stmt13.setString(1,k4);	
				stmt13.setInt(2,b[g]);
				int rs13=  stmt13.executeUpdate();
				System.out.println("------12");
				System.out.println("transaction updated successfullyyyyyyyyyyy");
				PreparedStatement stmt14= con.prepareStatement("UPDATE movies SET noofcopies=(noofcopies+?)  WHERE  movid=?");
				
				stmt14.setInt(1,q);
				
				stmt14.setInt(2,d1[g]);	
				
				int rs14=  stmt14.executeUpdate();
				System.out.println("------13");
				System.out.println("movies updated successfullyyyyyyyyyyy");
				PreparedStatement stmt12=con.prepareStatement("INSERT INTO audit(memberid,tranid,movid,quantity,date,status,paidamount) VALUES(?,?,?,?,?,?,?)");
				 stmt12.setString(1,memberid);
				 stmt12.setInt(2,b[g]);
				 stmt12.setInt(3,mid);
				 stmt12.setInt(4,q);
				 stmt12.setString(5,dat);
				 if((qq-q)==0)
				 stmt12.setString(6,k1);
				 else
				 stmt12.setString(6,k2);
				 if(m.equalsIgnoreCase("simple"))
				 stmt12.setLong(7,ma);
				 else
					 stmt12.setLong(7,0); 
				int rowcount1=stmt12.executeUpdate();
				System.out.println("------14");
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
			 //////if(con!=null)
					//pooling.returnConnection(con);
			}
		 catch(Exception e)
			{
				e.printStackTrace();
			}
		 }
		 
	 return result;
	 }

	public String updateLoggedInfo(String username,String finallogintime)
	{

		String result="";
		int rowcount_update;
		try
		{
			
		String update_login="Update login set logintime= ? where username=?";

					pstmt=con.prepareStatement(update_login);
					pstmt.setString(1, finallogintime);
					pstmt.setString(2, username);
					
					rowcount_update =pstmt.executeUpdate();
		
					if (rowcount_update>0)
					{
						result="true";
					System.out.println("Updation successful");
					}
					else
						result="false:Updation failed";
					//////if(con!=null)
						//pooling.returnConnection(con);
					}
					
		
		 catch(SQLException e)
		 {
			
			 e.printStackTrace();
		}
		
		
		return result;
		
	
		
		}
	

	public String createMembers(String fname,String lname,String mtype,String address,String city,String state,String zipcode,String memberid,String mdate,String country,String email,String password,String logintime)

	{
		String result="";
		int rowcount_person=0,rowcount_pmember=0,rowcount_smember=0,rowcount_login=0;
		
		
		try
		{
			
			String checkformemid="Select * from person where memberid=? ";
			pstmt=con.prepareStatement(checkformemid);
			pstmt.setString(1, memberid);
			rs = pstmt.executeQuery();
			//int personid=0;
			
			if(!rs.next())
			{
				String checkforemailid="Select * from login where username=? ";
				pstmt=con.prepareStatement(checkforemailid);
				pstmt.setString(1, email);
				rs = pstmt.executeQuery();
				if(!rs.next())
				{
				
System.out.println("entereddddddddddddd required part---------------------------->");
			
			String query_person="Insert into person (firstname,lastname,type,address,city,state,zipcode,memberid,country) values(?,?,?,?,?,?,?,?,?)";

			
			pstmt=con.prepareStatement(query_person);
			pstmt.setString(1, fname);
			pstmt.setString(2, lname);
			pstmt.setString(3, mtype);
			pstmt.setString(4, address);
			pstmt.setString(5, city);
			pstmt.setString(6, state);
			pstmt.setString(7, zipcode);
			pstmt.setString(8, memberid);
			pstmt.setString(9, country);
	
			

			rowcount_person =pstmt.executeUpdate();
			
			String query_personid="Select personid,type from person where memberid=? ";
			pstmt=con.prepareStatement(query_personid);
			pstmt.setString(1, memberid);
			rs = pstmt.executeQuery();
			int personid=0;
			String memtype="";
			while(rs.next())
			{
				personid=rs.getInt("personid");
				memtype=rs.getString("type");

			}

			
			if(rowcount_person>0)
			{
				String query_login="Insert into login(personid,username,password,logintime) values(?,?,?,?)";
				pstmt=con.prepareStatement(query_login);
				pstmt.setInt(1, personid);
				pstmt.setString(2, email);
				pstmt.setString(3, password);
				pstmt.setString(4, logintime);
				rowcount_login =pstmt.executeUpdate();
			
				if(rowcount_login>0)
				{	
			
					if (memtype.equalsIgnoreCase("premium"))
					{
						String query_pmember="Insert into premiummember(pmemberid,personid,moviesno,memdate) values(?,?,?,?)";
						pstmt=con.prepareStatement(query_pmember);
						pstmt.setString(1, memberid);
						pstmt.setInt(2, personid);
						pstmt.setString(3, "0");
						pstmt.setString(4, mdate);
						rowcount_pmember =pstmt.executeUpdate();
					}
			
					else
					{
				
						String query_smember="Insert into simplemember(smemberid,personid,balancedue,moviesno) values(?,?,?,?)";
						pstmt=con.prepareStatement(query_smember);
						pstmt.setString(1, memberid);
						pstmt.setInt(2, personid);
						pstmt.setString(3, "0");
						pstmt.setInt(4, 0);
						rowcount_smember=pstmt.executeUpdate();
				
					  }
				}
			}
			
					
			if ((rowcount_person>0) && (rowcount_login>0)  &&  ((rowcount_pmember>0) || (rowcount_smember>0)))
			{
				result="true";
			System.out.println("Insertion successful");
			}
			else
			{
				result="false:Insertion failed";
			}}
				else
					result="duplicateemail";
			}
			else
				result="duplicateid";
			//////if(con!=null)
				//pooling.returnConnection(con);
		}
			catch(SQLException e)
			{
				e.printStackTrace();
			
			}
		
			return result;
		
	}
	
	
	
	public String createMembers(String fname,String lname,String mtype,String address,String city,String state,String zipcode,String memberid,String mdate,String country)

	{
		String result="";
		int rowcount_person,rowcount_pmember=0,rowcount_smember=0;
		try
		{
			String query_person="Insert into person (firstname,lastname,type,address,city,state,zipcode,memberid,country) values(?,?,?,?,?,?,?,?,?)";

			
			pstmt=con.prepareStatement(query_person);
			pstmt.setString(1, fname);
			pstmt.setString(2, lname);
			pstmt.setString(3, mtype);
			pstmt.setString(4, address);
			pstmt.setString(5, city);
			pstmt.setString(6, state);
			pstmt.setString(7, zipcode);
			pstmt.setString(8, memberid);
			pstmt.setString(9, country);

			rowcount_person =pstmt.executeUpdate();
			
			String query_personid="Select personid,type from person where memberid=? ";
			pstmt=con.prepareStatement(query_personid);
			pstmt.setString(1, memberid);
			rs = pstmt.executeQuery();
			int personid=0;
			String memtype="";
			while(rs.next())
			{
				personid=rs.getInt("personid");
				memtype=rs.getString("type");

			}

			
			if (memtype.equalsIgnoreCase("premium"))
			{
			String query_pmember="Insert into premiummember(pmemberid,personid,moviesno,memdate) values(?,?,?,?)";
			pstmt=con.prepareStatement(query_pmember);
			pstmt.setString(1, memberid);
			pstmt.setInt(2, personid);
			pstmt.setString(3, "0");
			pstmt.setString(4, mdate);
			rowcount_pmember =pstmt.executeUpdate();
			}
			
			else
			{
				
				String query_smember="Insert into simplemember(smemberid,personid,balancedue,moviesno) values(?,?,?,?)";
				pstmt=con.prepareStatement(query_smember);
				pstmt.setString(1, memberid);
				pstmt.setInt(2, personid);
				pstmt.setString(3, "0");
				pstmt.setInt(4, 0);
				rowcount_smember=pstmt.executeUpdate();
				
			}
			
			
			if ((rowcount_person>0) &&  ((rowcount_pmember>0) || (rowcount_smember>0)))
			{
				result="true";
			System.out.println("Insertion successful");
			}
			else
				result="false:Insertion failed";
			//////if(con!=null)
				//pooling.returnConnection(con);
		}
		
		
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		
			return result;
		
	}

	
	
	
	
	public String delmember(String memberid)
	{
		String result="";
		int rowcount_delper,rowcount_delmem;
		try
		{
			
			String query_memtype="Select type from person where memberid=? ";
			pstmt=con.prepareStatement(query_memtype);
			pstmt.setString(1, memberid);
			rs = pstmt.executeQuery();
			String memtype="";
			while(rs.next())
			{
				memtype=rs.getString("type");
			}


			if (memtype.equalsIgnoreCase("premium"))
			{
				
			String query_delmem="Delete from premiummember where pmemberid=?" ;

			pstmt=con.prepareStatement(query_delmem);
			pstmt.setString(1, memberid);

			rowcount_delmem =pstmt.executeUpdate();

			
			}
			
			else
			{
				
				String query_delmem="Delete from simplemember where smemberid=?" ;

				pstmt=con.prepareStatement(query_delmem);
				pstmt.setString(1, memberid);

				rowcount_delmem =pstmt.executeUpdate();
	
			}
			
			
					String query_delper="Delete from person where memberid=?";

					pstmt=con.prepareStatement(query_delper);
					pstmt.setString(1, memberid);
					
					rowcount_delper =pstmt.executeUpdate();
		
					
					if (rowcount_delper>0 && rowcount_delmem>0)
					{
						result="true";
					System.out.println("Deletion successful");
					}
					else
						result="false:Deletion failed";
					//////if(con!=null)
						//pooling.returnConnection(con);			
		}
					
		
		catch(SQLException e)
		{
			
			e.printStackTrace();
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
		//	Connection conn = getConnection();
			String a="pending";String b="rented";
			PreparedStatement stmt= con.prepareStatement("SELECT tranid FROM transaction WHERE memberid=? && transtatus=?");
			
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
				PreparedStatement stmt1= con.prepareStatement("SELECT movid FROM `transactiondetails` WHERE `tranid`=? && status=?");
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
					PreparedStatement stmt3= con.prepareStatement("SELECT quantity FROM `transactiondetails` WHERE `movid`=? && `tranid`=?");
					stmt3.setString(1,m);
					stmt3.setString(2,tid[j]);
					java.sql.ResultSet rs3 =  stmt3.executeQuery();
					while(rs3.next())
					{
	mn[j]+=rs3.getString(1)+"*";
					}
					PreparedStatement stmt2= con.prepareStatement("SELECT movname FROM `movies` WHERE `movid`=? ");
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
			//////if(con!=null)
				//pooling.returnConnection(con);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	public String[] allPersons()
	{
		int id;
		
		String personid;
		int rowcount=0;
		
			
		String[]  person = null;

			try
			{
			
			String query_per="Select * from person";
			pstmt=con.prepareStatement(query_per);
			rs = pstmt.executeQuery();
			 person=new String[100500];
			System.out.println(rs.getMetaData().getColumnCount());

				int i=0;			
				while(rs.next())
				{
				
				
					person[i]=rs.getString(1)+"$"+rs.getString(2)+"$"+rs.getString(3)+"$"+rs.getString(4)+"$"+rs.getString(5)+"$"+rs.getString(6)+"$"+rs.getString(7)+"$"+rs.getString(8)+"$"+rs.getString(9)+"$"+rs.getString(10);
					
					i++;

				}
				//////if(con!=null)
					//pooling.returnConnection(con);
			}

	
			
		catch(SQLException e)
		{
			
			e.printStackTrace();

		}
		
		return person ;

}
	
	
	
	
	public String[] pMembers()
	{
		String result[];
		result=new String[10000];
		int i=0;
		
		try
		{
			//conection con = getconection();
			String a="premium";
			 pstmt= con.prepareStatement("SELECT personid,firstname,lastname,address,city,state,zipcode,memberid,country FROM `person` WHERE `type`='"+a+"'");
			rs =  pstmt.executeQuery();
			while(rs.next())
			{
				result[i]=rs.getString(1)+"$"+rs.getString(2)+"$"+rs.getString(3)+"$"+rs.getString(4)+"$"+rs.getString(5)+"$"+rs.getString(6)+"$"+rs.getString(7)+"$"+rs.getString(8)+"$"+rs.getString(9);
				System.out.println("--------------------->>>"+result[i]);
				i++;
				}		
			//////if(con!=null)
				//pooling.returnConnection(con);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}


	
	
	
	
/*	
	public  String[] pMembers()
	{
		
		int rowcount_pmem=0;
		
			
		String[]  pmembers = null;

			try
			{
			
			String query_pmem="Select * from person where type='premium'";
			pstmt=con.prepareStatement(query_pmem);
			rs = pstmt.executeQuery();
			pmembers=new String[100];
			

				int i=0;			
				while(rs.next())
				{
				
				
					pmembers[i]=rs.getString(1)+"   "+rs.getString(2)+"   "+rs.getString(3)+"   "+rs.getString(4)+"   "+rs.getString(5)+"   "+rs.getString(6)+"   "+rs.getString(7)+"   "+rs.getString(8)+"   "+rs.getString(9)+"   "+rs.getString(10);
					
					i++;

				}
			}

			
					
			
		catch(SQLException e)
		{
			
			e.printStackTrace();

		}
		
		return pmembers ;

}
	
	
	
	
	
	
	public  String[] sMembers()
	{
		
		int rowcount_smem=0;
		
			
		String[]  smembers = null;

			try
			{
			
			String query_pmem="Select * from person where type='simple'";
			pstmt=con.prepareStatement(query_pmem);
			rs = pstmt.executeQuery();
			smembers=new String[100];
			

				int i=0;			
				while(rs.next())
				{
				
				
					smembers[i]=rs.getString(1)+"   "+rs.getString(2)+"   "+rs.getString(3)+"   "+rs.getString(4)+"   "+rs.getString(5)+"   "+rs.getString(6)+"   "+rs.getString(7)+"   "+rs.getString(8)+"   "+rs.getString(9)+"   "+rs.getString(10);
					
					i++;

				}
			}

			
					
			
		catch(SQLException e)
		{
			
			e.printStackTrace();

		}
		
		return smembers ;

}
	
*/
	
	
	
	public String[] sMembers()
	{
		String result[]=new String[10050];
		int i=0;
		String smem="SELECT * FROM `person` WHERE `type`=?";
		try{
			pstmt=con.prepareStatement(smem);
			pstmt.setString(1, "simple");
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				result[i]=rs.getString(1)+"$"+rs.getString(2)+"$"+rs.getString(3)+"$"+rs.getString(5)+"$"+rs.getString(6)+"$"+rs.getString(7)+"$"+rs.getString(8)+"$"+rs.getString(9)+"$"+rs.getString(10);
				i++;
			}
			//////if(con!=null)
				//pooling.returnConnection(con);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	public String[] allMovies()
	{
		System.out.println("in all movies dao impl---------------->");
		System.out.println();
		String result=null;
		int i=0;
		String[] finalString= new String[100050];
		//Connection conn=(Connection)u.getConnection();
		try {
			
			String vsql="SELECT * FROM movies";

			pstmt=con.prepareStatement(vsql);
			rs=pstmt.executeQuery();
			//Connection conn=(Connection)u.getConnection();
			//Statement stmt6= (Statement) conn.createStatement();
			//java.sql.ResultSet rs2 =  stmt6.executeQuery(vsql);
			
			String wholestring;
			while(	rs.next())
			{
			
			int res=rs.getInt(1);
			String moviename=rs.getString(2);
			String moiveBanner=rs.getString(3);
			String category=rs.getString(6);
			String releaseDate=rs.getString(4);
			String rentamt=rs.getString(5);
			String noofcopies=rs.getString(7);
			wholestring=""+res+"$"+moviename+"$"+moiveBanner+"$"+category+"$"+releaseDate+"$"+noofcopies+"$"+rentamt+"$";
			System.out.println("Printing in dao whole string---->"+wholestring);
			finalString[i]=wholestring;
			i++;
			
			}
			//////if(con!=null)
				//pooling.returnConnection(con);
		
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return finalString;
	}



	
	
	
	
	
	/*
	
	public  String[] allMovies()
	{
		
		int rowcount_mov=0;
		
			
		String[]  movies = null;

			try
			{
			
			String query_movies="Select * from movies";
			pstmt=con.prepareStatement(query_movies);
			rs = pstmt.executeQuery();
			movies=new String[100];
			

				int i=0;			
				while(rs.next())
				{
				
				
					movies[i]=rs.getString(1)+"   "+rs.getString(2)+"   "+rs.getString(3)+"   "+rs.getString(4)+"   "+rs.getString(5)+"   "+rs.getString(6)+"   "+rs.getString(7);
					
					i++;

				}
			}

			
					
			
		catch(SQLException e)
		{
			
			e.printStackTrace();

		}
		
		return movies ;

}
	
	
	
	
	*/
	
	
	
	
	public String updatePinfo(String fname,String lname,String address,String city,String state,String zipcode,String memberid,String country)
	{
		String result="";
		int rowcount_update;
		try
		{
			
			System.out.println("in update dao--------------->"+fname);
					String update_query="UPDATE person SET firstname = IFNULL(?,firstname),lastname = IFNULL(?,lastname),address = IFNULL(?,address),city = IFNULL(?,city),state = IFNULL(?,state),zipcode = IFNULL(?,zipcode),country = IFNULL(?,country) WHERE memberid=?";

					pstmt=con.prepareStatement(update_query);
					//pstmt.setString(1, memberid);
					pstmt.setString(1, fname);
					pstmt.setString(2, lname);
					pstmt.setString(3, address);
					pstmt.setString(4, city);
					pstmt.setString(5, state);
					pstmt.setString(6, zipcode);
					pstmt.setString(7, country);
					pstmt.setString(8, memberid);
					
					rowcount_update =pstmt.executeUpdate();
		
					if (rowcount_update>0)
					{
						result="true";
					System.out.println("Updation successful");
					}
					else
						result="false:Updation failed";
					//////if(con!=null)
						//pooling.returnConnection(con);
					}
					
		
		
		catch(SQLException e)
		{
			
					e.printStackTrace();
		}
		
		
		
 return result;
		
	
		
		}
	
	
	
	
	
public String payment(String memberid,String amount,String paydate)
	{
		String result="";
		int rowcount_payment;
		
		try
		{
			String query_payment="Insert into payment(memberid,amount,paydate) values(?,?,?)";
			pstmt=con.prepareStatement(query_payment);
		
			pstmt.setString(1, memberid);
			pstmt.setString(2, amount);
			pstmt.setString(3, paydate);

			rowcount_payment =pstmt.executeUpdate();
			
			if (rowcount_payment>0)
			{
				result="true";
			System.out.println("Insertion successful");
			}
			else
				result="false:Insertion failed";
			//////if(con!=null)
				//pooling.returnConnection(con);
		}
		
		
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		
			return result;
		
	}


	
	



public String[] searchMovie(String moviename, String moviebanner, String category, String reldate)
{
	//int id;
	//String personid;
	//String db_moviename,db_moviebanner,db_category,db_reldate;
	int rowcount=0;
	String  mov[] = null;

		try
		{
		
		//String query_sear_per="select * from person where firstname like IFNULL(?,firstname) and lastname like IFNULL(?,lastname) and type like IFNULL(?,type) and address like IFNULL(?,address) and city like IFNULL(?,city) and state like IFNULL(?,state) and zipcode like IFNULL(?,zipcode) and memberid like IFNULL(?,memberid) and country like IFNULL(?,country)";
			mov=new String[100500];

			String query_sear_mov="SELECT * FROM movies WHERE (movname LIKE IFNULL(?,movname) OR movname = IFNULL(?,movname)) AND (movbanner LIKE IFNULL(?,movbanner) OR movbanner = IFNULL(?,movbanner)) AND (category LIKE IFNULL(?,category) OR category = IFNULL(?,category)) AND (releasedate LIKE IFNULL(?,releasedate) OR releasedate = IFNULL(?,releasedate))";

		pstmt=con.prepareStatement(query_sear_mov);
		pstmt.setString(1, "%"+moviename+"%");
		pstmt.setString(2, 	moviename);
		pstmt.setString(3, "%"+moviebanner+"%");
		pstmt.setString(4, 	moviebanner);
		pstmt.setString(5, 	"%"+category+"%");
		pstmt.setString(6, 	category);
		pstmt.setString(7, "%"+reldate+"%");
		pstmt.setString(8, reldate);
		
		rs = pstmt.executeQuery();

			int i=0;
			while(rs.next())
			{
				
				mov[i]=rs.getString(1)+"$"+rs.getString(2)+"$"+rs.getString(3)+"$"+rs.getString(4)+"$"+rs.getString(6)+"$"+rs.getString(7);
				

				i++;
				
				
			}
			//////if(con!=null)
				//pooling.returnConnection(con);
	
	
		}

		
		
		catch(SQLException e)
		{
			
			e.printStackTrace();

		}
		
		return mov ;


		
	}

public String updateMinfo(String movieid,String moviename, String moviebanner, String category,String releasedate, String mcopies)
{
	String result="";
	int rowcount_update;
	try
	{
		

		
		String update_query="Update movies set movname=IFNULL(?,movname),movbanner=IFNULL(?,movbanner),category=IFNULL(?,category),releasedate=IFNULL(?,releasedate),noofcopies=IFNULL(?,noofcopies) where movid=?";
		pstmt=con.prepareStatement(update_query);
		pstmt.setString(1, moviename);
		pstmt.setString(2, moviebanner);
		pstmt.setString(3, category);
		pstmt.setString(4, releasedate);
		pstmt.setString(5, mcopies);
		pstmt.setString(6, movieid);
		rowcount_update =pstmt.executeUpdate();
	
		if (rowcount_update>0)
		{
			result="true";
			System.out.println("Updation successful");
		}
				
		else
			result="false:Updation failed";
		//////if(con!=null)
			//pooling.returnConnection(con);
				
	}
				
	
	
	catch(SQLException e)
	{
		
				e.printStackTrace();
	}
	
	
	
return result;
	

	
	}


	
	
	
	/*

	public String createMovies(String moviename, String moviebanner, String category, String reldate, int mcopies)

	{
		String result="";
		int rowcount_movies;
		try
		{
			String query_movies="Insert into movies(movname,movbanner,releasedate,category,noofcopies) values(?,?,?,?,?)";

			
			pstmt=con.prepareStatement(query_movies);
			pstmt.setString(1, moviename);
			pstmt.setString(2, moviebanner);
			pstmt.setString(3, reldate);
			pstmt.setString(4, category);
			pstmt.setInt(5, mcopies);
			
			rowcount_movies =pstmt.executeUpdate();
			
			
			if (rowcount_movies>0)
			{
				result="true";
			System.out.println("Insertion successful");
			}
			else
				result="false:Insertion failed";
			}
		
		
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		
			return result;
		
	}

*/
	
	
	
	public String createMovies(String moviename, String moviebanner, String Category, String reldate, int mcopies)
	{
		//Connection conn = getConnection();
		System.out.println("------------>"+moviename);
		System.out.println("------------>"+moviebanner);
		System.out.println("------------>"+Category);
		System.out.println("------------>"+reldate);
		System.out.println("------------>"+mcopies);
		
		
		String result="";
		int rowcount;
		try
		{
			
			String checkformemid="Select * from movies where movname=? ";
			pstmt=con.prepareStatement(checkformemid);
			pstmt.setString(1, moviename);
			rs = pstmt.executeQuery();
			//int personid=0;
			
			if(!rs.next())
			{
			System.out.println("entered if------------------------------>");
			 pstmt=con.prepareStatement("INSERT INTO movies(movname,movbanner,releasedate,category,noofcopies) VALUES(?,?,?,?,?)");
			 pstmt.setString(1,moviename);
			 pstmt.setString(2,moviebanner);
			 pstmt.setString(3,reldate);
			 pstmt.setString(4,Category);
			 pstmt.setInt(5,mcopies);
			rowcount=pstmt.executeUpdate();
		
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
			else
			{
				result="duplicatemovie";
				System.out.println("Entered duplicate else-------------------->");
				
			}
			//////if(con!=null)
				//pooling.returnConnection(con);
		}
		catch(Exception e)
		{

			
			e.getStackTrace();
		}
		return result;
		
	}
	
	
	
	
	public String updateMinfo(String movieid,String moviename, String moviebanner, String category, String mcopies)
	{
		String result="";
		int rowcount_update;
		try
		{
			
	
			
			String update_query="Update movies set movname=IFNULL(?,movname),movbanner=IFNULL(?,movbanner),category=IFNULL(?,category),noofcopies=IFNULL(?,noofcopies) where movid=?";
			pstmt=con.prepareStatement(update_query);
			pstmt.setString(1, moviename);
			pstmt.setString(2, moviebanner);
			pstmt.setString(3, category);
			pstmt.setString(4, mcopies);
			pstmt.setString(5, movieid);

			rowcount_update =pstmt.executeUpdate();
		
			if (rowcount_update>0)
			{
				result="true";
				System.out.println("Updation successful");
			}
					
			else
				result="false:Updation failed";
					
			//////if(con!=null)
				//pooling.returnConnection(con);
		}
					
		
		
		catch(SQLException e)
		{
			
					e.printStackTrace();
		}
		
		
		
 return result;
		
	
		
		}
	
	
	
	
	public String[] personDetails(String memberid)
	{
		int id;
		String personid;
		String firstname,lastname,type,address,city,state,zipcode,country,moviename;
		int rowcount=0;
		//String person[]=new String[100];
		
			
		String  mov_issue[] = null;
		String  person[] = null;

			try
			{
			
			String query_per_memid="Select p.firstname,p.lastname,p.type,p.address,p.city,p.state,p.zipcode,p.country , m.movname FROM  person p, movies m,transactiondetails td,transaction t WHERE t.memberid=? AND td.tranid = t.tranid AND td.status='rented' AND m.movid=td.movid  AND t.memberid=p.memberid";
			pstmt=con.prepareStatement(query_per_memid);
			pstmt.setString(1,memberid);
			
			rs = pstmt.executeQuery();

			person=new String[80];
			System.out.println(rs.getMetaData().getColumnCount());


				int i=1;
				while(rs.next())
				{
				
				
				person[i]=rs.getString(1)+"   "+rs.getString(2)+"   "+rs.getString(3)+"   "+rs.getString(4)+"   "+rs.getString(5)+"   "+rs.getString(6)+"   "+rs.getString(7)+"   "+rs.getString(8)+"   "+rs.getString(9);
	
				i++;

				}
				//////if(con!=null)
					//pooling.returnConnection(con);
			}

	
		catch(SQLException e)
		{
			
			e.printStackTrace();

		}
		
		return person ;


		
	}
		
	
	
	public String[] searchPerson(String fname,String lname,String mtype,String address,String city,String state,String zipcode,String memberid,String country)
	{
		String[] result;
		String personid;
		int id;
		//String db_firstname,db_lastname,db_type,db_address,db_city,db_state,db_zipcode,db_memberid,db_country;
		int rowcount=0;
		//String person[]=new String[100];
		String  person[] = null;

			try
			{
			
			//String query_sear_per="select * from person where firstname like IFNULL(?,firstname) and lastname like IFNULL(?,lastname) and type like IFNULL(?,type) and address like IFNULL(?,address) and city like IFNULL(?,city) and state like IFNULL(?,state) and zipcode like IFNULL(?,zipcode) and memberid like IFNULL(?,memberid) and country like IFNULL(?,country)";
			String query_sear_per="SELECT personid,firstname,lastname,type,address,city,state,zipcode,memberid,country FROM person WHERE (firstname LIKE IFNULL(?,firstname) OR firstname = IFNULL(?,firstname)) AND (lastname LIKE IFNULL(?,lastname) OR lastname = IFNULL(?,lastname)) AND (type LIKE IFNULL(?,type) OR type = IFNULL(?,type)) AND (address LIKE IFNULL(?,address) OR address = IFNULL(?,address)) AND (city LIKE IFNULL(?,city) OR city = IFNULL(?,city)) AND ( state LIKE IFNULL(?,state) OR state = IFNULL(?,state)) AND ( zipcode LIKE IFNULL(?,zipcode) OR zipcode = IFNULL(?,zipcode)) AND (memberid LIKE IFNULL(?,memberid) OR memberid = IFNULL(?,memberid)) AND (country LIKE IFNULL(?,country) OR country = IFNULL(?,country))";
			//String query_sear_per="select * from person where (firstname like IFNULL(?,firstname) OR firstname = IFNULL(?,firstname)) AND (lastname like IFNULL(?,lastname) OR lastname = IFNULL(?,lastname))AND (type LIKE IFNULL(?,type) OR type = IFNULL(?,type))";

			pstmt=con.prepareStatement(query_sear_per);
			pstmt.setString(1, "%"+fname+"%");
			pstmt.setString(2, 	fname);
			pstmt.setString(3, "%"+lname+"%");
			pstmt.setString(4, 	lname);
			pstmt.setString(5, 	"%"+mtype+"%");
			pstmt.setString(6, 	mtype);
			pstmt.setString(7, "%"+address+"%");
			pstmt.setString(8, address);
			pstmt.setString(9, "%"+city+"%");
			pstmt.setString(10,city);
			pstmt.setString(11,"%"+state+"%");
			pstmt.setString(12,state);
			pstmt.setString(13, "%"+zipcode+"%");
			pstmt.setString(14, zipcode);
			pstmt.setString(15, "%"+memberid+"%");
			pstmt.setString(16, memberid);
			pstmt.setString(17, "%"+country+"%");
			pstmt.setString(18, country);


			
			rs = pstmt.executeQuery();

			person=new String[10050];
				int i=0;
				while(rs.next())
				{
									
				person[i]=rs.getString(1)+"$"+rs.getString(2)+"$"+rs.getString(3)+"$"+rs.getString(4)+"$"+rs.getString(5)+"$"+rs.getString(6)+"$"+rs.getString(7)+"$"+rs.getString(8)+"$"+rs.getString(9)+"$"+rs.getString(10);
				i++;
					
				}
				//////if(con!=null)
					//pooling.returnConnection(con);
			}

			
			
			catch(SQLException e)
			{
				
				e.printStackTrace();

			}
			
			return person ;


			
		}
		
	
	
	public String[] rentMovie(String memberid,String[] movieorder,String date)
	{
		String result[]=null,membertype=null;
		result=new String[20];
		int count=0;
		String ptype="SELECT `type` FROM `person` WHERE `memberid`=? ";
		String moviecopies="SELECT `noofcopies` FROM `movies` WHERE `movid`=?";
		try{
			
			stmt1=(PreparedStatement)con.prepareStatement(ptype);
			stmt1.setString(1, memberid);
			ResultSet rs=stmt1.executeQuery();
			while(rs.next())
			{
				membertype=rs.getString(1);
			}
			StringTokenizer temp1;
			int movcount=0;
			for(int i=0;i<movieorder.length&& movieorder[i]!=null;i++)
			{
				temp1=new StringTokenizer(movieorder[i],"#");
				String var[]=new String[2];
				int k=0;
				while(temp1.hasMoreTokens())
				{
					var[k]=temp1.nextToken();
					k++;
				}
				System.out.println("in db ################"+var[1]);
				movcount=movcount+Integer.parseInt(var[1]);
			}
			
			if(membertype.equals("simple"))
			{
				int movc;
				System.out.println("entered hereeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
				stmt3=(PreparedStatement)con.prepareStatement("SELECT `moviesno` FROM `simplemember` WHERE `smemberid`=?");
				stmt3.setString(1, memberid);
				ResultSet rs2=stmt3.executeQuery();
				while(rs2.next())
				{
					movc=Integer.parseInt(rs2.getString(1));
					if(movc+movcount>2)
					{
						result[19]="can issue u now "+ Math.abs(2-movc)+" movies";
						return result;
					}
				}
			}
			
			else if(membertype.equals("premium"))
			{
				int valid=0;
				stmt10=(PreparedStatement)con.prepareStatement("SELECT `memdate` FROM `premiummember` WHERE `pmemberid`=?");
				stmt10.setString(1, memberid);
				ResultSet rs3=stmt10.executeQuery();
				String pmemdate="";
				while(rs.next())
				{
					pmemdate=rs3.getString(1);
				}
				
				Calendar currentDate = Calendar.getInstance();
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				String curdate=dateFormat.format(currentDate.getTime());
				stmt9=(PreparedStatement)con.prepareStatement("SELECT DATEDIFF(?,?)");
				stmt9.setString(1,curdate);
				stmt9.setString(2, pmemdate);
				ResultSet rs4=stmt9.executeQuery();
				while(rs.next())
				{
					if(Integer.parseInt(rs4.getString(1))>30)
						valid=1;
				}
				
				if(valid==0)
				{
				int movc;
				stmt3=(PreparedStatement)con.prepareStatement("SELECT `moviesno` FROM `premiummember` WHERE `pmemberid`=?");
				stmt3.setString(1, memberid);
				ResultSet rs2=stmt3.executeQuery();
				while(rs2.next())
				{
					movc=Integer.parseInt(rs2.getString(1));
					if(movc+movcount>10)
					{
						result[19]="can issue u now "+ Math.abs(10-movc)+" movies";
						return result;
					}
				}
				}
				else
				{
					result[18]="cant issue movies ur membership expired";
					return result;
				}
			}
			
			stmt2=(PreparedStatement)con.prepareStatement(moviecopies);
			StringTokenizer temp;
			
			for(int i=0;i<movieorder.length&& movieorder[i]!=null;i++)
			{
				temp=new StringTokenizer(movieorder[i],"#");
				String var[]=new String[2];
				int k=0;
				while(temp.hasMoreTokens())
				{
					var[k]=temp.nextToken();
					k++;
				}
				stmt2.setString(1, var[0]);
				ResultSet rs1=stmt2.executeQuery();
				while(rs1.next())
				{
					count=Integer.parseInt(rs1.getString(1));
				}
				if(count>=Integer.parseInt(var[1]))
				{
					//String res=tableupdation(membertype,memberid,var,date);
					result[i]=var[0]+" issue succes";
				}
				else
					result[i]=var[0]+" movie cant be issued it has only "+count+"copies so if u want change the number of copies";
			}
			//////if(con!=null)
				//pooling.returnConnection(con);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	

	
	


	
	public String movieDetails(String movieid)
	{
		String result=null;
		
		String[] finalString= new String[100];
		//Connection conn=(Connection)u.getConnection();
		try {
			
			String vsql="SELECT * FROM movies WHERE movid=?";
			pstmt=con.prepareStatement(vsql);

			pstmt.setString(1,movieid);

			rs =  pstmt.executeQuery();
			System.out.println("hello");
			String wholestring;
			while(	rs.next())
			{
			
				int res=rs.getInt(1);
				String moviename=rs.getString(2);
				String moiveBanner=rs.getString(3);
				String category=rs.getString(6);
				String releaseDate=rs.getString(4);
			result=""+moviename+"$"+moiveBanner+"$"+category+"$"+releaseDate+"$";
			//wholestring=""+moviename+"$"+moiveBanner+"$"+category+"$"+releaseDate+"$";
			//i++;
			
			}
			//////if(con!=null)
				//pooling.returnConnection(con);
		int i=0;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String premiumtableupdation(String memberid,String[] movieorder,String date)
	{
		String res="false";
		String result="",type=null;
		int count=0;
		String transid="";
		String ptype="SELECT `type` FROM `person` WHERE `memberid`=? ";
		int movcount=0;
		try{
			stmt1=(PreparedStatement)con.prepareStatement(ptype);
			stmt1.setString(1, memberid);
			ResultSet rs=stmt1.executeQuery();
			while(rs.next())
			{
				type=rs.getString(1);
			}

	
		if(type!=null && type.equals("premium"))
		{
			StringTokenizer temp;
			
			for(int i=0;i<movieorder.length&& movieorder[i]!=null;i++)
			{
				temp=new StringTokenizer(movieorder[i],"#");
				String var[]=new String[2];
				int k=0;
				while(temp.hasMoreTokens())
				{
					var[k]=temp.nextToken();
					k++;
				}
				movcount=movcount+Integer.parseInt(var[1]);
				stmt6=(PreparedStatement)con.prepareStatement("UPDATE `movies` SET `noofcopies`=`noofcopies`-? WHERE `movid`=? ");
				stmt6.setString(1,var[1]);
				stmt6.setString(2,var[0]);
				int c=stmt6.executeUpdate();
				
			}
		
			
			stmt4=(PreparedStatement)con.prepareStatement("UPDATE `premiummember` SET `moviesno`= `moviesno`+ ? WHERE `pmemberid`=?");
			stmt4.setString(1,""+movcount);
			stmt4.setString(2,memberid);
			int b=stmt4.executeUpdate();
			
			stmt9=(PreparedStatement)con.prepareStatement("INSERT INTO `transaction`(`memberid`,`date`) VALUES(?,?)");
			stmt9.setString(1,memberid);
			stmt9.setString(2, date);
			int a=stmt9.executeUpdate();
			
			stmt10=(PreparedStatement)con.prepareStatement("SELECT `tranid` FROM `transaction` WHERE `memberid`=? AND `date`=?");
			stmt10.setString(1, memberid);
			stmt10.setString(2, date);
			ResultSet rs2=stmt10.executeQuery();
			while(rs2.next())
			{
				transid=rs2.getString(1);
			}
			
			StringTokenizer temp1;
			for(int i=0;i<movieorder.length&& movieorder[i]!=null;i++)
			{
				temp1=new StringTokenizer(movieorder[i],"#");
				String var[]=new String[2];
				int k=0;
				while(temp1.hasMoreTokens())
				{
					var[k]=temp1.nextToken();
					k++;
				}
				
			stmt7=(PreparedStatement)con.prepareStatement("INSERT INTO `transactiondetails`(`tranid`,`movid`,`quantity`,`status`) VALUES(?,?,?,?)");
			stmt7.setString(1, transid);
			stmt7.setString(2,var[0]);
			stmt7.setString(3, var[1]);
			stmt7.setString(4, "rented");
			int d=stmt7.executeUpdate();
			
			stmt8=(PreparedStatement)con.prepareStatement("INSERT INTO `audit`(`memberid`,`tranid`,`movid`,`quantity`,`date`,`status`,`paidamount`) VALUES(?,?,?,?,?,?,?)");
			stmt8.setString(1, memberid);
			stmt8.setString(2, transid);
			stmt8.setString(3, var[0]);
			stmt8.setString(4, var[1]);
			stmt8.setString(5, date);
			stmt8.setString(6, "rented");
			stmt8.setString(7, ""+movcount*5);
			int e=stmt8.executeUpdate();
		}
		}
		//////if(con!=null)
			//pooling.returnConnection(con);
		}
		catch(Exception e)
		{
			result="false";
			e.printStackTrace();
		}
		
		res=transid;
		return res;
		
	}
	
	
	public String movieCount(String memberid)
	{
		
		System.out.println("Inside movie count impl--------------->");
		String result="";
		
		try {
			
			int rowcount=0;
			String count_mov="select count(td.movid) from transaction  t,transactiondetails td where t.tranid=td.tranid AND td.status='rented' AND t.memberid=?";
			pstmt=con.prepareStatement(count_mov);
			pstmt.setString(1,memberid);

			rs =  pstmt.executeQuery();
			//Statement stmt3= (Statement) conn.createStatement();
			
			//System.out.println(""+vsql);
			String moviecount="";
			
			while(rs.next())
			{
				moviecount=rs.getString(1);
				rowcount++;
				
			}
		
		
			if (rowcount>0)
			{
				result=moviecount;
			}
					
			else
				result="false:No movie issued";
			//////if(con!=null)
			//pooling.returnConnection(con);
		
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		}

		
	public String simpletableupdation(String cardnum,String cvv,String memberid,String[] movieorder,String date)
	{
		String res="false";
		String result="",type=null;
		int count=0;
		String transid="";
		String ptype="SELECT `type` FROM `person` WHERE `memberid`=? ";
		int movcount=0;
		
		try{
			stmt1=(PreparedStatement)con.prepareStatement(ptype);
			stmt1.setString(1, memberid);
			ResultSet rs=stmt1.executeQuery();
			while(rs.next())
			{
				type=rs.getString(1);
			}
				
		if(type!=null && type.equals("simple"))
		{
			if(cardnum!=null && cvv!=null)
			{
			Pattern p = Pattern.compile("[^0-9 ]", Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(cardnum);
			boolean b2 = m.find();
			
			Pattern p1 = Pattern.compile("[^0-9 ]", Pattern.CASE_INSENSITIVE);
			Matcher m1 = p1.matcher(cvv);
			boolean b1 = m1.find();

			if ((b2||b1) || (cardnum.length()!=16||cvv.length()!=3))
			{
				if(b2|| (cardnum.length()!=16))
				return "enter credit card number properly";
				if(b1||(cvv.length()!=3))
					return "enter correct cvv number";
			   
			}
			
			
			else{
				
				StringTokenizer temp;
				
				for(int i=0;i<movieorder.length&& movieorder[i]!=null;i++)
				{
					temp=new StringTokenizer(movieorder[i],"#");
					String var[]=new String[2];
					int k=0;
					while(temp.hasMoreTokens())
					{
						var[k]=temp.nextToken();
						k++;
					}
					movcount=movcount+Integer.parseInt(var[1]);
					stmt6=(PreparedStatement)con.prepareStatement("UPDATE `movies` SET `noofcopies`=`noofcopies`-? WHERE `movid`=? ");
					stmt6.setString(1,var[1]);
					stmt6.setString(2,var[0]);
					int c=stmt6.executeUpdate();
					
				}
			

			stmt4=(PreparedStatement)con.prepareStatement("UPDATE `simplemember` SET `moviesno`= `moviesno`+ ? WHERE `smemberid`=?");
			stmt4.setString(1,""+movcount);
			stmt4.setString(2,memberid);
			int b=stmt4.executeUpdate();
			
			stmt5=(PreparedStatement)con.prepareStatement("UPDATE `simplemember` SET `balancedue`= `balancedue`+? WHERE `smemberid`=?  ");
			stmt5.setString(1, ""+movcount*5);
			stmt5.setString(2,memberid);
			int c=stmt5.executeUpdate();
		
			stmt2=(PreparedStatement)con.prepareStatement("INSERT INTO `payment`(`memberid`,`amount`,`paydate`) VALUES(?,?,?)");
			stmt2.setString(1, memberid);
			stmt2.setString(2, ""+movcount*5);
			stmt2.setString(3, date);
			int d=stmt2.executeUpdate();
			
			stmt9=(PreparedStatement)con.prepareStatement("INSERT INTO `transaction`(`memberid`,`date`) VALUES(?,?)");
			stmt9.setString(1,memberid);
			stmt9.setString(2, date);
			int a=stmt9.executeUpdate();
			
			stmt10=(PreparedStatement)con.prepareStatement("SELECT `tranid` FROM `transaction` WHERE `memberid`=? AND `date`=?");
			stmt10.setString(1, memberid);
			stmt10.setString(2, date);
			ResultSet rs2=stmt10.executeQuery();
			while(rs2.next())
			{
				transid=rs2.getString(1);
			}
			
			StringTokenizer temp1;
			for(int i=0;i<movieorder.length&& movieorder[i]!=null;i++)
			{
				temp1=new StringTokenizer(movieorder[i],"#");
				String var[]=new String[2];
				int k=0;
				while(temp1.hasMoreTokens())
				{
					var[k]=temp1.nextToken();
					k++;
				}
				
			stmt7=(PreparedStatement)con.prepareStatement("INSERT INTO `transactiondetails`(`tranid`,`movid`,`quantity`,`status`) VALUES(?,?,?,?)");
			stmt7.setString(1, transid);
			stmt7.setString(2,var[0]);
			stmt7.setString(3, var[1]);
			stmt7.setString(4, "rented");
			int d1=stmt7.executeUpdate();
			
			stmt8=(PreparedStatement)con.prepareStatement("INSERT INTO `audit`(`memberid`,`tranid`,`movid`,`quantity`,`date`,`status`,`paidamount`) VALUES(?,?,?,?,?,?,?)");
			stmt8.setString(1, memberid);
			stmt8.setString(2, transid);
			stmt8.setString(3, var[0]);
			stmt8.setString(4, var[1]);
			stmt8.setString(5, date);
			stmt8.setString(6, "rented");
			stmt8.setString(7, ""+movcount*5);
			int e=stmt8.executeUpdate();
			}
			
			}
			
		}
			
		}
		//pooling.returnConnection(con);
		}
		catch(Exception e)
		{
			result="false";
			e.printStackTrace();
		}
		res=transid;
		return res;
	}
	
	
	
	

	public String delMovies(String movieid)
	{
		String result=null;
		int k=0;
		//String check="SELECT * FROM `transactiondetails` WHERE `movid`=? ";
		String dele="DELETE FROM `movies` WHERE `movid`=?";
		try{
		//pstmt2=(PreparedStatement)con.prepareStatement(check);
		//pstmt2.setString(1, movieid);
		pstmt=(PreparedStatement)con.prepareStatement(dele);
		pstmt.setString(1, movieid);
		//ResultSet rs=pstmt2.executeQuery();
	/*	while(rs.next())
		{
			k++;
		}
		
		
		if(k==0)
		{
		*/
		int deleted=pstmt.executeUpdate();
		if(deleted>0)
		result="deleted";
		else
			result="not deleted or no such movie exists";
		/*}
		else 
			result="some one has rented the movie cant be deleted";
		*/
		//pooling.returnConnection(con);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	

}
	



	
	
	
	
	
	
	


