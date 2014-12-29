package common;

import java.io.Serializable;

/**
 * The request to get a command. Must be used to define the Data Packet.
 * To send the request, create a DataPacket that contains
 * this request, i.e. DataPacket<IRequestCmd>
 * 
 * This is a known type and therefore each program must implement an algorithm
 * for the host of type IRequestCmd.
 * 
 * The algorithm to handle this type should return a DataPacket<IAddCmd>
 *
 */
public interface IRequestCmd extends Serializable {

	/**
	 * Get the class type of the requested unknown host command. Should be used
	 * when getting the command from the visitor.
	 * 
	 * e.g. myDataPacketAlgo.getCmd(myRequest.getID())
	 * 
	 * @return The class type for the requested command
	 */
	public Class<?> getID();

}
