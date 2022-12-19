package automation_auction.model;

public class AuctionTable {
	private int auctionId;
	private int bid;
	private int auctionPrice;
	public AuctionTable() {
		super();
	}
	public int getAuctionId() {
		return auctionId;
	}
	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getAuctionPrice() {
		return auctionPrice;
	}
	public void setAuctionPrice(int auctionPrice) {
		this.auctionPrice = auctionPrice;
	}
	@Override
	public String toString() {
		return "AuctionTable [auctionId=" + auctionId + ", bid=" + bid + ", auctionPrice=" + auctionPrice + "]";
	}
	
}
