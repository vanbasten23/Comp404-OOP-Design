package common;

import java.io.Serializable;

/**
 * The message used to reject other messages, usually as a reply.
 * 
 * @author jdp5
 *
 */
public interface IRejectMsg extends Serializable {
	
	/**
	 * Get the reason for rejecting the message
	 * 
	 * @return The text that explains the reason for rejection.
	 */
	public String getReasonText();

}
