package Main;


import UseCases.AddItem_UseCase;
import UseCases.BuyerRegister_UseCase;
import UseCases.DeleteItem;
import UseCases.Product_Selling;
import UseCases.SellerLogin_UseCase;
import UseCases.SellerRegister;
import UseCases.UpdatePriceProduct_UseCase;
import UseCases.soldHistory_UseCase;

public class Seller_Main {

public static  boolean SellerLoginMain() {
		
		SellerLogin_UseCase bu = new SellerLogin_UseCase();
		
		boolean res = bu.SellerLogin();
		
		return res;

	}

public static void SellerDashBoard() {
	
	System.out.println("Press 1 Create list of items to sell");
	System.out.println("Press 2 Update Item price");
	System.out.println("Press 3 Add a Item to sell");
	System.out.println("Press 4 Remove items from your List");
	System.out.println("Press 5 for checking Sold History");
	System.out.println("presss 6 for go back to Main Page");
	
}

public static void registerSeller() {
	SellerRegister bru = new SellerRegister();
	
	bru.registerSeller();
}

public static void sellItems() {
	Product_Selling ps = new Product_Selling();
	ps.sell_Product();
}

public static void updateItem() {
	UpdatePriceProduct_UseCase ps = new UpdatePriceProduct_UseCase();
	ps.findTheProduct();
}

public static void AddIten() {
	AddItem_UseCase ad = new AddItem_UseCase();
	ad.addItem();
}

public static void DeleteItemProduct() {
	
	DeleteItem sd = new DeleteItem();
	
	sd.findTheProduct();;
	
}

public static void soldHistory() {
	soldHistory_UseCase sd = new soldHistory_UseCase();
	sd.soldItemsHistory();
}

}
