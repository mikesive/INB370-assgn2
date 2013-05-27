package asgn2Exceptions;

/**
 * 
 * @author Wayne Maxwell
 * 
 */
@SuppressWarnings("serial")
public class TrainException extends Exception {

	/**
	 * produces a train exception with a string message
	 * 
	 * @param msg
	 */
	public TrainException(String msg) {
		super("Train Exception: " + msg);
	}
}
