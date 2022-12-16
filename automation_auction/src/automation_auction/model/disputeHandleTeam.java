package automation_auction.model;

public class disputeHandleTeam {
	private int DTid;
	private String DTname;
	private int cid;
	public int getDTid() {
		return DTid;
	}
	public void setDTid(int dTid) {
		DTid = dTid;
	}
	public String getDTname() {
		return DTname;
	}
	public void setDTname(String dTname) {
		DTname = dTname;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public disputeHandleTeam() {
		super();
	}
	@Override
	public String toString() {
		return "disputeHandleTeam [DTid=" + DTid + ", DTname=" + DTname + ", cid=" + cid + "]";
	}
	
}
