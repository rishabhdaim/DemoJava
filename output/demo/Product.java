package demo;

public class Product {

	private int i;
	private volatile boolean b;

	public int get() {
		synchronized (this) {

			while (!b) {
				try {
					wait();
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}

			b = false;
			notifyAll();
			return i;
		}
	}

	public void put(int i) {
		synchronized (this) {

			while (b) {
				try {
					wait();
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}

			b = true;
			this.i = i;
			notifyAll();
		}
	}
}
