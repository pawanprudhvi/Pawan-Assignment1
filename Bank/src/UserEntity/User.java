package UserEntity;

public class User {
	int aadhaarNumber;
	String address;
	long mobileNo;
	String branch;
	public User(int aadhaarNumber, String address, long mobileNo, String name,String branch) {
		this.aadhaarNumber = aadhaarNumber;
		this.address = address;
		this.mobileNo = mobileNo;
		this.name = name;
		this.branch=branch;
	}
	public String getName() {
		return name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public void setName(String name) {
		this.name = name;
	}
	String name;
	public int getAadhaarNumber() {
		return aadhaarNumber;
	}
	public void setAadhaarNumber(int aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}
	public String getAddress() {
		return address;
	}
	public User(int aadhaarNumber, String address, long mobileNo) {
		super();
		this.aadhaarNumber = aadhaarNumber;
		this.address = address;
		this.mobileNo = mobileNo;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}


}
