package automation_auction.Exception;

public class AdministrationException extends Exception{
	String message;

	public AdministrationException() {
		super();
	}
	
	public AdministrationException(String message) {
		super(message);
		
	}
}
