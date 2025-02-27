package demo.java8.junit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class MethodInvocationReflection {

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			NoSuchMethodException, SecurityException, IllegalArgumentException,
			InvocationTargetException {
		Class<?> loadedClass = null;
		List<String> list = null;

		loadedClass = Class.forName("java.util.ArrayList");
		list = (List<String>) loadedClass.newInstance();

		// use interface on reflective instance..
		list.add("asd");
		list.add("bdjfsd");

		System.out.println(list);

		// getting method reflectively..

		Method method = loadedClass.getMethod("size", (Class[]) null);

		Method method2 = loadedClass.getMethod("add", Object.class);

		method2.invoke(list, "rishu");

		Object size = method.invoke(list, (Object[]) null);
		System.out.println(size);
		System.out.println(list);
	}

}
