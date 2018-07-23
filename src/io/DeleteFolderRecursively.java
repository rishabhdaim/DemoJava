/**
 * 
 */
package io;

import java.io.File;

/**
 * @author rishabh.daim
 * 
 */
public class DeleteFolderRecursively {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		recursiveDelete(new File("temp"));
	}

	private static void recursiveDelete(File file) {
		// to end the recursive loop
		if (!file.exists())
			return;

		// if directory, go inside and call recursively
		if (file.isDirectory())
			for (File f : file.listFiles())
				// call recursively
				recursiveDelete(f);
		// call delete to delete files and empty directory
		file.delete();
		System.out.println("Deleted file/folder: " + file.getAbsolutePath());
	}

}
