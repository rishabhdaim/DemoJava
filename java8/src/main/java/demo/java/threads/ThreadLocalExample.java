/**
 * 
 */
package demo.java.threads;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * @author rishabh.daim
 * 
 */
public class ThreadLocalExample implements Runnable {

	// SimpleDateFormat is not thread-safe, so give one to each thread
	private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		System.out.println("Thread Name= " + Thread.currentThread().getName() + " default Formatter = " + formatter.get().toPattern());
		try {
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		formatter.set(new SimpleDateFormat());
		System.out.println("Thread Name= " + Thread.currentThread().getName() + " formatter = " + formatter.get().toPattern());
	}

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		var obj = new ThreadLocalExample();
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(obj, "" + i);
			Thread.sleep(new Random().nextInt(1000));
			t.start();
		}
	}
}