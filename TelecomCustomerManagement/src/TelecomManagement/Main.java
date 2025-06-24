package TelecomManagement;

import java.util.Scanner;

import Customer.Customer;
import Customer.CustomersManager;

public class Main {
	public static void main(String args[]) {
		CustomersManager manager=new CustomersManager();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Yes to use Telecom System(No to exit)");
        String choice =sc.nextLine();
        while(choice.equals("Yes")) {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = sc.nextLine();
        manager.addCustomer(name,phoneNumber);
        System.out.println("Customer Added successfully");
        
        System.out.println("Do you want to add call to your call history?(Yes/No)");
        String recordCall=sc.nextLine();
        if(recordCall.equalsIgnoreCase("Yes")) {
        System.out.print("Enter Customer ID: ");
        int custId = sc.nextInt();
        sc.nextLine();
        Customer customer = manager.getCustomer(custId);
        if (customer!=null) {
            System.out.print("Enter number called: ");
            String number = sc.nextLine();
            System.out.print("Duration in minutes");
            int duration = Integer.parseInt(sc.nextLine());
            customer.recordCalls(number,duration);
            System.out.println("Call record Added successfully");
        } 
        else {
            System.out.println("Customer not found.");
        }
        }
        System.out.println("Enter Yes to continue using Telecom System");
        choice=sc.nextLine();
        }
        manager.AllCustomers();
    }	
	
}
