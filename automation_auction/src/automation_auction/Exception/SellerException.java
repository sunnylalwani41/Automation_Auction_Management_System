package automation_auction.Exception;

public class SellerException extends Exception{
	String message;

	public SellerException() {
		super();
	}

	public SellerException(String message) {
		super(message);
	}
	
}
