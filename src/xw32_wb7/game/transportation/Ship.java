package xw32_wb7.game.transportation;

import xw32_wb7.game.element.Transportation;
/**
 * Subclass of Transportation, a kind of transportation.
 * @author Wenbo Bu, Xiongfei Wei, Master of Computer Science
 * 		   Department of Computer Science, Rice University
 * @Version Created on Dec 4, 2014, 12:05:06 AM
 */
public class Ship extends Transportation {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1842644219625853769L;

	/**
	 * Construct this ship transportation object
	 */
	public Ship(){
		this(6, 150);
		name = "Ship";
	}
	

	/**
	 * Construct this ship transportation object using time spent
	 * and price of the transportation.
	 * @param time The time spent of using this transportation.
	 * @param price The price of this transportation.
	 */
	private Ship(int time, int price) {
		super(time, price);
	}

}
