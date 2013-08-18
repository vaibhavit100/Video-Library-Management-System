package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import services.VideoLibraryManagement;

public class VideoLibraryManagementTest {

	VideoLibraryManagement video;
	VideoLibraryManagement videoLibraryManagement;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		videoLibraryManagement=new VideoLibraryManagement();
		video= new VideoLibraryManagement();
	}

	@After
	public void tearDown() throws Exception {
		video=null;
		videoLibraryManagement=null;
	}

	@Test
	public void testMovieName() {
		fail("Not yet implemented");
	}

	@Test
	public void testMovieIssue() {
		fail("Not yet implemented");
	}

	@Test
	public void testPersonDetail() {
		fail("Not yet implemented");
	}

	@Test
	public void testMovieProfile() {
		fail("Not yet implemented");
	}


	@Test
	public void test1SignIn() {
	//String result="false:Validation failed";
	String result="Invalid Input";
	System.out.println("starting 000000000"); 
	String res=video.signIn("", null);
	System.out.println("value is"+res);
	//assertEquals(result,res);
    assertTrue(result==res);

	}

	
	
	@Test
	public void test2SignIn() {

		String result="Invalid Input";
		  String res =video.signIn("","");
			System.out.println("-----------------"+res);

	        assertTrue(result==res);
	}
	@Test
	public void test3SignIn() 
	{
		//String result="false:Validation failed";
		String res=video.signIn("test","test");
		System.out.println(res);

		assertTrue(res=="false:Validation failed");

	}

	@Test
	public void testUpdateMinfo() {
		//updateMinfo(String movieid,String moviename, String moviebanner, String category,String releasedate, String mcopies)
		String movied="10003";
		String moviename="vijayThuppaki";
		String moviebanner="gproductions";
		String Category="action";
		String reldate="2012-11-11 12:31:44";
		String mcopies="6";
		String expectedresult="true";
		String resultobtained=videoLibraryManagement.updateMinfo(movied,moviename,moviebanner,Category,reldate,mcopies);
		System.out.println("---------------------->"+resultobtained);

		assertTrue(resultobtained=="true");
		
		//fail("Not yet implemented");
	}
	@Test
	public void testUpdateMinforNeg() {
		//updateMinfo(String movieid,String moviename, String moviebanner, String category,String releasedate, String mcopies)
		String movied="10113";
		String moviename="vijayThuppaki";
		String moviebanner="gproductions";
		String Category="action";
		String reldate="2012-11-11 12:31:44";
		String mcopies="6";
		String expectedresult="true";
		String resultobtained=videoLibraryManagement.updateMinfo(movied,moviename,moviebanner,Category,reldate,mcopies);
		System.out.println("---------------------->"+resultobtained);

		assertTrue(resultobtained=="false:Updation failed");
		
		//fail("Not yet implemented");
	}

	@Test
	public void testUpdateLoggedInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateMembers() {
		
		
		String fname="a";
		String lname="a";
		String mtype="a";
		String address="a";
		String city="a";
		String state="a";
		String zipcode="1";	
		String memberid="181-11-1111";
		String mdate="2012-11-11 12:31:44";
		String country="USA";
		String email="a@gmadiil.com";
		String password="a";
		String logintime="2012-11-11 12:31:44";
		String expectedresult="true";
		String resultobtained=videoLibraryManagement.createMembers(fname, lname, mtype, address, city, state, zipcode, memberid, mdate, country, email, password, logintime);
		System.out.println("---------------------->"+resultobtained);

		assertTrue(resultobtained=="true");
		
		//fail("Not yet implemented");
	}
	@Test
	public void testCreateMembersNeg() {
		
		
		String fname="a";
		String lname="a";
		String mtype="a";
		String address="a";
		String city="a";
		String state="a";
		String zipcode="1";	
		String memberid="191-11-1111";
		String mdate="2012-11-11 12:31:44";
		String country="USA";
		String email="a@gmadiil.com";
		String password="a";
		String logintime="2012-11-11 12:31:44";
		String expectedresult="true";
		String resultobtained=videoLibraryManagement.createMembers(fname, lname, mtype, address, city, state, zipcode, memberid, mdate, country, email, password, logintime);
		System.out.println("---------------------->"+resultobtained);

		assertTrue(resultobtained=="duplicateid");
		
		//fail("Not yet implemented");
	}
	@Test
	public void testCreateMembersNeg2() {
		
		
		String fname="a";
		String lname="a";
		String mtype="a";
		String address="a";
		String city="a";
		String state="a";
		String zipcode="1";	
		String memberid="196-11-1781";
		String mdate="2012-11-11 12:31:44";
		String country="USA";
		String email="a@gmadiil.com";
		String password="a";
		String logintime="2012-11-11 12:31:44";
		String expectedresult="duplicateemail";
		String resultobtained=videoLibraryManagement.createMembers(fname, lname, mtype, address, city, state, zipcode, memberid, mdate, country, email, password, logintime);
		System.out.println("---------for neg 2------------->"+resultobtained);

		assertTrue(resultobtained=="duplicateemail");
		
		//fail("Not yet implemented");
	}
	@Test
	public void test1Delmember() {
		String result="Invalid Input";
		String res=video.delmember("");
		System.out.println(res);
		assertTrue(result==res);
}

	@Test
	public void test2Delmember() {
		String result="false:Deletion failed";
		String res=video.delmember("000123456");
		System.out.println(res);
		assertTrue(result==res);
		}

	@Test
	public void testCreateMoviesNeg() {
	String moviename=null;
	String moviebanner="gproductions";
	String Category="action";
	String reldate="2012-11-11 12:31:44";
	int mcopies=6;
	String resultobtained=videoLibraryManagement.createMovies(moviename,moviebanner,Category,reldate,mcopies);
	System.out.println("------FOR CREATE MOVIES---------------->"+resultobtained);

	assertTrue(resultobtained=="received null");
			//fail("Not yet implemented");
	}
	@Test
	public void testCreateMovies() {
	String moviename="thuppaki";
	String moviebanner="gproductions";
	String Category="action";
	String reldate="2012-11-11 12:31:44";
	int mcopies=6;
	String resultobtained=videoLibraryManagement.createMovies(moviename,moviebanner,Category,reldate,mcopies);
	System.out.println("------FOR CREATE MOVIES---------------->"+resultobtained);

	assertTrue(resultobtained=="true");
			//fail("Not yet implemented
	}

	@Test
	public void testRentMovie() {
		fail("Not yet implemented");
	}

	@Test
	public void testPayment() {
		fail("Not yet implemented");
	}

	@Test
	public void testReturnMovie() {
		fail("Not yet implemented");
	}


	@Test
	public void test1Returnmovofmember() {
		String result="Invalid Input";
		String res=video.returnmovofmember("");
		System.out.println(res);
		assertTrue(result==res);
}
		

	
	@Test
	public void test2Returnmovofmember() {
		String result="false:Deletion failed";
		String res=video.returnmovofmember("000123456");
		System.out.println(res);
		assertTrue(result==res);
		}
	

	@Test
	public void testPMembers() {
		fail("Not yet implemented");
	}

	@Test
	public void testSMembers() {
		fail("Not yet implemented");
	}

	@Test
	public void testAllMovies() {
		fail("Not yet implemented");
	}

	@Test
	public void testAllPersons() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdatePinfo() {
		
		String fname="a";
		String lname="a";
		String mtype="a";
		String address="a";
		String city="a";
		String state="a";
		String zipcode="1";	
		String memberid="100000001";
		String mdate="2012-11-11 12:31:44";
		String country="USA";
		String email="a@gmadiil.com";
		String password="a";
		String logintime="2012-11-11 12:31:44";
		String expectedresult="duplicateemail";
		String resultobtained=videoLibraryManagement.updatePinfo(fname,lname,address,city,state,zipcode,memberid,country);
		System.out.println("------FOR UPDATE PINFO---------------->"+resultobtained);

		assertTrue(resultobtained=="true");
		//fail("Not yet implemented");
	}
	
	@Test
	public void testUpdatePinfoNeg() {
		
		String fname="a";
		String lname="a";
		String mtype="a";
		String address="a";
		String city="a";
		String state="a";
		String zipcode="1";	
		String memberid="1800000001";
		String mdate="2012-11-11 12:31:44";
		String country="USA";
		String email="a@gmadiil.com";
		String password="a";
		String logintime="2012-11-11 12:31:44";
		String expectedresult="duplicateemail";
		String resultobtained=videoLibraryManagement.updatePinfo(fname,lname,address,city,state,zipcode,memberid,country);
		System.out.println("------FOR UPDATE PINFO---------------->"+resultobtained);

		assertTrue(resultobtained=="false:Updation failed");
		//fail("Not yet implemented");
	}

	@Test
	public void testSearchPerson() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchMovie() {
		fail("Not yet implemented");
	}

	@Test
	public void testPersonDetails() {
		fail("Not yet implemented");
	}

	@Test
	public void testSimpletableupdation() {
		fail("Not yet implemented");
	}

	@Test
	public void testPremiumtableupdation() {
		fail("Not yet implemented");
	}

	@Test
	public void testMovieDetails() {
		fail("Not yet implemented");
	}

	@Test
	public void testMovieCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelMovies() {
		fail("Not yet implemented");
	}

}
