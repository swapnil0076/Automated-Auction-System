package UseCases;

import java.util.Scanner;

import Custom_Colors.Colors;
import DAO.BuyerDAO;
import DAO.BuyerDAO_impl;
import Exception.buyerException;

public class BuyerLogin_UseCase {

	public static void main(String[] args) {
		
buyerLogin();
		
	}
	
	public static boolean buyerLogin() {
		
		boolean flag = false;
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the Email");
		String em = s.next();
		
		System.out.println("Enter the Password");
		String pss = s.next();
		
		BuyerDAO bd = new BuyerDAO_impl();
		
		try {
			String str = bd.BuyerLoginIn(em, pss);
			
			System.out.println(Colors.GREEN_BACKGROUND+str);
			flag = true;
		} catch (buyerException e) {
			
			e.printStackTrace();
		}
		
		return flag;
		
	}

}
