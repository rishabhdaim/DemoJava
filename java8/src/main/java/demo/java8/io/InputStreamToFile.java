/**
 * 
 */
package demo.java8.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author rishabh.daim
 * 
 */
public class InputStreamToFile {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("source.txt");
		OutputStream os = new FileOutputStream("new_source.txt");
		byte[] buffer = new byte[1024];
		int bytesRead;
		// read from is to buffer
		while ((bytesRead = is.read(buffer)) != -1)
			os.write(buffer, 0, bytesRead);
		is.close();
		// flush OutputStream to write any buffered data to file
		os.close();
	}
}