/**
 * 
 */
package io;

import java.io.File;

/**
 * @author aa49442
 * 
 */
public class JavaFilePermissions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File("employee.xml");
		// check file permissions for application user
		System.out.println("File is readable? " + file.canRead());
		System.out.println("File is writable? " + file.canWrite());
		System.out.println("File is executable? " + file.canExecute());
		// change file permissions for application user only
		file.setReadable(false);
		file.setWritable(false);
		file.setExecutable(false);
		// check file permissions for application user
		System.out.println("File is readable? " + file.canRead());
		System.out.println("File is writable? " + file.canWrite());
		System.out.println("File is executable? " + file.canExecute());
		// change file permissions for other users also
		file.setReadable(true, false);
		file.setWritable(true, false);
		file.setExecutable(true, true);
	}
}