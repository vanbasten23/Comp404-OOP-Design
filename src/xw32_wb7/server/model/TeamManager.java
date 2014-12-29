package xw32_wb7.server.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import xw32_wb7.chatroom.model.Team;

import common.IChatroom;
import common.IMember;

/**
 * This is the team manager.
 * @author xw32, wb7
 *
 */
public class TeamManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5413021019631104178L;
	
	/**
	 * This is the lobby
	 */
	private IChatroom lobby;
	
	/**
	 * This is the team list. 
	 */
	private List<IChatroom> teams;
	
	/**
	 * Constuct a team manager.
	 */
	public TeamManager(){
		lobby = new Team("Lobby");
		teams = new ArrayList<IChatroom>();
		
	}
	
	/**
	 * add a member to the lobby.
	 * @param member The member.
	 */
	public void add2Lobby(IMember member){
		lobby.addMember(member);
	}
	
	/**
	 * add a member to the team.
	 * @param member The member.
	 */
	public void add2Teams(IMember member){
		for(IChatroom c: teams){
			c.addMember(member);
		}
	}
	
	/**
	 * Add the member to the team with the given index.
	 * @param member The member stub
	 * @param idx The index of the team.
	 */
	public void add2TeamByIdx(IMember member, int idx){
		teams.get(idx).addMember(member);
	}
	
	/**
	 * Add the team to the team list.
	 * @param team  The team.
	 */
	public void addTeam(IChatroom team){
		teams.add(team);
	}
	
	/**
	 * Get the lobby
	 * @return The lobby.
	 */
	public IChatroom getLobby(){
		return lobby;
	}
	
	/**
	 * Get the team by index.
	 * @param idx Index
	 * @return The team with the given index.
	 */
	public IChatroom getTeamByIdx(int idx){
		return teams.get(idx);
	}
	
	/**
	 * Get all the teams
	 * @return All the teams.
	 */
	public List<IChatroom> getTeams(){
		return this.teams;
	}
	
	/**
	 * Get the team that has this member
	 * @param member The given member stub
	 * @return The team that contaains the member stub.
	 */
	public IChatroom getTeamByMember(IMember member){
		IChatroom team = null;
		for(IChatroom c: teams){
			if(((Team)c).isInTeam(member)){
				team = c;
			}
		}
		return team;
	}
	
	/**
	 * Create a team using the team name and the server member stub.
	 * @param name The given team name.
	 * @param serverMember The server member stub.
	 * @return The team just created.
	 */
	public IChatroom createTeam(String name, IMember serverMember){
		IChatroom team = new Team(name);
		team.addMember(serverMember);
		addTeam(team);
		return team;
	}
}
