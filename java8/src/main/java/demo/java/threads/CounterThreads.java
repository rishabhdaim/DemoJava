package demo.java.threads;

import java.util.concurrent.Callable;

public class CounterThreads implements Callable<Long>, Runnable {

	private Counter counter;

	public CounterThreads(Counter counter) {
		this.counter = counter;
	}

	public void run() {
		for (int i = 0; i < 10; i++)
			System.out.println(counter.incrementCounter() + "-----"
					+ Thread.currentThread().getName());
	}

	@Override
	public Long call() throws Exception {
		for (int i = 0; i < 10; i++)
			System.out.println(counter.incrementCounter() + "----------"
					+ Thread.currentThread().getName());
		return counter.getCount();
	}

}
