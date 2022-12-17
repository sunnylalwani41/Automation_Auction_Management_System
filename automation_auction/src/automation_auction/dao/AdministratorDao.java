package automation_auction.dao;

import java.util.List;

import automation_auction.Exception.AdministratorException;
import automation_auction.Exception.BuyerException;
import automation_auction.Exception.DisputeException;
import automation_auction.Exception.ItemException;
import automation_auction.Exception.SellerException;
import automation_auction.model.Administrator;
import automation_auction.model.Buyer;
import automation_auction.model.DisputeBuyerToSeller;
import automation_auction.model.DisputeSellerToApp;
import automation_auction.model.Seller;
import automation_auction.model.Selling_Item;

public interface AdministratorDao {
	
	public Administrator loginAdministrator(String username, String password) throws AdministratorException;
	
	public List<Buyer> listOfBuyers() throws BuyerException;
	
	public List<Seller> listOfSeller() throws SellerException;
	
	public List<DisputeBuyerToSeller> disputeListBuyerToSeller() throws DisputeException;
	
	public List<DisputeSellerToApp> disputeListSellerToApp() throws DisputeException;
	
	public List<Selling_Item> listOfItemsForSell() throws ItemException;
	
	public List<DisputeBuyerToSeller> solvedDisputeListBuyerToSeller() throws DisputeException;
	
	public List<DisputeSellerToApp> solvedDisputeListSellerToApp() throws DisputeException;
	
}
