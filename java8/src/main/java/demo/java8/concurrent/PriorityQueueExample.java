/**
 * 
 */
package demo.java8.concurrent;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * @author rishabh.daim
 * 
 */
public class PriorityQueueExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// natural ordering example of priority queue
		Queue<Integer> integerPriorityQueue = new PriorityQueue<Integer>(7);
		Random rand = new Random();
		for (int i = 0; i < 10; i++)
			integerPriorityQueue.add(rand.nextInt(100));
		for (int i = 0; i < 10; i++)
			System.out.println("Processing Integer:"
					+ integerPriorityQueue.poll());
		// PriorityQueue example with Comparator
		Queue<Customer> customerPriorityQueue = new PriorityQueue<Customer>(7,
				idComparator);
		addDataToQueue(customerPriorityQueue);
		pollDataFromQueue(customerPriorityQueue);
	}

	// Comparator anonymous class implementation
	private static Comparator<Customer> idComparator = new Comparator<Customer>() {
		@Override
		public int compare(Customer c1, Customer c2) {
			return (int) (c1.getId() - c2.getId());
		}
	};

	// utility method to add random data to Queue
	private static void addDataToQueue(Queue<Customer> customerPriorityQueue) {
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			int id = rand.nextInt(100);
			customerPriorityQueue.add(new Customer(id, "rishu " + id));
		}
	}

	// utility method to poll data from queue
	private static void pollDataFromQueue(Queue<Customer> customerPriorityQueue) {
		while (true) {
			Customer cust = customerPriorityQueue.poll();
			if (cust == null)
				break;
			System.out.println("Processing Customer with ID=" + cust.getId());
		}
	}
}