package xw32_wb7.server.model;

import common.IChatroom;
import common.IPerson;

/**
 * This is the server model to server view adapter.
 * @author xw32, wb7
 *
 */
public interface IServerModel2ViewAdpt {

	/**
	 * Append text to the server GUI.
	 * @param s The text to be appended.
	 */
	public void append(String s);

	/**
	 * Set the remote host.
	 * @param localAddress The local address.
	 */
	public void setRemoteHost(String localAddress);
	
	/**
	 * add the created team to the team drop list.
	 * @param team The team object of type IChatroom
	 */
	public void addToTeamDropList(IChatroom team);
	
	/**
	 * add the newly connected person to the person list.
	 * @param personStub The newly connected person to be added to the person drop list.
	 */
	public void addToPersonDropList(IPerson personStub);

	/**
	 * append the newly connect person to the JList on server GUI
	 * @param personStub
	 */
	public void appendToPersonJList(IPerson personStub);
	
	/**
	 * Get the selected chat room
	 * @return The selected chat room
	 */
	public IChatroom getSelectedChatroom();
}
