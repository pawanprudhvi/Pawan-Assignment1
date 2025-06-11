package Accounts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import AccountsInterface.AccountFactory;
import BankEntity.Bank;
import Branch.Branch;
import UserEntity.User;



public class AccountsService {
	
	HashMap<String,List<Account>> accountsForType;
	Bank bank;
	public AccountsService(Bank bank)
	{
		accountsForType=new HashMap<>();
	}
	
	public void AllAccounts() {
		for(Map.Entry<String,List<Account>> account:accountsForType.entrySet())
		{
			account.getValue().forEach(accounts->System.out.println("\n All accounts \n"+ "\n Accoun Number: "+ accounts.getAccountNumber()+" \n Accoun Holder Name: "+accounts.getAccountHolderName()+"\n Accoun Holder Mobile Number:  "+accounts.getUser().getMobileNo()+"\n Bank:"+bank.getBankName()));
		}
	}
	public Account openAccount(String username, int aadhar, long mobileNo, String address,String accountType,Business business,Branch branch,Bank bank) {	
		User user=new User(aadhar,address,mobileNo,username,branch.getBranchName());
		System.out.println(branch.getBranchName());
		Account account=AccountFactory.getAccount(accountType,user,business);
		accountsForType.putIfAbsent(accountType, new ArrayList<>());
		accountsForType.get(accountType).add(account);
		bank.addNewBranch(branch);
		return account;
	
	}

}
