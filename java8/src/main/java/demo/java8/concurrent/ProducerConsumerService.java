/**
 * 
 */
package demo.java8.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author rishabh.daim
 * 
 */
public class ProducerConsumerService {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Creating BlockingQueue of size 10
		BlockingQueue<Message> queue = new ArrayBlockingQueue<Message>(10);
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);
		// starting producer to produce messages in queue
		new Thread(producer).start();
		// starting consumer to consume messages from queue
		new Thread(consumer).start();
		System.out.println("Producer and Consumer has been started");
	}
}