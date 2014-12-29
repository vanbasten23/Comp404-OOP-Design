package xw32_wb7.game.model;

import xw32_wb7.game.msg.IUpdateTeamMsg;

/**
 * 
 * @author Wenbo Bu, Xiongfei Wei, Master of Computer Science
 * 		   Department of Computer Science, Rice University
 * @Version Created on Dec 14, 2014, 3:17:54 AM
 */
public class UpdateTeamMsg implements IUpdateTeamMsg{

	/**
	 * current score.
	 */
	private int curScore;
	
	/**
	 * The latitude.
	 */
	private double latitude;
	
	/**
	 * The longitude
	 */
	private double longtitude;
	/**
	 * 
	 */
	private static final long serialVersionUID = -4638902457990726060L;

	/**
	 * Construct a updateTeamMsg.
	 * @param n The current score.
	 * @param lat The latitude
	 * @param longt The longitude.
	 */
	public UpdateTeamMsg(int n, double lat, double longt){
		this.curScore = n;
		this.latitude = lat;
		this.longtitude = longt;
	}
	@Override
	public int getScore() {
		return this.curScore;
	}

	@Override
	public double getLatitude(){
		return this.latitude;
	}
	
	@Override
	public double getLongtitude(){
		return this.longtitude;
	}
}
