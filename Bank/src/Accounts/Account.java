package Accounts;

import UserEntity.User;
import java.time.LocalDate;

public abstract class Account {
  public Account() {}
  String accountNumber;
  String accountHolderName;
  User user;
  double initialBalance;
  double currentBalance;
  LocalDate date;
  double interest=0.0;

  public Account(User user) {
    int random = (int) (Math.random() * 9000000) + 1000000;
    this.user = user;
    this.accountHolderName = user.getName();
    this.accountNumber = String.valueOf(random);
    this.initialBalance = 0.0;
    this.currentBalance = 0.0;
  }

  public Account(String accountNumber, String accountHolderName, User user,
      double initialBalance, double currentBalance, double interest,
      LocalDate date) {
    super();
    this.accountNumber = accountNumber;
    this.accountHolderName = accountHolderName;
    this.user = user;
    this.initialBalance = initialBalance;
    this.currentBalance = currentBalance;
    this.date = date;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getAccountHolderName() {
    return accountHolderName;
  }

  public void setAccountHolderName(String accountHolderName) {
    this.accountHolderName = accountHolderName;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public double getInitialBalance() {
    return initialBalance;
  }

  public void setInitialBalance(double initialBalance) {
    this.initialBalance = initialBalance;
  }

  public double getCurrentBalance() {
    return currentBalance;
  }

  public void setCurrentBalance(double currentBalance) {
    this.currentBalance = currentBalance;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public double getInterestRate() {
    return 0.0;
  }

  public abstract String typeOfAccount();
  public abstract double withdraw(double amount);
  public abstract double deposit(double amount);

  public String createAcountNumber() {
    Integer random = (int) Math.random() * 10000000;
    System.out.println(random);
    return random.toString();
  }
  
  public double calculateInterest() {
	  return (this.currentBalance*interest)/100;
  }
  
	public void displayDetails(Account account,Business business) {
		System.out.println("Account created \n \n account number: "+account.getAccountNumber()+
				"\n Account Name: "                                +account.getAccountHolderName()+
				"\n Aadhar Number: "                               +"**** **** "+account.getUser().getAadhaarNumber()+
				"\n Branch: "                                      +account.getUser().getBranch()+
				"\n Account Type: "                                +account.typeOfAccount()+
				"\n Current Balance: "                             +account.getCurrentBalance()+" \n Interest Rate: "+account.getInterestRate()+
				"\n Business: "                                    +business.getBusinessName()!=null?business.getBusinessName():"Savings Account"+
				"\n gstNumber: "                                   +business.getGstNumber()!=null?business.getGstNumber():"No Gst for Savings Account");	
	}
}
