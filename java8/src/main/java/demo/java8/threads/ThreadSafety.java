/**
 * 
 */
package demo.java8.threads;

/**
 * @author rishabh.daim
 * 
 */
public class ThreadSafety {

	/**
	 * @author rishabh.daim
	 * 
	 */
	private static class ProcessingThread implements Runnable {

		private final Object mutex = new Object();
		private int count;

		@Override
		public void run() {
			for (int i = 1; i < 5; i++) {
				processSomething(i);
				synchronized (mutex) {
					count++;
				}
			}
		}

		private void processSomething(int i) {
			// processing some job
			try {
				Thread.sleep(i * 100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		/**
		 * @return the count
		 */
		public int getCount() {
			return count;
		}
	}

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		ProcessingThread pt = new ProcessingThread();
		Thread t1 = new Thread(pt, "t1");
		Thread t2 = new Thread(pt, "t2");
		t1.start();
		t2.start(); // wait for threads to finish processing
		t1.join();
		t2.join();
		System.out.println("Processing count=" + pt.getCount());
	}
}