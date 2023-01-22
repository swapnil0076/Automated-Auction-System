package DAO;

import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import Exception.buyerException;
import Models.Buyer;
import Models.Seller_Sold_Items;

public interface BuyerDAO {

	public String BuyerLoginIn(String email,String password) throws buyerException;
	public String RegisterBuyer(Buyer buyer) throws buyerException;
	public List<Seller_Sold_Items> ViewAllItems() throws buyerException;
	public String BuyItem(int productId,LocalDate date,int buyerId) throws buyerException;

	public List<Seller_Sold_Items> viewAllBuyer() throws buyerException;
	
}
