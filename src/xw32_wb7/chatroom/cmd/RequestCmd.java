package xw32_wb7.chatroom.cmd;

import common.IRequestCmd;

/**
 * The request command.
 * @author xw32, wb7
 *
 */
public class RequestCmd implements IRequestCmd {


	private static final long serialVersionUID = 2418085136856103780L;

	/**
	 * The id
	 */
	private Class<?> id;

	/**
	 * Construct a request command.
	 * @param ID
	 */
	public RequestCmd(Class<?> ID) {
		this.id = ID;
	}

	@Override
	public Class<?> getID() {
		return id;
	}

}
