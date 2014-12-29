package xw32_wb7.game.model;

/**
 * The game model to game view adapter.
 * @author xw32, wb7
 *
 */
public interface ILocalViewAdapter {
	/**
	 * Default view adapter that simply prints to standard out.
	 */
	public static final ILocalViewAdapter DEFAULT_ADAPTER = new ILocalViewAdapter() {
		public void append(String s) {
			System.out.println("ITaskViewAdapter.append: " + s);
		}
	};

	/**
	 * Append the given string to the view's display
	 * @param s the string to display
	 */
	public void append(String s);
}
