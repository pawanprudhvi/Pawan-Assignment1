package Accounts;

import AccountsInterface.AccountFunctions;
import UserEntity.User;
import java.time.LocalDate;

public class CurrentAccount extends Account implements AccountFunctions {
  private double interest = 4.0;

  public CurrentAccount() {}

  public CurrentAccount(User user) {
    super(user);
  }

  @Override
  public double getInterestRate() {
    return interest;
  }

  public CurrentAccount(String accountNumber, String accountHolderName,
      User user, double initialBalance, double currentBalance, double interest,
      LocalDate date) {
    super(accountNumber, accountHolderName, user, initialBalance,
        currentBalance, interest, date);
  }

  @Override
  public String typeOfAccount() {
    return "Current";
  }

  public double withdraw(double amount) {
    if (this.currentBalance >= amount) {
      this.currentBalance -= amount;
      System.out.println("Amount withdrawn successfully");
    } else {
      System.out.println("Insufficient Funds");
    }

    return 0;
  }

  @Override
  public double deposit(double amount) {
    this.currentBalance += amount;
    System.out.println("Amount successfullt deposited");
    return amount;
  }
}
