package xw32_wb7.chatroom.cmd;

import provided.datapacket.ADataPacket;
import provided.datapacket.ADataPacketAlgoCmd;
import xw32_wb7.game.msg.IScoreBoardMsg;
import common.IAddCmd;

/**
 * The score board command 
 * @author xwei
 *
 */
public class ScoreBoardCmd implements IAddCmd{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2461689773689865454L;
	
	

	@Override
	public Class<?> getID() {
		return IScoreBoardMsg.class;
	}

	@Override
	public ADataPacketAlgoCmd<ADataPacket, ?, Void> getCmd() {
		return null;
	}

}
