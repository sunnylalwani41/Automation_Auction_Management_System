package automation_auction.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import automation_auction.Exception.BuyerException;
import automation_auction.Exception.ItemException;
import automation_auction.Exception.SellerException;
import automation_auction.model.Buyer;
import automation_auction.model.Buyer_Item;
import automation_auction.model.Seller;
import automation_auction.model.Selling_Item;
import automation_auction.utility.DBUtil;

public class BuyerDaoImpl implements BuyerDao{

	@Override
	public String registerBuyer(Buyer buyer) throws BuyerException {
		String message = "Buyer`s email is already registered.";
		
		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into buyer (bFirstName, bLastName, bemail, bpassword, bmobile, bdod) values(?, ?, ?, ?, ?, ?)");
			
			ps.setString(1, buyer.getbFirstName());
			ps.setString(2, buyer.getbLastName());
			ps.setString(3, buyer.getBemail());
			ps.setString(2, buyer.getBpassword());
			ps.setString(2, buyer.getBmobile());
			ps.setDate(2, buyer.getBdod());
			
			int x = ps.executeUpdate();
			if(x > 0) {
				message = "Buyer successfully register...";
			}
			else {
				throw new BuyerException(message);
			}
			
		} catch (SQLException e) {
			throw new BuyerException(e.getMessage());
		}

		return message;
	}

	@Override
	public Buyer loginBuyer(String username, String password) throws BuyerException {
		Buyer buyer= null;
		
		try (Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("select * from Buyer where bemail = ? AND bpassword = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();

			if(rs.next()) {
				buyer= new Buyer();
				buyer.setBid(rs.getInt("bid"));
				buyer.setbFirstName(rs.getString("bFirstName"));
				buyer.setbLastName(rs.getString("bLastName"));
				buyer.setBemail(rs.getString("bemail"));
				buyer.setBpassword(rs.getString("bpassword"));
				buyer.setBmobile(rs.getString("bmobile"));
				buyer.setBdod(rs.getDate("bdod"));
			}
			else {
				throw new BuyerException("Invalid username or password..."); 
			}
			
		} catch (SQLException e) {
			throw new BuyerException(e.getMessage());
		}
		
		return buyer;
	}

	@Override
	public String resetPasswordByBuyer(String username, String password) throws BuyerException {
		String message = "Email/username does not exist ...";
		
		try (Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update buyer set bpassword = ? where bemail = ?");
			
			ps.setString(1, password);
			
			ps.setString(2, username);
			
			int x = ps.executeUpdate();
			
			if(x > 0 ) {
				message= "Password successfully reset, login again ...";
			}
			else {
				throw new BuyerException(message);
			}
			
		} catch (SQLException e) {
			throw new BuyerException(e.getMessage());
		}
		
		
		return message;
	}

	@Override
	public String resetUsernameByBuyer(String firstName, String username, Date dob, String mobile) throws BuyerException {
		String message = "Email/username already exist ...";
		
		try (Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update buyer set bemail= ? where bFirstName= ? AND bdod= ? AND bmobile = ?");
			
			ps.setString(1, username);
			
			ps.setString(2, firstName);
			
			ps.setDate(3, dob);
			
			ps.setString(4, mobile);
						
			int x = ps.executeUpdate();
			
			if(x > 0 ) {
				message= "Email/username successfully reset ...";
			}
			else {
				throw new BuyerException(message);
			}
			
		} catch (SQLException e) {
			throw new BuyerException(e.getMessage());
		}
		
		
		return message;
	}

	@Override
	public Map<Integer, Selling_Item> SearchItemByName(String itemName) throws ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, Selling_Item> SearchItemByCategory(String categoryName) throws ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, Selling_Item> viewAllItem() throws ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, Buyer_Item> listOfBuyerAndItemCategoryWise() throws BuyerException, ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Selling_Item selectItemWithBuyerList(Map<Integer, Buyer_Item> listBuyerAndItem, int index)
			throws ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectItemToBuy(Selling_Item item) throws ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changePasswordByBuyer(String username, String updatePassword) throws BuyerException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
