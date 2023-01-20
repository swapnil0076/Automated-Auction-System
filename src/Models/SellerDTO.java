package Models;

public class SellerDTO {

	private int sellerID;
	private String name;
	private String email;
	private String location;
	
	public SellerDTO() {}
	
	
	public SellerDTO(int sellerID, String name, String email, String location) {
		super();
		this.sellerID = sellerID;
		this.name = name;
		this.email = email;
		this.location = location;
	}



	public int getSellerID() {
		return sellerID;
	}



	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	@Override
	public String toString() {
		return "SellerDTO [sellerID=" + sellerID + ", name=" + name + ", email=" + email + ", location=" + location
				+ "]";
	}
	
	
	
}
