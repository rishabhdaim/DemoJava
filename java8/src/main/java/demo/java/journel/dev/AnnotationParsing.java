package demo.java.journel.dev;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationParsing {

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws SecurityException
	 */
	public static void main(String[] args) throws SecurityException,
			ClassNotFoundException {
		for (Method method : AnnotationParsing.class.getClassLoader()
				.loadClass("journel.dev.AnnotationExample").getDeclaredMethods()) {
			// checks if MethodInfo journel.dev is present for the method
			if (method.isAnnotationPresent(MethodInfo.class)) {
				for (Annotation annotation : method.getDeclaredAnnotations())
					System.out.println("Annotation in Method '" + method
							+ "' : " + annotation);
				MethodInfo methodAnno = method.getAnnotation(MethodInfo.class);
				if (methodAnno.revision() == 1)
					System.out.println("Method with revision no 1 = " + method);
			}
		}
	}
}