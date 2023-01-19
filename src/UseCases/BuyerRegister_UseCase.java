package UseCases;

import java.util.Scanner;

import DAO.BuyerDAO;
import DAO.BuyerDAO_impl;
import Exception.buyerException;
import Models.Buyer;
import Models.BuyerDTO;

public class BuyerRegister_UseCase {

	public static void main(String[] args) {
	registerBuyer();
		

	}
	
	public static void registerBuyer() {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter Your Name");
		String n = s.next();
		System.out.println("Enter the Email");
		String e = s.next();
		
		System.out.println("Enter the New Password");
		String pas = s.next();
		
		System.out.println("Enter the Location");
		String lo = s.next();
		
		System.out.println("Enter the Amount to you account");
		int am = s.nextInt();
		
		BuyerDAO bd = new BuyerDAO_impl();
		
		
		Buyer bs = new Buyer();
		bs.setName(n);
		bs.setEmail(e);
		bs.setPassword(pas);
		bs.setLocation(lo);
		bs.setAmount(am);
		
		String res = "";
		
		try {
			res = bd.RegisterBuyer(bs);
			System.out.println(res);
		} catch (buyerException e1) {
			
			e1.printStackTrace();
		}
		
		
		
		
		
		
	}

}
