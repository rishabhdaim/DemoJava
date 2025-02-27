package demo.java8.demo;

import com.google.common.base.Preconditions;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CountDownLatchDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final CountDownLatch latch = new CountDownLatch(3);
		Thread cacheService = new Thread(Service.of("CacheService", 1000, latch));
		Thread alertService = new Thread(Service.of("AlertService", 4000, latch));
		Thread validationService = new Thread(Service.of("ValidationService",8000, latch));

		cacheService.start(); // separate thread will initialize CacheService
		alertService.start(); // another thread for AlertService initialization
		validationService.start();

		// application should not start processing any thread until all service
		// is up
		// and ready to do there job.
		// Countdown latch is idle choice here, main thread will start with
		// count 3
		// and wait until count reaches zero. each thread once up and read will
		// do
		// a count down. this will ensure that main thread is not started
		// processing
		// until all services is up.

		// count is 3 since we have 3 Threads (Services)

		try {
			latch.await(); // main thread is waiting on CountDownLatch to finish
			System.out.println("All services are up, Application is starting now");
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	/**
	 * Service class which will be executed by Thread using CountDownLatch
	 * synchronizer.
	 */
	private static class Service implements Runnable {
		private final String name;
		private final int timeToStart;
		private final CountDownLatch latch;

		@Contract(pure = true)
		private Service(final String name, final int timeToStart, final CountDownLatch latch) {
			this.name = name;
			this.timeToStart = timeToStart;
			this.latch = latch;
		}

		@NotNull
		@Contract("_, _, _ -> new")
		static Service of(final String name, final int timeToStart, final CountDownLatch latch) {
			Objects.requireNonNull(name);
			Objects.requireNonNull(latch);
			Preconditions.checkArgument(timeToStart > 0);
			return new Service(name, timeToStart, latch);
		}

		@Override
		public void run() {
			try {
				Thread.sleep(timeToStart);
			} catch (InterruptedException ex) {
				Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
			}
			System.out.println(name + " is Up");
			latch.countDown(); // reduce count of CountDownLatch by 1
		}
	}
}
