package Customer;

import java.util.HashMap;

public class CustomersManager {
	private static int customerId;
	HashMap<Integer,Customer> allCustomers;
	
	public CustomersManager() {
		allCustomers=new HashMap<>();
	}
	
	public void addCustomer(String name,String phoneNumber) {
		customerId++;
		Customer customer=new Customer(customerId,name,phoneNumber);
		allCustomers.put(customerId,customer);		
		}
    
    public Customer getCustomer(int customerId) {
    	return allCustomers.get(customerId);
    }
    
    public void AllCustomers() {
        if (allCustomers.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            for (Customer customer : allCustomers.values()) {
                System.out.println("\n");
                customer.displaySummary();
            }
        }
    }
}

