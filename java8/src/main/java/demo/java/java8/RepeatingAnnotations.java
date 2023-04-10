/**
 * 
 */
package demo.java.java8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Rishabh.Daim
 *
 */
public class RepeatingAnnotations {

	/**
	 * @param args
	 */

	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Filters {
		Filter[] value();
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE)
	@Repeatable(Filters.class)
	public @interface Filter {
		String value();
	}

	@Filter("filter1")
	@Filter("filter2")
	@Filter("filter3")
	@Filter("filter4")
	public @interface Filterable {

	}

	public static void main(String[] args) {
		for (Filter filter : Filterable.class
				.getAnnotationsByType(Filter.class))
			System.out.println(filter.value());
	}
}
