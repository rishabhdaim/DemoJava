/**
 * 
 */
package javageeks.dp.command;

/**
 * @author rishabh.daim
 * 
 */
public class FileSystemReceiverUtil {

	public static FileSystemReceiver getUnderlyingFileSystem() {
		final String osName = System.getProperty("os.name");
		System.out.println("Underlying OS is : " + osName);
		if (osName.contains("Windows"))
			return new WindowsFileSystemReceiver();
		else if (osName.contains("unix"))
			return new UnixFileSystemReceiver();
		else
			return new MacFileSystemReceiver();
	}
}