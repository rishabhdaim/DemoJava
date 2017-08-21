/**
 * 
 */
package threads;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author aa49442
 * 
 */
public class ScheduledThreadPool {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		ScheduledExecutorService scheduledExecutorService = Executors
				.newScheduledThreadPool(5);
		// schedule to run after sometime
		System.out.println("Current Time = " + new Date());

		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			WorkerThread worker = new WorkerThread("do heavy processing");
			scheduledExecutorService.schedule(worker, 10, TimeUnit.SECONDS);
		}
		// add some delay to let some threads spawn by scheduler
		Thread.sleep(2000);
		System.out.println("..............");
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			WorkerThread worker = new WorkerThread("do heavy processing");
			// schedule task to execute at fixed rate
			scheduledExecutorService.scheduleAtFixedRate(worker, 0, 10,
					TimeUnit.SECONDS);
		}
		Thread.sleep(2000);
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			WorkerThread worker = new WorkerThread("do heavy processing");
			scheduledExecutorService.scheduleWithFixedDelay(worker, 0, 1,
					TimeUnit.SECONDS);
		}
		scheduledExecutorService.shutdown();
		while (!scheduledExecutorService.isTerminated())
			;
		System.out.println("Finished all threads");
	}
}