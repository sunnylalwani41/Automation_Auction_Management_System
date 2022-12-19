package automation_auction.model;

public class Buyer_Item {
	private int bid;
	private String bFirstName;
	private String bLastName;
	private int autionID;
	private int sid;
	private int cid;
	private String ItemDate;
	private int sellingPrice;
	private String item_detail;
	private int item_quantity;
	private String auctionAddress;
	private String auctionDate;
	private int noOfBuyerAuction;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getbFirstName() {
		return bFirstName;
	}
	public void setbFirstName(String bFirstName) {
		this.bFirstName = bFirstName;
	}
	public String getbLastName() {
		return bLastName;
	}
	public void setbLastName(String bLastName) {
		this.bLastName = bLastName;
	}
	public int getAutionID() {
		return autionID;
	}
	public void setAutionID(int autionID) {
		this.autionID = autionID;
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
	public String getItemDate() {
		return ItemDate;
	}
	public void setItemDate(String itemDate) {
		ItemDate = itemDate;
	}
	public int getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public String getItem_detail() {
		return item_detail;
	}
	public void setItem_detail(String item_detail) {
		this.item_detail = item_detail;
	}
	public int getItem_quantity() {
		return item_quantity;
	}
	public void setItem_quantity(int item_quantity) {
		this.item_quantity = item_quantity;
	}
	public String getAuctionAddress() {
		return auctionAddress;
	}
	public void setAuctionAddress(String auctionAddress) {
		this.auctionAddress = auctionAddress;
	}
	public String getAuctionDate() {
		return auctionDate;
	}
	public void setAuctionDate(String auctionDate) {
		this.auctionDate = auctionDate;
	}
	public int getNoOfBuyerAuction() {
		return noOfBuyerAuction;
	}
	public void setNoOfBuyerAuction(int noOfBuyerAuction) {
		this.noOfBuyerAuction = noOfBuyerAuction;
	}
	public Buyer_Item() {
		super();
	}
	@Override
	public String toString() {
		return "Buyer_Item [bid=" + bid + ", bFirstName=" + bFirstName + ", bLastName=" + bLastName + ", autionID="
				+ autionID + ", sid=" + sid + ", cid=" + cid + ", ItemDate=" + ItemDate + ", sellingPrice="
				+ sellingPrice + ", item_detail=" + item_detail + ", item_quantity=" + item_quantity
				+ ", auctionAddress=" + auctionAddress + ", auctionDate=" + auctionDate + ", noOfBuyerAuction="
				+ noOfBuyerAuction + "]";
	}
	
}
