package demo.java.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCounter {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		Counter counter = new Counter();
		CounterThreads counterThreads = new CounterThreads(counter);

		/*
		 * Thread thread = new Thread(new CounterThreads(counter), "1"); Thread
		 * thread1 = new Thread(new CounterThreads(counter), "2"); Thread
		 * thread2 = new Thread(new CounterThreads(counter), "3");
		 * thread1.start(); thread.start(); thread2.start();
		 */

		ExecutorService executor = Executors.newCachedThreadPool();
		Callable<Long> callable = Executors.callable(counterThreads,
				counterThreads.call());
		Future<Long> future = executor.submit(callable);
		System.out.println(future.get());
	}
}