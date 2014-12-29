package xw32_wb7.messagefactory;

import provided.datapacket.DataPacket;
import common.IMember;
import common.ITextMsg;

/**
 * The text message factory used to create text message factory.
 * @author xw32, wb7.
 *
 */
public class TextMsgFactory implements IMsgFactory<ITextMsg>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2206750680516770859L;

	/**
	 * myMemberStub
	 */
	private IMember myMemberStub;
	
	/**
	 * textMsg 
	 */
	private String textMsg;
	
	/**
	 * Constructor of the factory.
	 * @param myMemberStub My member stub.
	 * @param textMsg The text message
	 */
	public TextMsgFactory(IMember myMemberStub, String textMsg) {
		this.myMemberStub = myMemberStub;
		this.textMsg = textMsg;
	}
	
	@Override
	public DataPacket<ITextMsg> makeMsg() {
		return new DataPacket<ITextMsg>(ITextMsg.class, myMemberStub, new ITextMsg() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = -477122808967104642L;

			@Override
			public String getText() {
				return textMsg;
			}
		});
	}

}