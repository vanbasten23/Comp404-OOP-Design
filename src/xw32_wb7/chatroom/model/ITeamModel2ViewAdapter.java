package xw32_wb7.chatroom.model;

import java.util.Collection;

import common.IMember;

/**
 * This is the team mini model to team mini view adapter.
 * @author xw32, wb7
 *
 */
public interface ITeamModel2ViewAdapter {

	/**
	 * append the string to the textarea.
	 * @param s The given string.
	 */
	public void append(String s);
	
	/**
	 * start a team mini view.
	 */
	public void start();
	
	/**
	 * refresh the member list.
	 */
	public void refreshMemberList(Collection<IMember> memberStubList);
}
