package xw32_wb7.game.element;

import java.io.Serializable;
/**
 * A transportation class, used to store transportation information.
 * @author Wenbo Bu, Xiongfei Wei, Master of Computer Science
 * 		   Department of Computer Science, Rice University
 * @Version Created on Dec 4, 2014, 12:04:33 AM
 */
public abstract class Transportation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 562733294221725873L;

	/**
	 * The time spent by using this transportation.
	 */
	public int time;
	
	/**
	 * The price of this transportation.
	 */
	public int price;
	
	/**
	 * The name of this transportation.
	 */
	public String name;

	/**
	 * Construct a transportation object.
	 * @param time The time spent using this transportation.
	 * @param price The price.
	 */
	public Transportation(int time, int price){
		this.time = time;
		this.price = price;
	}
	
	/**
	 * Set the price and time spent of this transportation.
	 * @param price The price of this transportation.
	 * @param time The time spent using this transportation
	 */
	public void setPriceTime(int price, int time) {
		this.price = price;
		this.time = time;
	}
	
	/**
	 * Get the price of this transportation.
	 * @return The price.
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * Get the time spent of this transportation.
	 * @return The time spent.
	 */
	public int getTime() {
		return time;
	}
	
	@Override 
	public String toString(){
		return name;
	}
	
}
