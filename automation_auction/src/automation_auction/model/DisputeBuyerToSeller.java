package automation_auction.model;

public class DisputeBuyerToSeller {
	private int did;
	private int bid;
	private int cid;
	private String distputDetail;
	private String dDate;
	private int sid;
	private boolean technical_or_login_issue;
	private int disputeAssignToSolve;
	private String solutionDate;
	private boolean IsSolve;
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
	public String getdDate() {
		return dDate;
	}
	public void setdDate(String dDate) {
		this.dDate = dDate;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public boolean isTechnical_or_login_issue() {
		return technical_or_login_issue;
	}
	public void setTechnical_or_login_issue(boolean technical_or_login_issue) {
		this.technical_or_login_issue = technical_or_login_issue;
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
	public DisputeBuyerToSeller() {
		super();
	}
	@Override
	public String toString() {
		return "DisputeBuyerToSeller [did=" + did + ", bid=" + bid + ", cid=" + cid + ", distputDetail=" + distputDetail
				+ ", dDate=" + dDate + ", sid=" + sid + ", technical_or_login_issue=" + technical_or_login_issue
				+ ", disputeAssignToSolve=" + disputeAssignToSolve + ", solutionDate=" + solutionDate + ", IsSolve="
				+ IsSolve + "]";
	}
	
}
