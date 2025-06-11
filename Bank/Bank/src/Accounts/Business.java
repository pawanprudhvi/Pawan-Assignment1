package Accounts;

public class Business {
	private String businessName;
	private String gstNumber;
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public Business(String businessName, String gstNumber) {
		this.businessName = businessName;
		this.gstNumber = gstNumber;
	}
	public String getGstNumber() {
		return gstNumber;
	}
	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}
}
