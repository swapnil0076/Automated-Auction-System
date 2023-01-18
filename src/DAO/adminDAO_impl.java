package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Exception.AdminException;
import Exception.CredentialException;
import Models.Buyer;
import Models.BuyerDTO;
import Models.OrderHistory;
import Models.SellerDTO;
import Utility.DbUtil;

public class adminDAO_impl  implements AdminDAO{

	@Override
	public String adminLogin(String username, String password) throws CredentialException {
		
		String mess = "Your UserName And Password is Wrong";
		
			
			if(username.equals(AdminDAO.username) && password.equals(AdminDAO.password)) {
				mess = "Login Successfull";
			}else {
				throw new CredentialException(mess);
			}
			
		
		
		return mess;
	}

	@Override
	public List<BuyerDTO> viewRegisteredBuyer() throws AdminException{
		
		List<BuyerDTO> rsb = new ArrayList<>();
		
		try (Connection con =DbUtil.provideConnection() ){
			
			PreparedStatement ps = con.prepareStatement("select * from buyer");
			
			ResultSet rs  = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("buyerId");
				String n = rs.getString("Name");
				String e = rs.getString("email");
				int a = rs.getInt("amount");
				String l = rs.getString("location");
				
				BuyerDTO bs =new BuyerDTO(id, n, e, a, l);
				
				rsb.add(bs);
				
				
			}
			
			if(rsb.size() == 0) {
				throw new AdminException("No data Found");
			}
			
			
		} catch (SQLException e) {
			e.getMessage();
			throw new AdminException(e.getMessage());
		}
		
		
		return rsb;
	}

	@Override
	public List<SellerDTO> viewRegisteredSeller() throws AdminException {
	    
		List<SellerDTO> vrs = new ArrayList<>();
		
		try (Connection con =DbUtil.provideConnection()){
			
		 PreparedStatement ps = con.prepareStatement("Select * from seller");
		 
		ResultSet rs =   ps.executeQuery();
		
		while(rs.next()) {
			int r = rs.getInt("sellerId");
			String n = rs.getString("name");
			String e = rs.getString("email");
			String l = rs.getString("location");
			
			SellerDTO sd = new SellerDTO(r, n, e, l);
			vrs.add(sd);
		}
		
		if(vrs.isEmpty()) {
			System.out.println("Empty Data");
		}
			
			
		} catch (Exception e) {
			e.getMessage();
		}
		
		return vrs;
	}

	@Override
	public List<OrderHistory> DailySellingReport(String Date) throws AdminException {
		
		List<OrderHistory> oh = new ArrayList<>();
		
		try(Connection con =DbUtil.provideConnection() ) {
			
			con.prepareStatement("select b.buyerId,b.name,b.email,p.productId,p.productName,s.name,s.sellerId,p.price from "
			+"seller s inner join buyer b inner join product p on p.sellerId = s.sellerId AND p.buyerId = b.buyerId "
					+"where p.status = 'sold' AND p.date = ?");
			
		} catch (Exception e) {
			
		}
		
		return oh;
	}

}
