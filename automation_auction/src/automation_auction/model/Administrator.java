package automation_auction.model;

import java.sql.Date;

public class Administrator {
	private int aid;
	private String aFirstName;
	private String aLastName;
	private String aemail;
	private String apassword;
	private String amobile;
	private Date adod;
	public Administrator() {
		super();
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getaFirstName() {
		return aFirstName;
	}
	public void setaFirstName(String aFirstName) {
		this.aFirstName = aFirstName;
	}
	public String getaLastName() {
		return aLastName;
	}
	public void setaLastName(String aLastName) {
		this.aLastName = aLastName;
	}
	public String getAemail() {
		return aemail;
	}
	public void setAemail(String aemail) {
		this.aemail = aemail;
	}
	public String getApassword() {
		return apassword;
	}
	public void setApassword(String apassword) {
		this.apassword = apassword;
	}
	public String getAmobile() {
		return amobile;
	}
	public void setAmobile(String amobile) {
		this.amobile = amobile;
	}
	public Date getAdod() {
		return adod;
	}
	public void setAdod(Date adod) {
		this.adod = adod;
	}
	@Override
	public String toString() {
		return "Administrator [aid=" + aid + ", aFirstName=" + aFirstName + ", aLastName=" + aLastName + ", aemail="
				+ aemail + ", apassword=" + apassword + ", amobile=" + amobile + ", adod=" + adod + "]";
	}
	
	
}
