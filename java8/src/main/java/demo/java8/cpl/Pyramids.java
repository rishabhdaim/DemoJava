package demo.java8.cpl;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Pyramids {

	private static List<String> pyramid = null;
	private static final LinkedList<Boolean> stackList = new LinkedList<Boolean>();// new
																					// ArrayList<String>();
	private static final String H = "H";
	private static final String L = "L";
	private static boolean solutionFound = false;

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.println("Please enter number of cubes..");
		String number = in.next();
		while (!number.equalsIgnoreCase("exit")) {
			int noOfCubes = 0;
			int n = 0;
			try {
				noOfCubes = Integer.parseInt(number);
				n = (int) Math.sqrt(noOfCubes);
				System.out.println(n);
				for (; noOfCubes > 5 && n > 1; n--) {
					checkNumber(n, noOfCubes);
					if (solutionFound)
						System.out.println(pyramid);
					else
						System.err.println("Impossible");
				}
			} catch (NumberFormatException nfe) {
				System.err
						.println("invalid input. Please enter valid number..");
			}
			System.out.println();
			System.out.println("Enter no. to continue or \"exit\" to end..");
			number = in.next();
		}

	}

	/**
	 * @param n
	 * @param noOfCubes
	 */
	private static void checkNumber(int n, int noOfCubes) {
		int k, l;
		l = n;
		if (n >= 6) {

			k = (n * (n + 1) * (n * 2 + 1)) / 6;
			if (k <= noOfCubes)
				checkSolution(k, noOfCubes, H, l);
			System.out.println(n);

		} else {
			stackList.addFirst(false);
			int i = n / 2;
			int sumOfSquares = (n * (n + 1) * (n * 2 + 1)) / 6;
			if (i == 0) {
				n = n + 1;
				k = evenSquare(n);
			} else
				k = oddSquare(n);

			if (sumOfSquares > k)
				checkSolution(sumOfSquares, noOfCubes, H, l);
			else
				checkSolution(k, noOfCubes, L, l);

		}
	}

	/**
	 * @param n
	 * @param noOfCubes
	 * @param typeOfPyramid
	 * @param l
	 */
	private static void checkSolution(int n, int noOfCubes,
			String typeOfPyramid, int l) {
		noOfCubes = noOfCubes - n;
		if (noOfCubes == 0) {
			solutionFound = true;
			return;
		} else if (noOfCubes < 5)
			return;
		else
			checkNumber(--l, noOfCubes);
	}

	/**
	 * @param n
	 * @return
	 */
	private static int evenSquare(int n) {
		int k = 0;
		for (int j = 1; j <= n; j++) {
			k = k + j ^ 2;
			j++;
		}
		return n;
	}

	/**
	 * @param n
	 * @return
	 */
	private static int oddSquare(int n) {
		int k = 0;
		for (int j = 2; j <= n; j++) {
			k = k + j ^ 2;
			j++;
		}
		return k;
	}
}