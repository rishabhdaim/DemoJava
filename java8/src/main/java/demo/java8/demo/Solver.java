package demo.java8.demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Solver {
	final int N;
	final float[][] data;
	final CyclicBarrier barrier;

	class Worker implements Runnable {
		int myRow;

		Worker(int row) {
			myRow = row;
		}

		public void run() {
			while (!done()) {
				processRow(myRow);

				try {
					barrier.await();
				} catch (InterruptedException ex) {
					return;
				} catch (BrokenBarrierException ex) {
					return;
				}
			}
		}

		private void processRow(int myRow2) {
			// TODO Auto-generated method stub

		}

		private boolean done() {
			// TODO Auto-generated method stub
			return false;
		}
	}

	public Solver(float[][] matrix) {
		data = matrix;
		N = matrix.length;
		barrier = new CyclicBarrier(N, new Runnable() {
			public void run() {
				mergeRows();
			}

			private void mergeRows() {
				// TODO Auto-generated method stub

			}
		});
		for (int i = 0; i < N; ++i)
			new Thread(new Worker(i)).start();

		waitUntilDone();
	}

	private void waitUntilDone() {

	}
}