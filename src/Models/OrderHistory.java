package Models;

public class OrderHistory {

	private int productId;
	private int buyerId;
	private int sellerId;
	private int categoryId;
	private String productName;
	private String date;
	
	public OrderHistory() {}

	public OrderHistory(int productId, int buyerId, int sellerId, int categoryId, String productName,
			 String date) {
		super();
		this.productId = productId;
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		this.categoryId = categoryId;
		this.productName = productName;
		this.date = date;
	
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "OrderHistory [productId=" + productId + ", buyerId=" + buyerId + ", sellerId=" + sellerId
				+ ", categoryId=" + categoryId + ", productName=" + productName +
				 ", date=" + date  +"]";
	}
	
	
	
}
