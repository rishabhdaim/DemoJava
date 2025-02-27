/**
 * 
 */
package demo.java8.io;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * @author rishabh.daim
 * 
 */
public class DownloadFileFromURL {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String url = "http://www.journaldev.com/sitemap.xml";
		downloadUsingNIO(url, "sitemap.xml");
		downloadUsingStream(url, "sitemap_stream.xml");
	}

	private static void downloadUsingStream(String urlStr, String file)
			throws IOException {
		URL url = new URL(urlStr);
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		FileOutputStream fis = new FileOutputStream(file);
		byte[] buffer = new byte[1024];
		int count = 0;
		while ((count = bis.read(buffer, 0, 1024)) != -1)
			fis.write(buffer, 0, count);
		fis.close();
		bis.close();
	}

	private static void downloadUsingNIO(String urlStr, String file)
			throws IOException {
		URL url = new URL(urlStr);
		ReadableByteChannel rbc = Channels.newChannel(url.openStream());
		FileOutputStream fos = new FileOutputStream(file);
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		fos.close();
		rbc.close();
	}
}
