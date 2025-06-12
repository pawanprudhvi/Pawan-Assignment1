package Accounts;

import UserEntity.User;
import java.time.LocalDate;

import CustomExceptions.WithdrawalLimitReachedException;

public class SavingsAccount extends Account {

  private static final int withdrawalLimit = 3;
  private double interest = 4.0;
  private int withdrawMonthlyLimit;

  public SavingsAccount() {}

  public SavingsAccount(User user) {
	  super(user);
    this.withdrawMonthlyLimit = 0;
  }
  
  public SavingsAccount(SavingsAccount savingsAccount) {
	  super(savingsAccount.user);
    this.withdrawMonthlyLimit = 0;
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
    try {
      if (this.currentBalance >= amount) {
        if (withdrawalLimit <= ++withdrawMonthlyLimit) {
          throw new WithdrawalLimitReachedException("Withdrawal limit reached");
        }
        this.currentBalance -= amount;
        if (amount < 1000) {
          System.out.println("Minimum deposit should be 1000");
          currentBalance -= 500;
        }
        System.out.println("Amount withdrawn successfully \n Current Balance: " + this.currentBalance);
      } else {
        throw new WithdrawalLimitReachedException("Withdrawal limit reached for this month");
      }
    } catch (WithdrawalLimitReachedException e) {
      System.out.println("Withdrawal limit reached");

    }
    return currentBalance;
  }

  public double calculateInterest() {
    return (this.currentBalance * interest) / 100;
  }

  public double calculateTotalAmount() {
    double interestAmount = calculateInterest();
    System.out.println("Total Amount with interest " + interestAmount + this.currentBalance);
    return interestAmount + this.currentBalance;
  }

  @Override
  public double deposit(double amount) {
    this.currentBalance += amount;
    if (amount < 1000) {
      System.out.println("Minimum deposit should be 1000");
    }
    System.out.println("Amount successfullt deposited \n Current Balance: " + this.currentBalance);
    return amount;
  }

  @Override
  public void displayDetails(Account account, Business business) {
		System.out.println("Account created \n \n account number: "+account.getAccountNumber()+
				"\n Account Name: "                                +account.getAccountHolderName()+
				"\n Aadhar Number: "                               +"**** **** "+account.getUser().getAadhaarNumber()+
				"\n Branch: "                                      +account.getUser().getBranch()+
				"\n Account Type: "                                +account.typeOfAccount()+
				"\n Current Balance: "                             +account.getCurrentBalance()+" \n Interest Rate: "+account.getInterestRate());
  }
}