package demo.java.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Driver2 {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch doneSignal = new CountDownLatch(10);
		Executor e = Executors.newCachedThreadPool();

		for (int i = 0; i < 10; ++i)
			// create and start threads
			e.execute(new WorkerRunnable(doneSignal, i));

		doneSignal.await();
		System.out.println("end..");// wait for all to finish
	}

	static class WorkerRunnable implements Runnable {
		private final CountDownLatch doneSignal;
		private final int i;

		WorkerRunnable(CountDownLatch doneSignal, int i) {
			this.doneSignal = doneSignal;
			this.i = i;
		}

		@Override
		public void run() {
			doWork(i);
			doneSignal.countDown();
		}

		void doWork(int i) {
			System.err.println("do work.. " + i);
		}
	}
}
