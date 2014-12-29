package xw32_wb7.client.model;


import java.rmi.RemoteException;
import java.util.UUID;

import common.IChatroom;
import common.IPerson;

/**
 * This is the person concrete class that implements IPerson
 * @author xw32, wb7
 *
 */
public class Person implements IPerson{

	/**
	 * This is the person's name.
	 */
	private String name;
	
	/**
	 * This is the randomized uuid to identify a person.
	 */
	private UUID uuid = UUID.randomUUID();
	
	/**
	 * This is the person to model adapter.
	 */
	private IPerson2ModelAdpt _person2ModelAdpt;
	
	/**
	 * Construct the person object using a person2ModelAdpt and its name.
	 * @param _person2ModelAdpt The person to model adapter
	 * @param name The person's name.
	 */
	public Person(IPerson2ModelAdpt _person2ModelAdpt, String name){
		this._person2ModelAdpt = _person2ModelAdpt;
		this.name = name;
	}
	
	@Override
	public int connectBack(IPerson myPersonStub) throws RemoteException {
		if (myPersonStub == null) {
			return IPerson.STATUS_FAILED;
		}
		else {
			_person2ModelAdpt.addToPersonList(myPersonStub);
//			recvRequest(myPersonStub);
			return IPerson.STATUS_SUCC;
		}
	}

	@Override
	public int acceptInvitation(IChatroom chatroom) throws RemoteException {
		if (chatroom != null) {
			_person2ModelAdpt.joinTeam(chatroom);
			return IPerson.STATUS_SUCC;
		}
		else return IPerson.STATUS_FAILED;
	}

	@Override
	public int recvRequest(IPerson requesterStub) throws RemoteException {
		if (requesterStub != null) {
			_person2ModelAdpt.invite(requesterStub);
			return IPerson.STATUS_SUCC;
		}
		else {
			System.out.println("null pointer in recvRequest(..) in class Person.");
			return IPerson.STATUS_FAILED;
		}
	}

	@Override
	public String getName() throws RemoteException {
		return name;
	}

	@Override
	public UUID getUUID() throws RemoteException {
		return uuid;
	}

	@Override
	public String toString(){
		return name;
	}
}
