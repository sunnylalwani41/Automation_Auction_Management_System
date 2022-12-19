package automation_auction.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		
		List<Buyer> buyers = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from buyer");
			
			ResultSet rs= ps.executeQuery();
			boolean flag= true;
			while(rs.next()) {
				flag= false;
				Buyer buyer = new Buyer();
				buyer.setBid(rs.getInt("bid"));
				buyer.setbFirstName(rs.getString("bFirstName"));
				buyer.setbLastName(rs.getString("bLastName"));
				buyer.setBemail(rs.getString("bemail"));
				buyer.setBpassword(rs.getString("bpassword"));
				buyer.setBmobile(rs.getString("bmobile"));
				buyer.setBdod(rs.getDate("bdod"));
				buyers.add(buyer);
			}
			if(flag) {
				throw new BuyerException("Buyer information is not present...");
			}
		} catch (SQLException e) {
			throw new BuyerException(e.getMessage());
		}
		
		
		return buyers;
	}

	@Override
	public List<Seller> listOfSeller() throws SellerException {
		List<Seller> sellers = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from seller");
			
			ResultSet rs= ps.executeQuery();
			boolean flag= true;
			while(rs.next()) {
				flag= false;
				Seller seller = new Seller();
				seller.setSid(rs.getInt("sid"));
				seller.setsFirstName(rs.getString("sFirstName"));
				seller.setsLastName(rs.getString("sLastName"));
				seller.setsEmail(rs.getString("semail"));
				seller.setSpassword(rs.getString("spassword"));
				seller.setSmobile(rs.getString("smobile"));
				seller.setSdod(rs.getDate("sdod"));
				sellers.add(seller);
			}
			if(flag) {
				throw new SellerException("Buyer information is not present...");
			}
		} catch (SQLException e) {
			throw new SellerException(e.getMessage());
		}
		
		
		return sellers;
	}

	@Override
	public List<DisputeBuyerToSellerWithTeamAndCategoryNameDTO> disputeListBuyerToSeller() throws DisputeException {
		List<DisputeBuyerToSellerWithTeamAndCategoryNameDTO> dispute = new ArrayList<>(); 
		
		try (Connection conn = DBUtil.provideConnection()){

			PreparedStatement ps = conn.prepareStatement("select s.did, s.bid, s.sid, c.cname, s.disputeDetail, s.dDate, s.solutionDate, s.IsSolve, t.DTname from buyer_to_seller s INNER JOIN disputTeam t INNER JOIN category c ON s.cid = t.cid AND s.cid = c.cid AND s.IsSolve = false");
			
			ResultSet rs= ps.executeQuery();
			boolean flag= true;
			
			
			while(rs.next()) {
				flag= false;
				DisputeBuyerToSellerWithTeamAndCategoryNameDTO buyertoSeller = new DisputeBuyerToSellerWithTeamAndCategoryNameDTO();
				buyertoSeller.setDid(rs.getInt("did"));
				
				buyertoSeller.setBid(rs.getInt("bid"));
				
				buyertoSeller.setSid(rs.getInt("sid"));
				
				buyertoSeller.setCname(rs.getString("cname"));
				
				buyertoSeller.setDistputDetail(rs.getString("disputeDetail"));
				
				buyertoSeller.setdDate(rs.getDate("dDate"));
				
				buyertoSeller.setSolutionDate(rs.getDate("solutionDate"));
				
				buyertoSeller.setIsSolve(rs.getBoolean("isSolve"));
				
				buyertoSeller.setDTname(rs.getString("DTname"));
				
				dispute.add(buyertoSeller);
			}
			if(flag) {
				throw new DisputeException("Any dispute is not avaliable ...");
			}
		} catch (SQLException e) {
			throw new DisputeException(e.getMessage());
		}
		return dispute;
	}

	@Override
	public List<DisputeSellerToAppWithTeamNameDto> disputeListSellerToApp() throws DisputeException {
		List<DisputeSellerToAppWithTeamNameDto> dispute = new ArrayList<>();
		try (Connection conn = DBUtil.provideConnection()){

			PreparedStatement ps = conn.prepareStatement("select s.did, s.sid, s.cid, s.distputDetail, s.dDate, s.solutionDate, s.IsSolve, t.DTname from seller_app s INNER JOIN disputTeam t ON s.cid = t.cid AND s.IsSolve = false");
			
			ResultSet rs= ps.executeQuery();
			boolean flag= true;
			while(rs.next()) {
				flag= false;
				DisputeSellerToAppWithTeamNameDto sellerdto = new DisputeSellerToAppWithTeamNameDto();
				sellerdto.setDid(rs.getInt("did"));
				
				sellerdto.setSid(rs.getInt("sid"));
				
				sellerdto.setCid(rs.getInt("cid"));
				
				sellerdto.setDistputDetail(rs.getString("disputDetail"));
				
				sellerdto.setdDate(rs.getDate("dDate"));
				
				sellerdto.setSolutionDate(rs.getDate("solutionDate"));
				
				sellerdto.setIsSolve(rs.getBoolean("isSolve"));
				
				sellerdto.setDTname(rs.getString("DTname"));
				
				dispute.add(sellerdto);
			}
			if(flag) {
				throw new DisputeException("Any dispute is not avaliable ...");
			}
		} catch (SQLException e) {
			throw new DisputeException(e.getMessage());
		}
		
		
		return dispute;
	}


	@Override
	public List<DisputeBuyerToSellerWithTeamAndCategoryNameDTO> solvedDisputeListBuyerToSeller() throws DisputeException {
		List<DisputeBuyerToSellerWithTeamAndCategoryNameDTO> dispute = new ArrayList<>(); 
		
		try (Connection conn = DBUtil.provideConnection()){

			PreparedStatement ps = conn.prepareStatement("select s.did, s.bid, s.sid, c.cname, s.disputeDetail, s.dDate, s.solutionDate, s.IsSolve, t.DTname from buyer_to_seller s INNER JOIN disputTeam t INNER JOIN category c ON s.cid = t.cid AND s.cid = c.cid AND s.IsSolve = true");
			
			ResultSet rs= ps.executeQuery();
			boolean flag= true;
			
			
			while(rs.next()) {
				flag= false;
				DisputeBuyerToSellerWithTeamAndCategoryNameDTO buyertoSeller = new DisputeBuyerToSellerWithTeamAndCategoryNameDTO();
				
				buyertoSeller.setDid(rs.getInt("did"));
				
				buyertoSeller.setBid(rs.getInt("bid"));
				
				buyertoSeller.setSid(rs.getInt("sid"));
				
				buyertoSeller.setCname(rs.getString("cname"));
				
				buyertoSeller.setDistputDetail(rs.getString("disputeDetail"));
				
				buyertoSeller.setdDate(rs.getDate("dDate"));
				
				buyertoSeller.setSolutionDate(rs.getDate("solutionDate"));
				
				buyertoSeller.setIsSolve(rs.getBoolean("isSolve"));
				
				buyertoSeller.setDTname(rs.getString("DTname"));
				
				dispute.add(buyertoSeller);
			}
			if(flag) {
				throw new DisputeException("Any dispute is not avaliable ...");
			}
		} catch (SQLException e) {
			throw new DisputeException(e.getMessage());
		}
		return dispute;
	}

	@Override
	public List<DisputeSellerToAppWithTeamNameDto> solvedDisputeListSellerToApp() throws DisputeException {
		List<DisputeSellerToAppWithTeamNameDto> dispute = new ArrayList<>();
		try (Connection conn = DBUtil.provideConnection()){

			PreparedStatement ps = conn.prepareStatement("select s.did, s.sid, s.cid, s.distputDetail, s.dDate, s.solutionDate, s.IsSolve, t.DTname from seller_app s INNER JOIN disputTeam t ON s.cid = t.cid AND s.IsSolve = true");
			
			ResultSet rs= ps.executeQuery();
			boolean flag= true;
			while(rs.next()) {
				flag= false;
				DisputeSellerToAppWithTeamNameDto sellerdto = new DisputeSellerToAppWithTeamNameDto();
				sellerdto.setDid(rs.getInt("did"));
				
				sellerdto.setSid(rs.getInt("sid"));
				
				sellerdto.setCid(rs.getInt("cid"));
				
				sellerdto.setDistputDetail(rs.getString("disputDetail"));
				
				sellerdto.setdDate(rs.getDate("dDate"));
				
				sellerdto.setSolutionDate(rs.getDate("solutionDate"));
				
				sellerdto.setIsSolve(rs.getBoolean("isSolve"));
				
				sellerdto.setDTname(rs.getString("DTname"));
				
				dispute.add(sellerdto);
			}
			if(flag) {
				throw new DisputeException("Any dispute is not avaliable ...");
			}
		} catch (SQLException e) {
			throw new DisputeException(e.getMessage());
		}
		
		
		return dispute;
	}

	@Override
	public String changePasswordAdmin(String username, String password) throws AdministratorException {
		String message = "Password can not change...";
		
		try (Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("update administrator set apassword = ? where aemail= ?");
			
			
			ps.setString(1, password);
			ps.setString(2, username);
			
			int x= ps.executeUpdate();
//			 
			if(x> 0) {
				message = "Password change successfully...";
			}
			else {
				throw new AdministratorException(message); 
			}
			
		} catch (SQLException e) {
			throw new AdministratorException(e.getMessage());
		}
		
		
		return message;
	}

	
	@Override
	public List<Sold> SoldItemListDatewise() throws ItemException {
		List<Sold> soldReport = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){

			PreparedStatement ps = conn.prepareStatement("select * from sold order by auctionDate desc");
			
			ResultSet rs= ps.executeQuery();
			boolean flag= true;
			while(rs.next()) {
				flag= false;
				Sold sold = new Sold();
				sold.setAuctionid(rs.getInt("auctionid"));
				
				sold.setSid(rs.getInt("sid"));
				
				sold.setBid(rs.getInt("bid"));
				
				sold.setCid(rs.getInt("cid"));
				
				sold.setItem_detail(rs.getString("item_detail"));
				
				sold.setItem_quantity(rs.getInt("item_quantity"));
				
				sold.setItemDate(rs.getDate("ItemDate"));
				
				sold.setSellingPrice(rs.getInt("sellingPrice"));
				
				sold.setAuctionPrice(rs.getInt("auctionPrice"));
				
				sold.setAuctionAddress(rs.getString("auctionAddress"));
				
				sold.setAuctionDate(rs.getDate("auctionDate"));
				
				soldReport.add(sold);
			}
			if(flag) {
				throw new ItemException("No items sold yet !!");
			}
		} catch (SQLException e) {
			throw new ItemException(e.getMessage());
		}
		
		
		return soldReport;
	}

}
