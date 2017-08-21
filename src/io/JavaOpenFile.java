/**
 * 
 */
package io;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 * @author aa49442
 * 
 */
public class JavaOpenFile {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// text file, should be opening in default text editor
		File file = new File("Employee.xsd");
		// first check if Desktop is supported by Platform or not
		if (!Desktop.isDesktopSupported()) {
			System.out.println("Desktop is not supported");
			return;
		}
		Desktop desktop = Desktop.getDesktop();
		if (file.exists())
			desktop.open(file);
		// let's try to open PDF file
		file = new File("jaxb-emp.xml");
		if (file.exists())
			desktop.open(file);
	}
}