/**
 * 
 */
package io;

import java.io.File;

/**
 * @author rishabh.daim
 * 
 */
public class RenameFileJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// absolute path rename file
		File file = new File("temp/employees.xml");
		File newFile = new File("temp/newEmp.xml");
		if (file.renameTo(newFile))
			System.out.println("File rename success");
		else
			System.out.println("File rename failed");

		// relative path rename file
		file = new File("out.txt");
		newFile = new File("new_out.txt");
		if (file.renameTo(newFile))
			System.out.println("File rename success");
		else
			System.out.println("File rename failed");

		// move file from one directory to another
		file = new File("new_out.txt");
		newFile = new File("temp/new_out_moved.txt");
		if (file.renameTo(newFile))
			System.out.println("File move success");
		else
			System.out.println("File move failed");

		// when source file is not present
		file = new File("/Users/pankaj/xyz.txt");
		newFile = new File("xyz.properties");
		if (file.renameTo(newFile))
			System.out.println("File move success");
		else
			System.out.println("File move failed");

		// when destination already have a file with same name
		file = new File("orderUpdator.log.1");
		newFile = new File("temp/orderUpdator.log.0");
		if (file.renameTo(newFile))
			System.out.println("File move success");
		else
			System.out.println("File move failed");
	}

}
