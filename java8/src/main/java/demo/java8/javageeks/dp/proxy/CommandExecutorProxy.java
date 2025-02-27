/**
 * 
 */
package demo.java8.javageeks.dp.proxy;

/**
 * @author rishabh.daim
 * 
 */
public class CommandExecutorProxy implements CommandExecutor {
	private boolean isAdmin;
	private CommandExecutor executor;

	public CommandExecutorProxy(String user, String pwd) {
		if ("rishu".equals(user) && "rishu".equals(pwd))
			isAdmin = true;
		executor = new CommandExecutorImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see proxydp.CommandExecutor#runCommand(java.lang.String)
	 */
	@Override
	public void runCommand(String cmd) throws Exception {
		if (isAdmin)
			executor.runCommand(cmd);
		else {
			if (cmd.trim().startsWith("rm"))
				throw new Exception(
						"rm command is not allowed for non-admin users..");
			else
				executor.runCommand(cmd);
		}
	}
}