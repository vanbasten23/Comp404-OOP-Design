package common;

import java.io.Serializable;

import provided.datapacket.ADataPacket;
import provided.datapacket.ADataPacketAlgoCmd;

/**
 * The interface to add a command. Must be used to define the Data Packet.
 * To send the command, create a DataPacket that contains
 * this interface, i.e. DataPacket<IAddCmd>
 * 
 * This is a known type and therefore each program must implement an algorithm
 * for the host of type IAddCmd.
 * 
 * Running the algorithm that corresponds to this case should cause the visitor
 * to add the command provided by IAddCmd
 * 
 * e.g. myDataPacketAlgo.addCmd(myAddCmd.getID(), myAddCmd.getCmd());
 * 
 * The visitor must use parameter type Void. Because Void only accepts null, and
 * using null in varargs is not allowed, this means parameters are not used.
 *
 */
public interface IAddCmd extends Serializable {
	
	/**
	 * Get the class type of the requested unknown host command. Should be used
	 * when adding the command to the visitor.
	 * 
	 * @return The class type for the command to add
	 */
	public Class<?> getID();
	
	/**
	 * Get the Visitor Cmd so it can be added to the visitor.
	 * 
	 * 
	 * @return
	 */
	public ADataPacketAlgoCmd<ADataPacket, ?, Void> getCmd();
	
}
