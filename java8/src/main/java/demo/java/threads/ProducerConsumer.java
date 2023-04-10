/**
 * 
 */
package demo.java.threads;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author rishabh.daim
 * 
 */
public class ProducerConsumer {

	private final BlockingQueue<Integer> queue;
	private static final Random RANDOM = new Random(1234);

	public ProducerConsumer() {
		queue = new LinkedBlockingQueue<Integer>();
	}

	public static void main(String[] args) {
		ProducerConsumer pc = new ProducerConsumer();
		pc.init();
	}

	private void init() {
		ThreadPool pool = new ThreadPool(5);

		for (int i = 0; i < 5; i++) {
			pool.addTask(new Producer());
			pool.addTask(new Producer());
			pool.addTask(new Producer());
			pool.addTask(new Producer());

			pool.addTask(new Consumer());
			pool.addTask(new Consumer());
			pool.addTask(new Consumer());
			pool.addTask(new Consumer());
		}
	}

	private class Producer implements Runnable {

		@Override
		public void run() {
			Integer i = RANDOM.nextInt(1234);
			System.out.println("inserting element : " + i);

			try {
				queue.put(i);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private class Consumer implements Runnable {

		@Override
		public void run() {
			try {
				Integer i = queue.take();
				System.out.println("getting element : " + i);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
