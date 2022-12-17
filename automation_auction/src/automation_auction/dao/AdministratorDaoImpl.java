package automation_auction.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import automation_auction.utility.DBUtil;

public class AdministratorDaoImpl implements AdministratorDao{

	@Override
	public Administrator loginAdministrator(String username, String password) throws AdministratorException {
		Administrator administrator= null;
		
		try (Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("select * from Administrator where aemail = ? AND apassword = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();
//			(aFirstName, aLastName, aemail, apassword, amobile, adod) 
			if(rs.next()) {
				administrator= new Administrator();
				administrator.setAid(rs.getInt("aid"));
				administrator.setaFirstName(rs.getString("aFirstName"));
				administrator.setaLastName(rs.getString("aLastName"));
				administrator.setAemail(rs.getString("aemail"));
				administrator.setApassword(rs.getString("apassword"));
				
				administrator.setAmobile(rs.getString("amobile"));
				administrator.setAdod(rs.getDate("adod"));
			}
			else {
				throw new AdministratorException("Invalid username or password..."); 
			}
			
		} catch (SQLException e) {
			throw new AdministratorException(e.getMessage());
		}
		
		return administrator;
	}

	@Override
	public List<Buyer> listOfBuyers() throws BuyerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seller> listOfSeller() throws SellerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DisputeBuyerToSeller> disputeListBuyerToSeller() throws DisputeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DisputeSellerToApp> disputeListSellerToApp() throws DisputeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Selling_Item> listOfItemsForSell() throws ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DisputeBuyerToSeller> solvedDisputeListBuyerToSeller() throws DisputeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DisputeSellerToApp> solvedDisputeListSellerToApp() throws DisputeException {
		// TODO Auto-generated method stub
		return null;
	}

}
