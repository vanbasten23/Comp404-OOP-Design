package xw32_wb7.messagefactory;

import provided.datapacket.DataPacket;
import common.IFailMsg;
import common.IMember;

/**
 * The fail message factory to make fail message
 * @author xw32, wb7
 *
 */
public class FailMsgFactory implements IMsgFactory<IFailMsg>{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2705136425862936909L;

	/**
	 * The sender member stub.
	 */
	private IMember sender;
	
	/**
	 * Error text message.
	 */
	private String errorText;
	
	/**
	 * Construct  a fail message factory
	 * @param sender The sender member stub.
	 * @param errorText The error text message.
	 */
	public FailMsgFactory(IMember sender, String errorText) {
		this.sender = sender;
		this.errorText = errorText;
	}
	
	@Override
	public DataPacket<IFailMsg> makeMsg() {
		return new DataPacket<IFailMsg>(IFailMsg.class, sender, new IFailMsg() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 7477288283566784844L;

			@Override
			public String getErrorText() {
				return errorText;
			}
		});
	}

}
