package demo.java.demo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {

	/**
	 * @param args
	 */
	static Semaphore binary = new Semaphore(1);

	public static void main(String[] args) {
		final SemaphoreTest test = new SemaphoreTest();
		new Thread() {
			@Override
			public void run() {
				test.mutualExclusion();
			}
		}.start();

		new Thread() {
			@Override
			public void run() {
				test.mutualExclusion();
			}
		}.start();

	}

	private void mutualExclusion() {
		try {
			binary.acquire();

			// mutual exclusive region
			System.err.println(Thread.currentThread().getName()
					+ " inside mutual exclusive region");
			TimeUnit.SECONDS.sleep(1);

		} catch (InterruptedException ie) {
			ie.printStackTrace();
		} finally {
			binary.release();
			System.out.println(Thread.currentThread().getName()
					+ " outside of mutual exclusive region");
		}

	}
}
