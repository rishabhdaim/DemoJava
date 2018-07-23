/**
 * 
 */
package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author rishabh.daim
 * 
 */
public class PatternExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile(".xx.");
		Matcher matcher = pattern.matcher("MxxY");
		System.out.println("Input String matches regex - " + matcher.matches());
		// bad regular expression
		// pattern = Pattern.compile("*xx*");
		String str = "bbb";
		System.out
				.println("Using String matches method: " + str.matches(".bb"));
		System.out.println("Using Pattern matches method: "
				+ Pattern.matches(".bb", str));
		System.out.println(Pattern.matches("(\\w\\d)\\1", "a2a2")); // true
		System.out.println(Pattern.matches("(\\w\\d)\\1", "a2b2")); // false
		System.out.println(Pattern.matches("(AB)(B\\d)\\2\\1", "ABB2B2AB")); // true
		System.out.println(Pattern.matches("(AB)(B\\d)\\2\\1", "ABB2B3AB")); // false
		System.out.println(Pattern.matches("(AB)(B\\d)\\1\\2", "ABB2ABB2"));
	}

}
