package xw32_wb7.chatroom.model;

import provided.datapacket.ADataPacket;

/**
 * This is the member to model adapter
 * @author xw32, wb7
 *
 */
public interface IMember2ModelAdpt {
	
	public static IMember2ModelAdpt defaultAdpt = new IMember2ModelAdpt(){

		@Override
		public ADataPacket handleMessage(ADataPacket msg) {
			return null;
		}
		
	};
	
	/**
	 * After memberStub receives a message, execute this message.
	 * @param msg The message that the memberStub receives.
	 * @return A message.
	 */
	public ADataPacket handleMessage(ADataPacket msg);
}
