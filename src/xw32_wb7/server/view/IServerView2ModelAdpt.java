package xw32_wb7.server.view;

import common.IChatroom;
import common.IPerson;

/**
 * This is the server view to server model adapter.
 * @author xw32, wb7
 *
 * @param <TTeamDropListItem>
 * @param <TPersonDropListItem>
 */
public interface IServerView2ModelAdpt<TTeamDropListItem, TPersonDropListItem> {

	/**
	 * create a new team to be passed to the client to join.
	 * @param teamName The name of the new team.
	 */
	public IChatroom createTeam(String teamName);
	
	/**
	 * assign a team from the drop list to the selected person.
	 * @param team The team to be assigned
	 * @param personStub The person to be assigned.
	 */
	public void assignTeam(IChatroom team, IPerson personStub);
	
	/**
	 * Start the game, call model.startGame();
	 */
	public void startGame();
	
	/**
	 * set team created=true if the team has been created.
	 * @param created
	 */
	public void setTeamCreated(boolean created);
}
