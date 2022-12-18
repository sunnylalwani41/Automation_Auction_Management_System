package automation_auction.model;

import java.sql.Date;

public class Buyer {
	private int bid;
	private String bFirstName;
	private String bLastName;
	private String bemail;
	private String bpassword;
	private String bmobile;
	private Date bdod;
	
	@Override
	public String toString() {
		return "Buyer [bid=" + bid + ", bFirstName=" + bFirstName + ", bLastName=" + bLastName + ", bemail=" + bemail
				+ ", bpassword=" + bpassword + ", bmobile=" + bmobile + ", bdod=" + bdod + "]";
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getbFirstName() {
		return bFirstName;
	}

	public void setbFirstName(String bFirstName) {
		this.bFirstName = bFirstName;
	}

	public String getbLastName() {
		return bLastName;
	}

	public void setbLastName(String bLastName) {
		this.bLastName = bLastName;
	}

	public String getBemail() {
		return bemail;
	}

	public void setBemail(String bemail) {
		this.bemail = bemail;
	}

	public String getBpassword() {
		return bpassword;
	}

	public void setBpassword(String bpassword) {
		this.bpassword = bpassword;
	}

	public String getBmobile() {
		return bmobile;
	}

	public void setBmobile(String bmobile) {
		this.bmobile = bmobile;
	}

	public Date getBdod() {
		return bdod;
	}

	public void setBdod(Date bdod) {
		this.bdod = bdod;
	}

	public Buyer() {
		super();
	}
	
	

}
