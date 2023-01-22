package Models;

public class Seller {

	private int sellerID;
	private String name;
	private String email;
	private String password;
	private String location;
	
	public Seller() {}

	public Seller(int sellerID, String name, String email, String password, String location) {
		super();
		this.sellerID = sellerID;
		this.name = name;
		this.email = email;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Seller [sellerID=" + sellerID + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", location=" + location + "]";
	}
	
	
	
}
