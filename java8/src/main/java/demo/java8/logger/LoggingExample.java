/**
 * 
 */
package demo.java8.logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

/**
 * @author rishabh.daim
 * 
 */
public class LoggingExample {

	private static Logger logger = Logger.getLogger(LoggingExample.class
			.getName());

	/**
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws SecurityException
	 */
	public static void main(String[] args) throws SecurityException,
			FileNotFoundException, IOException {
		LogManager.getLogManager().readConfiguration(
				new FileInputStream("mylogging.properties"));
		logger.setLevel(Level.SEVERE);
		logger.addHandler(new ConsoleHandler());
		// adding custom handler
		logger.addHandler(new MyHandler());
		// FileHandler file name with max size and number of log files limit
		Handler fileHandler = new FileHandler("com.ctli.logger.log", 2048000,
				5, true);
		fileHandler.setFormatter(new XMLFormatter());
		// setting custom filter for FileHandler
		fileHandler.setFilter(new MyFilter());

		logger.addHandler(fileHandler);
		for (int i = 0; i < 10000; i++)
			// logging messages
			logger.log(Level.SEVERE, "New Message = " + i);
		logger.log(Level.CONFIG, "Config data");
	}
}