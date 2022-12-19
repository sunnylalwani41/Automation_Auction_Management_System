package automation_auction.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import automation_auction.Exception.AdministratorException;
import automation_auction.Exception.ItemException;
import automation_auction.Exception.SellerException;
import automation_auction.model.Administrator;
import automation_auction.model.Seller;
import automation_auction.model.Selling_Item;
import automation_auction.model.Sold;
import automation_auction.utility.DBUtil;

public class SellerDaoImpl implements SellerDao{

	@Override
	public String registerSeller(Seller seller) throws SellerException {
		String message = "This email account already exist ...";
		
		try (Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into seller (sFirstName, sLastName, semail, spassword, smobile, sdod) values(?, ?, ?, ?, ?, ?)");
			
			ps.setString(1, seller.getsFirstName());
			
			ps.setString(2, seller.getsLastName());
			
			ps.setString(3, seller.getsEmail());
			
			ps.setString(4, seller.getSpassword());
			
			ps.setString(5, seller.getSmobile());
			
			ps.setDate(6, seller.getSdod());
			
			int x = ps.executeUpdate();
			
			if(x> 0 ) {
				message= "Seller successfully register ...";
			}
			else {
				throw new SellerException(message);
			}
			
		} catch (SQLException e) {
			throw new SellerException(e.getMessage());
		}
		
		
		return message;
	}

	@Override
	public Seller loginBySeller(String username, String password) throws SellerException {
		Seller seller= null;
		
		try (Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("select * from Seller where semail = ? AND spassword = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();

			if(rs.next()) {
				seller= new Seller();
				seller.setSid(rs.getInt("sid"));
				seller.setsFirstName(rs.getString("sFirstName"));
				seller.setsLastName(rs.getString("sLastName"));
				seller.setsEmail(rs.getString("semail"));
				seller.setSpassword(rs.getString("spassword"));
				
				seller.setSmobile(rs.getString("smobile"));
				seller.setSdod(rs.getDate("sdod"));
			}
			else {
				throw new SellerException("Invalid username or password..."); 
			}
			
		} catch (SQLException e) {
			throw new SellerException(e.getMessage());
		}
		
		return seller;
	}

	@Override
	public String resetPasswordBySeller(String username, String password) throws SellerException {
		String message = "Email/username does not exist ...";
		
		try (Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update seller set spassword = ? where semail = ?");
			
			ps.setString(1, password);
			
			ps.setString(2, username);
			
			int x = ps.executeUpdate();
			
			if(x > 0 ) {
				message= "Password successfully reset, login again ...";
			}
			else {
				throw new SellerException(message);
			}
			
		} catch (SQLException e) {
			throw new SellerException(e.getMessage());
		}
		
		
		return message;
	}

	@Override
	public String resetUsernameBySeller(String sFirstName, String username, Date dob, String mobile) throws SellerException {
		String message = "Email/username already exist ...";
		
		try (Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update seller set semail= ? where sFirstName= ? AND sdod= ? AND smobile = ?");
			
			ps.setString(1, username);
			
			ps.setString(2, sFirstName);
			
			ps.setDate(3, dob);
			
			ps.setString(4, mobile);
						
			int x = ps.executeUpdate();
			
			if(x> 0 ) {
				message= "Email/username successfully reset ...";
			}
			else {
				throw new SellerException(message);
			}
			
		} catch (SQLException e) {
			throw new SellerException(e.getMessage());
		}
		
		
		return message;
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

	@Override
	public String ChangePasswordBySeller(String username, String password) throws SellerException {
String message = "Password can not change ...";
		
		try (Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update seller set spassword = ? where semail = ?");
			
			ps.setString(1, password);
			
			ps.setString(2, username);
			
			int x = ps.executeUpdate();
			
			if(x > 0 ) {
				message= "Password successfully change ...";
			}
			else {
				throw new SellerException(message);
			}
			
		} catch (SQLException e) {
			throw new SellerException(e.getMessage());
		}
		
		
		return message;
	}

}
