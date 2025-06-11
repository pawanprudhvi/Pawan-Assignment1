package BankEntity;



import Branch.Branch;
import java.lang.*;
import java.util.*;
import java.util.Scanner;

import Accounts.Account;
import AccountsInterface.AccountFunctions;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    //
    Bank bank = new Bank("Canara Bank");
    Branch branch = new Branch("Chennai Central", bank);
    AccountFunctions accountFunction=null;

    System.out.println("Do you want to create an account in Canara Bank(Yes/No)");
    String userChoice = sc.nextLine();
    
     if(userChoice.equals("Yes")) {
      System.out.println("Enter your name as in Aadhaar Card");
      String userName = sc.nextLine();
      System.out.println("Enter the last four digits of your aadhaar number");
      int aadharNumber = sc.nextInt();
      sc.nextLine();
      System.out.println("Enter your Mobile Number");
      long mobileNo = sc.nextLong();
      sc.nextLine();
      System.out.println("Enter your permanent address");
      String address = sc.nextLine();
      System.out.println("Enter type of account you want to create(Current/Savings)");
      String accountType = sc.nextLine();
      Account account=branch.createBankAccount(
          userName, aadharNumber, mobileNo, address, accountType);
      branch.AllAccounts();     
      accountFunction=(AccountFunctions)account;
    }
    System.out.println("Thank you for choosing our bank");
    System.out.println("Do you want to deposit money?(Yes/No)");
    String depositCoice=sc.nextLine();
    if(depositCoice.equals("Yes")) {
    	System.out.println("Enter the amount for deposit");
    	double amountToDeposit=sc.nextDouble();
    	sc.nextLine();
    	accountFunction.deposit(amountToDeposit);
    }
    System.out.println("Do you want to withdraw money?(Yes/No)");
    String withdrawChoice=sc.nextLine();
    if(withdrawChoice.equals("Yes")) {
    	System.out.println("Enter the amount for withdrawal");
    	double amountToWithdraw=sc.nextDouble();
    	sc.nextLine();
    	accountFunction.withdraw(amountToWithdraw);
    }   
  }
}
