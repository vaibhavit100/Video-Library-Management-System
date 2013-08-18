package bean;

public class moviesbean {
	
	String movid;
	String movname;
	String movbanner;
    String releasedate;
	String rentamount;
	String category;
	String noofcopies;

	
	public String getmovid() {
		return movid;
	}

	public void setmovid(String movid) {
		this.movid = movid;
	}	
		
	public String getmovname() {
			return movname;
		}

	public void setmovname(String movname) {
			this.movname = movname;		
	}
	
	public String getmovbanner() {
		    return movbanner;
	}
	
	public void setmovbanner(String movbanner) {
			this.movbanner = movbanner;		
	}

    public void setreleasedate(String releasedate) {
		    this.releasedate = releasedate;		
    }
	
    public String getreleasedate() {
		    return releasedate;
	}

   
    public String getrentamount() {
		return rentamount;
	}

	public void setrentamount(String rentamount) {
		this.rentamount = rentamount;
	}
	
	public String getcategory() {
		return category;
	}

	public void setcategory(String category) {
		this.category = category;

	}	
	
	public String getnoofcopies() {
		return noofcopies;
	}

	public void setnoofcopies(String noofcopies) {
		this.noofcopies = noofcopies;
	}	
	
}
