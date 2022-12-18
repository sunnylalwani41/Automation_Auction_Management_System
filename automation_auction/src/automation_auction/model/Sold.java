package automation_auction.model;

import java.sql.Date;

public class Sold {
	private int auctionid;
	private int sid;
	private int bid;
	private int cid;
	private String item_detail;
	private int item_quantity;
	private Date ItemDate;
	private int sellingPrice;
	private int auctionPrice;
	private String auctionAddress;
	private Date auctionDate;
	
	public Sold() {
		super();
	}

	public int getAuctionid() {
		return auctionid;
	}

	public void setAuctionid(int auctionid) {
		this.auctionid = auctionid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
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

	public int getAuctionPrice() {
		return auctionPrice;
	}

	public void setAuctionPrice(int auctionPrice) {
		this.auctionPrice = auctionPrice;
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

	@Override
	public String toString() {
		return "Sold [auctionid=" + auctionid + ", sid=" + sid + ", bid=" + bid + ", cid=" + cid + ", item_detail="
				+ item_detail + ", item_quantity=" + item_quantity + ", ItemDate=" + ItemDate + ", sellingPrice="
				+ sellingPrice + ", auctionPrice=" + auctionPrice + ", auctionAddress=" + auctionAddress
				+ ", auctionDate=" + auctionDate + "]";
	}

	
	
}
