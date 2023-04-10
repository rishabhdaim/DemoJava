/**
 * 
 */
package demo.java.threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author rishabh.daim
 * 
 */
public class ConcurrencyLockExample implements Runnable {

	private Resource resource;
	private Lock lock;

	public ConcurrencyLockExample(Resource r) {
		this.resource = r;
		this.lock = new ReentrantLock();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try {
			if (lock.tryLock(10, TimeUnit.SECONDS)) {
				resource.doSomething();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {// release lock
			lock.unlock();
		}
		resource.doLogging();
	}
}