/**
 * 
 */
package java8;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Rishabh.Daim
 *
 */
public class Streams {

	private enum Status {
		OPEN, CLOSED
	}

	private static class Task {
		private final Status status;
		private final int points;

		/**
		 * @param status
		 * @param points
		 */
		public Task(Status status, int points) {
			super();
			this.status = status;
			this.points = points;
		}

		/**
		 * @return the status
		 */
		public Status getStatus() {
			return status;
		}

		/**
		 * @return the points
		 */
		public int getPoints() {
			return points;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Task [status=" + status + ", points=" + points + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		Collection<Task> tasks = Arrays.asList(new Task(Status.OPEN, 1),
				new Task(Status.OPEN, 13), new Task(Status.CLOSED, 3),
				new Task(Status.OPEN, 11), new Task(Status.CLOSED, 13),
				new Task(Status.OPEN, 131));

		// Calculate total points of all active tasks using sum()
		long totalOpenPoints = tasks.stream()
				.filter(task -> task.getStatus() == Status.OPEN)
				.mapToInt(Task::getPoints).sum();

		System.out.println("Total open points: " + totalOpenPoints);

		// Calculate total points of all tasks

		long totalPoints = tasks.stream().parallel().map(e -> e.getPoints()) // map
				// (Task::getPoints)
				.reduce(0, Integer::sum);

		System.out.println("total points : " + totalPoints);

		// Group tasks by their status

		Map<Status, List<Task>> map = tasks.stream().collect(
				Collectors.groupingBy(Task::getStatus));

		System.out.println(map);

		// Calculate the weight of each tasks (as percent of total points)

		Collection<String> result = tasks.stream().mapToInt(Task::getPoints)
				.asLongStream().mapToDouble(points -> points / totalPoints)
				.boxed().mapToLong(weight -> (long) (weight * 100))
				.mapToObj(percentage -> percentage + "%")
				.collect(Collectors.toList());

		System.out.println(result);

		Path path = new File("com.ctli.logger.log.0").toPath();
		try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
			lines.onClose(() -> System.out.println("done !!!!")).forEach(
					System.out::println);
		}
	}
}