package automation_auction.model;

import java.sql.Date;

public class DisputeBuyerToSeller {
	private int did;
	private int bid;
	private int cid;
	private String distputDetail;
	private Date dDate;
	private int sid;
	private Date solutionDate;
	private boolean IsSolve;
	public DisputeBuyerToSeller() {
		super();
	}
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
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
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
	@Override
	public String toString() {
		return "DisputeBuyerToSeller [did=" + did + ", bid=" + bid + ", cid=" + cid + ", distputDetail=" + distputDetail
				+ ", dDate=" + dDate + ", sid=" + sid + ", solutionDate=" + solutionDate + ", IsSolve=" + IsSolve + "]";
	}
	
	
}
