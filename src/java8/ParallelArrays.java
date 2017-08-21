/**
 * 
 */
package java8;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Rishabh.Daim
 *
 */
public class ParallelArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(Runtime.getRuntime().maxMemory());
		long[] ls = new long[1 << 20];
		Arrays.parallelSetAll(ls,
				i -> ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE));

		Arrays.stream(ls).limit(20).forEach(i -> System.out.print(i + " "));

		System.out.println();
		Arrays.parallelSort(ls);

		Arrays.stream(ls).limit(20).forEach(i -> System.out.print(i + " "));
	}
}