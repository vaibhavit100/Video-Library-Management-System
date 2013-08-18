package services;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class VideoLibraryManagement {

DatabaseConnection db=new DatabaseConnection();
Date date= new Date();
java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	

public String movieName(String movid)
{
	if(movid.length()==0 ||  movid == null)
	{	
		return "Invalid Input";
	}
	String result;
	result=db.movieName(movid);
	return result;

}

public String movieIssue(String memberid)
{
	String result;
	System.out.println(memberid);
	result=db.movieIssue(memberid);
	return result;
}

public String personDetail(String memberid)
{
	String result;
	result=db.personDetail(memberid);
	return result;
}


public String[] movieProfile(String movid)
{
  String[] person_issue=null;
	
  person_issue=db.movieProfile(movid);
  
  return person_issue;
}
public String signIn(String username,String password)
{
System.out.println("enter func");
	if((username.length()==0) || (password.length()==0) || (username == null) || (password == null))

	{
	
		return "Invalid Input";
	}
		

	String result;
	if(!((username == null)||(password == null)))
	result=db.signIn(username,password);
	else
		return "Invalid Input";	
	return result;
	
	}


public String updateMinfo(String movieid,String moviename, String moviebanner, String category,String releasedate, String mcopies)
{
String result;
result=db.updateMinfo(movieid,moviename,moviebanner,category,releasedate,mcopies);
return result;
}

public String updateLoggedInfo(String username,String finallogintime)
{

	if((username.length()==0) || (finallogintime.length()==0))
	{	
		return "Invalid input";
	}
	
	String result;
	
	result=db.updateLoggedInfo(username,finallogintime);
	return result;
}




public String createMembers(String fname,String lname,String mtype,String address,String city,String state,String zipcode,String memberid,String mdate,String country,String email,String password,String logintime)
{
	
	System.out.println("value zippppppp"+zipcode);
	System.out.println("lengthhhhhhh"+zipcode.length());

	if((fname.length()==0) || (lname.length()==0) || (mtype.length()==0) || (address.length()==0) || (city.length()==0) || (state.length()==0) || (zipcode.length()==0)||((zipcode.length()>0) && (zipcode.length()<5)) || ((zipcode.length()<6) && (zipcode.length()>10)) || (memberid.length()==0) || (memberid.length()>11) || (mdate.length()==0)  || (country.length()==0) || (email.length()==0) || (password.length()==0) || (logintime.length()==0))
	{	
		return "Invalid input";
	}
	
	String result;
	
	//mdate = sdf.format(date);
	//logintime=sdf.format(date);
	result=db.createMembers(fname,lname,mtype,address,city,state,zipcode,memberid,mdate,country,email,password,logintime);
	return result;
	
}

public String delmember(String memberid)
{

	if(memberid.length()==0 ||  memberid == null)
	{	
		return "Invalid Input";
	}
	String result;
	result=db.delmember(memberid);
	return result;
}



public String createMovies(String moviename, String moviebanner, String category, String reldate, int mcopies)
{
	String result="";
	if(!(moviename == null))
	result=db.createMovies(moviename,moviebanner,category,reldate,mcopies);
	else
		result="received null";
 return result;
}






public String[] rentMovie(String memberid, String[] movieorder,String date)
{

	String[] result;
	result=db.rentMovie(memberid,movieorder,date);
	return result;
	}
	



public String payment(String memberid,String amount,String paydate)
{
	String result;
	paydate = sdf.format(date);
	result=db.payment(memberid,amount,paydate);
	return result;
}



public String returnMovie (String memberid, String movieid, String moviename,String count,String date, String tid)
{
	System.out.println("inside return movie");
	String result=db.returnMovie (memberid,movieid,moviename,count,date,tid);
	return result;
}
public String returnmovofmember(String memberid)
{
	if(memberid.length()==0 ||  memberid == null)
	{	
		return "Invalid Input";
	}
	
	String result=db.returnmovofmember(memberid);
	System.out.println("in returnmovofmemberrrrrrrrrrrrr");
	return result;
}


public  String[] pMembers()
{
	String[] result;
	result=db.pMembers();
	return result;
}


public  String[] sMembers()
{
	String[] result;
	result=db.sMembers();
	return result;
}


public  String[] allMovies()
{
	String[] result;
	result=db.allMovies();
	return result;
}


public  String[] allPersons()
{
	String[] result;
	result=db.allPersons();
	return result;
}


/*

public  String allPerson()
{
	String result;
	result=db.allPerson();
	return result;
}

*/


public String updatePinfo(String fname,String lname,String address,String city,String state,String zipcode,String memberid,String country)
{
String result;
result=db.updatePinfo(fname,lname,address,city,state,zipcode,memberid,country);
return result;
}






public String[] searchPerson(String fname,String lname,String mtype,String address,String city,String state,String zipcode,String memberid,String country)
{
	String[] result;
	result=db.searchPerson(fname,lname,mtype,address,city,state,zipcode,memberid,country);
	return result;
}



public String[] searchMovie(String moviename, String moviebanner, String category, String reldate)
{
	String[] result;
	result=db.searchMovie(moviename,moviebanner,category,reldate);
	return result;
}



public String[] personDetails(String memberid)
{
	String[] result;
	result=db.personDetails(memberid);
	return result;
}




public String simpletableupdation(String cardnum,String cvv,String memberid, String[] movieorder,String date)
{
	String result;
	
	
	result=db.simpletableupdation(cardnum,cvv,memberid, movieorder, date);
			return result;
}

public String premiumtableupdation(String memberid, String[] movieorder,String date)
{
	String result;
	
	result=db.premiumtableupdation(memberid, movieorder, date);
			return result;
}



public String movieDetails(String movieid)
{
	String result;
	result=db.movieDetails(movieid);
	return result;
}




public String movieCount(String memberid)

{
	String result;
	result=db.movieCount(memberid);
	return result;
}

public String delMovies(String movieid)
{
	String result;
	result=db.delMovies(movieid);
	return result;
}





}
