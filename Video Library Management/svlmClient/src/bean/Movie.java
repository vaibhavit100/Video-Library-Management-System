package bean;
//Movie pojo used to store and retrieve movie details.
public class Movie {
	String movid;
	String movname;
	String movbanner;
	String relesedate;
	String rentamount;
	String category;
	String copiesno;
	String noofcopies;
	public String getNoofcopies() {
		return noofcopies;
	}
	public void setNoofcopies(String noofcopies) {
		this.noofcopies = noofcopies;
	}
	public String getMovid() {
		return movid;
	}
	public void setMovid(String movid) {
		this.movid = movid;
	}
	public String getMovname() {
		return movname;
	}
	public void setMovname(String movname) {
		this.movname = movname;
	}
	public String getMovbanner() {
		return movbanner;
	}
	public void setMovbanner(String movbanner) {
		this.movbanner = movbanner;
	}
	public String getRelesedate() {
		return relesedate;
	}
	public void setRelesedate(String relesedate) {
		this.relesedate = relesedate;
	}
	public String getRentamount() {
		return rentamount;
	}
	public void setRentamount(String rentamount) {
		this.rentamount = rentamount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCopiesno() {
		return copiesno;
	}
	public void setCopiesno(String copiesno) {
		this.copiesno = copiesno;
	}
}
