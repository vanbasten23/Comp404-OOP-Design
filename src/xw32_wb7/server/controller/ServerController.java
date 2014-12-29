package xw32_wb7.server.controller;

import common.IChatroom;
import common.IPerson;
import xw32_wb7.server.model.IServerModel2ViewAdpt;
import xw32_wb7.server.model.ServerModel;
import xw32_wb7.server.view.IServerView2ModelAdpt;
import xw32_wb7.server.view.ServerGUI;

/**
 * The server controller
 * @author xw32, wb7
 *
 */
public class ServerController {

	/**
	 * The server model
	 */
	private ServerModel model;
	
	/**
	 * The server view.
	 */
	private ServerGUI<IChatroom, IPerson> view;
	
	/**
	 * Construct server controller
	 */
	public ServerController(){
		model = new ServerModel(new IServerModel2ViewAdpt(){

			@Override
			public void append(String s) {
				view.append(s);
			}

			@Override
			public void setRemoteHost(String ip) {
				view.append("Connected IP address is " + ip + "\n");
			}

			@Override
			public void addToTeamDropList(IChatroom team) {
				view.addToTeamDropList(team);
			}

			@Override
			public void addToPersonDropList(IPerson personStub) {
				view.addToPersonDropList(personStub);
			}

			@Override
			public void appendToPersonJList(IPerson personStub) {
				view.appendToPersonJList(personStub);
			}

			@Override
			public IChatroom getSelectedChatroom() {
				return view.getSelectedChatroom();
			}
			
		});
		
		view = new ServerGUI<IChatroom, IPerson>(new IServerView2ModelAdpt<IChatroom, IPerson>(){

			@Override
			public IChatroom createTeam(String teamName) {
				return model.createTeam(teamName);
			}

			@Override
			public void assignTeam(IChatroom team, IPerson personStub) {
				model.assignTeam(team, personStub);
			}

			@Override
			public void startGame() {
				model.startGame();
			}

			@Override
			public void setTeamCreated(boolean created) {
				model.setTeamCreated(created);
			}
			
		});
	}
	
	/**
	 * The server main function.
	 * @param args
	 */
	public static void main(String[] args){
		ServerController controller = new ServerController();
		controller.start();
	}
	
	/**
	 * Start the controller.
	 */
	public void start(){
		model.start();
		view.start();
	}
	
}
