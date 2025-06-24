package Complaint;

public class Complaint {
	private int complaintId=0;
    private String description;

    public Complaint(String description) {
    	complaintId++;
        this.description = description;
    }

    public int getComplaintId() {
        return complaintId;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Complaint ID: " + complaintId + ", Description: " + description;
    }
}
