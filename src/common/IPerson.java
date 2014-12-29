package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.UUID;

import common.IChatroom;

public interface IPerson extends Remote {
	
	
	/** 
	 * Constant name for Server Iperson Stub
	 */
	final String SERVER_BOUND_NAME = "ServerStub";

	/** 
	 * Constant port for Server Iperson Stub
	 */
	final int SERVER_BOUND_PORT = 2101;
	 
	/** 
	 * Constant name for Server Iperson Stub
	 */
	final String CLIENT_BOUND_NAME = "ClientStub";

	/** 
	 * Constant port for Server Iperson Stub
	 */
	final int CLIENT_BOUND_PORT = 2102;
	
	/**
     * Initial connection to the host [Colin]: I think the method name can just be connectTo(...) 
     * since the it is the local iperson that calls the IPerson stub's connectTo() method. 
     */
	/**
	 * Let the receiver receive my stub.
	 * @param myPersonStub
	 * @return STATUS_SUCC or STATUS_FAILED
	 */
	public int connectBack(IPerson myPersonStub) throws RemoteException;


    
    /**
     * Return int when acceptInvitation and recvRequest is successful.
     * [Colin] just minor naming issue, I'd go with STATUS_OK = 0; STATUS_FAIL = -1;
     */
    final int STATUS_SUCC = 0;
    
    /**
     * Return int when acceptInvitation and recvRequest fails.
     */
    final int STATUS_FAILED = -1;
    
    /**
    * Accepts an invitation to join the chat room.
    * @param chatroom The chat room to which the host is invited to join.
    * @return The status code indicating whether the invitation has
    * been successfully accepted by the host.
    */
    public int acceptInvitation(IChatroom chatroom) throws RemoteException;
    
    /**
     * The host receives an invitation from the requester.
     * @param requesterStub The requester's host stub. The requester gives
     * his host stub to the requestee, so the requestee knows how to invite back.
     * @return The status code indicating whether the request has been
     * successfully received.
     */
    public int recvRequest(IPerson requesterStub) throws RemoteException;
   
	/**
	 * Get the name of the Person
	 * @return The name of the Person
	 */
	public String getName() throws RemoteException;
	
	/**
	 * Returns the unique UUID of the stub. 
	 * @return The UUID of the IPerson stub
	 * by Justin
	 */
	public UUID getUUID() throws RemoteException;

}

