/**
 * 
 */
package demo.java8.logger;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * @author rishabh.daim
 * 
 */
public class MyFormatter extends Formatter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.logging.Formatter#format(java.util.logging.LogRecord)
	 */
	@Override
	public String format(LogRecord record) {
		return record.getThreadID() + "::" + record.getSourceClassName() + "::"
				+ record.getSourceMethodName() + "::"
				+ new Date(record.getMillis()) + "::" + record.getMessage()
				+ "\n";
	}
}