package xw32_wb7.client.model;

import xw32_wb7.chatroom.model.ITeamModel2ViewAdapter;
import xw32_wb7.chatroom.model.TeamMiniModel;

/**
 * This is the client model to client view adapter.
 * @author xw32,wb7
 *
 */
public interface IClientModel2ViewAdpt {

	/**
	 * Append message onto the client view.
	 * @param string The text to be appended.
	 */
	public void append(String string);

	/**
	 * set remote host
	 * @param localAddress The local ip address.
	 */
	public void setRemoteHost(String localAddress);

	/**
	 * make the team-mini-model-to-team-mini-view adapter
	 * @param teamMiniModel The team mini model
	 * @return Team model to team view adapter.
	 */
	public ITeamModel2ViewAdapter makeTeamModel2ViewAdapter(TeamMiniModel teamMiniModel);
	
	/**
	 * make the team-mini-model-to-lobby-mini-view adapter. We use the same ITeamModel2ViewAdapter interface
	 * and the same mini model for the lobby MVC.
	 * @param teamMiniModel Lobby mini model.(Lobby and team are both the same as the chatroom)
	 * @return team The lobby mini model.
	 */
	public ITeamModel2ViewAdapter makeTeamModel2LobbyViewAdapter(TeamMiniModel teamMiniModel);
}
