package demo;

import java.util.concurrent.Semaphore;

public class Pool {

	/**
	 * @param args
	 */
	private static final int MAX_AVAILABLE = 100;
	private final static Semaphore available = new Semaphore(MAX_AVAILABLE,
			true);

	@SuppressWarnings("unused")
	private static Integer getItem() throws InterruptedException {
		available.acquire();
		return getNextAvailableItem();
	}

	@SuppressWarnings("unused")
	private static void putItem(Integer x) {
		if (markAsUnused(x))
			available.release();
	}

	// Not a particularly efficient data structure; just for demo
	private static Integer[] items;
	static {
		items = new Integer[MAX_AVAILABLE];
		for (int i = 0; i < MAX_AVAILABLE; i++)
			items[i] = i;
	}
	protected static boolean[] used = new boolean[MAX_AVAILABLE];

	protected synchronized static Integer getNextAvailableItem() {
		for (int i = 0; i < MAX_AVAILABLE; ++i) {
			if (!used[i]) {
				used[i] = true;
				return items[i];
			}
		}
		return null; // not reached
	}

	protected synchronized static boolean markAsUnused(Integer item) {
		for (int i = 0; i < MAX_AVAILABLE; ++i) {
			if (item == items[i]) {
				if (used[i]) {
					used[i] = false;
					return true;
				} else
					return false;
			}
		}
		return false;
	}

	public static void main(String[] args) {

	}
}
