package automation_auction.dao;

import java.util.List;

import automation_auction.Exception.SellerException;
import automation_auction.Exception.ItemException;
import automation_auction.model.Seller;
import automation_auction.model.Selling_Item;
import automation_auction.model.Sold;

public interface SellerDao {
	public String registerSeller(Seller seller)throws SellerException;
	
	public Seller loginBySeller(String username, String password) throws SellerException;
	
	public String resetPasswordBySeller (String username, String dob) throws SellerException;
	
	public String resetUsernameBySeller (String sFirstName, String sLastName, String dob, String mobile) throws SellerException;
	
	public String addListOfItems(List<Selling_Item> list) throws ItemException;
	
	public String updateItemPrice(int auctionId, int updatePrice) throws ItemException;
	
	public String updateItemQuantity(int auctionId, int itemQuantity) throws ItemException;
	
	public String updateItemPriceAndQuantity(int auctionId, int updatePrice, int itemQuantity) throws ItemException;
	
	public String addItemInTheList(Selling_Item item) throws ItemException;
	
	public String removeItemFromTheList(int auctionId) throws ItemException;
	
	public List<Sold> soldItemList() throws ItemException;
	
}
