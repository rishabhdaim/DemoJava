/**
 * 
 */
package javageeks.dp.proxy;

/**
 * @author rishabh.daim
 * 
 */
public class CommandExecutorImpl implements CommandExecutor {

	/*
	 * (non-Javadoc)
	 * 
	 * @see proxydp.CommandExecutor#runCommand(java.lang.String)
	 */
	@Override
	public void runCommand(String cmd) throws Exception {
		// some heavy implementation
		Runtime.getRuntime().exec(cmd);
		System.out.println("'" + cmd + "' command executed..");
	}
}