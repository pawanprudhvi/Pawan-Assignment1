package Calls;

import java.time.LocalDateTime;

public class CallRecord {
    private String caller;
    private String receiver;
    private int duration; // in seconds
    private String operator;
    private String location;
    private LocalDateTime timestamp;

    public CallRecord(String caller, String receiver, int duration, String operator, String location, LocalDateTime timestamp) {
        this.caller = caller;
        this.receiver = receiver;
        this.duration = duration;
        this.operator = operator;
        this.location = location;
        this.timestamp = timestamp;
    }
    @Override
	public String toString() {
		return "CallRecord [caller=" + caller + ", receiver=" + receiver + ", duration=" + duration + ", operator="
				+ operator + ", location=" + location + ", timestamp=" + timestamp + "]";
	}
	public String getCaller() { return caller; }
    public String getReceiver() { return receiver; }
    public int getDuration() { return duration; }
    public String getOperator() { return operator; }
    public String getLocation() { return location; }
    public LocalDateTime getTimestamp() { return timestamp; }
}
