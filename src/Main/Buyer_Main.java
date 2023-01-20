package Main;

import Custom_Colors.Colors;
import UseCases.BuyerLogin_UseCase;
import UseCases.BuyerRegister_UseCase;
import UseCases.ViewAllBuyer;
import UseCases.ViewAllBuyer_UseCase;
import UseCases.buyerViewAllItems_UseCase;
import UseCases.selectItem_UseCase;

public class Buyer_Main {

	public static  boolean buyerLoginMain() {
		
		BuyerLogin_UseCase bu = new BuyerLogin_UseCase();
		
		boolean res = bu.buyerLogin();
		
		return res;

	}
	
	public static void buyerDashBoard() {
		
		System.out.println(Colors.GREEN_BACKGROUND+"Press 1 View All the Items"+Colors.RESET);
		System.out.println();
		System.out.println(Colors.RED_BACKGROUND+"Press 2 Selects Items to buy"+Colors.RESET);
		
		System.out.println();
		System.out.println(Colors.RED_BACKGROUND+"Press 3 View all the buyers and also their Items category wise"+Colors.RESET);
	
		System.out.println();
		System.out.println(Colors.RED_BACKGROUND+"Press 4 For LogOut"+Colors.RESET);
	
	}

	public static void registerBuyer() {
		BuyerRegister_UseCase bru = new BuyerRegister_UseCase();
		
		bru.registerBuyer();
	}
	
	public static void viewItems() {
		
		buyerViewAllItems_UseCase vs = new buyerViewAllItems_UseCase();
		vs.ViewAllItem();
		
	}
	
	public static void buyItem() {
		selectItem_UseCase cs = new selectItem_UseCase();
		
		cs.selectProduct();
		
	}
	
	public static void checkAllbuyer() {
		ViewAllBuyer vs = new ViewAllBuyer();
		
		vs.AllBuyerDetails();
	}
	
	
}
