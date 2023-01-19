package UseCases;

import java.util.List;

import Custom_Colors.Colors;
import DAO.AdminDAO;
import DAO.adminDAO_impl;
import Exception.AdminException;
import Models.Seller;
import Models.SellerDTO;

public class ViewAllSellers_UseCase {

	public static void main(String[] args) {
		viewAllSellers();
		
	}
	
	public static void viewAllSellers() {
	
		AdminDAO ad = new adminDAO_impl();
		
		try {
			List<SellerDTO> se = ad.viewRegisteredSeller();
			
			se.forEach(s ->{
				
				System.out.println(Colors.PURPLE+"+--------------------------------------------------------------------------+");
				System.out.println( Colors.PURPLE+" | Seller id is "+s.getSellerID()+"|"+Colors.PURPLE);
				System.out.println(" | Seller name is "+Colors.PURPLE+s.getName()+"|" +Colors.PURPLE);
				System.out.println(" |Seller Email is "+Colors.PURPLE+s.getEmail()+"|"+Colors.PURPLE);
				System.out.println(" | Seller Location is "+Colors.PURPLE+s.getLocation()+"|"+Colors.PURPLE);
				System.out.println("+--------------------------------------------------------------------------+");
				
			});
		} catch (AdminException e) {
			
			e.printStackTrace();
		}

	}
	
}
