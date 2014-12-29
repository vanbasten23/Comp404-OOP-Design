package xw32_wb7.game.msg;

import java.io.Serializable;
/**
 * 
 * @author Wenbo Bu, Xiongfei Wei, Master of Computer Science
 * 		   Department of Computer Science, Rice University
 * @Version Created on Dec 14, 2014, 3:17:31 AM
 */
public interface IMoveMsg extends Serializable{

	/**
	 * Get the current city.
	 * @return
	 */
	public String getCurCity();
	
	/**
	 * Get the time spent using the selected transporation.
	 * @return Time spent.
	 */
	public int getTime();
	
	/**
	 * Get the price of the transportation.
	 * @return Price of the transportation
	 */
	public int getPrice();
}
