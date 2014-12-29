package xw32_wb7.game.model;

import java.io.Serializable;

import xw32_wb7.game.element.City;
import xw32_wb7.game.element.Transportation;

/**
 * Game model to view adapter
 * @author Wenbo Bu, Xiongfei Wei, Master of Computer Science
 * 		   Department of Computer Science, Rice University
 * @Version Created on Dec 9, 2014, 2:29:22 PM
 */
public interface IGameModel2ViewAdpt extends Serializable{
	
	/**
	 * Go to a place
	 * @param c The city
	 * @param t The transportation.
	 */
	public void goPlace(City c, Transportation t);
	
	/**
	 * Local game over.
	 */
	public void localGameOver();
	
	/**
	 * Update this team's score.
	 * @param n
	 */
	public void updateTeamScore(int n);
	
	/**
	 * Update team mates' position.
	 * @param lat
	 * @param longt
	 */
	public void updateTeammatesPosition(double lat, double longt);

	/**
	 * Game over.
	 * @param winningTeam
	 * @param winningScore
	 */
	public void gameOver(String winningTeam, int winningScore);
}
