package xw32_wb7.game.model;

import xw32_wb7.game.msg.IMoveMsg;
/**
 * 
 * @author Wenbo Bu, Xiongfei Wei, Master of Computer Science
 * 		   Department of Computer Science, Rice University
 * @Version Created on Dec 10, 2014, 2:54:35 PM
 */
public class MoveMsg implements IMoveMsg {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5609109356512690950L;
	
	/**
	 * The name of the city.
	 */
	private String cityName;
	
	/**
	 * The price of the transportation.
	 */
	private int price;

	/**
	 * The time spent of the transportation.
	 */
	private int time;
	
	/**
	 * The latitude of the destination.
	 */
	private double latitude;
	
	/**
	 * The longtitude of the transportation.
	 */
	private double longtitude;
	
	/**
	 * Construct the MoveMsg
	 * @param name The name of the destination city.
	 * @param price The price of the transportation
	 * @param time The time spent of the transportation.
	 * @param lat The latitude of the destination.
	 * @param longt The longtitude of the destination.
	 */
	public MoveMsg(String name, int price, int time, double lat, double longt){
		this.cityName = name;
		this.price = price;
		this.time = time;
		this.latitude = lat;
		this.longtitude = longt;
	}
	
	@Override
	public String getCurCity() {
		return cityName;
	}

	@Override
	public int getPrice(){
		return price;
	}
	
	@Override
	public int getTime(){
		return time;
	}
	
	/**
	 * Get the latitude of the destination city.
	 * @return Latitude of the destination city.
	 */
	public double getLatitude(){
		return this.latitude;
	}
	
	/**
	 * Get the longitude of the destination city.
	 * @return The longitude of the destination city.
	 */
	public double getLongtitude(){
		return this.longtitude;
	}
	
}
