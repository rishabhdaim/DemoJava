package demo.java8.threads;

public class Counter {

	private long counter;

	public long incrementCounter() {
		return counter++;
	}

	public Long getCount() {
		return counter;
	}

}
