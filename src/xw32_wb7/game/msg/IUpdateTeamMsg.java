package xw32_wb7.game.msg;

import java.io.Serializable;

/**
 * This is the UpdateTeamMsg
 * @author xw32, wb7
 *
 */
public interface IUpdateTeamMsg extends Serializable {
	
	/**
	 * Get the score.
	 * @return
	 */
	public int getScore();
	
	/**
	 * Get the latitude.
	 * @return The latitude.
	 */
	public double getLatitude();
	
	/**
	 * Get the longitude.
	 * @return The longitude.
	 */
	public double getLongtitude();
}
