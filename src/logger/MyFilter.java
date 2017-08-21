/**
 * 
 */
package logger;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

/**
 * @author aa49442
 * 
 */
public class MyFilter implements Filter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.logging.Filter#isLoggable(java.util.logging.LogRecord)
	 */
	@Override
	public boolean isLoggable(LogRecord record) {
		return true;
	}

}
