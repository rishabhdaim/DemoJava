/**
 * 
 */
package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author aa49442
 * 
 */
public class ReadFileLineByLine {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		File file = new File("source.txt");
		// create FileReader object from File object
		FileReader fr = new FileReader(file);
		// create BufferedReader object from FileReader to read file line by
		// line
		BufferedReader reader = new BufferedReader(fr);
		// read first line to start
		String line;
		while ((line = reader.readLine()) != null)
			System.out.println(line);
	}
}