package xw32_wb7.game.controller;

import java.io.Serializable;

import xw32_wb7.game.element.City;
import xw32_wb7.game.element.Transportation;
import xw32_wb7.game.model.GameModel;
import xw32_wb7.game.model.IGameModel2ViewAdpt;
import xw32_wb7.game.view.GameGUI;
import xw32_wb7.game.view.IGameView2ModelAdpt;
import common.IMember;

/**
 * This is the game controller.
 * @author xw32, wb7
 *
 */
public class GameController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4939777664493848194L;
	
	/**
	 * This is the game model.
	 */
	private GameModel model;
	
	/**
	 * This is the game view.
	 */
	private GameGUI view;
	
	/**
	 * Construct the game controller using the server member stub.
	 * @param serverMember
	 */
	public GameController(IMember serverMember){
		model = new GameModel(new IGameModel2ViewAdpt(){

			/**
			 * 
			 */
			private static final long serialVersionUID = -7587478431467677638L;

			@Override
			public void goPlace(City c, Transportation t) {
				
				view.setPosition(c.getPlace().getPosition());
				view.updateTravelInfo(c);
				view.setCurrentCity(c);
				view.updateCurrentInfo(t);
			}

			@Override
			public void gameOver(String winningTeam, int winningScore) {
				view.gameOver(winningTeam, winningScore);
			}

			@Override
			public void localGameOver() {
				view.localGameOver();
			}

			@Override
			public void updateTeamScore(int n) {
				view.upadateTeamScore(n);
			}

			@Override
			public void updateTeammatesPosition(double lat, double longt) {
				view.updateTeammatesPlace(lat, longt);
			}

	
			
		}, serverMember);
		
		view = new GameGUI(new IGameView2ModelAdpt(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 6066833328374237767L;

			@Override
			public void goLatLong(String latitude, String longitude) {
				
			}

			@Override
			public void updateCities(City city) {
				
			}

			@Override
			public void goPlace(City c, Transportation t) {
				model.goPlace(c, t);
			}});
	}
	
	/**
	 * Start the game model and game view respectively.
	 */
	public void start(){
		model.start();
		view.start();
	}
	
	/**
	 * Get the game view.
	 * @return The game view.
	 */
	public GameGUI getGameView(){
		return view;
	}
	
	/**
	 * Get the game model
	 * @return The game model.
	 */
	public GameModel getGameModel(){
		return model;
	}
	
}
