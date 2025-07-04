package Calls;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	    public static void main(String[] args) {
	        CallOperations service = new CallOperations();
	        Scanner sc = new Scanner(System.in);
	        while (true) {
	            System.out.println("1.Add Call Record");
	            System.out.println("2.View All Records");
	            System.out.println("3.Group by Location");
	            System.out.println("4. Most called");
	            System.out.println("5. Exit");
	            System.out.print("Choose Number: ");
	            int choice = sc.nextInt();
	            sc.nextLine();
	            switch (choice) {
	                case 1:
	                    System.out.print("Caller:");
	                    String caller = sc.nextLine();
	                    System.out.print("Receiver:");
	                    String receiver = sc .nextLine();
	                    System.out.print("Duration (seconds):");
	                    int duration = sc.nextInt(); sc.nextLine();
	                    System.out.print("Operator:");
	                    String operator = sc.nextLine();
	                    System.out.print("Location:");
	                    String location = sc.nextLine();
	                    CallRecord record = new CallRecord(caller, receiver, duration, operator, location, LocalDateTime.now());
	                    service.addRecord(record);
	                    System.out.println("Record addedd.");
	                    break;
	                case 2:
	                    service.getAllRecords().forEach(System.out::println);
	                    break;

	                case 3:
	                    Map<String, List<CallRecord>> grouped = service.groupByLocation();
	                    grouped.forEach((loc, list) -> {
	                        System.out.println("Location:"+loc);
	                        list.forEach(System.out::println);
	                    });
	                    break;
	                case 4:
	                    service.countCallsByCaller()
	                        .entrySet()
	                        .stream()
	                        .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
	                        .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()+"calls"));
	                    break;
	                case 5:
	                    System.out.println("Thank you for using callHistoryAnalysis.");
	                    sc.close();
	                    return;
	                default:
	                    System.out.println("Invalid number.");
	            }
	        }
	    }
}
