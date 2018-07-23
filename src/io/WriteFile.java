/**
 * 
 */
package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author rishabh.daim
 * 
 */
public class WriteFile {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String data = "I will write this String to File in Java";
		int noOfLines = 10000;
		writeUsingFileWriter(data);
		writeUsingBufferedWriter(data, noOfLines);
		//writeUsingFiles(data);
		writeUsingOutputStream(data);
		System.out.println("DONE");
	}

	/**
	 * @param data
	 * @throws IOException
	 */
	private static void writeUsingOutputStream(String data) throws IOException {
		OutputStream os = new FileOutputStream(new File("os.txt"));
		os.write(data.getBytes(), 0, data.length());
		os.close();
	}

	/*private static void writeUsingFiles(String data) throws IOException {
		Files.write(Paths.get("files.txt"), data.getBytes());
	}*/

	/**
	 * Use BufferedWriter when number of write operations are more * It uses
	 * internal buffer to reduce real IO operations and saves time
	 * 
	 * @param data
	 * @param noOfLines
	 * @throws IOException
	 */
	private static void writeUsingBufferedWriter(String data, int noOfLines)
			throws IOException {
		File file = new File("BufferedWriter.txt");
		FileWriter fr = null;
		BufferedWriter br = null;
		String dataWithNewLine = data + System.getProperty("line.separator");
		fr = new FileWriter(file);
		br = new BufferedWriter(fr);
		for (int i = noOfLines; i > 0; i--)
			br.write(dataWithNewLine);
		br.close();
		fr.close();
	}

	/**
	 * Use FileWriter when number of write operations are less
	 * 
	 * @param data
	 * @throws IOException
	 */
	private static void writeUsingFileWriter(String data) throws IOException {
		File file = new File("FileWriter.txt");
		FileWriter fr = null;
		fr = new FileWriter(file);
		fr.write(data);
		fr.close();
	}
}