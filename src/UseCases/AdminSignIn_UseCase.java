package UseCases;

import java.util.Scanner;

import Custom_Colors.Colors;
import DAO.AdminDAO;
import DAO.adminDAO_impl;
import Exception.CredentialException;

public class AdminSignIn_UseCase {

	public static boolean adminLogin() {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println(Colors.BOXING+Colors.RED+"Enter the Admin UserName");
		
		String username = s.next();
		
		System.out.println(Colors.BANANA_YELLOW+"Enter the Password");
		
		String password = s.next();
		String mess;
		AdminDAO da = new adminDAO_impl();
		
		try {
			mess = da.adminLogin(username, password);
			System.out.println(Colors.BOXING +Colors.GREEN_BACKGROUND+ mess);
			return true;
			
		} catch (CredentialException e) {
		
			mess = e.getMessage();
			System.out.println(mess);
			return false;
		}
		
	}
	
}
