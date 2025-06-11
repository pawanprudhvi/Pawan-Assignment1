package Accounts;

import AccountsInterface.AccountFunctions;
import UserEntity.User;
import java.time.LocalDate;

public class SavingsAccount extends Account implements AccountFunctions {
  private double interest = 4.0;

  public SavingsAccount() {}

  public SavingsAccount(User user) {
    super(user);
  }

  @Override
  public double getInterestRate() {
    return interest;
  }

  public SavingsAccount(String accountNumber, String accountHolderName,
      User user, double initialBalance, double currentBalance, double interest,
      LocalDate date) {
    super(accountNumber, accountHolderName, user, initialBalance,
        currentBalance, interest, date);
  }

  @Override
  public String typeOfAccount() {
    return "Savings";
  }

  @Override
  public double withdraw(double amount) {
    if (this.currentBalance >= amount) {
      this.currentBalance -= amount;
      System.out.println("Amount withdrawn successfully \n Current Balance: "+this.currentBalance);
    } else {
      System.out.println("Insufficient Funds");
    }

    return currentBalance;
  }
  
  public double calculateInterest() {
	  return (this.currentBalance*interest)/100;
  }
  
  public double calculateTotalAmount() {
	  double interestAmount=calculateInterest();
	  System.out.println("Total Amount with interest "+interestAmount+this.currentBalance);
	  return interestAmount+this.currentBalance;
  }

  @Override
  public double deposit(double amount) {
    this.currentBalance += amount;
    System.out.println("Amount successfullt deposited \n Current Balance: "+this.currentBalance);
    return amount;
  }
}
