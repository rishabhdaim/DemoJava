/**
 * 
 */
package demo.java8.demo;

import java.util.concurrent.TimeUnit;

/**
 * @author Rishabh.Daim
 *
 */
public class Varargs {

	private static volatile boolean stopRequested;

	public static void main(String[] args) throws InterruptedException {

		final int i = 1;
		Thread backgroundThread = new Thread(new Runnable() {
			public void run() {
				int c = i;
				while (!stopRequested) {
					c+= i;
					System.out.println(c);
				}
			}
		});

		backgroundThread.start();
		TimeUnit.SECONDS.sleep(1);
		stopRequested = true;
		
	}

}
