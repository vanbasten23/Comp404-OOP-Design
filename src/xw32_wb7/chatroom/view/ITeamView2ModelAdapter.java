package xw32_wb7.chatroom.view;

/**
 * This is the team view to team model adapter.
 * @author xw32, wb7
 *
 */
public interface ITeamView2ModelAdapter {

	/**
	 * send the string.
	 * @param str The given string.
	 */
	public void send(String str);
	
	/**
	 * leave the chatroom(either lobby or team)
	 */
	public void leave();

}
