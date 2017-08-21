/**
 * 
 */
package threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author aa49442
 * 
 */
public class ThreadPool {

	private final BlockingQueue<Runnable> runnables;
	private final Thread[] workers;

	public ThreadPool(int noOfThreads) {
		runnables = new LinkedBlockingQueue<Runnable>();
		workers = new Thread[noOfThreads];
		int i = 0;
		for (Thread thread : workers) {
			thread = new Thread(new Worker(), " : " + i++);
			thread.start();
		}
	}

	public void addTask(Runnable r) {
		try {
			runnables.put(r);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private class Worker implements Runnable {

		@Override
		public void run() {
			while (true) {
				Runnable r = null;
				try {
					System.out.println("running thread : " + this.toString());
					r = runnables.take();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				r.run();
			}
		}
	}
}
