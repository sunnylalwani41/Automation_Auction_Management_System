package automation_auction.model;

public class Seller {
	private int sid;
	private String sFirstName;
	private String sLastName;
	private String sEmail;
	private String spassword;
	private String smobile;
	private String sdod;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getsFirstName() {
		return sFirstName;
	}
	public void setsFirstName(String sFirstName) {
		this.sFirstName = sFirstName;
	}
	public String getsLastName() {
		return sLastName;
	}
	public void setsLastName(String sLastName) {
		this.sLastName = sLastName;
	}
	public String getsEmail() {
		return sEmail;
	}
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	public String getSmobile() {
		return smobile;
	}
	public void setSmobile(String smobile) {
		this.smobile = smobile;
	}
	public String getSdod() {
		return sdod;
	}
	public void setSdod(String sdod) {
		this.sdod = sdod;
	}
	@Override
	public String toString() {
		return "Seller [sid=" + sid + ", sFirstName=" + sFirstName + ", sLastName=" + sLastName + ", sEmail=" + sEmail
				+ ", spassword=" + spassword + ", smobile=" + smobile + ", sdod=" + sdod + "]";
	}
	public Seller() {
		super();
	}
	

}
