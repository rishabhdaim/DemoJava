/**
 * 
 */
package demo.java8.javageeks.dp.command;

import java.util.concurrent.BlockingQueue;

import com.google.common.collect.Queues;

/**
 * @author Rishabh.Daim
 *
 */
public class ThreadPool {
	
	private final BlockingQueue<Job> jobQueue;
	private final Thread[] jobThreads;
	private volatile boolean isShutdown;
	
	public ThreadPool(final int n) {
		jobQueue = Queues.newLinkedBlockingQueue();
		jobThreads = new Thread[n];
		
		for (int i = 0; i < n; i++) {
			jobThreads[i] = new Thread(new Worker(), "Pool Thread " + i);
			jobThreads[i].start();
		}
	}
	
	
	public void addJob(final Job job) {
		try {
			jobQueue.put(job);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void shutdownPool() {
		
		while (!jobQueue.isEmpty()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			isShutdown = true;
			
			for (Thread thread : jobThreads) {
				thread.interrupt();
			}
		}
	}
	
	
	// worker class to perform work taken from jobQueue
	
	private class Worker implements Runnable {
		
		@Override
		public void run() {
			while (!isShutdown) {
				try {
					Job job = jobQueue.take();
					job.run();
				} catch (InterruptedException e) {
				}
			}
		}
		
	}
}
