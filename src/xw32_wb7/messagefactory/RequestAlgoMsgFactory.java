package xw32_wb7.messagefactory;

import common.IMember;
import common.IRequestCmd;
import provided.datapacket.DataPacket;

/**
 * This is the request algorithm 
 * @author xwei
 *
 */
public class RequestAlgoMsgFactory implements IMsgFactory<IRequestCmd> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2493560719295800011L;

	/**
	 * The index
	 */
	private Class<?> index;
	
	/**
	 * My member stub.
	 */
	private IMember myMemberStub;
	
	/**
	 * Construct a request algorithm message factory
	 * @param index The index.
	 * @param myMemberStub The my member stub.
	 */
	public RequestAlgoMsgFactory(Class<?> index, IMember myMemberStub) {
		this.index = index;
		this.myMemberStub = myMemberStub;
	}
	
	@Override
	public DataPacket<IRequestCmd> makeMsg() {
		return new DataPacket<IRequestCmd>(IRequestCmd.class, myMemberStub, new IRequestCmd() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 7653203709189653754L;

			@Override
			public Class<?> getID() {
				return index;
			}
		});
		
	}
}
