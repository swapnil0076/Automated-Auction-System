package UseCases;

import java.util.Scanner;

import DAO.SellerDAO;
import DAO.SellerDAO_impl;
import Exception.SellerException;

public class DeleteItem {

	public static void main(String[] args) {
		
		findTheProduct();
		
	}
	
public static void findTheProduct() {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Please Enter the SellerId");
		int id = s.nextInt();
		
		SellerDAO sd = new SellerDAO_impl();
		
		try {
			String str = sd.UpdatePrice(id);
			
			System.out.println(str);
			
			System.out.println();
			
//			System.out.println("Enter the Product Id");
			
			DeleteProduct(id);
			
		} catch (SellerException e) {
			
			e.printStackTrace();
		}

	}
	
	public static void DeleteProduct(int Id) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the ProdutId You want to Delete");
		int prod = s.nextInt();
		
		SellerDAO sd = new SellerDAO_impl();
		
		try {
			String str = sd.DeleteItem(prod);
			
			System.out.println(str);
			
		} catch (SellerException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}

}
