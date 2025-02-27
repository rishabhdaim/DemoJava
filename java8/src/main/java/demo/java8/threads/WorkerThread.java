/**
 * 
 */
package demo.java8.threads;

import java.util.Date;

/**
 * @author rishabh.daim
 * 
 */
public class WorkerThread implements Runnable {

	private String command;

	public WorkerThread(String s) {
		this.command = s;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Start. Time = "
				+ new Date());
		processCommand();
		System.out.println(Thread.currentThread().getName() + " End. Time = "
				+ new Date());

	}

	private void processCommand() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return this.command;
	}
}
