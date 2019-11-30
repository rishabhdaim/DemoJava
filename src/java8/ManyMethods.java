/**
 * 
 */
package java8;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author Rishabh.Daim
 *
 */
public class ManyMethods {
	public ManyMethods() {
	}

	@SuppressWarnings("unused")
	private void addArrayOfStrings(String[] strings) {
	}

	@SuppressWarnings("unused")
	private void addManyStrings(final String... strings) {
	}

	@SuppressWarnings("unused")
	private void addListOfStrings(final List<String> strings) {
	}

	@Override
	public String toString() {
		return "ManyMethods";
	}

	public static void main(String[] args) {
		List<String> list = Lists.newArrayList("Daim", "Rishabh", "kumar");

		list.removeIf(v -> Character.isLowerCase(v.charAt(0)));

		System.out.println(list);
	}
}