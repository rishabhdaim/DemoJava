/**
 * 
 */
package demo.java.java8;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author Rishabh.Daim
 *
 */
public class ParameterNames {

	/**
	 * @param args
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	public static void main(String[] args) throws NoSuchMethodException,
			SecurityException {
		Method method = ParameterNames.class.getMethod("main", String[].class);
		for (Parameter parameter : method.getParameters())
			System.out.println("parameter : " + parameter.getName());
	}
}