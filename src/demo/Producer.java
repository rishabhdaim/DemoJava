package demo;

public class Producer implements Runnable {

	private Product product;
	private int i;

	public Producer(Product product, int i) {
		super();
		this.product = product;
		this.i = i;
	}

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			product.put(i);
			System.err.println("putting " + this.i + " " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException ie) {
			}
		}
	}

}
