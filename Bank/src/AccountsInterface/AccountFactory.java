package AccountsInterface;

import Accounts.Account;
import Accounts.CurrentAccount;
import Accounts.SavingsAccount;
import UserEntity.User;

public interface AccountFactory {
  public static Account getAccount(String accountType, User user) {
    if (accountType.equalsIgnoreCase("Savings")) {
      return new SavingsAccount(user);
    } else if (accountType.equalsIgnoreCase("Current")) {
      return new CurrentAccount(user);
    }
    return null;
  }
}
