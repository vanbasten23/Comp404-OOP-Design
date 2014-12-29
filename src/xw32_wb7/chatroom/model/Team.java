package xw32_wb7.chatroom.model;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import provided.datapacket.ADataPacket;
import provided.datapacket.DataPacket;
import xw32_wb7.util.ThreadPoolUtil;
import common.IChatroom;
import common.IFailMsg;
import common.IMember;


/**
 * This is the concrete team class. Lobby and team are the same. They all
 * implements IChatroom interface.
 * @author xw32,wb7
 *
 */
public class Team implements IChatroom{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5350480459737123398L;

	/**
	 * The name of the team.
	 */
	private String name;
	
	/**
	 * The uuid of the team.
	 */
	private UUID uuid = UUID.randomUUID();
	
	/**
	 * The member stub in this team.
	 */
	private List<IMember> memberStubList;
	
	/**
	 * Construct the team using a name.
	 * @param name
	 */
	public Team(String name) {
		this.name = name;
		memberStubList = new ArrayList<IMember>();
	}
	
	@Override
	public String toString(){
		return name;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public UUID getUUID() {
		return uuid;
	}

	@Override
	public Collection<IMember> getMembers() {
		return memberStubList;
	}

	@Override
	public void addMembers(Collection<IMember> userstub) {
		memberStubList.addAll(userstub);
	}

	public void send2Teammates(IMember member, ADataPacket msg){
		ThreadPoolUtil.execute(new Runnable(){
			@Override
			public void run() {
				for(IMember m: memberStubList){
					try {
						if(m.getUUID().equals(member.getUUID())){
							member.recvMessage(msg);
						}
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}				
			}
			
		});
		
	}
	@Override
	public void addMember(IMember member) {
		for(IMember m: memberStubList){
			try {
				if(m.getUUID().equals(member.getUUID())){
					return;
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		memberStubList.add(member);
	}

	/**
	* removes user LOCALLY from chatroom object
	* This method does not do any broadcasting.
	*/
	@Override
	public void removeMember(IMember userstub) {
		IMember removeMember = null;
		for(IMember m :memberStubList){
			try {
				if(m.getUUID().equals(userstub.getUUID())){
					removeMember = m;
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		if(removeMember != null){
			memberStubList.remove(removeMember);
		}
		
	}

	@Override
	public Collection<ADataPacket> broadcastMsg(ADataPacket msg) {
		Collection<ADataPacket> returnDataPacketList = new ArrayList<ADataPacket>();
		for(int i = 0; i < memberStubList.size(); i++){
			
			ADataPacket pac;
			IMember m = memberStubList.get(i);
			try {
				pac = m.recvMessage(msg);
				returnDataPacketList.add(pac);
			} catch (RemoteException e) {
				e.printStackTrace();
				pac = new DataPacket<IFailMsg>(IFailMsg.class, m, new IFailMsg() {
					
					/**
					 * 
					 */
					private static final long serialVersionUID = 2864677635566290486L;

					@Override
					public String getErrorText() {
						return "fails to send a msg. RemoteException.";
					}
				});
				returnDataPacketList.add(pac);
			}
		
		}
		return returnDataPacketList;
	}
	
	/**
	 * Check if a member is in the team.
	 * @param member The member stub.
	 * @return True if the given memberstub is already in the team.
	 */
	public boolean isInTeam(IMember member){
		for(IMember m: memberStubList){
			try {
				if(m.getUUID().equals(member.getUUID())){
					return true;
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return false;
		
	}
}
