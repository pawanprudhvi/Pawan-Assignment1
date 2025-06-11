package Validations;

public class validateCredentials {
	public  static boolean validateAadhaar(int aadhaarNumber) {
		String aadhar=String.valueOf(aadhaarNumber);
		System.out.println(aadhar);
		if(aadhar.length()!=4) {
			return false;
		}
		for(char ch:aadhar.toCharArray()) {
			if(!Character.isDigit(ch)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean validateNumber(long mobileNumber) {
		String mobile=String.valueOf(mobileNumber);
		if(mobile.length()!=10) {
			return false;
		}
		for(char ch:mobile.toCharArray()) {
			if(!Character.isDigit(ch)) {
				return false;
			}
		}
		return true;
	}
}
