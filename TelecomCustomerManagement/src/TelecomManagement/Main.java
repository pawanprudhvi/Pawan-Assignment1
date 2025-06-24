package TelecomManagement;

import java.util.Scanner;

import Complaint.Complaint;
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
        
        System.out.print("Do you want to subscribe to VAS?(Yes/No)");
        String vasChoice=sc.nextLine();
        if(vasChoice.equalsIgnoreCase("Yes")) {
        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        Customer Vascustomer = manager.getCustomer(id);
        if (Vascustomer!=null) {
            System.out.println("Enter VAS to subscribe: ");
            String vas = sc.nextLine();
            Vascustomer.subscribetoVas(vas);
            System.out.println("VAS Successfully Subscribed");
        } else {
            System.out.println("Customer not found.");
        }
        }
        System.out.println("Do you want to unsubscribe to VAS?(Yes/No)");
        String vasUnsubscribe=sc.nextLine();
        if(vasUnsubscribe.equalsIgnoreCase("Yes")) {
        System.out.print("Enter Customer ID: ");
        int id=sc.nextInt();
        sc.nextLine();
        Customer customer = manager.getCustomer(id);
        if (customer!=null) {
            System.out.println("Enter VAS to unsubscribe: ");
            String vas = sc.nextLine();
            customer.removeVasSubscription(vas);
            System.out.println("VAS unsubscribed");
        } else {
            System.out.println("Customer not found.");
        }
    }
	
        System.out.println("Do you want to file a complaint?(Yes/No)");
        String complaints=sc.nextLine();
        if(complaints.equalsIgnoreCase("Yes")) {
	        System.out.print("Enter Customer ID: ");
	        int id=sc.nextInt();
	        sc.nextLine();
	        Customer customer = manager.getCustomer(id);
	        if (customer != null) {
	            System.out.print("Enter complaint description: ");
	            String desc = sc.nextLine();
	            Complaint complaint=new Complaint(desc);
	            customer.addComplaint(complaint);
	            System.out.print("Complaint filed");
        } 
	    else {
            System.out.println("Customer not found.");
        }
      }
        manager.AllCustomers();
	}
}
