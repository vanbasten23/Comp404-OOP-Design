package xw32_wb7.chatroom.model;

import java.rmi.RemoteException;
import java.util.UUID;

import provided.datapacket.ADataPacket;
import common.IChatroom;
import common.IMember;

/**
 * This is the concrete member class.
 * @author xw32, wb7
 *
 */
public class Member implements IMember {

	/**
	 * According to the API, this uuid should be the 
	 * same as the corresponding person's uuid.
	 */
	private UUID uuid;

	/**
	 * This is the name of the member.
	 */
	private String userName;
	
	/**
	 * This is the member to model adapter.
	 */
	private IMember2ModelAdpt _member2TeamModelAdpt;


	/**
	 * The chat room that this member belongs to.
	 */
	private IChatroom ownChatRoom;

	/**
	 * Construct the member object.
	 * @param userName The name of the member
	 * @param uuid The uuid of the member, should be the same as the corresponding person's uuid.
	 * @param adapter The member to model adapter.
	 */
	public Member(String userName, UUID uuid, IMember2ModelAdpt adapter) {//TODO: need to unify the two constructor together.
		this.userName = userName;
		this.uuid = uuid;
		this._member2TeamModelAdpt = adapter;
	}
	
	/**
	 * Get the team that this member belongs to.
	 * @return The team that this member belongs to.
	 */
	public IChatroom getOwnChatRoom() {
		return ownChatRoom;
	}

	/**
	 * Set the member to team model adapter.
	 * @param adapter The member to team model adapter.
	 */
	public void setMember2TeamModelAdpt(IMember2ModelAdpt adapter){
		this._member2TeamModelAdpt = adapter;
	}

	@Override
	public String getName() throws RemoteException {
		return userName;
	}

	@Override
	public UUID getUUID() throws RemoteException {
		return uuid;
	}

	@Override
	public ADataPacket recvMessage(ADataPacket msg)
			throws RemoteException {
		return _member2TeamModelAdpt.handleMessage(msg);
	}

	/**
	 * To display the name of this member.
	 */
	public String toString() {
		return userName;
	}
}
