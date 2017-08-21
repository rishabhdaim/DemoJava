/**
 * 
 */
package threads;

/**
 * @author aa49442
 * 
 */
public class SynchronizedLockExample implements Runnable {

	private Resource resource;

	public SynchronizedLockExample(Resource r) {
		this.resource = r;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		synchronized (resource) {
			resource.doSomething();
		}
		resource.doLogging();
	}
}