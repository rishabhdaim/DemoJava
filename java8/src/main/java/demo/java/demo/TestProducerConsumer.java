package demo.java.demo;

public class TestProducerConsumer {

	public static void main(String[] args) throws InterruptedException {
		Product product = new Product();

		Thread consumer = new Thread(new Consumer(product, 10));

		Thread producer = new Thread(new Producer(product, 10));

		producer.start();
		consumer.start();

	}
}