package xw32_wb7.game.view;

import java.io.Serializable;

import xw32_wb7.game.element.City;
import xw32_wb7.game.element.Transportation;

/**
 * Game view to model adapter
 * @author Wenbo Bu, Xiongfei Wei, Master of Computer Science
 * 		   Department of Computer Science, Rice University
 * @Version Created on Dec 9, 2014, 2:31:48 PM
 */
public interface IGameView2ModelAdpt extends Serializable{
	
	/**
	 * Go the the place with the given latitude and longitude
	 * @param latitude
	 * @param longitude
	 */
	public void goLatLong(String latitude, String longitude);
	
	/**
	 * Update cities.
	 * @param city The give city.
	 */
	public void updateCities(City city);
	
	/**
	 * Go to a place with the given destination and transportation.
	 * @param c The destination
	 * @param t The transportation.
	 */
	public void goPlace(City c, Transportation t);
}
