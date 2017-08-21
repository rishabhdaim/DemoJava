/**
 * 
 */
package java8;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author Rishabh.Daim
 *
 */
public class Base64s {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String text = "My name is rishabh daim !!!";
		final String encoded = Base64.getEncoder().encodeToString(
				text.getBytes(StandardCharsets.UTF_8));
		System.out.println("encoded string : " + encoded);

		final String decoded = new String(Base64.getDecoder().decode(encoded),
				StandardCharsets.UTF_8);
		System.out.println(decoded);
	}
}