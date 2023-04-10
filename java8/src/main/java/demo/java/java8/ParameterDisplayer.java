/**
 * 
 */
package demo.java.java8;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * @author Rishabh.Daim
 *
 */
public class ParameterDisplayer {

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 */

	private static void displayParametersMetadata(String[] classesNames)
			throws ClassNotFoundException {
		for (String className : classesNames) {
			Class<?> clazz = Class.forName(className);
			// Get all class's declared methods (does not get inherited methods)
			Method[] methods = clazz.getDeclaredMethods();

			for (Method method : methods) {
				writeClass("Method " + method.toGenericString() + " has "
						+ method.getParameterCount() + " parameters.");
				int pc = 0;
				Parameter[] parameters = method.getParameters();
				for (Parameter parameter : parameters) {
					System.out.println("\targ"
							+ pc++
							+ ": "
							+ (parameter.isNamePresent() ? parameter.getName()
									: "Parameter Name not provided,")
							+ (isParameterFinal(parameter) ? " IS "
									: " is NOT ") + "final, type "
							+ parameter.getType().getCanonicalName()
							+ ", and parameterized type of "
							+ parameter.getParameterizedType() + " and "
							+ (parameter.isVarArgs() ? "IS " : "is NOT ")
							+ "variable.");
				}
			}
		}
	}

	private static boolean isParameterFinal(Parameter parameter) {
		return Modifier.isFinal(parameter.getModifiers());
	}

	private static void writeClass(String headerText) {
		System.out.println("======================================");
		System.out.println("= " + headerText);
		System.out.println("======================================");
	}

	public static void main(String[] args) throws ClassNotFoundException {
		displayParametersMetadata(args);
	}

}
