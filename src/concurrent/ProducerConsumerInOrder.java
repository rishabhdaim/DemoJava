/**
 * 
 */
package concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Rishabh.Daim
 *
 */
public class ProducerConsumerInOrder {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		final BlockingQueue<Double> queue = new ArrayBlockingQueue<>(10);
		
		final Thread[] runnables = new Thread[20];
		int j = 0;
		
		for (int i = 0; i < 20; i++) {
			Producer producer = new Producer(queue);
			Consumer consumer = new Consumer(queue);
			runnables[i] = new Thread(producer, "Prod : Thread " + j);
			i++;
			runnables[i] = new Thread(consumer, "Cons : Thread " + j);
			j++;
		}
		
		for (Thread t : runnables) {
			t.start();
			t.join();
		}
	}
	
	
	private static class Producer implements Runnable {
		
		private final BlockingQueue<Double> queue;

		public Producer(final BlockingQueue<Double> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			try {
				double e = Math.random() * 10;
				System.out.println("Put by : " + Thread.currentThread().getName() + " value is : " + e);
				queue.put(e);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private static class Consumer implements Runnable {
		
		private final BlockingQueue<Double> queue;

		public Consumer(final BlockingQueue<Double> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			try {
				System.out.println("taken by : " + Thread.currentThread().getName() + "  value is : " + queue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
