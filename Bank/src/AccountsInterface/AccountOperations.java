package AccountsInterface;

import Accounts.Account;
import Accounts.Business;
import BankEntity.Bank;
import Branch.Branch;

public interface AccountOperations {
	public Account openAccount(String username, int aadhar, long mobileNo, String address,String accountType,Business business,Branch branch,Bank bank);

}
