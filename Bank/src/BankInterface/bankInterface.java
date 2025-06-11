package BankInterface;

import Accounts.Account;

public interface bankInterface {	
	public Account createBankAccount(String username,int aadhar,long mobileNo,String address,String accountType);
}
