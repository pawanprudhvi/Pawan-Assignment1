package CustomExceptions;

public class WithdrawalLimitReachedException extends Exception {
	public WithdrawalLimitReachedException(String message) {
		super(message);
	}

}
