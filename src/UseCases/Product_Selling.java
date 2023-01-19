package UseCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Custom_Colors.Colors;
import DAO.SellerDAO;
import DAO.SellerDAO_impl;
import Exception.SellerException;
import Models.Seller_Sold_Items;

public class Product_Selling {

	public static void main(String[] args) {
		sell_Product();
	}
	
	public static void sell_Product() {
		
		Scanner s = new Scanner(System.in);
		List<Seller_Sold_Items> list = new ArrayList<>();
		System.out.println("Enter the Number of product  you want to Sell in the Auction");
		int n = s.nextInt();
		Seller_Sold_Items ss = new Seller_Sold_Items();
		for(int i=0;i<n;i++) {
			
			s.nextLine();
			System.out.println("Enter the Product Name");
			String name = s.nextLine();
			ss.setProductName(name);
			
			System.out.println(Colors.BANANA_YELLOW_BACKGROUND+Colors.GREEN+"Enter the Below CategoryId \n"
			+"+------------+-----------------+\r\n"
			+ "| categoryId | categoryName    |\r\n"
			+ "+------------+-----------------+\r\n"
			+ "|        101 | Vechicle        \r\n"
			+ "|        102 | Antique         \r\n"
			+ "|        103 | Alcohol         \r\n"
			+ "|        104 | Art             \r\n"
			+ "|        105 | Jewelry         \r\n"
			+ "|        106 | AutoGraph-items \r\n"
			+ "+------------+-----------------+"+Colors.RESET
					
					);
			int catId = s.nextInt();
			ss.setCategoryId(catId);
			
			System.out.println("Enter the seller Id");
			int sId = s.nextInt();
			ss.setSellerId(sId);
			
			System.out.println("Enter the price of the Product");
			int price = s.nextInt();
			ss.setPrice(price);
			
			list.add(ss);
			
		}
		SellerDAO dsa = new SellerDAO_impl();
		
	try {
		String str = dsa.SellProduct(list);
		System.out.println(str);
	} catch (SellerException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	
}
