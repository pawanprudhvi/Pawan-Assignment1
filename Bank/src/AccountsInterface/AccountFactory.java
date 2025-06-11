package AccountsInterface;

import Accounts.Account;
import Accounts.Business;
import Accounts.CurrentAccount;
import Accounts.SavingsAccount;
import UserEntity.User;

public interface AccountFactory {
  public static Account getAccount(String accountType, User user,Business business) {
    if (accountType.equalsIgnoreCase("Savings")) {
      return new SavingsAccount(user);
    } else if (accountType.equalsIgnoreCase("Current")) {
      return new CurrentAccount(user,business);
    }
    return null;
  }

}
