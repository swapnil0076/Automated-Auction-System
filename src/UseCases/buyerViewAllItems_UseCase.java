package UseCases;

import java.util.ArrayList;
import java.util.List;

import Custom_Colors.Colors;
import DAO.BuyerDAO;
import DAO.BuyerDAO_impl;
import Exception.buyerException;
import Models.Seller_Sold_Items;

public class buyerViewAllItems_UseCase {

	public static void main(String[] args) {
		
		ViewAllItem();

		
	}
	
	public static void ViewAllItem() {
		
		
		List<Seller_Sold_Items> ssd = new ArrayList<>();
		
		BuyerDAO bd = new BuyerDAO_impl();
		
		try {
			ssd =  bd.ViewAllItems();
			
			ssd.forEach(s ->{
				
				System.out.println(Colors.PURPLE_BACKGROUND + "Product Id -: "+s.getProductId());
				System.out.println(Colors.PURPLE_BACKGROUND + "Product Name -: "+s.getProductName());
				System.out.println(Colors.PURPLE_BACKGROUND + "Seller Id -: "+s.getSellerId());
				System.out.println(Colors.PURPLE_BACKGROUND + "CategoryId -: "+s.getCategoryId());
				System.out.println(Colors.PURPLE_BACKGROUND + "Price -: "+s.getPrice()+Colors.RESET);
				System.out.println();
				
				System.out.println(Colors.RED+"+====================================+"+Colors.RESET);
				
				
			});
			
		} catch (buyerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
