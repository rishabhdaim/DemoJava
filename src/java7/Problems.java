package java7;

import java.util.HashSet;

public class Problems {

	/**
	 * @param args
	 */
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abc";
		System.out.println("s1 == s2 is:" + s1 == s2);

		System.out.println();

		String s3 = "JournalDev";
		int start = 1;
		char end = 5;
		System.out.println(start + end);
		System.out.println(s3.substring(start, end));

		System.out.println();

		HashSet<Short> shortSet = new HashSet<Short>();
		for (short i = 0; i < 100; i++) {
			shortSet.add(i);
			shortSet.remove(i - 1);
		}
		System.out.println(shortSet.size());
		System.out.println();

		// String str = null;
		// String str1 = "abc";
		// System.out.println(str1.equals("abc") | str.equals(null));

		main2(null);

		System.out.println();

		long longWithL = 1000 * 60 * 60 * 24 * 365L;
		long longWithoutL = 1000 * 60 * 60 * 24 * 365;
		System.out.println(longWithL);
		System.out.println(longWithoutL);
	}

	@SuppressWarnings("unused")
	private static void main2(Object object) {
		System.out.println("object");
	}

	private static void main2(String object) {
		System.out.println("string");
	}

	/*
	 * public static void main2(StringBuffer i) {
	 * System.out.println("StringBuffer impl"); }
	 */
}