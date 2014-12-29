package xw32_wb7.chatroom.cmd;


import provided.datapacket.ADataPacket;
import provided.datapacket.ADataPacketAlgoCmd;
import provided.datapacket.DataPacket;
import provided.mixedData.IMixedDataDictionary;
import provided.mixedData.MixedDataKey;
import xw32_wb7.game.controller.GameFac;
import xw32_wb7.game.model.GameModel;
import xw32_wb7.game.msg.IAroundWorld;

import common.IAddCmd;
import common.ICmd2ModelAdapter;
import common.IFailMsg;
import common.IMember;
import common.ISuccessMsg;

/**
 * The Game Cmd
 * @author xw32, wb7
 *
 */
public class GameCmd implements IAddCmd {

	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 8173376426036459499L;
	
	/**
	 * Command algorithm
	 */
	private ADataPacketAlgoCmd<ADataPacket, ?, Void> cmd;
	
	/**
	 * he mixed data dictionary
	 */
	private IMixedDataDictionary mdd;
	
	/**
	 * Construct a GameCmd
	 * @param modelKey The model key
	 * @param localMemberStub The local member stub
	 */
	public GameCmd(MixedDataKey<GameModel> modelKey, IMember localMemberStub){
		cmd = new ADataPacketAlgoCmd<ADataPacket, Object, Void>(){

			/**
			 * 
			 */
			private static final long serialVersionUID = -7451469749538918667L;
			private ICmd2ModelAdapter adapter;
			@Override
			public ADataPacket apply(Class<?> index,
					DataPacket<Object> host, Void... params) {
				ADataPacket result;
				try{
					GameFac gf = ((GameFac)host.getData());
					gf.makeGame();
					
					mdd = adapter.getMDD();
				
					GameModel model = gf.getController().getGameModel();
				
					mdd.put(modelKey, model);
				
					model.setClientMemberStub(adapter.getLocalMember());
				
					result = new DataPacket<ISuccessMsg>(ISuccessMsg.class, localMemberStub, null);
					System.out.println(adapter.getLocalMember().getName() + "has received the game command!");
				
				}catch(Exception e){
					result = new DataPacket<IFailMsg>(IFailMsg.class, localMemberStub, null);
				}
				return result;
			}

			@Override
			public void setCmd2ModelAdpt(
					ICmd2ModelAdapter cmd2ModelAdpt) {
				adapter = cmd2ModelAdpt;
			}
			
		
			
		};
	}



	@Override
	public Class<?> getID() {
		return IAroundWorld.class;
	}

	@Override
	public ADataPacketAlgoCmd<ADataPacket, ?, Void> getCmd() {
		return this.cmd;
	}

}