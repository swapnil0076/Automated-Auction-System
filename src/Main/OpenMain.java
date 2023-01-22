package Main;

import java.util.Scanner;

import Custom_Colors.Colors;
import Exception.BadInput;
import UseCases.AdminSignIn_UseCase;

public class OpenMain {

	public static void FirstMain() throws BadInput{
		
		
		
		
			
			Scanner s = new Scanner(System.in);
			
			System.out.println("Welcome to the Automated Auction System ");
			System.out.println();
			
			System.out.println( Colors.GREEN_BACKGROUND+Colors.RED_BRIGHT+"| Please Chose the Option from Below Tables of LogIn/SignUp |\n"
					+ "+----------------------------------------------+\r\n"
					+ "| Press 1 for Login As Admin                     \n"
					+ "|Press 2 for Login As Buyer                       \n"
					+ "|Press 3 for Register As Buyer                   \n"
					+" |Press 4 for Login As Seller                        \n"
					+ "|Press 5 for Register As Seller                    \n"
					+ "+----------------------------------------------+\r\n"+Colors.RESET);
			System.out.println();
			
			
			String number = s.nextLine();
			
			if(number.equals("1")) {
				Admin_Main as = new Admin_Main();
				
				boolean result = as.AdminLogin();
				
				
				if(result) {
					while(true) {
						Admin_Main.AdminControlOption();
						
						String choose = s.nextLine();
						
						if(choose.equals("1")) {
							Admin_Main.buyerList();
						}else if(choose.equals("2")) {
							Admin_Main.sellerList();
						}else if(choose.equals("3")) {
							Admin_Main.dailyselling();
						}else if(choose.equals("4")) {
							break;
						}
						else {
							System.out.println("Enter the Correct Input");
						}
							
						
						
					}
					FirstMain();
				}
				FirstMain();
			}
			else if(number.equals("2")) {
				Buyer_Main bm = new Buyer_Main();
				boolean res = bm.buyerLoginMain();
				
				
				
				
				
				if(res) {
					while(true) {
						Buyer_Main.buyerDashBoard();
						String choose = s.nextLine();
						
						if(choose.equals("1")) {
							bm.viewItems();
						}else if(choose.equals("2")) {
							bm.buyItem();
						}else if(choose.equals("3")) {
							bm.checkAllbuyer();
						}else if(choose.equals("4")) {
							System.out.println("Main Menu");
							break;
						}else {
							System.out.println("Choose the Correct Input from 1 to 4"); 
						}
						
					}
					
					FirstMain();
				}
				FirstMain();
				
			}
			else if(number.equals("3")) {
				Buyer_Main bm = new Buyer_Main();
				bm.registerBuyer();
				
				bm.buyerDashBoard();
				
			}
			else if(number.equals("4")) {
				Seller_Main bm = new Seller_Main();
				boolean res = bm.SellerLoginMain();
				
				
				
				
				
				if(res) {
					while(true) {
						Seller_Main.SellerDashBoard();
						String choose = s.nextLine();
						
						if(choose.equals("1")) {
							bm.sellItems();
						}else if(choose.equals("2")) {
							bm.updateItem();
						}else if(choose.equals("3")) {
							bm.AddIten();
						}else if(choose.equals("4")){
							bm.DeleteItemProduct();
						}else if(choose.equals("5")){
							bm.soldHistory();;
						}else if(choose.equals("6")){
							System.out.println("Go back to Login Dashboard");
							break;
							
						}else {
							System.out.println("Choose the Correct Input from 1 to 6"); 
						}
						
						FirstMain();
						
					}
					FirstMain();
				}
				
			}
			else if(number.equals("5")) {
				Seller_Main bm = new Seller_Main();
				 bm.registerSeller();
				 System.out.println("+--------------------------------------------------------------------+");
				System.out.println();
				System.out.println("Choose Option 4 for SignIn");
				System.out.println();
				 FirstMain();
				 
			}
		
		
	}
	
	public static void main(String[] args) {
		try {
			FirstMain();
		} catch (BadInput e) {
			
			e.printStackTrace();
		}
	}
	
}
