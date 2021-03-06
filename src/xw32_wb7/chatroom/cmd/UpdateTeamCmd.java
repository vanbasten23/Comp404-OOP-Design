package xw32_wb7.chatroom.cmd;

import provided.datapacket.ADataPacket;
import provided.datapacket.ADataPacketAlgoCmd;
import provided.datapacket.DataPacket;
import provided.mixedData.IMixedDataDictionary;
import provided.mixedData.MixedDataKey;
import xw32_wb7.game.model.GameModel;
import xw32_wb7.game.model.UpdateTeamMsg;
import xw32_wb7.game.msg.IUpdateTeamMsg;

import common.IAddCmd;
import common.ICmd2ModelAdapter;
import common.IFailMsg;
import common.IMember;
import common.ISuccessMsg;

/**
 * The update team command.
 * @author xw32, wb7.
 *
 */
public class UpdateTeamCmd implements IAddCmd {

	/**
	 * 
	 */
	private static final long serialVersionUID = -344420583133635322L;
	
	/**
	 * The command.
	 */
	private ADataPacketAlgoCmd<ADataPacket, Object, Void> cmd;
	
	/**
	 * The mixed data dictionary.
	 */
	private IMixedDataDictionary mdd;

	/**
	 * Construct the updateTeamCommand
	 * @param modelKey The model key.
	 * @param localMemberStub The local member stub.
	 */
	public UpdateTeamCmd(MixedDataKey<GameModel> modelKey, IMember localMemberStub){
		cmd = new ADataPacketAlgoCmd<ADataPacket, Object, Void>(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 7224583564658098600L;
			private ICmd2ModelAdapter adapter;
			@Override
			public ADataPacket apply(Class<?> index, DataPacket<Object> host,
					Void... params) {
				ADataPacket result;
				try{
					mdd = adapter.getMDD();
					GameModel model = (GameModel)mdd.get(modelKey);
					UpdateTeamMsg msg = (UpdateTeamMsg)host.getData();
					int curScore = msg.getScore();
					
					double lat = msg.getLatitude();
					double longt = msg.getLongtitude();
					
					System.out.println("Client received update message!");
					model.updateTeamScore(curScore);
					model.updateTeammatesPlace(lat, longt);
					
					result = new DataPacket<ISuccessMsg>(ISuccessMsg.class, localMemberStub, null);
				}catch(Exception e){
					result = new DataPacket<IFailMsg>(IFailMsg.class, localMemberStub, null);
				}
				return result;
			}

			@Override
			public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
				adapter = cmd2ModelAdpt;
			}
			
		};
	}
	
	@Override
	public Class<?> getID() {
		return IUpdateTeamMsg.class;
	}

	@Override
	public ADataPacketAlgoCmd<ADataPacket, ?, Void> getCmd() {
		return this.cmd;
	}

}
