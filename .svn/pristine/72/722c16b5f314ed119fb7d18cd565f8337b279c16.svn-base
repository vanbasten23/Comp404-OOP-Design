package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.UUID;

import provided.datapacket.ADataPacket;

public interface IMember extends Remote {	
	
	
	/**
	 * Get the name of the member
	 * @return friendly name for the member
	 * @throws RemoteException  Required for RMI transactions.
	 * by Justin
	 */
	public abstract String getName() throws RemoteException;
	
	
	
	/**
	 * Returns the unique UUID of the stub. NOTE: It is REQUIRED that this
	 * method return the same UUID as the getUUID() method on the IPerson stub
	 * associated with this IMember.
	 * @return The UUID of the IMember stub
	 * by Justin
	 */
	public abstract UUID getUUID() throws RemoteException;
	
	
	/**
	 * IMember Stub use this method to receive message from chat room 
	 * remotely. in this method, we should call the execute message method 
	 * to execute the message as a Host in Visitor design
	 * pattern. And receiveMessage method return an Imessage return by the algo execution as 
	 * a result.
	 * @param The message sent from the chat room
	 * @return IMessage: another message as the feedback to the 
	 * 					 sender.
	 */
	public ADataPacket recvMessage(ADataPacket msg) throws RemoteException;


}
