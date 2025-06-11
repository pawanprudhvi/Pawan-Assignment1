package BankInterface;

import Accounts.Account;
import Accounts.Business;
import BankEntity.Bank;

public interface bankInterface {	
	public Account openAccount(String username,int aadhar,long mobileNo,String address,String accountType,Business business);
}
