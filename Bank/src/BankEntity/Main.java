package BankEntity;



import Branch.Branch;
import CustomExceptions.InvalidAadharException;
import CustomExceptions.WithdrawalLimitReachedException;
import CustomExceptions.invalidMobileNumberException;
import Validations.validateCredentials;

import java.lang.*;
import java.util.*;
import java.util.Scanner;

import Accounts.Account;
import Accounts.AccountsService;
import Accounts.Business;

public class Main {
  public static void main(String args[]) throws WithdrawalLimitReachedException, InvalidAadharException, invalidMobileNumberException {
    Scanner sc = new Scanner(System.in);
    
    //hardcoding values can be optimised by using a list or map and getting bank names form that list.
    Bank bank = new Bank("Canara Bank");
    
    //a list or map can be used to pre-populate the branches of a particular bank(Pawan's approach)
    Branch branch = new Branch("Chennai Central", bank);

    System.out.println("Do you want to create an account in Canara Bank(Yes/No)");
    String userChoice = sc.nextLine();
    Account account=null;
    AccountsService accountService=new AccountsService(bank);
    Business business=null;
    
     while(userChoice.equalsIgnoreCase("Yes")) {
      System.out.println("Enter your name as in Aadhaar Card");
      String userName = sc.nextLine();
      if(userName.equals(""))
      {
    	  System.out.println("Username cannot be empty");
    	  continue;
      }
      System.out.println("Enter the last four digits of your aadhaar number");
      int aadharNumber = sc.nextInt();
      try {
      if(!validateCredentials.validateAadhaar(aadharNumber)) {
    	  throw new InvalidAadharException("Aadhar has to be 12 digits in length and only contain numbers");
      }
      sc.nextLine();
      System.out.println("Enter your Mobile Number");
      long mobileNo = sc.nextLong();
      if(!validateCredentials.validateNumber(mobileNo)) {
    	  throw new invalidMobileNumberException("Number has to be 10 digits in length and only contain numbers");
      }
      sc.nextLine();
      System.out.println("Enter your permanent address");
      String address = sc.nextLine();
      System.out.println("Enter type of account you want to create(Current/Savings)");
      String accountType = sc.nextLine();
      if(accountType.equalsIgnoreCase("Current"))
      {
      System.out.print("Enter Business Name: ");
      String businessName = sc.nextLine();
      System.out.print("Enter GST Number: ");
      String gstNumber = sc.nextLine();
      business = new Business(businessName,gstNumber);
    }
      account=accountService.openAccount(userName, aadharNumber, mobileNo, address, accountType,business,branch,bank);    
      account.displayDetails(account,business);
      System.out.println("Interest per Annum: "+account.calculateInterest());
      System.out.println("Do you want to create another account?(Yes/No)");
      userChoice=sc.nextLine();
     }
     catch(InvalidAadharException e) {
   	  System.out.println("Aadhar has to be 12 digits in length and only contain numbers");
     }
     catch(invalidMobileNumberException e) {
      System.out.println("Number has to be 10 digits in length and only contain numbers");
     }
    
    System.out.println("Thank you for choosing our bank");
    System.out.println("Do you want to deposit money?(Yes/No)");
    String depositCoice=sc.nextLine();
    if(depositCoice.equals("Yes")) {
    	System.out.println("Enter the amount for deposit");
    	double amountToDeposit=sc.nextDouble();
    	account.deposit(amountToDeposit);
    	sc.nextLine();
    }
    System.out.println("Do you want to withdraw money?(Yes/No)");
    String withdrawChoice=sc.nextLine();
    while(withdrawChoice.equalsIgnoreCase("Yes")) {
    	System.out.println("Enter the amount for withdrawal");
    	double amountToWithdraw=sc.nextDouble();
    	sc.nextLine();
    	account.withdraw(amountToWithdraw);
    	System.out.println("Do you want to withdraw again?(Yes/No)");
    	withdrawChoice=sc.nextLine();
    }  
    System.out.println("Thank you for your valuable transaction with us.See you again!");
    bank.showAllBranches();   
  }
}
}
