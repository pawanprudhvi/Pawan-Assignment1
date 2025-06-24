package Complaint;

public class Complaint {
	private String complaintId;
    private String description;

    public Complaint(String complaintId, String description) {
        this.complaintId = complaintId;
        this.description = description;
    }

    public String getComplaintId() {
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
