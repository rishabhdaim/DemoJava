/**
 * 
 */
package demo.java8.threads;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author rishabh.daim
 * 
 */
public class MyMonitorThread implements Runnable {

	private ThreadPoolExecutor executor;
	private int seconds;
	private boolean run = true;

	public MyMonitorThread(ThreadPoolExecutor executor, int delay) {
		this.executor = executor;
		this.seconds = delay;
	}

	public void shutdown() {
		this.run = false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while (run) {
			System.out
					.println(String
							.format("[monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
									this.executor.getPoolSize(),
									this.executor.getCorePoolSize(),
									this.executor.getActiveCount(),
									this.executor.getCompletedTaskCount(),
									this.executor.getTaskCount(),
									this.executor.isShutdown(),
									this.executor.isTerminated()));
			try {
				Thread.sleep(seconds * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}