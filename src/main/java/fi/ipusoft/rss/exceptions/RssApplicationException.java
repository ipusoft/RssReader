package fi.ipusoft.rss.exceptions;

/**
 * RSS application exception. 
 * @author isto
 *
 */
public class RssApplicationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
 	public RssApplicationException(String message) {
 		super(message);
 	}
	
}
