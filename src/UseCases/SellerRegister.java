package UseCases;

import java.util.Scanner;

import DAO.BuyerDAO;
import DAO.BuyerDAO_impl;
import DAO.SellerDAO;
import DAO.SellerDAO_impl;
import Exception.SellerException;
import Exception.buyerException;
import Models.Buyer;
import Models.Seller;

public class SellerRegister {

	public static void main(String[] args) {
		registerSeller();

	}
	
public static void registerSeller() {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter Your Name");
		String n = s.next();
		System.out.println("Enter the Email");
		String e = s.next();
		
		System.out.println("Enter the New Password");
		String pas = s.next();
		
		System.out.println("Enter the Location");
		String lo = s.next();
		
		
		SellerDAO bd = new SellerDAO_impl();
		
		
		Seller bs = new Seller();
		bs.setName(n);
		bs.setEmail(e);
		bs.setPassword(pas);
		bs.setLocation(lo);
		
		String res = "";
		
		try {
			res = bd.RegisterSeller(bs);
			System.out.println(res);
		} catch (SellerException e1) {
			
			e1.printStackTrace();
		}
		
}
}
