package xw32_wb7.game.model;

import java.io.Serializable;
import java.rmi.RemoteException;

import provided.datapacket.ADataPacket;
import provided.datapacket.DataPacket;
import xw32_wb7.client.model.Place;
import xw32_wb7.game.element.City;
import xw32_wb7.game.element.Transportation;
import xw32_wb7.game.msg.ILocalGameOverMsg;
import xw32_wb7.game.msg.IMoveMsg;
import xw32_wb7.util.ThreadPoolUtil;

import common.IFailMsg;
import common.IMember;

/**
 * Game model, can handle actions from game GUI, and send messages to server.
 * @author Wenbo Bu, Xiongfei Wei, Master of Computer Science
 * 		   Department of Computer Science, Rice University
 * @Version Created on Dec 5, 2014, 8:55:16 PM
 */
public class GameModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3418006685812648562L;
	/**
	 * Model to view adapter
	 */
	private IGameModel2ViewAdpt m2gvAdpt;
	/**
	 * The action message that will be sent to the server
	 */
	private ADataPacket action;
	/**
	 * Server member stub, can be used to send messages to server
	 */
	private IMember serverMember;
	/**
	 * Client member stub, got from ICmd2ModelAdapter, used to let server know 
	 * which client send the message.
	 */
	private IMember clientMember;
	
	/**
	 * The first city player chooses
	 */
	private String startCity;
	
	/**
	 * A flag identify whether the game is started
	 */
	private boolean started = false;
	
	/**
	 * Move message. 
	 */
	private IMoveMsg moveMsg;
	
	/**
	 * Local gameover message
	 */
	private ILocalGameOverMsg localGameOverMsg;
	/**
	 * Constructor of game model
	 * @param gameAdpt the model to view adapter
	 */
	public GameModel(IGameModel2ViewAdpt gameAdpt, IMember serverMember){
		this.m2gvAdpt = gameAdpt;
		this.serverMember = serverMember;
	}
	
	/**
	 * Start the game model
	 */
	public void start(){
		
	}
	
	/**
	 * Response to the view's goPlace function, tell the server what aciont the 
	 * player has chosen.
	 * @param c 
	 * 		Current city that the player is in, passed from view.
	 * @param t
	 * 		The transportation that the player selected to travel,
	 */
	public void goPlace(City c, Transportation t){
		
		ThreadPoolUtil.execute(new Runnable(){
			@Override
			public void run() {
				try {
					if(c.toString().equals(startCity) && started == true){
						try{
							m2gvAdpt.localGameOver();
							localGameOverMsg = new LocalGameOverMsg(clientMember);
							action = new DataPacket<ILocalGameOverMsg>(ILocalGameOverMsg.class, clientMember, localGameOverMsg);
							serverMember.recvMessage(action);
						}catch(Exception e){
							e.printStackTrace();
						}
					
					}
					
					if(started == false){
						started = true;
						startCity = c.toString();
					}
					m2gvAdpt.goPlace(c, t);
					Place curPlace = c.getPlace();
					double lat = curPlace.getPosition().getLatitude().degrees;
					double longt = curPlace.getPosition().getLongitude().degrees;
					moveMsg = new MoveMsg(c.toString(), t.price, t.time, lat, longt);
					action = new DataPacket<IMoveMsg>(IMoveMsg.class, clientMember, moveMsg);
					serverMember.recvMessage(action);
					
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}	
		});
		
		
	}
	
	/**
	 * Make it possible for client to set its IMemberStub to the game model
	 * @param clientMember
	 * 		Client's IMember
	 */
	public void setClientMemberStub(IMember clientMember){
		this.clientMember = clientMember;
	}
	
	/**
	 * Send message to server
	 * @param msg
	 * 		The message to be sent to the server
	 * @return
	 * 		The return type of message
	 */
	public ADataPacket sendMsg2Server(DataPacket<?> msg){
		ADataPacket result;
		try{
			result = serverMember.recvMessage(msg);
		}catch(Exception e){
			result = new DataPacket<IFailMsg>(IFailMsg.class, clientMember, null);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Call adatper's gameOver method.
	 * @param winningTeam The winning team.
	 * @param winningScore The winning score.
	 */
	public void gameOver(String winningTeam, int winningScore){
		m2gvAdpt.gameOver(winningTeam, winningScore);
	}
	
	/**
	 * Update the team score.
	 * @param n The score.
	 */
	public void updateTeamScore(int n){
		m2gvAdpt.updateTeamScore(n);
	}
	
	/**
	 * Update the teammates' place.
	 * @param lat The latitude of the place.
	 * @param longt The longtitude of the place.
	 */
	public void updateTeammatesPlace(double lat, double longt){
		m2gvAdpt.updateTeammatesPosition(lat, longt);
	}
	
}
