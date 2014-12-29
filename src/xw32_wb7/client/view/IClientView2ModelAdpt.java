package xw32_wb7.client.view;

/**
 * This is the client view to model adapter
 * @author xw32,wb7
 *
 */
public interface IClientView2ModelAdpt {

	/**
	 * ConnectTo function is used to connect to another machine
	 * using that machine's IP address.
	 * @param text The IP address
	 * @return A string indicating if we have connected successfully.
	 */
	public String connectTo(String text);

	/**
	 * quit the application.
	 */
	public void quit();
	
	
}
