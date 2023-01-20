package UseCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DAO.SellerDAO;
import DAO.SellerDAO_impl;
import Exception.SellerException;
import Models.OrderHistory;

public class soldHistory_UseCase {

	public static void main(String[] args) {
		soldItemsHistory();

	}
	
	public static void soldItemsHistory() {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the Seller ID");
		int sellerId = s.nextInt();
		
		List<OrderHistory> list = new ArrayList<>();
		
		SellerDAO sda = new SellerDAO_impl();
		
		try {
			list = sda.soldHistory(sellerId);
			
			list.forEach(i ->{
				
				System.out.println();
				System.out.println("Product Id - "+i.getProductId());
				System.out.println("Product Name - "+i.getProductName());
				System.out.println("Product CategoryId - "+i.getCategoryId());
				System.out.println("Seller Id  - "+i.getSellerId());
				System.out.println("Buyer Id - "+i.getBuyerId());
				System.out.println(" Date of Sold - "+i.getDate());
				
				System.out.println();
				System.out.println("+----------------------------------------------------+");
				
			});
			
		} catch (SellerException e) {
			
			e.printStackTrace();
		}
		
	}

}
