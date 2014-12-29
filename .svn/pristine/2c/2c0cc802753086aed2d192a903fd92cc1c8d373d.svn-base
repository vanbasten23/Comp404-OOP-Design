package xw32_wb7.game.element;

import java.util.ArrayList;
import java.util.List;

import xw32_wb7.client.model.Place;

/**
 * City class, used to identify where the player is.
 * @author Wenbo Bu, Xiongfei Wei, Master of Computer Science
 * 		   Department of Computer Science, Rice University
 * @Version Created on Dec 5, 2014, 4:00:18 PM
 */
public class City{
	
	/**
	 * The place of the city.
	 */
	private Place place;
	
	/**
	 * The next available cities.
	 */
	private List<City> nextAvailableCities;
	
	/**
	 * The available transportation at this city.
	 */
	private List<Transportation> availableTransp;
	
	/**
	 * Construct this city.
	 * @param place The place of this city.
	 */
	public City(Place place){
		this.place = place;
		nextAvailableCities = new ArrayList<City>();
		availableTransp = new ArrayList<Transportation>();
	}
	
	/**
	 * Get the place of this city.
	 * @return the place
	 */
	public Place getPlace() {
		return place;
	}
	/**
	 * Set the place of this city.
	 * @param place the place to set
	 */
	public void setPlace(Place place) {
		this.place = place;
	}
	
	/**
	 * Get the next available cities.
	 * @return The nextAvailableCities list.
	 */
	public List<City> getNextAvailableCities() {
		return nextAvailableCities;
	}

	/**
	 * Set the next available cities.
	 * @param nextAvailableCities The nextAvailableCities list to set
	 */
	public void setNextAvailableCities(List<City> nextAvailableCities) {
		this.nextAvailableCities = nextAvailableCities;
	}

	/**
	 * Add the next available city.
	 * @param city The city to be added.
	 */
	public void addNextCity(City city){
		this.nextAvailableCities.add(city);
	}

	/**
	 * Get the available transportation at this city.
	 * @return The available transportation.
	 */
	public List<Transportation> getAvailableTransp() {
		return availableTransp;
	}

	/**
	 * Set the available transportation.
	 * @param availableTransp the availableTransp to set
	 */
	public void setAvailableTransp(List<Transportation> availableTransp) {
		this.availableTransp = availableTransp;
	}

	/**
	 * Add an available transportation.
	 * @param tsp
	 */
	public void addTransp(Transportation tsp){
		this.availableTransp.add(tsp);
	}
	
	@Override
	public String toString(){
		return place.toString();
	}
	
}
