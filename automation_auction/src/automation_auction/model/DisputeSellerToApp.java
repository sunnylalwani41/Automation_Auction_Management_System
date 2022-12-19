package automation_auction.model;

import java.sql.Date;

public class DisputeSellerToApp {
	private int did;
	private int sid;
	private int cid;
	private String distputDetail;
	private Date dDate;

	private Date solutionDate;
	private boolean IsSolve;
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
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
		return "DisputeSellerToApp [did=" + did + ", sid=" + sid + ", cid=" + cid + ", distputDetail=" + distputDetail
				+ ", dDate=" + dDate + ", solutionDate=" + solutionDate + ", IsSolve=" + IsSolve + "]";
	}
	public DisputeSellerToApp() {
		super();
	}
	
	
}
