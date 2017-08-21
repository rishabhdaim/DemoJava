/**
 * 
 */
package javageeks.dp.command;

/**
 * @author aa49442
 * 
 */
public class CloseFileCommand implements Command {

	private FileSystemReceiver fileSystem;

	/**
	 * @param fileSystem
	 */
	public CloseFileCommand(FileSystemReceiver fileSystem) {
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
		this.fileSystem.closeFile();
	}
}