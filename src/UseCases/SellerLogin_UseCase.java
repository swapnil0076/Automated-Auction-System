package UseCases;

import java.util.Scanner;

import Custom_Colors.Colors;
import DAO.BuyerDAO;
import DAO.BuyerDAO_impl;
import DAO.SellerDAO;
import DAO.SellerDAO_impl;
import Exception.SellerException;
import Exception.buyerException;

public class SellerLogin_UseCase {

	public static void main(String[] args) {
		
		SellerLogin();

	}
	
public static boolean SellerLogin() {
		
		boolean flag = false;
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the Email");
		String em = s.next();
		
		System.out.println("Enter the Password");
		String pss = s.next();
		
		SellerDAO bd = new SellerDAO_impl();
		
		try {
			String str = bd.SellerLoginIn(em, pss);
			
			System.out.println(str);
			System.out.println(Colors.BOXING +Colors.GREEN_BACKGROUND+ str);
			flag = true;
		} catch (SellerException e) {
			
			e.printStackTrace();
		}
		
		return flag;
		
	}

}
