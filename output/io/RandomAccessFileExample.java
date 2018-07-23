/**
 * 
 */
package io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author rishabh.daim
 * 
 */
public class RandomAccessFileExample {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String filePath = "source.txt";
		System.out.println(new String(readCharsFromFile(filePath, 0, 80)));
		writeData(filePath, "Data", 5);
	}

	private static void writeData(String filePath, String data, int seek)
			throws IOException {
		RandomAccessFile file = new RandomAccessFile(filePath, "rw");
		file.seek(file.length());
		file.write(data.getBytes());
		file.close();
	}

	private static byte[] readCharsFromFile(String filePath, int seek, int chars)
			throws IOException {
		RandomAccessFile file = new RandomAccessFile(filePath, "r");
		file.seek(seek);
		byte[] bytes = new byte[chars];
		file.read(bytes);
		file.close();
		return bytes;
	}
}