package automation_auction.dao;

import java.util.List;

import automation_auction.Exception.ItemException;
import automation_auction.Exception.SellerException;
import automation_auction.model.Seller;
import automation_auction.model.Selling_Item;
import automation_auction.model.Sold;

public class SellerDaoImpl implements SellerDao{

	@Override
	public String registerSeller(Seller seller) throws SellerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seller loginBySeller(String username, String password) throws SellerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String resetPasswordBySeller(String username, String dob) throws SellerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String resetUsernameBySeller(String sFirstName, String sLastName, String dob, String mobile)
			throws SellerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addListOfItems(List<Selling_Item> list) throws ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateItemPrice(int auctionId, int updatePrice) throws ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateItemQuantity(int auctionId, int itemQuantity) throws ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateItemPriceAndQuantity(int auctionId, int updatePrice, int itemQuantity) throws ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addItemInTheList(Selling_Item item) throws ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeItemFromTheList(int auctionId) throws ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sold> soldItemList() throws ItemException {
		// TODO Auto-generated method stub
		return null;
	}

}
