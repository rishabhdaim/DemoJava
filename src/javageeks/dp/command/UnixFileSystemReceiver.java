/**
 * 
 */
package javageeks.dp.command;

/**
 * @author aa49442
 * 
 */
public class UnixFileSystemReceiver implements FileSystemReceiver {

	/*
	 * (non-Javadoc)
	 * 
	 * @see commanddp.FileSystemReceiver#openFile()
	 */
	@Override
	public void openFile() {
		System.out.println("Opening file in unix OS");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see commanddp.FileSystemReceiver#writeFile()
	 */
	@Override
	public void writeFile() {
		System.out.println("writing file in unix OS");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see commanddp.FileSystemReceiver#closeFile()
	 */
	@Override
	public void closeFile() {
		System.out.println("closing file in unix OS");
	}
}