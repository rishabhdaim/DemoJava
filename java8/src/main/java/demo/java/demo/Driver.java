package demo.java.demo;

import java.util.concurrent.CountDownLatch;

public class Driver {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch startSignal = new CountDownLatch(1);
		CountDownLatch doneSignal = new CountDownLatch(10);

		for (int i = 0; i < 10; ++i)
			// create and start threads
			new Thread(new Worker(startSignal, doneSignal), Integer.toString(i))
					.start();

		doSomethingElse(); // don't let run yet
		startSignal.countDown(); // let all threads proceed
		doSomethingElse();
		doneSignal.await();
		doSomethingElse();// wait for all to finish
	}

	private static void doSomethingElse() {
		System.out.println("doSomethingElse "
				+ Thread.currentThread().getName());
	}

	private static class Worker implements Runnable {
		private final CountDownLatch startSignal;
		private final CountDownLatch doneSignal;

		Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
			this.startSignal = startSignal;
			this.doneSignal = doneSignal;
		}

		public void run() {
			try {
				startSignal.await();
				doWork();
				doneSignal.countDown();
			} catch (InterruptedException ex) {
			} // return;
		}

		void doWork() {
			System.err.println("do work " + Thread.currentThread().getName());
		}
	}
}
