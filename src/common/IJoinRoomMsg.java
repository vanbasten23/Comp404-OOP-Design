package common;

import java.io.Serializable;

/**
 * Known message type for joining request
 * @author Colin
 * @author jdp5
 *
 */
public interface IJoinRoomMsg extends Serializable {

	/**
	 * Get the member that is joining the room
	 * 
	 * @return The stub for the member that is joining the room
	 */
	public IMember getMember();

}
