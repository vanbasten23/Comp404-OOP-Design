package xw32_wb7.game.msg;

import java.io.Serializable;

import common.IMember;

/**
 * The ILocalGameOverMsg
 * @author xw32, wb7
 *
 */
public interface ILocalGameOverMsg extends Serializable{
	
	/**
	 * Get the sender.
	 * @return sender.
	 */
	public IMember getSender();
}
