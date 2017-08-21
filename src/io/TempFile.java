/**
 * 
 */
package io;

import java.io.File;
import java.io.IOException;

/**
 * @author aa49442
 * 
 */
public class TempFile {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		File tmpFile = File.createTempFile("data", null);
		File newFile = File.createTempFile("text", ".temp", new File(
				"temp"));
		System.out.println(tmpFile.getCanonicalPath());
		System.out.println(newFile.getCanonicalPath());
		// write,read data to tmp file like any normal file
		// delete when application terminates
		tmpFile.deleteOnExit();
		newFile.deleteOnExit();
	}
}