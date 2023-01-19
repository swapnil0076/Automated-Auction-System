package UseCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Custom_Colors.Colors;
import DAO.SellerDAO;
import DAO.SellerDAO_impl;
import Exception.SellerException;
import Models.Seller_Sold_Items;

public class AddItem_UseCase {

	public static void main(String[] args) {
		
		addItem();

	}
	
	public static void addItem() {
		
		Scanner s = new Scanner(System.in);
		
		
		
		System.out.println("Enter the Product Name");
		String name = s.nextLine();
		
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
				
				
				System.out.println("Enter the seller Id");
				int sId = s.nextInt();
			
				System.out.println("Enter the price of the Product");
				int price = s.nextInt();
				
				SellerDAO sd = new SellerDAO_impl();
				
				Seller_Sold_Items sst = new Seller_Sold_Items(catId,sId,name, price);
				
				
				
				try {
					String str = sd.AddProduct(sst);
					System.out.println(str);
					
				} catch (SellerException e) {
				
					e.printStackTrace();
				}
				
		
	}

}
