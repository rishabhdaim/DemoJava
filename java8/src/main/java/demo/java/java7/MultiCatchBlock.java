package demo.java.java7;

import java.util.Scanner;

public class MultiCatchBlock {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String number = scanner.next();

		try {
			if (number.length() > 8)
				throw new IllegalArgumentException(
						"number greater than 8 characters..");
			Integer.parseInt(number);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}