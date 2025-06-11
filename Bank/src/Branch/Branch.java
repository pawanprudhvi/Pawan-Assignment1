package Branch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Accounts.Account;
import Accounts.Business;
import AccountsInterface.AccountFactory;
import BankEntity.Bank;
import BankInterface.bankInterface;
import UserEntity.User;

public class Branch implements bankInterface {
	String branchName;
	HashMap<String,List<Account>> accountsForType;
	Bank bank;
	
	public Branch(String brsanchName,Bank bank)
	{
		accountsForType=new HashMap<>();	
		this.branchName=brsanchName;
		this.bank=bank;
	}
	
	public void AllAccounts() {
		for(Map.Entry<String,List<Account>> account:accountsForType.entrySet())
		{
			account.getValue().forEach(accounts->System.out.println("\n All accounts \n"+ "\n Accoun Number: "+ accounts.getAccountNumber()+" \n Accoun Holder Name: "+accounts.getAccountHolderName()+"\n Accoun Holder Mobile Number:  "+accounts.getUser().getMobileNo()+"\n Bank:"+bank.getBankName()));
		}
	}

	@Override
	public Account openAccount(String username, int aadhar, long mobileNo, String address,String accountType,Business business) {	
		User user=new User(aadhar,address,mobileNo,username,this.branchName);
		System.out.println(this.branchName);
		Account account=AccountFactory.getAccount(accountType,user,business);
		accountsForType.putIfAbsent(accountType, new ArrayList<>());
		accountsForType.get(accountType).add(account);
		bank.addNewBranch(this);
		return account;
	
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
}
