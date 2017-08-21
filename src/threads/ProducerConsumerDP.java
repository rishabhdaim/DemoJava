/**
 * 
 */
package threads;

import java.util.Queue;
import java.util.Random;

import com.google.common.collect.Lists;

/**
 * @author Rishabh.Daim
 *
 */
public class ProducerConsumerDP {
	
	public static void main(String[] args) {
		System.out.println("Producer Consumer demo");
		final Queue<Integer> queue = Lists.newLinkedList();
		System.out.println("Creating producer");
		ProducerConsumerDP dp = new ProducerConsumerDP();
		Producer producer = dp.new Producer(queue, 10);
		System.out.println("Creating consumer");
		Consumer consumer = dp.new Consumer(queue);
		System.out.println("Running consumer");
		new Thread(consumer, "Consumer").start();
		System.out.println("Running producer");
		new Thread(producer, "Producer").start();
	}
	
	private class Producer implements Runnable {

		private final Queue<Integer> queue;
		private final int size;

		public Producer(Queue<Integer> queue, int size) {
			this.queue = queue;
			this.size = size;
		}

		@Override
		public void run() {
			while(true) {
				synchronized (queue) {
					while (queue.size() == size) {
						System.out.println("Waiting since queue is fill");
						try {
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
					Random  random = new Random(10);
					queue.add(random.nextInt());
					queue.notifyAll();
				}
			}
		}
		
	}
	
	private class Consumer implements Runnable {

		private final Queue<Integer> queue;

		public Consumer(Queue<Integer> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			while(true) {
				synchronized (queue) {
					while (queue.isEmpty()) {
						System.out.println("Queue is empty");
						try {
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
					Integer remove = queue.remove();
					System.out.println("fetched integer " + remove);
					queue.notifyAll();
				}
			}
		}
		
	}
}
