package xw32_wb7.client.model;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import provided.rmiUtils.IRMIUtils;
import provided.rmiUtils.IRMI_Defs;
import provided.rmiUtils.RMIUtils;
import provided.util.IVoidLambda;
import xw32_wb7.chatroom.model.ITeamModel2ViewAdapter;
import xw32_wb7.chatroom.model.TeamMiniModel;
import xw32_wb7.util.ThreadPoolUtil;
import common.IChatroom;
import common.IPerson;

public class ClientModel {

	/**
	 * client model to view adapter
	 */
	private IClientModel2ViewAdpt _cm2vAdpt;
	
	/**
	 * server person stub
	 */
	private IPerson serverPersonStub;
	
	/**
	 * local client person stub
	 */
	private IPerson clientPersonStub;
	
	/**
	 * teamMiniModel list
	 * This is used in stop() method and send the ILeaveRoomMsg to all people in the lobby/team
	 */
//	private TeamMiniModel[] miniModelList = new TeamMiniModel[];
	private ArrayList<TeamMiniModel> miniModelList = new ArrayList<TeamMiniModel>();
	
//	/**
//	 * my member stub
//	 */
//	IMember myMemberStub;
	
	/**
	 * This person's team.
	 */
	private IChatroom team;
	
	/**
	 * output command used to put multiple strings up onto the view.
	 */
	private IVoidLambda<String> outputCmd = new IVoidLambda<String>() {

		@Override
		public void apply(String... params) {
			for (String s : params) {
				_cm2vAdpt.append(s + "\n");
			}
		}
	};
	
	/**
	 * Factory for the Registry and other uses.
	 */
	IRMIUtils rmiUtils = new RMIUtils(outputCmd);
	
	/**
	 * person to model adapter.
	 */
	private IPerson2ModelAdpt _person2ModelAdpt = new IPerson2ModelAdpt() {
		
		@Override
		public void addToPersonList(IPerson personStub) {
			
		}

		@Override
		public void invite(IPerson requesterStub) {
			invite(requesterStub);
		}

		/**
		 * create the local team mini MVC and join the team.
		 * @param chatroom chatroom is the team received.
		 */
		@Override
		public void joinTeam(IChatroom chatroom) {
			/*create new mini MVC*/
			TeamMiniModel teamMiniModel = createMiniModel(chatroom);
			if (chatroom.getName().equals("Lobby")) {
				createLobbyMVC(teamMiniModel);
			}else{
				createTeamMVC(teamMiniModel);
				team = chatroom;
				_cm2vAdpt.append("You got the team: "+team.getName());
			}
			//notify everybody
			teamMiniModel.joinChatRoom();
		}
	};
	
	/**
	 * Construct a client model.
	 * @param _cm2vAdpt The client model to client view adapter.
	 */
	public ClientModel(IClientModel2ViewAdpt _cm2vAdpt) {
		this._cm2vAdpt = _cm2vAdpt;
	}
	
	/**
	 * start the client model
	 * @param personName The server's IP address.
	 */
	public void start(String personName) {
		rmiUtils.startRMI(IRMI_Defs.CLASS_SERVER_PORT_CLIENT);
		
			try {
				_cm2vAdpt.setRemoteHost(rmiUtils.getLocalAddress());
			} catch (SocketException e) {

				e.printStackTrace();
			} catch (UnknownHostException e) {
				
				e.printStackTrace();
			} 
			IPerson clientPerson = new Person(_person2ModelAdpt,personName);
			try {
				clientPersonStub = (IPerson) UnicastRemoteObject.exportObject(clientPerson, IPerson.CLIENT_BOUND_PORT);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
	
	}
	
	/**
	 * Stops the client by shutting down the class server.
	 */
	public void stop() {
		System.out.println("ClientModel.stop(): client is quitting.");
		
		//send the ILeaveRoomMsg to all the people in the team/lobby
		for (TeamMiniModel t: miniModelList) {
			t.leave();
		}
		
		try {
			rmiUtils.stopRMI();
		} catch (Exception e) {
			System.err
					.println("ClientModel.stop(): Error stopping class server: "
							+ e);
		}
		System.exit(0);
	}
	
	/**
	 * Connects to the given remote host and retrieves the stub to the ICompute object bound 
	 * to the ICompute.BOUND_NAME name in the remote Registry on port 
	 * IRMI_Defs.REGISTRY_PORT.  
	 * 
	 * @param remoteHost The IP address or host name of the remote server.
	 * @return  A status string on the connection.
	 */
	public String connectTo(String remoteHost) {
		try{
		ThreadPoolUtil.execute(new Runnable(){

			@Override
			public void run() {
				try{
				_cm2vAdpt.append("Locating registry at " + remoteHost + "...\n");
				//Registry registry = registryFac.getRemoteRegistry(remoteHost);
				Registry registry = rmiUtils.getRemoteRegistry(remoteHost);
				_cm2vAdpt.append("Found registry: " + registry + "\n");
				serverPersonStub = (IPerson) registry.lookup(IPerson.SERVER_BOUND_NAME);

				
				_cm2vAdpt.append("Found remote Server object: " + serverPersonStub + "\n");
				
				/*connect back, i.e. auto connect*/
				if ((serverPersonStub.connectBack(clientPersonStub)) == IPerson.STATUS_SUCC) {
					_cm2vAdpt.append("Connection established. Name :"+serverPersonStub.getName()+"\n");
				} else {
					//the case that connect fails.
				}
//				
				/*request to join a team*/
				if (serverPersonStub.recvRequest(clientPersonStub) == IPerson.STATUS_FAILED) {
//					_cm2vAdpt.append("Failed to join the team");
				}
				
			
				}catch(Exception e){
					e.printStackTrace();
				}
			}	
		});
		}catch(Exception e){
			_cm2vAdpt.append("Exception connecting to " + remoteHost + ": " + e
					+ "\n");
			e.printStackTrace();
			return "No connection established!";
		
		}
		return "Connection to " + remoteHost + " established!";
	}
	
	/**
	 * create the mini team model for outside rooms
	 * This is called in public void joinTeam(IChatroom team) in ClientModel.java
	 * @param chatRoom The chatroom(that is, team).
	 * @return Team mini model.
	 */
	public TeamMiniModel createMiniModel(IChatroom chatRoom) {
		TeamMiniModel miniModel;
		try {
			miniModel = new TeamMiniModel(chatRoom, clientPersonStub.getUUID(), clientPersonStub.getName());
			return miniModel;
		} catch (RemoteException e) {
			e.printStackTrace();
			System.out.println("failed to create mini team model on client side.");
			return null;
		}
		
	}
	
	/**
	 * This is used to create team mini mvc
	 * This is called in public void joinTeam(IChatroom team) in ClientModel.java
	 * @param teamMiniModel The team mini model.
	 */
	public void createTeamMVC(TeamMiniModel teamMiniModel) {
		ITeamModel2ViewAdapter teamModel2ViewAdpt = _cm2vAdpt
				.makeTeamModel2ViewAdapter(teamMiniModel);
		teamMiniModel.setTeamModel2ViewAdapter(teamModel2ViewAdpt);//equivalent to miniModel.miniModel2ViewAdpt = miniModel2ViewAdpt;
		teamMiniModel.start();//start the mini view
		miniModelList.add(teamMiniModel);//add the miniModel to the miniModelList
	}
	
	/**
	 * create lobby MVC, use the same model as the team MVC
	 * @param teamMiniModel The team mini model.
	 */
	public void createLobbyMVC(TeamMiniModel teamMiniModel) {
		ITeamModel2ViewAdapter teamModel2LobbyViewAdpt = _cm2vAdpt
				.makeTeamModel2LobbyViewAdapter(teamMiniModel);
		teamMiniModel.setTeamModel2ViewAdapter(teamModel2LobbyViewAdpt);//equivalent to miniModel.miniModel2ViewAdpt = miniModel2ViewAdpt;
		teamMiniModel.start();//start the mini lobby view
		miniModelList.add(teamMiniModel);//add the miniModel to the miniModelList
	}
	

}
