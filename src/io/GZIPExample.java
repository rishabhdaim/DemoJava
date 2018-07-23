/**
 * 
 */
package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author rishabh.daim
 * 
 */
public class GZIPExample {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String file = "largeFile3.txt";
		String gzipFile = "largeFile3.txt.gz";
		String newFile = "new_largeFile3.txt";
		long l = System.currentTimeMillis();
		compressGzipFile(file, gzipFile);
		decompressGzipFile(gzipFile, newFile);
		System.out.println(System.currentTimeMillis() - l);
	}

	private static void decompressGzipFile(String gzipFile, String newFile)
			throws IOException {
		FileInputStream fis = new FileInputStream(gzipFile);
		GZIPInputStream gis = new GZIPInputStream(fis);
		FileOutputStream fos = new FileOutputStream(newFile);
		byte[] buffer = new byte[1024];
		int len;
		while ((len = gis.read(buffer)) != -1)
			fos.write(buffer, 0, len);
		// close resources
		fos.close();
		gis.close();
	}

	private static void compressGzipFile(String file, String gzipFile)
			throws IOException {
		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream(gzipFile);
		GZIPOutputStream gzipOS = new GZIPOutputStream(fos);
		byte[] buffer = new byte[1024];
		int len;
		while ((len = fis.read(buffer)) != -1) {
			gzipOS.write(buffer, 0, len);
		}
		// close resources
		gzipOS.close();
		fos.close();
		fis.close();
	}
}