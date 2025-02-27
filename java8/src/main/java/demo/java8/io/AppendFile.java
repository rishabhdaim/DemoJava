/**
 * 
 */
package demo.java8.io;

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
public class AppendFile {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String filePath = "append.txt";
		String appendText = "This String will be appended to the file, Byte=0x0A 0xFF";
		appendUsingFileWriter(filePath, appendText);
		appendUsingBufferedWriter(filePath, appendText, 10);
		appendUsingOutputStream(filePath, appendText);
	}

	/**
	 * Use Streams when you are dealing with raw data, binary data
	 * 
	 * @param data
	 * @throws IOException
	 */
	private static void appendUsingOutputStream(String fileName, String data)
			throws IOException {
		// below true flag tells OutputStream to append
		OutputStream os = new FileOutputStream(new File(fileName), true);
		os.write(data.getBytes(), 0, data.length());
		os.write("\n".getBytes());
		os.close();
	}

	/**
	 * Use BufferedWriter when number of write operations are more
	 * 
	 * @param filePath
	 * @param text
	 * @param noOfLines
	 * @throws IOException
	 */
	private static void appendUsingBufferedWriter(String filePath, String text,
			int noOfLines) throws IOException {
		File file = new File(filePath);
		// to append to file, you need to initialize FileWriter using below
		// constructor
		FileWriter fr = new FileWriter(file, true);
		BufferedWriter br = new BufferedWriter(fr);
		for (int i = 0; i < noOfLines; i++) {
			// you can use write or append method
			br.write(text);
			br.newLine();
		}
		br.write("br..");
		br.newLine();
		br.close();
		fr.close();
	}

	/**
	 * Use FileWriter when number of write operations are less
	 * 
	 * @param filePath
	 * @param text
	 * @param noOfLines
	 * @throws IOException
	 */
	private static void appendUsingFileWriter(String filePath, String text)
			throws IOException {
		File file = new File(filePath);
		// Below constructor argument decides whether to append or override
		FileWriter fr = new FileWriter(file, true);
		fr.write(text);
		fr.write("\n");
		fr.write("done..");
		fr.write("\n");
		fr.close();
	}
}