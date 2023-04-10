/**
 * 
 */
package demo.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author rishabh.daim
 * 
 */
public class UnzipFiles {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String zipFilePath = "largeFile3.zip";
		String destDir = "new_largeFile_unzip.txt";
		unzip(zipFilePath, destDir);
	}

	private static void unzip(String zipFilePath, String destDir)
			throws IOException {
	//	File dir = new File(destDir);
		// create output directory if it doesn't exist
	//	if (!dir.exists())
	//		dir.mkdirs();
		// buffer for read and write data to file
		byte[] buffer = new byte[1024];
		FileInputStream fis = new FileInputStream(zipFilePath);
		ZipInputStream zis = new ZipInputStream(fis);
		ZipEntry ze = zis.getNextEntry();
		while (ze != null) {
		//	String fileName = ze.getName();
		//	File newFile = new File(destDir + File.separator + fileName);
		//	System.out.println("Unzipping to " + newFile.getAbsolutePath());
			// create directories for sub directories in zip
		//	new File(newFile.getParent()).mkdirs();
			FileOutputStream fos = new FileOutputStream(destDir);
			int len;
			while ((len = zis.read(buffer)) > 0) 
				fos.write(buffer, 0, len);
			fos.close();
			// close this ZipEntry
			zis.closeEntry();
			ze = zis.getNextEntry();
		}
		// close last ZipEntry
		zis.closeEntry();
		zis.close();
		fis.close();
	}
}