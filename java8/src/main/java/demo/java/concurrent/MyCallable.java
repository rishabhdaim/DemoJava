/**
 * 
 */
package demo.java.concurrent;

import java.util.concurrent.Callable;

/**
 * @author rishabh.daim
 * 
 */
public class MyCallable implements Callable<String> {

	private long waitTime;

	public MyCallable(int timeInMillis) {
		this.waitTime = timeInMillis;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public String call() throws Exception {
		Thread.sleep(waitTime);
		// return the thread name executing this callable task
		return Thread.currentThread().getName();
	}
}