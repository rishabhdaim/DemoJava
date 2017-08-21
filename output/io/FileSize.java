/**
 * 
 */
package io;

import java.io.File;

/**
 * @author aa49442
 * 
 */
public class FileSize {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File("temp/newEmp.xml");
		if (file.exists()) {
			System.out.println(getFileSizeBytes(file));
			System.out.println(getFileSizeKiloBytes(file));
			System.out.println(getFileSizeMegaBytes(file));
		} else
			System.out.println("File doesn't exist");
	}

	private static String getFileSizeMegaBytes(File file) {
		return (double) file.length() / (1024 * 1024) + " mb";
	}

	private static String getFileSizeKiloBytes(File file) {
		return (double) file.length() / 1024 + "  kb";
	}

	private static String getFileSizeBytes(File file) {
		return file.length() + " bytes";
	}
}
