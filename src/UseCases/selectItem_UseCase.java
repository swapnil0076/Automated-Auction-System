package UseCases;

import java.time.LocalDate;
import java.util.Scanner;

import DAO.BuyerDAO;
import DAO.BuyerDAO_impl;
import Exception.buyerException;

public class selectItem_UseCase {

	public static void main(String[] args) {
		
		selectProduct();

	}

	public static void selectProduct() {
		
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	    java.sql.Date dateU = sqlDate;
	    
		Scanner s = new Scanner(System.in);
		
			
		
		System.out.println("Enter Your buyerId");
		int buyerId = s.nextInt();
		
		BuyerDAO bds = new BuyerDAO_impl();
		System.out.println("Select the ProductId You want to buy");
		int pi = s.nextInt();
		
		LocalDate date= LocalDate.now();

		
		try {
			String str = bds.BuyItem(pi, date,buyerId);
			
			System.out.println(str);
			
		} catch (buyerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
