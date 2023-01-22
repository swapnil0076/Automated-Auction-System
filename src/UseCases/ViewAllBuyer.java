package UseCases;


import java.util.ArrayList;
import java.util.List;

import Custom_Colors.Colors;
import DAO.BuyerDAO;
import DAO.BuyerDAO_impl;
import Exception.buyerException;
import Models.Seller_Sold_Items;

public class ViewAllBuyer {

	public static void main(String[] args) {
		
		AllBuyerDetails();
		

	}
	
	public static void AllBuyerDetails() {
		
		List<Seller_Sold_Items> gs = new ArrayList<>();
		
	 BuyerDAO bs = new BuyerDAO_impl();
	 
	 try {
		gs = bs.viewAllBuyer();
		
		gs.forEach(s ->{
			
			System.out.println(Colors.GREEN);
			System.out.println( "  ProductID -=> "+s.getProductId());
			
			System.out.println(" Product Name -="+ s.getProductName());
			System.out.println("  Category Id -="+ s.getCategoryId());
			System.out.println(" Category Name -="+ s.getCategoryName());
            System.out.println(" Seller ID -="+ s.getSellerId());
            System.out.println("  Seller Name  -="+ s.getSellerName());
            System.out.println(" Buyer Name  -="+s.getBuyerName());
            System.out.println("Price -="+s.getPrice());
            System.out.println("Date of Buy -="+ s.getDate()+Colors.RESET);
            
            System.out.println();
            System.out.println(Colors.ORANGE+"=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-"+Colors.RESET);
			
		});
		
	} catch (buyerException e) {
	
		e.printStackTrace();
	}
		
		
	}

}
