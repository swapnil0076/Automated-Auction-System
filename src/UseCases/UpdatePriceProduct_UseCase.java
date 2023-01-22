package UseCases;

import java.util.Scanner;

import DAO.SellerDAO;
import DAO.SellerDAO_impl;
import Exception.SellerException;

public class UpdatePriceProduct_UseCase {

	public static void main(String[] args) {
		
		
findTheProduct();
		
	}
	
	public static void findTheProduct() {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Please Enter the Id");
		int id = s.nextInt();
		
		SellerDAO sd = new SellerDAO_impl();
		
		try {
			String str = sd.UpdatePrice(id);
			
			System.out.println(str);
			
			System.out.println();
			
//			System.out.println("Enter the Product Id");
			
			updatePrice();
			
		} catch (SellerException e) {
			
			e.printStackTrace();
		}

	}
	
	public static void updatePrice() {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the Product Id");
		int n = s.nextInt();
		
		System.out.println("Enter the UpdateAmount");
		int price = s.nextInt();
		
		SellerDAO sda = new SellerDAO_impl();
		
		try {
			String str = sda.UpdateProductPrice(price, n);
			System.out.println(str);
		} catch (SellerException e) {
			e.printStackTrace();
		}
		
	}
	

}
