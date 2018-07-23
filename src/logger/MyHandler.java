/**
 * 
 */
package logger;

import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

/**
 * @author rishabh.daim
 * 
 */
public class MyHandler extends StreamHandler {

	@Override
	public synchronized void publish(LogRecord record) {
		super.publish(record);
	}

	@Override
	public synchronized void flush() {
		super.flush();
	}

	@Override
	public synchronized void close() throws SecurityException {
		super.close();
	}
}