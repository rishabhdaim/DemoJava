package demo.java8.demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CyclicBarrierExample {
	// Runnable task for each thread
	private static class Task implements Runnable {

		private final CyclicBarrier barrier;

		@org.jetbrains.annotations.Contract(pure = true)
		Task(final CyclicBarrier barrier) {
			this.barrier = barrier;
		}

		@Override
		public void run() {
			try {
				System.out.printf("%s is waiting on barrier\n", Thread.currentThread().getName());
				barrier.await();
				System.out.printf("%s has crossed the barrier\n", Thread.currentThread().getName());
			} catch (InterruptedException | BrokenBarrierException ex) {
				Logger.getLogger(CyclicBarrierExample.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	public static void main(String[] args) {

		// creating CyclicBarrier with 3 parties i.e. 3 Threads needs to call
		// await()
		final CyclicBarrier cb = new CyclicBarrier(3, () -> {
			// This task will be executed once all thread reaches barrier
			System.out.println("All parties are arrived at barrier, lets play");
		});

		// starting each of thread
		Thread t1 = new Thread(new Task(cb), "Thread 1");
		Thread t2 = new Thread(new Task(cb), "Thread 2");
		Thread t3 = new Thread(new Task(cb), "Thread 3");

		t1.start();
		t2.start();
		t3.start();

	}
}
