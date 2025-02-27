/**
 * 
 */
package demo.java8.java8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Rishabh.Daim
 *
 */
public class Annotations {

	@Target({ ElementType.TYPE_USE, ElementType.TYPE_PARAMETER })
	@Retention(RetentionPolicy.RUNTIME)
	public @interface NonEmpty {
	}

	public static class Holder<@NonEmpty T> extends @NonEmpty Object {
		public void method() throws @NonEmpty Exception {
		}
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Holder<String> holder = new @NonEmpty Holder<String>();
		@SuppressWarnings("unused")
		@NonEmpty
		Collection<@NonEmpty String> strings = new @NonEmpty ArrayList<String>();
	}
}
