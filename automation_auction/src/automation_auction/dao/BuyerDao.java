package automation_auction.dao;

import java.util.Map;

import javax.xml.catalog.CatalogException;

import automation_auction.Exception.BuyerException;
import automation_auction.Exception.ItemException;
import automation_auction.model.Buyer;
import automation_auction.model.Buyer_Item;
import automation_auction.model.Selling_Item;

public interface BuyerDao {
	
	public String registerBuyer(Buyer buyer) throws BuyerException;
	
	public Buyer loginBuyer(String username, String password) throws BuyerException;
	
	public String resetPasswordByBuyer(String username, String dob) throws BuyerException;
	
	public String resetUsernameByBuyer(String bFirstName,String bLastName, String mobile, String dob) throws BuyerException;
	
	public Map<Integer, Selling_Item> SearchItemByName (String itemName) throws ItemException;
	
	public Map<Integer, Selling_Item> SearchItemByCategory (String categoryName) throws ItemException;
	
	public Map<Integer, Selling_Item> viewAllItem() throws ItemException;
	
	public Map<Integer, Buyer_Item> listOfBuyerAndItemCategoryWise() throws BuyerException, ItemException;
	
	public Selling_Item selectItemWithBuyerList(Map<Integer, Buyer_Item> listBuyerAndItem, int index) throws ItemException;
	
	public String selectItemToBuy(Selling_Item item) throws ItemException;
	
}
