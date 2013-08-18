package bean;

import java.util.ArrayList;
import java.util.List;

public class moviecart {
	String movid;
	String movname;
	String movbanner;
	String relesedate;
	String category;
	String copiesno;
	static int numofitems=0;
	static List<moviecart> items=new ArrayList<moviecart>();
	public void setdetails(String mid,String mname,String mbanner,String reld,String cat,String nocop)
	{
		numofitems++;
		moviecart a=new moviecart();
		a.movid=mid;
		a.movname=mname;
		a.movbanner=mbanner;
		a.relesedate=reld;
		a.category=cat;
		a.copiesno=nocop;
		items.add(a);
	}
	public List<moviecart> getItems() {
		return items;
	}
	
	public void rmList(String mid)
	{
		System.out.println("--------------------------"+mid);
		for(int i=0;i<items.size();i++)
		{
			String id=items.get(i).getMovid();
			System.out.println("--------------------------"+id);
			if(id.equalsIgnoreCase(mid))
			{
				
				items.remove(i);
				numofitems--;
			}
		}
		
	}



	public void setItems(List<moviecart> items) {
		this.items = items;
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
