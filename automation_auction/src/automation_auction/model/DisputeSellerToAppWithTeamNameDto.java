package automation_auction.model;

import java.sql.Date;

public class DisputeSellerToAppWithTeamNameDto {
	private int did;
	private int sid;
	private int cid;
	private String distputDetail;
	private Date dDate;
	private Date solutionDate;
	private boolean IsSolve;
	
	private String DTname;

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

	public String getDTname() {
		return DTname;
	}

	public void setDTname(String dTname) {
		DTname = dTname;
	}

	@Override
	public String toString() {
		return "DisputeSellerToAppWithTeamNameDto [did=" + did + ", sid=" + sid + ", cid=" + cid + ", distputDetail="
				+ distputDetail + ", dDate=" + dDate + ", solutionDate=" + solutionDate + ", IsSolve=" + IsSolve
				+ ", DTname=" + DTname + "]";
	}

	public DisputeSellerToAppWithTeamNameDto() {
		super();
	}

	

	
}
