package xw32_wb7.game.element;

import gov.nasa.worldwind.geom.Position;

import java.util.ArrayList;
import java.util.List;

import xw32_wb7.client.model.Place;
import xw32_wb7.game.transportation.Drive;
import xw32_wb7.game.transportation.Flight;
import xw32_wb7.game.transportation.Ship;
import xw32_wb7.game.transportation.Train;

/**
 * This class records all the cities and corresponding attributes in the game.
 * @author xw32, wb7
 *
 */
public class AllCities {
	/**
	 * The list of cities.
	 */
	private List<City> cities;
	
	/**
	 * The height.
	 */
	private final int HEIGHT = 10000;
	
	/**
	 * Construct the class.
	 */
	public AllCities(){

		cities = new ArrayList<City>();
		Place place;
		City city1NewYork, city2Houston, city3London, city4Beijing, city5Moscow, city6Amsterdam, city7Paris, city8Juneau, city9Melboune, city10Tokyo, city11buenosAries, city12;
		Transportation ship, flight, drive, train;
		
		ship = new Ship();
		flight = new Flight();
		drive = new Drive();
		train = new Train();
		
		Position nyc  = Position.fromDegrees(40.748974, -73.990288, HEIGHT);
		place = new Place("New York", nyc);
		city1NewYork = new City(place);
		city1NewYork.addTransp(flight);
		city1NewYork.addTransp(train);
		city1NewYork.addTransp(ship);
		city1NewYork.addTransp(drive);
		cities.add(city1NewYork);	
		
		Position houston = Position.fromDegrees(29.718550, -95.399068, HEIGHT);
		place = new Place("Houston", houston);
		city2Houston = new City(place);
		city2Houston.addTransp(flight);
		city2Houston.addTransp(ship);
		cities.add(city2Houston);
		
		Position london = Position.fromDegrees(51.503367, -0.119968, HEIGHT);
		place = new Place("London", london);
		city3London = new City(place);
		city3London.addTransp(flight);
		city3London.addTransp(ship);
		cities.add(city3London);
		
		Position beijing = Position.fromDegrees(39.928722, 116.387860, HEIGHT);
		place = new Place("Beijing", beijing);
		city4Beijing = new City(place);
		city4Beijing.addTransp(flight);
		city4Beijing.addTransp(ship);
		city4Beijing.addTransp(train);
		cities.add(city4Beijing);
		
		Position moscow = Position.fromDegrees(55.749792, 37.632495, HEIGHT);
		place = new Place("Moscow", moscow);
		city5Moscow = new City(place);
		city5Moscow.addTransp(train);
		city5Moscow.addTransp(flight);
		city5Moscow.addTransp(drive);
		cities.add(city5Moscow);
		
		Position amsterdam = Position.fromDegrees(52.3747158, 4.8986166, HEIGHT);
		place = new Place("Amsterdam", amsterdam);
		city6Amsterdam = new City(place);
		city6Amsterdam.addTransp(flight);
		city6Amsterdam.addTransp(train);
		cities.add(city6Amsterdam);
		
		Position paris = Position.fromDegrees(48.8588589, 2.3470599, HEIGHT);
		place = new Place("Paris", paris);
		city7Paris = new City(place);
		city7Paris.addTransp(flight);
		city7Paris.addTransp(ship);
		city7Paris.addTransp(train);
		cities.add(city7Paris);
		
		Position juneau = Position.fromDegrees(58.3844634, -134.1765792, HEIGHT);
		place = new Place("Juneau", juneau);
		city8Juneau = new City(place);
		city8Juneau.addTransp(flight);
		city8Juneau.addTransp(ship);
		cities.add(city8Juneau);
		
		Position melboune = Position.fromDegrees(-37.8602828, 145.079616, HEIGHT);
		place = new Place("Melboune", melboune);
		city9Melboune = new City(place);
		city9Melboune.addTransp(flight);
		city9Melboune.addTransp(ship);
		cities.add(city9Melboune);
		
		Position tokyo = Position.fromDegrees(35.673343, 139.710388, HEIGHT);
		place = new Place("Tokyo",tokyo);
		city10Tokyo = new City(place);
		city10Tokyo.addTransp(flight);
		city10Tokyo.addTransp(ship);
		cities.add(city10Tokyo);
		
		Position buenosAries = Position.fromDegrees(-34.6158527, -58.4332985, HEIGHT);
		place = new Place("Buenos Aries", buenosAries);
		city11buenosAries = new City(place);
		city11buenosAries.addTransp(flight);
		city11buenosAries.addTransp(ship);
		cities.add(city11buenosAries);
		
		Position pretoria = Position.fromDegrees(-25.7586499, 28.219682, HEIGHT);
		place = new Place("Pretoria", pretoria);
		city12 = new City(place);
		city12.addTransp(flight);
		city12.addTransp(ship);
		cities.add(city12);
		
		
		city1NewYork.addNextCity(city2Houston);
		city1NewYork.addNextCity(city3London);
		city1NewYork.addNextCity(city4Beijing);
		city1NewYork.addNextCity(city8Juneau);
		
		city2Houston.addNextCity(city6Amsterdam);
		city2Houston.addNextCity(city7Paris);
		city2Houston.addNextCity(city11buenosAries);
		
		city3London.addNextCity(city4Beijing);
		city3London.addNextCity(city6Amsterdam);
		
		city4Beijing.addNextCity(city5Moscow);
		
		city5Moscow.addNextCity(city8Juneau);
		city5Moscow.addNextCity(city9Melboune);
		
		city6Amsterdam.addNextCity(city5Moscow);
		city6Amsterdam.addNextCity(city9Melboune);
		city6Amsterdam.addNextCity(city12);
		
		city7Paris.addNextCity(city4Beijing);
		city7Paris.addNextCity(city9Melboune);
		
		city8Juneau.addNextCity(city1NewYork);
		city8Juneau.addNextCity(city2Houston);
		
		city9Melboune.addNextCity(city10Tokyo);
		city9Melboune.addNextCity(city11buenosAries);

		city10Tokyo.addNextCity(city5Moscow);
		
		city11buenosAries.addNextCity(city12);
		city11buenosAries.addNextCity(city3London);
		
		city12.addNextCity(city9Melboune);
		city12.addNextCity(city7Paris);
		
	}
	
	/**
	 * Get the list of cities.
	 * @return
	 */
	public List<City> getCities(){
		return cities;
	}
	
}