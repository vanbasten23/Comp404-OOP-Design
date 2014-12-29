package xw32_wb7.game.controller;

import xw32_wb7.game.msg.IAroundWorld;

import common.IMember;
/**
 * Implementation of IAroundWorld, used to create a game MVC.
 * @author Wenbo Bu, Xiongfei Wei, Master of Computer Science
 * 		   Department of Computer Science, Rice University
 * @Version Created on Dec 2, 2014, 9:28:59 PM
 */
public class GameFac implements IAroundWorld{
	/**
	 * 
	 */
	private static final long serialVersionUID = 871080065403457808L;

	/**
	 * The game controller.
	 */
	private GameController gc;
	
	/**
	 * The server member stub.
	 */
	private IMember serverMember;
	
	/**
	 * Construct a game factory.
	 * @param serverMember
	 */
	public GameFac(IMember serverMember){
		this.serverMember = serverMember;
	}
	
	/**
	 * create a new game controller and start it.
	 */
	public void start(){
		gc = new GameController(serverMember);
		gc.start();
	}
	
	/**
	 * Get the game controller
	 * @return The game controller.
	 */
	public GameController getController(){
		return gc;
	}
	
	@Override
	public GameFac makeGame() {
		start();
		return this;
	}
}
