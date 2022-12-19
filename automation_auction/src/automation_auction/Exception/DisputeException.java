package automation_auction.Exception;

public class DisputeException extends Exception{
	String message;

	public DisputeException() {
		super();
	}

	public DisputeException(String message) {
		super(message);
		
	}
	
}
