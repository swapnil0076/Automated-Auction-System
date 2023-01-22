package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Exception.SellerException;
import Exception.buyerException;
import Models.Buyer;
import Models.OrderHistory;
import Models.Seller;
import Models.Seller_Sold_Items;
import Utility.DbUtil;

public class SellerDAO_impl implements SellerDAO{

	@Override
	public String SellerLoginIn(String email, String password) throws SellerException {
     String mess = "Entered Details in Wrong";
		
		try (Connection con =DbUtil.provideConnection() ){
			
		PreparedStatement ps	= con.prepareStatement("select * from seller where email = ? AND password = ?");
		
		ps.setString(1, email);
		ps.setString(2, password);
		
		
		 ResultSet rs =ps.executeQuery();
		 
		 if(rs.next()) {
			 
			 mess = "Welcome to Seller DashBoard";
			 
		 }else {
			 throw new SellerException("Wrong Id/Password");
		 }
			
		} catch (SQLException e) {
			e.getMessage();
		}
		
		return mess;
	
		
	}

	@Override
	public String RegisterSeller(Seller seller) throws SellerException {
		
	String mess = "Not Registered Successfull";
		
		try (Connection con = DbUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("insert into seller(sellername,email,password,location) values(?,?,?,?)");
			ps.setString(1, seller.getName());
			ps.setString(2, seller.getEmail());
			ps.setString(3, seller.getPassword());
			ps.setString(4, seller.getLocation());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				mess = "Seller Registered Sucessfully";
			}else {
				throw new SellerException("Failed to registered");
			}
			
			
		} catch (SQLException e) {
			
			mess =e.getMessage();
		}
		
		return mess;
	}

	@Override
	public String SellProduct(List<Seller_Sold_Items> product) throws SellerException {
		
		String mess = "Failed to add the items";
		int count = 0;
		
		try(Connection con = DbUtil.provideConnection()) {
			
			for(int i=0;i<product.size();i++) {
				String productName = product.get(i).getProductName();
				int sellerId = product.get(i).getSellerId();
				int price = product.get(i).getPrice();
				int categoryId = product.get(i) .getCategoryId();

				PreparedStatement ps = null;
				
				try {
					ps = con.prepareStatement("insert into product(productName,sellerId,price,categoryId) values(?,?,?,?)");
					ps.setString(1, productName);
					ps.setInt(2, sellerId);
					ps.setInt(3, price);
					ps.setInt(4,categoryId);

					int x = ps.executeUpdate();
					count++;
					
				} catch (SQLException e) {
					mess =e.getMessage();
				}
				
				
			}
			
			if(count >0) {
				mess = "Product added Successfull";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mess;
	}

	@Override
	public String UpdatePrice(int sellerId) throws SellerException {
	
		String mess = "";
		
		try (Connection con = DbUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement(" select p.productId,p.productName,p.price from product p where sellerId = ?");
			
			ps.setInt(1, sellerId);
			
			 ResultSet rs = ps.executeQuery();
			 
			 int count = 1;
			 while(rs.next()) {
				 int r = rs.getInt("productId");
				 String str = rs.getString("productName");
				 int pri = rs.getInt("price");
				 
				
				 mess +=count+" |-: "+"ProductId is - "+ r+" \n"+"Product Name is  "+str+" \n"+"Product price is "+pri+"\n";
				 count++;
				 System.out.println();
				 
			 }
			 
			
			 
			
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		
		
		return mess;
	}

	@Override
	public String UpdateProductPrice(int productId,int Amount) throws SellerException {
		String mess = "Item Not Updated";
		
		try (Connection con = DbUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement(" update product set price = ? where productId = ?");
			ps.setInt(1, productId);
			
			ps.setInt(2, Amount);
			
			 int rs = ps.executeUpdate();
			 
			 if(rs>0) {
				 mess = "Items price Updated";
			 }else {
				 throw new SellerException("Item not Updated");
			 }
			 
			
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		
		
		return mess;
	}

	@Override
	public String AddProduct(Seller_Sold_Items product) throws SellerException {
	  
		String mess = "Item not Added";
		
		try (Connection con = DbUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("insert into product(productName,sellerId,price,categoryId) values(?,?,?,?)");
			ps.setString(1, product.getProductName());
			ps.setInt(2, product.getSellerId());
			ps.setInt(3, product.getPrice());
			ps.setInt(4,product.getCategoryId());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				mess = "Item Added Sucessfull";
			}else {
				throw new SellerException("Failed to add item");
			}
			
		} catch (Exception e) {
			
			mess = e.getMessage();
			
		}
		
		return mess;
	}

	@Override
	public String DeleteItem(int productId) throws SellerException {
		
		String mess = "Item Not Deleted";
		
		try (Connection con = DbUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("delete from product where productId=?");
			ps.setInt(1, productId);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				mess = "Item Deleted";
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mess;
	}

	@Override
	public List<OrderHistory> soldHistory(int sellerId) throws SellerException {
		
		List<OrderHistory> ssi = new ArrayList<>();
		
		try(Connection con = DbUtil.provideConnection()) {
			
		PreparedStatement	ps = con.prepareStatement("select * from product where sellerId = ? And status = 'sold' ");
		ps.setInt(1, sellerId);
		ResultSet rs  = ps.executeQuery();
		
		while(rs.next()) {
			
			int pId = rs.getInt("productId");
			int caId = rs.getInt("categoryId");
			String pname = rs.getString("productName");
			int sId = rs.getInt("sellerId");
			int bId = rs.getInt("buyerId");
			String date = rs.getString("date");
			
			OrderHistory oh = new OrderHistory(pId, sId,caId, bId, pname, date) ;
			ssi.add(oh);
		}
		
		if(ssi.isEmpty()) {
			throw new SellerException("No Sold History");
		}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return ssi;
	}

	
	
}
