package provided.datapacket;


import common.IMember;

import provided.extvisitor.*;



/**
 * Abstract data packet that defines the use of a Class object as the index type.  
 * The type of data held by the data packet defines its type and thus what case it
 * calls on its processing visitors.
 * 
 * @author Stephen Wong (c) 2014
 * * ----------------------------------------------
 * Specifies use of Class<?> type for host ID
 */
public abstract class ADataPacket extends AExtVisitorHost<Class<?>, ADataPacket> {
	
	/**
	 * Version number for serialization
	 */
	private static final long serialVersionUID = 5990493490087888131L;
	
	/**
	 * The stub for the sender of the datapacket
	 */
	private IMember senderStub;

	/**
	 * Constructor for this abstract superclass
	 * @param c A Class object to be used as the index value defining this type of data packet.
	 * @param senderStub The IMember stub of the sender
	 */
	public ADataPacket(Class<?> c, IMember senderStub){
		super(c);
		this.senderStub = senderStub;
	}
	
	/**
	 * Accessor for the IMember sender's stub
	 * @return The stub for the sender of the datapacket
	 */
	public IMember getSender() {
		return senderStub;
	}
	
}


