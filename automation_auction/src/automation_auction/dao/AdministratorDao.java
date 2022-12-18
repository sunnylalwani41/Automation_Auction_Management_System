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
import automation_auction.model.DisputeBuyerToSellerWithTeamAndCategoryNameDTO;
import automation_auction.model.DisputeSellerToApp;
import automation_auction.model.DisputeSellerToAppWithTeamNameDto;
import automation_auction.model.Seller;
import automation_auction.model.Selling_Item;
import automation_auction.model.Sold;

public interface AdministratorDao {
	
	public Administrator loginAdministrator(String username, String password) throws AdministratorException;
	
	public String changePasswordAdmin(String username, String password) throws AdministratorException;
	
	public List<Buyer> listOfBuyers() throws BuyerException;
	
	public List<Seller> listOfSeller() throws SellerException;
	
	public List<DisputeBuyerToSellerWithTeamAndCategoryNameDTO> disputeListBuyerToSeller() throws DisputeException;
	
	public List<DisputeSellerToAppWithTeamNameDto> disputeListSellerToApp() throws DisputeException;
	
	public List<Sold> SoldItemListDatewise() throws ItemException;
	
	public List<DisputeBuyerToSellerWithTeamAndCategoryNameDTO> solvedDisputeListBuyerToSeller() throws DisputeException;
	
	public List<DisputeSellerToAppWithTeamNameDto> solvedDisputeListSellerToApp() throws DisputeException;
	
}
