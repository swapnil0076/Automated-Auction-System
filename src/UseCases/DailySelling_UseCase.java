package UseCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Custom_Colors.Colors;
import DAO.AdminDAO;
import DAO.adminDAO_impl;
import Exception.AdminException;
import Models.Seller_Sold_Items;

public class DailySelling_UseCase {

	public static void main(String[] args) {
		
DailySelling();
	}
	
	public static void DailySelling() {
		
		List<Seller_Sold_Items> list = new ArrayList<>();
		
		AdminDAO ds = new adminDAO_impl();
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Date of ");
		String str = s.next();
		
		try {
			list = ds.DailySellingReport(str);
			
			list.forEach(n ->{
				System.out.println(Colors.BLUE+"Buyer Id -->"+n.getBuyerId());
				System.out.println("Buyer Name  -->"+n.getBuyerName());
				System.out.println("Buyer Email  -->"+n.getEmail());
				System.out.println("Product Id  -->"+n.getProductId());
				System.out.println("Seller Id  -->"+n.getSellerId());
				System.out.println("Product Name  -->"+n.getProductName());
				System.out.println("Seller Name  -->"+n.getSellerName());
				System.out.println("Price -->"+n.getPrice());
				
				System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="+Colors.RESET);
				
			});
			
		} catch (AdminException e) {
			e.printStackTrace();
		}
		
		
	}

}
