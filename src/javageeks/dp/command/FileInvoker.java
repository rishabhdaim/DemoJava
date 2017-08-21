/**
 * 
 */
package javageeks.dp.command;

/**
 * @author aa49442
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