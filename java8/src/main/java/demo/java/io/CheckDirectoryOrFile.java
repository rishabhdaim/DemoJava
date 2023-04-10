/**
 * 
 */
package demo.java.io;

import java.io.File;

/**
 * @author rishabh.daim
 * 
 */
public class CheckDirectoryOrFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File("DB.xml");
		File dir = new File("temp");
		File notExists = new File("/Users/pankaj/notafile");
		System.out.println("/Users/pankaj/source.txt is file?" + file.isFile());
		System.out.println("/Users/pankaj/source.txt is directory?"
				+ file.isDirectory());
		System.out.println("/Users/pankaj is file?" + dir.isFile());
		System.out.println("/Users/pankaj is directory?" + dir.isDirectory());
		System.out.println("/Users/pankaj/notafile is file?"
				+ notExists.isFile());
		System.out.println("/Users/pankaj/notafile is directory?"
				+ notExists.isDirectory());
	}
}