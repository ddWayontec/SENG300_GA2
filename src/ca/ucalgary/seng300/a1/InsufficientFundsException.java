package ca.ucalgary.seng300.a1;

/**
 * An exception to signal that there are no sufficient funds to make a purchase.
 * Can contain 
 *
 */
@SuppressWarnings("serial")
public class InsufficientFundsException extends Exception {
	private String message;
	public InsufficientFundsException(String message){
		super(message);
	}
	
	public String toString(){
		return message;
	}
}
