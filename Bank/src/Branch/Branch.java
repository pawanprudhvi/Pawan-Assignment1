package Branch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Accounts.Account;
import AccountsInterface.AccountFactory;
import BankEntity.Bank;
import BankInterface.bankInterface;
import UserEntity.User;

public class Branch implements bankInterface {
	String branchName;
	HashMap<String,List<Account>> accountsForType;
	Bank bank;
	
	public Branch(String branchName,Bank bank)
	{
		accountsForType=new HashMap<>();	
		this.branchName=branchName;
		this.bank=bank;
	}
	
	public void AllAccounts() {
		for(Map.Entry<String,List<Account>> account:accountsForType.entrySet())
		{
			account.getValue().forEach(accounts->System.out.println("\n All accounts \n"+ "\n Accoun Number: "+ accounts.getAccountNumber()+" \n Accoun Holder Name: "+accounts.getAccountHolderName()+"\n Accoun Holder Mobile Number:  "+accounts.getUser().getMobileNo()+"\n Bank:"+bank.getBankName()));
		}
	}

	@Override
	public Account createBankAccount(String username, int aadhar, long mobileNo, String address,String accountType) {	
		User user=new User(aadhar,address,mobileNo,username);
		Account account=AccountFactory.getAccount(accountType,user);
		accountsForType.putIfAbsent(accountType, new ArrayList<>());
		accountsForType.get(accountType).add(account);
		bank.addNewBranch(this);	
		displayDetails(account);
		return account;
	
	}

	public void displayDetails(Account account) {
		System.out.println("Account created \n \n account number: "+account.getAccountNumber()+"\n Account Name: "+account.getAccountHolderName()+"\n Aadhar Number: "+"**** **** "+account.getUser().getAadhaarNumber()+"\n Account Type: "+account.typeOfAccount()+" \n Current Balance: "+account.getCurrentBalance()+" \n Interest Rate: "+account.getInterestRate());	
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	
	

}
