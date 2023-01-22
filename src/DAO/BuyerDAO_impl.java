package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Date; 

import Exception.buyerException;
import Models.Buyer;
import Models.Seller;
import Models.Seller_Sold_Items;
import Utility.DbUtil;

public class BuyerDAO_impl implements BuyerDAO{
	
	private int bid;

	@Override
	public String BuyerLoginIn(String email,String password) throws buyerException {
		
		String mess = "Entered Details in Wrong";
		
		try (Connection con =DbUtil.provideConnection() ){
			
		PreparedStatement ps	= con.prepareStatement("select * from buyer where email = ? AND password = ?");
		
		ps.setString(1, email);
		ps.setString(2, password);
		
		
		 ResultSet rs =ps.executeQuery();
		 
		 if(rs.next()) {

			 bid = rs.getInt("buyerId");
			 
			 mess = "Welcome to Buyer DashBoard";
			 
		 }else {
			 throw new buyerException("Wrong Id/Password");
		 }
			
		} catch (SQLException e) {
			mess = e.getMessage();
		}
		
		return mess;
	}

	@Override
	public String RegisterBuyer(Buyer buyer) throws buyerException {
	   
		String mess = "Not Registered Successfull";
		
		try (Connection con = DbUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("insert into buyer(name,email,password,location,Amount) values(?,?,?,?,?)");
			ps.setString(1, buyer.getName());
			ps.setString(2, buyer.getEmail());
			ps.setString(3, buyer.getPassword());
			ps.setString(4, buyer.getLocation());
			ps.setInt(5, buyer.getAmount());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				mess = "Buyer Registered Sucessfully";
			}else {
				throw new buyerException("Failed to registered");
			}
			
			
		} catch (SQLException e) {
			
			mess =e.getMessage();
		}
		
		return mess;
	}

	@Override
	public List<Seller_Sold_Items> ViewAllItems() throws buyerException {
	   
		List<Seller_Sold_Items> ssi = new ArrayList<>();
		
		try (Connection con = DbUtil.provideConnection()){
			
		PreparedStatement ps = 	con.prepareStatement("select productId,productName,sellerId,categoryID,price from product where status = 'available'");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			int pi = rs.getInt("productId");
			String pn = rs.getString("productName");
			int sI = rs.getInt("sellerId");
			int cI = rs.getInt("categoryId");
			int pr = rs.getInt("price");
			

        Seller_Sold_Items sd = new Seller_Sold_Items(pr, pi, cI, sI, pn);
			
			ssi.add(sd);
			
		}
		
		while(ssi.isEmpty()) {
			throw new buyerException("Not Product found");
		}
			
			
		} catch (Exception e) {
			
			e.getMessage();
			
		}
		
		return ssi;
	}

	@Override
	public String BuyItem(int productId,LocalDate date, int buyerId) throws buyerException {
		
	
	
		String mess = "Wrong Product Id";
		
		try (Connection con = DbUtil.provideConnection()){
			
		PreparedStatement ps =	con.prepareStatement("update product set status = 'sold',buyerId = ? ,date = ?  where productId = ? And status = 'available' ");
		
		ps.setInt(1, buyerId);
		ps.setDate(2,java.sql.Date.valueOf(date));
		ps.setInt(3, productId);
		
		int x =  ps.executeUpdate();
		if(x>0) {
			mess = "Purchased Successfully";
		}else {
			throw new buyerException("Product Id not Found");
		}
		
		
		} catch (Exception e) {
			e.getMessage();
		}
		
		
		return mess;
	}

	@Override
	public List<Seller_Sold_Items> viewAllBuyer() throws buyerException {
		
		List<Seller_Sold_Items> list = new ArrayList<>();
		
		try (Connection con = DbUtil.provideConnection()){
			
			PreparedStatement ps =  con.prepareStatement("select p.productId,p.productName,c.categoryId,c.categoryName,b.buyerId,b.name,s.sellerId,s.name,p.price,p.date from product p inner join category c inner join seller s inner join buyer b on p.sellerId = s.sellerId And p.categoryId = c.categoryID And p.buyerId = b.buyerId where p.status = 'sold' ");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String productName = rs.getString("productName");
				String categoryName = rs.getString("categoryName");
				String sellerName = rs.getString("name");
				String buyerName = rs.getString("name");
				int price = rs.getInt("price");
				int productId = rs.getInt("productId");
				int categoryId = rs.getInt("categoryId");
				int sellerId = rs.getInt("sellerId");
				Date date = rs.getDate("date");
				
				Seller_Sold_Items sds = new Seller_Sold_Items(productName, categoryName, sellerName, buyerName, price, productId, categoryId, sellerId, (java.sql.Date) date);
				
				list.add(sds);
			}
			
			if(list.isEmpty()) {
				throw new buyerException("Not data found");
			}
			
			
		} catch (Exception e) {
			
			e.getMessage();
			e.printStackTrace();
		}
		
		return list;
	}

	

}
