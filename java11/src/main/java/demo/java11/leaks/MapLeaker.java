package demo.java11.leaks;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MapLeaker {

	public ExecutorService executorService = Executors.newFixedThreadPool(10);
	private Random random = new Random();
	private Map<Task, TaskStatus> map = Collections.synchronizedMap(new HashMap<>());

	private enum TaskStatus {
		NOT_STARTED, STARTED, FINISHED
	}

	private class Task implements Runnable {

		private int[] numbers = new int[random.nextInt(2200)];

		@Override
		public void run() {
			int[] temp = new int[random.nextInt(10000)];
			map.put(this, TaskStatus.STARTED);
			System.out.println(temp.length);
			map.put(this, TaskStatus.FINISHED);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Task [numbers= " + numbers.length + "]";
		}
	}

	private Task newTask() {
		Task task = new Task();
		map.put(task, TaskStatus.NOT_STARTED);
		executorService.execute(task);
		return task;
	}

	public static void main(String[] args) {
		MapLeaker leaker = new MapLeaker();
		System.out.println(leaker.newTask());
	}
}
