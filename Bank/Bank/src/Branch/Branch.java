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

public class Branch  {
	String branchName;
	Bank bank;
	
	public Branch(String branchName,Bank bank)
	{	
		this.branchName=branchName;
		this.bank=bank;
	}
	

	public Bank getBank() {
		return bank;
	}


	public void setBank(Bank bank) {
		this.bank = bank;
	}


	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
}
