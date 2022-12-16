package automation_auction.model;

public class DisputeSellerToApp {
	private int did;
	private int sid;
	private int cid;
	private String distputDetail;
	private String dDate;
	private int disputeAssignToSolve;
	private String solutionDate;
	private boolean IsSolve;
	public DisputeSellerToApp() {
		super();
	}
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
	public String getdDate() {
		return dDate;
	}
	public void setdDate(String dDate) {
		this.dDate = dDate;
	}
	public int getDisputeAssignToSolve() {
		return disputeAssignToSolve;
	}
	public void setDisputeAssignToSolve(int disputeAssignToSolve) {
		this.disputeAssignToSolve = disputeAssignToSolve;
	}
	public String getSolutionDate() {
		return solutionDate;
	}
	public void setSolutionDate(String solutionDate) {
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
				+ ", dDate=" + dDate + ", disputeAssignToSolve=" + disputeAssignToSolve + ", solutionDate="
				+ solutionDate + ", IsSolve=" + IsSolve + "]";
	}
	
}
