package Customer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import Calls.Call;
import Complaint.Complaint;

public class Customer {
	    private int customerId;
	    private String name;
	    private String phoneNumber;
	    private LinkedList<Call> callHistory;
	    private HashSet<String> vasSubscriptions;
	    private LinkedList<Complaint> complaints;
	      
		public int getCustomerId() {
			return customerId;
		}
		
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public List<Call> getCallHistory() {
			return callHistory;
		}
		
		public void setCallHistory(LinkedList<Call> callHistory) {
			this.callHistory = callHistory;
		}
		
		public Set<String> getVasSubscriptions() {
			return vasSubscriptions;
		}
		
		public void setVasSubscriptions(HashSet<String> vasSubscriptions) {
			this.vasSubscriptions = vasSubscriptions;
		}
		
		public List<Complaint> getComplaints() {
			return complaints;
		}
		
		public void setComplaints(LinkedList<Complaint> complaints) {
			this.complaints = complaints;
		}
		
		public Customer(int customerId, String name,String phoneNumber) {
			super();
			this.customerId = customerId;
			this.name = name;
			this.phoneNumber=phoneNumber;
			callHistory=new LinkedList<>();
			vasSubscriptions=new HashSet<>();
			complaints=new LinkedList<>();		
		}
		
		public synchronized void recordCalls(String phoneNumber,int duration) {
			callHistory.add(new Call(phoneNumber,duration));
		}
		                         
		public synchronized void subscribetoVas(String service) {
				vasSubscriptions.add(service);
			}			                 
		
		public synchronized void removeVasSubscription(String service) {	
			if(vasSubscriptions.contains(service)) {
				vasSubscriptions.remove(service);
			}			
		}
		
		public void addComplaint(Complaint complaint) {
			complaints.add(complaint);
		}	
		
	    public void viewComplaints() {
	        if (complaints.isEmpty()) {
	            System.out.println("No complaints filed");
	        } else {
	            for (Complaint complaint:complaints) {
	                System.out.println(complaint);
	            }
	        }
	    }

	    public void displaySummary() {
	        System.out.println("Customer ID: " +customerId);
	        System.out.println("Name : " +name);

	        System.out.println("Call History:");
	        if (callHistory.isEmpty()) {
	            System.out.println("No calls made");
	        } else {
	            for (Call call:callHistory) {
	                System.out.println("  " + call);
	            }
	        }
	    }
}
