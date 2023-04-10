package demo.java.journel.dev;

import java.util.ArrayList;
import java.util.List;

public class GenericsWildcards {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> ints = new ArrayList<Integer>();
		ints.add(3);
		ints.add(5);
		ints.add(10);
		double sum = sum(ints);
		System.out.println("Sum of ints=" + sum);
	}

	private static double sum(List<? extends Number> list) {
		double sum = 0;
		for (Number n : list)
			sum += n.doubleValue();
		return sum;
	}

	public static void printData(List<?> list) {
		for (Object obj : list) {
			System.out.print(obj + "::");
		}
	}
}