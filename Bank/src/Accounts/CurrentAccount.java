package Accounts;

import UserEntity.User;
import java.time.LocalDate;

public class CurrentAccount extends Account {
  private double interest = 4.0;
  private String accountCategory;
  private Business business;

  public CurrentAccount() {}

  public CurrentAccount(User user) {
    super(user);
  }
  
  public CurrentAccount(User user,Business business) {
	    super(user);
	    this.business=business;
	  }
  

  public double getInterest() {
	return interest;
}

public void setInterest(double interest) {
	this.interest = interest;
}

public String getAccountCategory() {
	return accountCategory;
}

public void setAccountCategory(String accountCategory) {
	this.accountCategory = accountCategory;
}

public Business getBusiness() {
	return business;
}

public void setBusiness(Business business) {
	this.business = business;
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

    return this.currentBalance;
  }

  @Override
  public double deposit(double amount) {
	if(currentBalance<5000) {
	   System.out.println("Minimum balance should be 5000");
	}  
    this.currentBalance += amount;
    System.out.println("Amount successfullt deposited");
    return amount;
  }
  
  @Override 
  public double calculateInterest() {
	  return (this.currentBalance*interest)/100;
  }
  
    @Override
	public void displayDetails(Account account,Business business) {
		System.out.println("Account created \n \n account number: "+account.getAccountNumber()+
				"\n Account Name: "                                +account.getAccountHolderName()+
				"\n Aadhar Number: "                               +"**** **** "+account.getUser().getAadhaarNumber()+
				"\n Branch: "                                      +account.getUser().getBranch()+
				"\n Account Type: "                                +account.typeOfAccount()+
				"\n Current Balance: "                             +account.getCurrentBalance()+" \n Interest Rate: "+account.getInterestRate()+
				"\n Business: "                                    +business.getBusinessName()+
				"\n gstNumber: "                                   +business.getGstNumber());	
	}
}
