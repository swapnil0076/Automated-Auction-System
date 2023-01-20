package Main;



import Custom_Colors.Colors;
import UseCases.AdminSignIn_UseCase;
import UseCases.ViewAllBuyer_UseCase;
import UseCases.ViewAllSellers_UseCase;

public class Admin_Main {

	public static boolean AdminLogin() {
		AdminSignIn_UseCase ad = new AdminSignIn_UseCase();
		
		boolean res = ad.adminLogin();
		return res;
	}
	
	public static void AdminControlOption() {
		
		System.out.println(Colors.PURPLE+"Press 1 to view the Buyer List ");
		System.out.println(Colors.PURPLE+"Press 2 to view the Seller List ");
		
	}
	
	public static void buyerList() {
		ViewAllBuyer_UseCase  vs =  new ViewAllBuyer_UseCase();
		
		vs.viewBuyerList();
	}
	
	public static void sellerList() {
		ViewAllSellers_UseCase vs = new ViewAllSellers_UseCase();
		vs.viewAllSellers();
	}
	
}
