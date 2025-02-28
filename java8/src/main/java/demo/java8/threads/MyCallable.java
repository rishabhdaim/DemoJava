/**
 * 
 */
package demo.java8.threads;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author rishabh.daim
 * 
 */
public class MyCallable implements Callable<String> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		// return the thread name executing this callable task
		return Thread.currentThread().getName();
	}

	/**
	 * @param args
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		// Get ExecutorService from Executors utility class, thread pool size is
		// 10
		ExecutorService executor = Executors.newFixedThreadPool(10);
		// create a list to hold the Future object associated with Callable
		List<Future<String>> list = new ArrayList<Future<String>>();
		// Create MyCallable instance
		Callable<String> callable = new MyCallable();
		for (int i = 0; i < 100; i++)
			// submit Callable tasks to be executed by thread pool
			// add Future to the list, we can get return value using Future
			list.add(executor.submit(callable));

		for (Future<String> future : list)
			// print the return value of Future, notice the output delay in
			// console
			// because Future.get() waits for task to get completed
			System.out.println(new Date() + "::" + future.get());
		executor.shutdown();
	}
}