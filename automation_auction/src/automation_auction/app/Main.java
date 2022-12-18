package automation_auction.app;

import java.util.List;
import java.util.Scanner;

import automation_auction.Exception.AdministratorException;
import automation_auction.Exception.BuyerException;
import automation_auction.Exception.DisputeException;
import automation_auction.Exception.ItemException;
import automation_auction.Exception.SellerException;
import automation_auction.colour.JavaConsoleColor;
import automation_auction.dao.AdministratorDao;
import automation_auction.dao.AdministratorDaoImpl;
import automation_auction.dao.BuyerDao;
import automation_auction.dao.BuyerDaoImpl;
import automation_auction.dao.SellerDao;
import automation_auction.dao.SellerDaoImpl;
import automation_auction.model.Administrator;
import automation_auction.model.Buyer;
import automation_auction.model.DisputeBuyerToSellerWithTeamAndCategoryNameDTO;
import automation_auction.model.DisputeSellerToApp;
import automation_auction.model.DisputeSellerToAppWithTeamNameDto;
import automation_auction.model.Seller;
import automation_auction.model.Sold;

public class Main {
	
	private static AdministratorDao admin;
	private static BuyerDao buyer;
	private static SellerDao seller;
	
	
	public static Administrator adminProfile;
	public static Buyer buyerProfile;
	public static Seller sellerProfile;
	
	static {
		System.out.println("+----------------------------------------------+"+JavaConsoleColor.BLUE);
		System.out.println("|**********************************************|");
		System.out.println("|********"+ JavaConsoleColor.BOLDON+ " Hellow Welcome to Auction 41 "+ JavaConsoleColor.BOLDOFF+JavaConsoleColor.BLUE +"********|");
		System.out.println("|**********************************************|" + JavaConsoleColor.RESET);
		System.out.println("+----------------------------------------------+");
		
		admin= new AdministratorDaoImpl();
		buyer = new BuyerDaoImpl();
		seller = new SellerDaoImpl();
		
	};
	public static void main(String[] args) {
		
		System.out.println("\n" +JavaConsoleColor.BOLDON+ "Please press following number:- who are you? " +JavaConsoleColor.BOLDOFF+"\n");
		
		System.out.println("1. Are you Administrator..");
		System.out.println("2. Are you Seller..");
		System.out.println("3. Are you Buyer..");
		System.out.println("4. Exit");
		
		
		
		Scanner sc = new Scanner(System.in);
		int num= sc.nextInt();
		sc.nextLine();

		
		switch(num){
		
			case 1:{
					while(true) {
						System.out.println("Enter username/email: ");
						String username=sc.nextLine();
						
						System.out.println("Enter password : ");
						String password = sc.nextLine();
						
						try {
							adminProfile = admin.loginAdministrator(username, password);
							System.out.print("\n Welcome Administrator "+adminProfile.getaFirstName());
							if(adminProfile.getaLastName()!=null) {
								System.out.println(" "+adminProfile.getaLastName());
							}
							else {
								
								System.out.println();
							}
							break;
						} catch (AdministratorException e) {
							System.out.println(e.getMessage());
							System.out.println("Do you want exit: press 4, else press any key...");
							String ex= sc.nextLine();
							if(ex.equals("4")) {
								System.out.println("Thanking you for visiting...");
								return;
							}
						}
					}
					adminDashboard();
				}
			break;
		case 2:
				{
					
				}
				break;
				
			case 3:
				{
					
				}
				break;
				
			case 4:
				{
					System.out.println("Thanking you for visiting...");
					return;
				}
				
			default:
				System.out.println("Invalid number, try again ...");
				main(args);
				break;
//				i++;
//				if(i<5) {
				
				
//				}
//				else {
//					System.out.println("Thanking you for visiting bye bye...");
//				}
				
		}
	}
	public static void adminDashboard() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. View the registered buyer list.");
		System.out.println("2. View the registered seller list.");
		System.out.println("3. View the daily dispute report.");
		System.out.println("4. View the daily selling report.");
		System.out.println("5. Solved the dispute report.");
		System.out.println("6. Profile Setting..");
		System.out.println("7. LogOut And Exit");
		
		int num = sc.nextInt();
		sc.nextLine();
		
		switch(num) {
			case 1 : {
				
				try {
					List<Buyer> list = admin.listOfBuyers();
					System.out.println(" registered buyer list ....");
					list.forEach(l -> {
						System.out.println(JavaConsoleColor.BOLDON+" Buyer ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getBid()+JavaConsoleColor.RESET);
						System.out.println(JavaConsoleColor.BOLDON+" Buyer first Name is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getbFirstName()+JavaConsoleColor.RESET);
						System.out.println(JavaConsoleColor.BOLDON+" Buyer last Name is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getbLastName()+JavaConsoleColor.RESET);
						System.out.println(JavaConsoleColor.BOLDON+" Buyer email is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getBemail()+JavaConsoleColor.RESET);
						System.out.println(JavaConsoleColor.BOLDON+" Buyer mobile number is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getBmobile()+JavaConsoleColor.RESET);
						System.out.println(JavaConsoleColor.BOLDON+" Buyer date of birth is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getBdod()+JavaConsoleColor.RESET);
						System.out.println("===========================");
					});
				} catch (BuyerException e) {
					System.out.println(e.getMessage());
				}
				
				System.out.println("\n 1. Profile Setting..");
				System.out.println("2. Back");
				System.out.println("3. LogOut And Exit");
				int num2 = sc.nextInt();
				sc.nextLine();
				switch(num2) {
					case 1 : {
						adminProfileSetting();
						break;
					}
					case 2 : {
						adminDashboard();
						break;
					}
					case 3 : {
						System.out.println("Thanking you for visiting...");
						return;
						
					}
					default : {
						System.out.println("Invalid number, try again ...");
						adminDashboard();
						break;
					}
				}
				break;
			}
			case 2 : {
				try {
					List<Seller> list2 = admin.listOfSeller();
					System.out.println(" registered Seller list ....");
					list2.forEach(l -> {
						System.out.println(JavaConsoleColor.BOLDON+" Seller ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getSid()+JavaConsoleColor.RESET);
						System.out.println(JavaConsoleColor.BOLDON+" Seller first Name is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getsFirstName()+JavaConsoleColor.RESET);
						System.out.println(JavaConsoleColor.BOLDON+" Seller last Name is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getsLastName()+JavaConsoleColor.RESET);
						System.out.println(JavaConsoleColor.BOLDON+" Seller email is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getsEmail()+JavaConsoleColor.RESET);
						System.out.println(JavaConsoleColor.BOLDON+" Seller mobile number is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getSmobile()+JavaConsoleColor.RESET);
						System.out.println(JavaConsoleColor.BOLDON+" Seller date of birth is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getSdod()+JavaConsoleColor.RESET);
						System.out.println("===========================");
					});
				} catch (SellerException e) {
					System.out.println(e.getMessage());
				}
				
				System.out.println("\n 1. Profile Setting..");
				System.out.println("2. Back");
				System.out.println("3. LogOut And Exit");
				int num2 = sc.nextInt();
				sc.nextLine();
				switch(num2) {
					case 1 : {
						adminProfileSetting();
						break;
					}
					case 2 : {
						adminDashboard();
						break;
					}
					case 3 : {
						System.out.println("Thanking you for visiting...");
						return;
						
					}
					default : {
						System.out.println("Invalid number, try again ...");
						adminDashboard();
						break;
					}
				}
			}
			break;
			case 3 : {
				System.out.println("\n 1. Dispute list Seller to Application ..");
				System.out.println("2. Dispute list Buyer to Seller ..");
				System.out.println("3. Back");
				int num3= sc.nextInt();
				switch(num3) {
					case 1 : {
						try {
							List<DisputeSellerToAppWithTeamNameDto> list3 = admin.disputeListSellerToApp();
							System.out.println(" Dispute list Seller to Application ....");
							list3.forEach(l -> {
								System.out.println(JavaConsoleColor.BOLDON+" Dispute ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getDid()+JavaConsoleColor.RESET);
								
								System.out.println(JavaConsoleColor.BOLDON+" Dispute by Seller ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getSid()+JavaConsoleColor.RESET);
								System.out.println(JavaConsoleColor.BOLDON+" Category ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getCid()+JavaConsoleColor.RESET);
								System.out.println(JavaConsoleColor.BOLDON+" Dispute description is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getDistputDetail()+JavaConsoleColor.RESET);
								System.out.println(JavaConsoleColor.BOLDON+" Dispute registration date is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getdDate()+JavaConsoleColor.RESET);
								System.out.println(JavaConsoleColor.BOLDON+" Dispute solution except date is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getSolutionDate()+JavaConsoleColor.RESET);
								System.out.println(JavaConsoleColor.BOLDON+" Dispute status is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.isIsSolve()+JavaConsoleColor.RESET);
								System.out.println(JavaConsoleColor.BOLDON+" Dispute Assign to solve is by : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getDTname()+JavaConsoleColor.RESET);
								System.out.println("===========================");
							});
						} catch (DisputeException e) {
							System.out.println(e.getMessage());
						}
						
						System.out.println("\n 1. Profile Setting..");
						System.out.println("2. Back");
						System.out.println("3. LogOut And Exit");
						int num2 = sc.nextInt();
						sc.nextLine();
						switch(num2) {
							case 1 : {
								adminProfileSetting();
								break;
							}
							case 2 : {
								adminDashboard();
								break;
							}
							case 3 : {
								System.out.println("Thanking you for visiting...");
								return;
								
							}
							default : {
								System.out.println("Invalid number, try again ...");
								adminDashboard();
								break;
							}
						}
					}
					break;
					case 2 : {
						try {
							List<DisputeBuyerToSellerWithTeamAndCategoryNameDTO> list4 = admin.disputeListBuyerToSeller();
							
							
							
							System.out.println(" Dispute list of Buyer to Seller ....");
							list4.forEach(l -> {
								System.out.println(JavaConsoleColor.BOLDON+" Dispute ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getDid()+JavaConsoleColor.RESET);
								
								System.out.println(JavaConsoleColor.BOLDON+" Dispute by Buyer ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getBid()+JavaConsoleColor.RESET);
								
								if(l.getSid() != 0)
									System.out.println(JavaConsoleColor.BOLDON+"Dispute On Seller ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getSid()+JavaConsoleColor.RESET);
								
								System.out.println(JavaConsoleColor.BOLDON+"Dispute Category is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getCname()+JavaConsoleColor.RESET);
								
								System.out.println(JavaConsoleColor.BOLDON+" Dispute description is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getDistputDetail()+JavaConsoleColor.RESET);
								
								System.out.println(JavaConsoleColor.BOLDON+" Dispute registration date is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getdDate()+JavaConsoleColor.RESET);
								
								System.out.println(JavaConsoleColor.BOLDON+" Dispute solution except date is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getSolutionDate()+JavaConsoleColor.RESET);
								
								System.out.println(JavaConsoleColor.BOLDON+" Dispute status is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.isIsSolve()+JavaConsoleColor.RESET);
								
								System.out.println(JavaConsoleColor.BOLDON+" Dispute Assign to solve is by : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getDTname()+JavaConsoleColor.RESET);
								
								System.out.println("===========================");
							});
							
						} catch (DisputeException e) {
							System.out.println(e.getMessage());
						}
						
						System.out.println("\n 1. Profile Setting..");
						System.out.println("2. Back");
						System.out.println("3. LogOut And Exit");
						int num2 = sc.nextInt();
						sc.nextLine();
						switch(num2) {
							case 1 : {
								adminProfileSetting();
								break;
							}
							case 2 : {
								adminDashboard();
								break;
							}
							case 3 : {
								System.out.println("Thanking you for visiting...");
								return;
								
							}
							default : {
								System.out.println("Invalid number, try again ...");
								adminDashboard();
								break;
							}
						}
					}
					break;
					case 3 : {
						adminDashboard();
					}
					break;
					default : {
						System.out.println("Invalid number, try again ...");
						adminDashboard();
						
					}
					break;
				}

				
			}
			break;
			case 4 : {
				System.out.println(JavaConsoleColor.PURPLE + "+ ---------------------------- +" +JavaConsoleColor.RESET);
				System.out.println(JavaConsoleColor.RED + "|** Datewise Selling Report **|" +JavaConsoleColor.RESET);
				System.out.println(JavaConsoleColor.PURPLE + "+ ---------------------------- +" +JavaConsoleColor.RESET);
				try {
					List<Sold> list5= admin.SoldItemListDatewise();
					list5.forEach(l -> {
						System.out.println(JavaConsoleColor.BOLDON+" Auction ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getAuctionid()+JavaConsoleColor.RESET);
						
						System.out.println(JavaConsoleColor.BOLDON+" Seller ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getSid()+JavaConsoleColor.RESET);
						
						System.out.println(JavaConsoleColor.BOLDON+" Buyer ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getBid()+JavaConsoleColor.RESET);
											
						System.out.println(JavaConsoleColor.BOLDON+" Category ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getCid()+JavaConsoleColor.RESET);
						
						System.out.println(JavaConsoleColor.BOLDON+" Item Name is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getItem_detail()+JavaConsoleColor.RESET);
						
						System.out.println(JavaConsoleColor.BOLDON+" Item Quantity is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getItem_quantity()+JavaConsoleColor.RESET);
						
						System.out.println(JavaConsoleColor.BOLDON+" Item insert date by seller is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getItemDate()+JavaConsoleColor.RESET);
						
						System.out.println(JavaConsoleColor.BOLDON+" Item sold price is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getSellingPrice()+JavaConsoleColor.RESET);
						
						System.out.println(JavaConsoleColor.BOLDON+" Item Auction price is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getAuctionPrice()+JavaConsoleColor.RESET);
						
						System.out.println(JavaConsoleColor.BOLDON+" Item Auction address is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getAuctionAddress()+JavaConsoleColor.RESET);
						
						System.out.println(JavaConsoleColor.BOLDON+" Item sold date is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getAuctionDate()+JavaConsoleColor.RESET);
						
						System.out.println("===========================");
					});
				
				} catch (ItemException e) {
					System.out.println(e.getMessage());
				}
				
				System.out.println("\n 1. Profile Setting..");
				System.out.println("2. Back");
				System.out.println("3. LogOut And Exit");
				int num2 = sc.nextInt();
				sc.nextLine();
				switch(num2) {
					case 1 : {
						adminProfileSetting();
						break;
					}
					case 2 : {
						adminDashboard();
						break;
					}
					case 3 : {
						System.out.println("Thanking you for visiting...");
						return;
						
					}
					default : {
						System.out.println("Invalid number, try again ...");
						adminDashboard();
						break;
					}
				}
				
				
			}
			break;
			case 5 : {
				
				System.out.println("\n 1. Solve Dispute list Seller to Application ..");
				System.out.println("2. Solve Dispute list Buyer to Seller ..");
				System.out.println("3. Back");
				int num3= sc.nextInt();
				switch(num3) {
					case 1 : {
						try {
							
							
							List<DisputeSellerToAppWithTeamNameDto> list7 = admin.solvedDisputeListSellerToApp();
							System.out.println(" Solve Dispute list Seller to Application ....");
							list7.forEach(l -> {
								System.out.println(JavaConsoleColor.BOLDON+" Dispute ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getDid()+JavaConsoleColor.RESET);
								
								System.out.println(JavaConsoleColor.BOLDON+" Dispute by Seller ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getSid()+JavaConsoleColor.RESET);
								System.out.println(JavaConsoleColor.BOLDON+" Category ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getCid()+JavaConsoleColor.RESET);
								System.out.println(JavaConsoleColor.BOLDON+" Dispute description is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getDistputDetail()+JavaConsoleColor.RESET);
								System.out.println(JavaConsoleColor.BOLDON+" Dispute registration date is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getdDate()+JavaConsoleColor.RESET);
								System.out.println(JavaConsoleColor.BOLDON+" Dispute solution date is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getSolutionDate()+JavaConsoleColor.RESET);
								System.out.println(JavaConsoleColor.BOLDON+" Dispute status is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.isIsSolve()+JavaConsoleColor.RESET);
								System.out.println(JavaConsoleColor.BOLDON+" Dispute Assign to solve is by : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getDTname()+JavaConsoleColor.RESET);
								System.out.println("===========================");
							});
						} catch (DisputeException e) {
							System.out.println(e.getMessage());
						}
						
						System.out.println("\n 1. Profile Setting..");
						System.out.println("2. Back");
						System.out.println("3. LogOut And Exit");
						int num2 = sc.nextInt();
						sc.nextLine();
						switch(num2) {
							case 1 : {
								adminProfileSetting();
								break;
							}
							case 2 : {
								adminDashboard();
								break;
							}
							case 3 : {
								System.out.println("Thanking you for visiting...");
								return;
								
							}
							default : {
								System.out.println("Invalid number, try again ...");
								adminDashboard();
								break;
							}
						}
					}
					break;
					case 2 : {
						try {
							List<DisputeBuyerToSellerWithTeamAndCategoryNameDTO> list8 = admin.disputeListBuyerToSeller();
							
							
							
							System.out.println(" Solve Dispute list of Buyer to Seller ....");
							list8.forEach(l -> {
								System.out.println(JavaConsoleColor.BOLDON+" Dispute ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getDid()+JavaConsoleColor.RESET);
								
								System.out.println(JavaConsoleColor.BOLDON+" Dispute by Buyer ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getBid()+JavaConsoleColor.RESET);
								
								if(l.getSid() != 0)
									System.out.println(JavaConsoleColor.BOLDON+"Dispute On Seller ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getSid()+JavaConsoleColor.RESET);
								
								System.out.println(JavaConsoleColor.BOLDON+"Dispute Category is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getCname()+JavaConsoleColor.RESET);
								
								System.out.println(JavaConsoleColor.BOLDON+" Dispute description is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getDistputDetail()+JavaConsoleColor.RESET);
								
								System.out.println(JavaConsoleColor.BOLDON+" Dispute registration date is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getdDate()+JavaConsoleColor.RESET);
								
								System.out.println(JavaConsoleColor.BOLDON+" Dispute solution date is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getSolutionDate()+JavaConsoleColor.RESET);
								
								System.out.println(JavaConsoleColor.BOLDON+" Dispute status is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.isIsSolve()+JavaConsoleColor.RESET);
								
								System.out.println(JavaConsoleColor.BOLDON+" Dispute Assign to solve is by : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+l.getDTname()+JavaConsoleColor.RESET);
								
								System.out.println("===========================");
							});
							
						} catch (DisputeException e) {
							System.out.println(e.getMessage());
						}
						
						System.out.println("\n 1. Profile Setting..");
						System.out.println("2. Back");
						System.out.println("3. LogOut And Exit");
						int num2 = sc.nextInt();
						sc.nextLine();
						switch(num2) {
							case 1 : {
								adminProfileSetting();
								break;
							}
							case 2 : {
								adminDashboard();
								break;
							}
							case 3 : {
								System.out.println("Thanking you for visiting...");
								return;
								
							}
							default : {
								System.out.println("Invalid number, try again ...");
								adminDashboard();
								break;
							}
						}
					}
					break;
					case 3 : {
						adminDashboard();
					}
					break;
					default : {
						System.out.println("Invalid number, try again ...");
						adminDashboard();
						
					}
					break;
				}

			}
			break;
			case 6 : {
				adminProfileSetting();
			}
			break;
			case 7 : {
				System.out.println("Thanking you for visiting");
				return;
			}
			default:{
				System.out.println("Invalid Entry, try again...");
				adminDashboard();
			}
			break;
		}
	}
	public static void adminProfileSetting() {
		
		System.out.println(JavaConsoleColor.BOLDON+" Admin ID is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+adminProfile.getAid()+JavaConsoleColor.RESET);
		System.out.println(JavaConsoleColor.BOLDON+" Admin first Name is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+adminProfile.getaFirstName()+JavaConsoleColor.RESET);
		System.out.println(JavaConsoleColor.BOLDON+" Admin last Name is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+adminProfile.getaLastName()+JavaConsoleColor.RESET);
		System.out.println(JavaConsoleColor.BOLDON+" Admin email is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+adminProfile.getAemail()+JavaConsoleColor.RESET);
		System.out.println(JavaConsoleColor.BOLDON+" Admin mobile number is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+adminProfile.getAmobile()+JavaConsoleColor.RESET);
		System.out.println(JavaConsoleColor.BOLDON+" Admin date of birth is : "+JavaConsoleColor.BOLDOFF+JavaConsoleColor.CYAN+adminProfile.getAdod()+JavaConsoleColor.RESET);
		System.out.println("===========================");
				
		System.out.println("\n 1. Change Password..");
		System.out.println("2. Go to dashboard..");
		System.out.println("3. LogOut And Exit");
		Scanner sc = new Scanner(System.in);
		int num2 = sc.nextInt();
		
		sc.nextLine();
		switch(num2) {
			case 1 : {
				System.out.println("Enter your new password...");
				String password= sc.nextLine();
				try {
					String msg = admin.changePasswordAdmin(adminProfile.getAemail(), password);
					System.out.println(msg);
					System.out.println("===========================");
					
				} catch (AdministratorException e) {
					System.out.println(e.getMessage());
					System.out.println("===========================");
				}
				adminProfileSetting();
			}
			break;
			case 2 : {
				adminDashboard();
			}
			break;
			case 3 : {
				System.out.println("Thanking you for visiting...");
				return;
				
			}
			default : {
				System.out.println("Invalid number, try again ...");
			}
			break;
		}
	}
}