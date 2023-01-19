package UseCases;

import java.util.List;

import DAO.AdminDAO;
import DAO.adminDAO_impl;
import Exception.AdminException;
import Models.BuyerDTO;

public class ViewAllBuyer_UseCase {
	
	public static void main(String[] args) {
        viewBuyerList();
    }

	public static void viewBuyerList() {
		
		AdminDAO da = new adminDAO_impl();
		
		try {
			List<BuyerDTO> st =  da.viewRegisteredBuyer();
			
			st.forEach(s ->{
				System.out.println("+--------------------------------------------------------------------------+");
				System.out.println("Buyer Id is "+ s.getBuyerID());
				System.out.println("Buyer Name is "+s.getName());
				System.out.println("Buyer Email is  "+s.getEmail());
				System.out.println("Buyer Amount is "+s.getAmount());
				System.out.println("Buyer location is "+s.getLocation());
				
				System.out.println("+--------------------------------------------------------------------------+");
			});
			
			
		} catch (AdminException e) {
			
			e.printStackTrace();
			e.getMessage();
		}
		
	}
	
}
