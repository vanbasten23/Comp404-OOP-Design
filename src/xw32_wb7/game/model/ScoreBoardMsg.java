package xw32_wb7.game.model;

import java.util.Collection;

import xw32_wb7.game.msg.IScoreBoardMsg;

/**
 * 
 * @author Wenbo Bu, Xiongfei Wei, Master of Computer Science
 * 		   Department of Computer Science, Rice University
 * @Version Created on Dec 14, 2014, 3:17:26 AM
 */
public class ScoreBoardMsg implements IScoreBoardMsg {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2851341878412982139L;
	
	/**
	 * The name of the player.
	 */
	private Collection<String> playerName;
	
	/**
	 * The score.
	 */
	private Collection<Integer> score;
	
	/**
	 * Construct a scoreBoardMsg.
	 * @param playerName The name of the player.
	 * @param score The score.
	 */
	public ScoreBoardMsg(Collection<String> playerName, Collection<Integer> score){
		this.playerName = playerName;
		this.score = score;
	}
	
	/**
	 * Get the name of the player
	 * @return The name of the player.
	 */
	public Collection<String> getPlayName(){
		return this.playerName;
	}
	
	/**
	 * Get the score.
	 * @return Score.
	 */
	public Collection<Integer> getScore(){
		return this.score;
	}
}
