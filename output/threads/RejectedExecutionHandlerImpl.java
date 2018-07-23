/**
 * 
 */
package threads;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author rishabh.daim
 * 
 */
public class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.util.concurrent.RejectedExecutionHandler#rejectedExecution(java.
	 * lang.Runnable, java.util.concurrent.ThreadPoolExecutor)
	 */
	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println(r.toString() + " is rejected");
	}
}