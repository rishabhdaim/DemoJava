/**
 * 
 */
package demo.java.javageeks.dp.command;

/**
 * @author rishabh.daim
 * 
 */
public class WindowsFileSystemReceiver implements FileSystemReceiver {

	/*
	 * (non-Javadoc)
	 * 
	 * @see commanddp.FileSystemReceiver#openFile()
	 */
	@Override
	public void openFile() {
		System.out.println("Opening file in Windows OS");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see commanddp.FileSystemReceiver#writeFile()
	 */
	@Override
	public void writeFile() {
		System.out.println("writing file in Windows OS");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see commanddp.FileSystemReceiver#closeFile()
	 */
	@Override
	public void closeFile() {
		System.out.println("closing file in Windows OS");
	}
}