/**
 * 
 */
package demo.java8.threads;

/**
 * @author rishabh.daim
 * 
 */
public class MyThread extends Thread {
	public MyThread(String name) {
		super(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		System.out.println("MyThread - START  "
				+ Thread.currentThread().getName());
		try {
			Thread.sleep(1000); // Get database connection, delete unused data
								// from DB
			doDBProcessing();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out
				.println("MyThread - END " + Thread.currentThread().getName());
	}

	private void doDBProcessing() throws InterruptedException {
		Thread.sleep(5000);
	}
}
