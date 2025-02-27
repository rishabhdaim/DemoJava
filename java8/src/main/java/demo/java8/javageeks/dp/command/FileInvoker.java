/**
 * 
 */
package demo.java8.javageeks.dp.command;

/**
 * @author rishabh.daim
 * 
 */
public class FileInvoker {

	private Command command;

	/**
	 * @param command
	 */
	public FileInvoker(Command command) {
		super();
		this.command = command;
	}

	public void execute() {
		this.command.execute();
	}

	/**
	 * @return the command
	 */
	public Command getCommand() {
		return command;
	}
}