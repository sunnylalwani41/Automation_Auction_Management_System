package automation_auction.app;

import java.util.Scanner;

import automation_auction.Exception.AdministratorException;
import automation_auction.colour.JavaConsoleColor;
import automation_auction.dao.AdministratorDao;
import automation_auction.dao.AdministratorDaoImpl;
import automation_auction.dao.BuyerDao;
import automation_auction.dao.BuyerDaoImpl;
import automation_auction.dao.SellerDao;
import automation_auction.dao.SellerDaoImpl;
import automation_auction.model.Administrator;
import automation_auction.model.Buyer;
import automation_auction.model.Seller;

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
		
			case 1:
				{
					while(true) {
						System.out.println("Enter username/email: ");
						String username=sc.nextLine();
						
						System.out.println("Enter password : ");
						String password = sc.nextLine();
						
						try {
							adminProfile = admin.loginAdministrator(username, password);
							System.out.print("Welcome Administrator "+adminProfile.getaFirstName());
							if(adminProfile.getaLastName()!=null) {
								System.out.println(" "+adminProfile.getaLastName());
							}
							else {
								
								System.out.println();
							}
							break;
						} catch (AdministratorException e) {
							System.out.println(e.getMessage());
							System.out.println("Do you want exit: press 4, else any key");
							String ex= sc.nextLine();
							if(ex.equals("4")) {
								System.out.println("Thanking you for visiting...");
								return;
							}
						}
					}
					
					
					
					
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
				
			}
			case 2 : {
					
			}
			case 3 : {
		
			}
			case 4 : {
		
			}
			case 5 : {
		
			}
			case 6 : {
		
			}
			case 7 : {
				System.out.println("Thanking you for visiting");
				return;
			}
			default:{
				System.out.println("Invalid Entry, try again...");
			}
		}
	}
}