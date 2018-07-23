/**
 * 
 */
package javageeks.dp.command;

/**
 * @author rishabh.daim
 * 
 */
public class WriteFileCommand implements Command {

	private FileSystemReceiver fileSystem;

	/**
	 * @param fileSystem
	 */
	public WriteFileCommand(FileSystemReceiver fileSystem) {
		super();
		this.fileSystem = fileSystem;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see commanddp.Command#execute()
	 */
	@Override
	public void execute() {
		this.fileSystem.writeFile();
	}
}