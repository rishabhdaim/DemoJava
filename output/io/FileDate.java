/**
 * 
 */
package io;

import java.io.File;
import java.util.Date;

/**
 * @author rishabh.daim
 * 
 */
public class FileDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File("employee.xml");
		long timestamp = file.lastModified();
		System.out.println("employee.xml last modified date = "
				+ new Date(timestamp));
	}

}
