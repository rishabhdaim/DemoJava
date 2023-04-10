/**
 * 
 */
package demo.java.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;

/**
 * @author rishabh.daim
 * 
 */
public class JavaCopyFile {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		File source = new File("largeFile3.txt");
		File dest = new File("temp/largeFile4.txt");
		// copy file conventional way using Stream
		long start = System.nanoTime();
		copyFileUsingStream(source, dest);
		System.out.println("Time taken by Stream Copy = "
				+ (System.nanoTime() - start));
		// copy files using java.nio FileChannel
		source = new File("largeFile3.txt");
		dest = new File("temp/largeFile5.txt");
		start = System.nanoTime();
		copyFileUsingChannel(source, dest);
		System.out.println("Time taken by Channel Copy = "
				+ (System.nanoTime() - start));
		// copy files using apache commons io
		source = new File("largeFile3.txt");
		dest = new File("temp/largeFile6.txt");
		start = System.nanoTime();
		copyFileUsingApacheCommonsIO(source, dest);
		System.out.println("Time taken by Apache Commons IO Copy = "
				+ (System.nanoTime() - start));
		// using Java 7 Files class
		source = new File("largeFile3.txt");
		dest = new File("temp/largeFile7.txt");
		start = System.nanoTime();
		copyFileUsingJava7Files(source, dest);
		System.out.println("Time taken by Java7 Files Copy = "
				+ (System.nanoTime() - start));
	}

	private static void copyFileUsingStream(File source, File dest)
			throws IOException {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(source);
			os = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} finally {
			is.close();
			os.close();
		}
	}

	private static void copyFileUsingChannel(File source, File dest)
			throws IOException {
		FileChannel sourceChannel = null;
		FileChannel destChannel = null;
		try {
			sourceChannel = new FileInputStream(source).getChannel();
			destChannel = new FileOutputStream(dest).getChannel();
			destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
		} finally {
			sourceChannel.close();
			destChannel.close();
		}
	}

	private static void copyFileUsingApacheCommonsIO(File source, File dest)
			throws IOException {
		FileUtils.copyFile(source, dest);
	}

	private static void copyFileUsingJava7Files(File source, File dest)
			throws IOException {
		Files.copy(source.toPath(), dest.toPath());
	}
}
