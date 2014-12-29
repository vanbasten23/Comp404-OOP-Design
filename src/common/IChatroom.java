package common;

import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;

import provided.datapacket.ADataPacket;

public interface IChatroom extends Serializable {
    //IUser myUserStub; 
    //ArrayList<IUser> userList;
	// Create chatroom API (Group 2)
	
	
	/**
	 * Get the name of the chatroom if needed
	 * @return The name of the chatroom
	 */
	public String getName();
	
	
	/**
	 * Returns the unique UUID of the chatroom if needed
	 * @return The UUID of the chatroom
	 * by Justin
	 */
	public UUID getUUID();

	
	/**
	 * Get the list of IMembers in the room
	 * @return a list of members in the room
	 */
	public Collection<IMember> getMembers();
	
	/**
	* Adds a list of members to IChatroom object
	*/
	public void addMembers(Collection<IMember> userstub);
	
	
	
	/**
	 * Used when joining a new chat room.
	 * The local will call IMember.sendMessage()
	 * The remote will execute the message which 
	 * asks to add the newly joined Member to their
	 * corresponding chat room
	 * @param member The IMember stub of the newly joined person.
	 */
	public void addMember(IMember member);
	
	

	
	/**
	* removes user LOCALLY from chatroom object
	* This method does not do any broadcasting.
	*/
	public void removeMember(IMember userstub);
	
	
	
	
	/**
	 * sends message across chat room to all IMembers. for all IMembers(Stub) in this chat room,
	 * it should call the receiveMessage method the get the message remotely. And, must 
	 * keep in mind that receiveMessage method always return another message as the feedback 
	 * to the sender.
	 * e.g
	 * for(IMembers user in userList) IMembers.receiveMessage
	 * @param the message sent across the chat room
	 * @return An ADataPacket List to collect all the return values.
	 */
	public Collection<ADataPacket> broadcastMsg(ADataPacket msg);
		
}
