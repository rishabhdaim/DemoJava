package demo;

public class Consumer implements Runnable {
	private Product product;
	private int i;

	public Consumer(Product product, int i) {
		super();
		this.product = product;
		this.i = i;
	}

	@Override
	public void run() {
		int value = 0;
		for (int i = 0; i < 10; i++) {
			value = product.get();
			System.out.println("Getting " + this.i + " " + value);
		}
	}

}
