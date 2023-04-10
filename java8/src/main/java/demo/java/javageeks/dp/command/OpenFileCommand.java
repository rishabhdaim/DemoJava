/**
 * 
 */
package demo.java.javageeks.dp.command;

/**
 * @author rishabh.daim
 * 
 */
public class OpenFileCommand implements Command {

	private FileSystemReceiver fileSystem;

	/**
	 * @param fileSystem
	 */
	public OpenFileCommand(FileSystemReceiver fileSystem) {
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
		// open command is forwarding request to openFile method
		this.fileSystem.openFile();
	}
}