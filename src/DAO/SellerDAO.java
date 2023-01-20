package DAO;

import java.util.List;

import Exception.SellerException;
import Exception.buyerException;
import Models.Buyer;
import Models.OrderHistory;
import Models.Seller;
import Models.Seller_Sold_Items;

public interface SellerDAO {

	public String SellerLoginIn(String email,String password) throws SellerException;
	public String RegisterSeller(Seller seller) throws SellerException;
	public String SellProduct(List<Seller_Sold_Items> product) throws SellerException;
	public String UpdatePrice(int sellerId) throws SellerException;
	public String UpdateProductPrice(int productId,int Amount) throws SellerException;
	public String AddProduct (Seller_Sold_Items product) throws SellerException;
	public String DeleteItem(int productId) throws SellerException;
	public List<OrderHistory> soldHistory(int sellerId) throws SellerException;
	
	
}
