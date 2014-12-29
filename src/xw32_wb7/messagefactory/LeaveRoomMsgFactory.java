package xw32_wb7.messagefactory;


import provided.datapacket.DataPacket;
import common.ILeaveRoomMsg;
import common.IMember;

/**
 * The leave room message factory to make leave room message.
 * @author xw32, wb7
 *
 */
public class LeaveRoomMsgFactory implements IMsgFactory<ILeaveRoomMsg>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7812289110815626860L;

	/**
	 * My member stub.
	 */
	private IMember myMemberStub;
	
	/**
	 * Construct a leave room message factory.
	 * @param myMemberStub
	 */
	public LeaveRoomMsgFactory(IMember myMemberStub) {
		this.myMemberStub = myMemberStub;
	}
	
	@Override
	public DataPacket<ILeaveRoomMsg> makeMsg() {
		return new DataPacket<ILeaveRoomMsg>(ILeaveRoomMsg.class, myMemberStub, new ILeaveRoomMsg() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = -5290872205969016592L;

			@Override
			public IMember getMember() {
				return myMemberStub;
			}
		});
	}
	
}
