/**
 * 
 */
package demo.java.javageeks.dp.command;

/**
 * @author rishabh.daim
 * 
 */
public class MacFileSystemReceiver implements FileSystemReceiver {

	@Override
	public void openFile() {
		System.out.println("Opening file in Mac OS");
	}

	@Override
	public void writeFile() {
		System.out.println("writing file in Mac OS");
	}

	@Override
	public void closeFile() {
		System.out.println("closing file in Mac OS");
	}
}