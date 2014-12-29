package xw32_wb7.messagefactory;


import provided.datapacket.ADataPacket;
import provided.datapacket.ADataPacketAlgoCmd;
import provided.datapacket.DataPacket;
import common.IAddCmd;
import common.IMember;

/**
 * addCmdMsgFactory is used to create AddCmdMsg.
 * @author xw32, wb7
 *
 */
public class AddCmdMsgFactory implements IMsgFactory<IAddCmd>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -926768623001519722L;

	/**
	 * My local member stub.
	 */
	private IMember myMemberStub;
	
	/**
	 * The index of the class.
	 */
	private Class<?> index;
	
	/**
	 * The command
	 */
	private ADataPacketAlgoCmd<ADataPacket, ?, Void> cmd;//TODO: WHY is <ADataPacket, ?, ?> ?
	
	/**
	 * Construct the AddCmdMsg
	 * @param myMemberStub My member stub
	 * @param index The index.
	 * @param cmd The command.
	 */
	public AddCmdMsgFactory(IMember myMemberStub,Class<?> index, ADataPacketAlgoCmd<ADataPacket, ?, Void> cmd) {
		this.myMemberStub = myMemberStub;
		this.index = index;
		this.cmd = cmd;
	}
	
	@Override
	public DataPacket<IAddCmd> makeMsg() {
		return new DataPacket<IAddCmd>(IAddCmd.class, myMemberStub, new IAddCmd() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 3188908811742718492L;

			@Override
			public Class<?> getID() {
				return index;
			}
			
			@Override
			public ADataPacketAlgoCmd<ADataPacket, ?, Void> getCmd() {
				return cmd;
			}
		});
	}

}
