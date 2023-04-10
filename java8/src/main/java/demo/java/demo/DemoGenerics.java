package demo.java.demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DemoGenerics {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		Set set = new HashSet<String>(Arrays.asList("asd", "df"));
		System.err.println(set);
		set = new HashSet<Integer>(Arrays.asList(1, 45, 65, 6, 7));
		System.out.println(set);
	}

}
