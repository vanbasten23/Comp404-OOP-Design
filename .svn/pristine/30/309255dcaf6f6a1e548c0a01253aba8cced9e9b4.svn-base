package xw32_wb7.messagefactory;


import provided.datapacket.DataPacket;
import common.IJoinRoomMsg;
import common.IMember;

/**
 * The join room message factory is used to make joint room message.
 * @author xwei
 *
 */
public class JoinRoomMsgFactory implements IMsgFactory<IJoinRoomMsg>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7132684176261628932L;
	
	/**
	 * My member stub
	 */
	private IMember myMemberStub;
	
	/**
	 * Construct a my member stub.
	 * @param myMemberStub The my member stub.
	 */
	public JoinRoomMsgFactory(IMember myMemberStub) {
		this.myMemberStub = myMemberStub;
	}

	@Override
	public DataPacket<IJoinRoomMsg> makeMsg() {
		return new DataPacket<IJoinRoomMsg>(IJoinRoomMsg.class, myMemberStub, new IJoinRoomMsg() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 482332132441190496L;

			@Override
			public IMember getMember() {
				return myMemberStub;
			}
		});
	}
}
