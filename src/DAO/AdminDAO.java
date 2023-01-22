package DAO;

import java.util.List;

import Exception.AdminException;
import Exception.CredentialException;
import Models.Buyer;
import Models.BuyerDTO;
import Models.OrderHistory;
import Models.SellerDTO;
import Models.Seller_Sold_Items;

public interface AdminDAO {

	public final String username = "admin";
	public final String password = "admin";
	
	
	public String adminLogin(String username,String password) throws CredentialException ;
	public List<BuyerDTO> viewRegisteredBuyer() throws AdminException;
	public List<SellerDTO> viewRegisteredSeller() throws AdminException;
	public List<Seller_Sold_Items>DailySellingReport(String Date) throws AdminException;
	
}
