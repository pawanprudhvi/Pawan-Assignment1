package Calls;

public class Call {
	  private String phoneNumber;
	  private int duration;
	public Call(String phoneNumber, int duration) {
		super();
		this.phoneNumber = phoneNumber;
		this.duration = duration;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getDuration() {
		return duration;
	}
	@Override
	public String toString() {
		return "Call [phoneNumber=" + phoneNumber + ", duration=" + duration + "]";
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
}
