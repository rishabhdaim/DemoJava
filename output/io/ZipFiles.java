/**
 * 
 */
package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author aa49442
 * 
 */
public class ZipFiles {

	List<String> filesListInDir = new ArrayList<String>();

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		File file = new File("sitemap.xml");
		String zipFileName = "sitemap.zip";
		File dir = new File("src");
		String zipDirName = "src.zip";
		zipSingleFile(file, zipFileName);
		ZipFiles zipFiles = new ZipFiles();
		zipFiles.zipDirectory(dir, zipDirName);
	}

	/**
	 * @param dir
	 * @param zipDirName
	 * @throws IOException
	 */
	private void zipDirectory(File dir, String zipDirName) throws IOException {
		populateFilesList(dir);
		// now zip files one by one
		// create ZipOutputStream to write to the zip file
		FileOutputStream fos = new FileOutputStream(zipDirName);
		ZipOutputStream zos = new ZipOutputStream(fos);
		for (String filePath : filesListInDir) {
			System.out.println("Zipping " + filePath);
			// for ZipEntry we need to keep only relative file path, so we used
			// substring on absolute path
			ZipEntry ze = new ZipEntry(filePath.substring(dir.getAbsolutePath()
					.length() + 1, filePath.length()));
			zos.putNextEntry(ze);
			// read the file and write to ZipOutputStream
			FileInputStream fis = new FileInputStream(filePath);
			byte[] buffer = new byte[1024];
			int len;
			while ((len = fis.read(buffer)) > 0)
				zos.write(buffer, 0, len);
			zos.closeEntry();
			fis.close();
		}
		zos.close();
		fos.close();
	}

	/**
	 * @param dir
	 */
	private void populateFilesList(File dir) {
		// to put files in List..
		for (File file : dir.listFiles())
			if (file.isFile())
				filesListInDir.add(file.getAbsolutePath());
			else
				populateFilesList(file);
	}

	/**
	 * @param file
	 * @param zipFileName
	 * @throws IOException
	 */
	private static void zipSingleFile(File file, String zipFileName)
			throws IOException {
		// create ZipOutputStream to write to the zip file
		FileOutputStream fos = new FileOutputStream(zipFileName);
		ZipOutputStream zos = new ZipOutputStream(fos);
		// add a new Zip Entry to the ZipOutputStream
		ZipEntry ze = new ZipEntry(file.getName());
		zos.putNextEntry(ze);
		// read the file and write to ZipOutputStream
		FileInputStream fis = new FileInputStream(file);
		byte[] buffer = new byte[1024];
		int len;
		while ((len = fis.read(buffer)) > 0)
			zos.write(buffer, 0, len);
		// Close the zip entry to write to zip file
		zos.closeEntry();
		// Close resources
		zos.close();
		fis.close();
		fos.close();
		System.out.println(file.getCanonicalPath() + " is zipped to "
				+ zipFileName);
	}

}
