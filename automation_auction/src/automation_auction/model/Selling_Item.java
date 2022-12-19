package automation_auction.model;

import java.sql.Date;

public class Selling_Item {
	private int autionID;
	private int sid;
	private int cid;
	private Date ItemDate;
	private int sellingPrice;
	private String item_detail;
	private int item_quantity;
	private String auctionAddress;
	private Date auctionDate;
	private int noOfBuyerAuction;
	public Selling_Item() {
		super();
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
	public Date getItemDate() {
		return ItemDate;
	}
	public void setItemDate(Date itemDate) {
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
	public Date getAuctionDate() {
		return auctionDate;
	}
	public void setAuctionDate(Date auctionDate) {
		this.auctionDate = auctionDate;
	}
	public int getNoOfBuyerAuction() {
		return noOfBuyerAuction;
	}
	public void setNoOfBuyerAuction(int noOfBuyerAuction) {
		this.noOfBuyerAuction = noOfBuyerAuction;
	}
	@Override
	public String toString() {
		return "Selling_Item [autionID=" + autionID + ", sid=" + sid + ", cid=" + cid + ", ItemDate=" + ItemDate
				+ ", sellingPrice=" + sellingPrice + ", item_detail=" + item_detail + ", item_quantity=" + item_quantity
				+ ", auctionAddress=" + auctionAddress + ", auctionDate=" + auctionDate + ", noOfBuyerAuction="
				+ noOfBuyerAuction + "]";
	}
	
	
}
