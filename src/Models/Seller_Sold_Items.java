package Models;

import java.sql.Date;

public class Seller_Sold_Items {

	private String productName;
	private String categoryName;
	private String sellerName;
	private String buyerName;
	private int price;
	private int productId;
	private int categoryId;
	private int sellerId;
	private Date date;
	
	
	

	
	
	public String getCategoryName() {
		return categoryName;
	}






	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}






	public String getSellerName() {
		return sellerName;
	}






	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}






	public String getBuyerName() {
		return buyerName;
	}






	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}






	public Date getDate() {
		return date;
	}






	public void setDate(Date date) {
		this.date = date;
	}






	public Seller_Sold_Items(String productName, String categoryName, String sellerName, String buyerName, int price,
			int productId, int categoryId, int sellerId, Date date) {
		super();
		this.productName = productName;
		this.categoryName = categoryName;
		this.sellerName = sellerName;
		this.buyerName = buyerName;
		this.price = price;
		this.productId = productId;
		this.categoryId = categoryId;
		this.sellerId = sellerId;
		this.date = date;
	}






	public Seller_Sold_Items() {}

	
	
	
	

	public Seller_Sold_Items(int price, int productId, int categoryId, int sellerId, String productName) {
		super();
		this.price = price;
		this.productId = productId;
		this.categoryId = categoryId;
		this.sellerId = sellerId;
		this.productName = productName;
	}






	public Seller_Sold_Items( String productName, int categoryId,int sellerId,int price
			 ) {
		super();

		this.price = price;
		this.categoryId = categoryId;
		this.sellerId = sellerId;
		this.productName = productName;
	}











	public int getProductId() {
		return productId;
	}






	public void setProductId(int productId) {
		this.productId = productId;
	}






	@Override
	public String toString() {
		return "Seller_Sold_Items [price=" + price + ", categoryId=" + categoryId + ", sellerId=" + sellerId
				+ ", productName=" + productName + "]";
	}




	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}



	public int getSellerId() {
		return sellerId;
	}


	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}

	
	
	
	
	
	
	
	
}
