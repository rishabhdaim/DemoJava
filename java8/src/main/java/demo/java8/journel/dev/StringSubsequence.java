/**
 * 
 */
package demo.java8.journel.dev;

/**
 * @author rishabh.daim
 * 
 */
public class StringSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "www.journaldev.com";
		System.out.println("Last 4 char String: "
				+ str.subSequence(str.length() - 4, str.length()));
		System.out.println("First 4 char String: " + str.subSequence(0, 4));
		System.out.println("website name: " + str.subSequence(4, 14));
		// substring v/s subSequence
		System.out.println("substring == subSequence ? "
				+ (str.substring(4, 14) == str.subSequence(4, 14)));
		System.out.println("substring equals subSequence ? "
				+ (str.substring(4, 14).equals(str.subSequence(4, 14))));
	}
}