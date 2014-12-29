package xw32_wb7.server.view;

import java.rmi.RemoteException;

import common.IPerson;

/**
 * This is the person wrapper class so that we can rewrite the toString method
 * and display the person name in the Jcombo box
 * @author xw32, wb7
 *
 */
public class PersonWrapper {
	
	/**
	 * The person stub.
	 */
	private IPerson personStub;
	
	/**
	 * Construct the person stub.
	 * @param personStub
	 */
	public PersonWrapper(IPerson personStub) {
		this.personStub = personStub;
	}
	
	/**
	 * Get the person stub.
	 * @return The person stub.
	 */
	public IPerson getPersonStub() {
		return personStub;
	}
	
	@Override
	public String toString() {
		try {
			return personStub.getName();
		} catch (RemoteException e) {
			return "bug in .getName()";
		}
	}
	
}
