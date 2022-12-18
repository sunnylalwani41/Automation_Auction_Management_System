package automation_auction.model;

import java.sql.Date;

public class DisputeBuyerToSellerWithTeamAndCategoryNameDTO {
	private int did;
	private int bid;
	private String distputDetail;
	private Date dDate;
	private int sid;
	private Date solutionDate;
	private boolean IsSolve;
	 
	private String cname;
	private String DTname;
	
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getDistputDetail() {
		return distputDetail;
	}
	public void setDistputDetail(String distputDetail) {
		this.distputDetail = distputDetail;
	}
	public Date getdDate() {
		return dDate;
	}
	public void setdDate(Date dDate) {
		this.dDate = dDate;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public Date getSolutionDate() {
		return solutionDate;
	}
	public void setSolutionDate(Date solutionDate) {
		this.solutionDate = solutionDate;
	}
	public boolean isIsSolve() {
		return IsSolve;
	}
	public void setIsSolve(boolean isSolve) {
		IsSolve = isSolve;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getDTname() {
		return DTname;
	}
	public void setDTname(String dTname) {
		DTname = dTname;
	}
	public DisputeBuyerToSellerWithTeamAndCategoryNameDTO() {
		super();
	}
	@Override
	public String toString() {
		return "DisputeBuyerToSellerWithTeamAndCategoryNameDTO [did=" + did + ", bid=" + bid + ", distputDetail="
				+ distputDetail + ", dDate=" + dDate + ", sid=" + sid + ", solutionDate=" + solutionDate + ", IsSolve="
				+ IsSolve + ", cname=" + cname + ", DTname=" + DTname + "]";
	}
	
	
}
