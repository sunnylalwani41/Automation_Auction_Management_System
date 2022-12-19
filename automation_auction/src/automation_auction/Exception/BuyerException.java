package automation_auction.Exception;

public class BuyerException extends Exception{
	String message;

	public BuyerException() {
		super();
	}
	public BuyerException(String message) {
		super(message);
	}
}
