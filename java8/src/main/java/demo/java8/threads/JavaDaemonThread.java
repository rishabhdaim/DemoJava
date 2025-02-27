/**
 * 
 */
package demo.java8.threads;

/**
 * @author rishabh.daim
 * 
 */
public class JavaDaemonThread {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread dt = new Thread(new DaemonThread(), "dt");
		//dt.setDaemon(true);
		dt.start(); // continue program
		Thread.sleep(3000);
		System.out.println("Finishing program");
	}

	private static class DaemonThread implements Runnable {

		@Override
		public void run() {
			try {
				Thread.sleep(5000);
				System.out.println("daemon thread");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}