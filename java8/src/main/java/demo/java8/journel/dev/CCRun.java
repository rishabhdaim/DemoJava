package demo.java8.journel.dev;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CCRun {

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	public static void main(String[] args) throws ClassNotFoundException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		String progClass = args[0];
		String progArgs[] = new String[args.length - 1];
		System.arraycopy(args, 1, progArgs, 0, progArgs.length);
		CCLoader ccl = new CCLoader(CCRun.class.getClassLoader());
		Class<?> clas = ccl.loadClass(progClass);
		Class<?> mainArgType[] = { (new String[0]).getClass() };
		Method main = clas.getMethod("main", mainArgType);
		Object argsArray[] = { progArgs };
		main.invoke(null, argsArray);
		// Below method is used to check that the Foo is getting loaded
		// by our custom class loader i.e CCLoader
		Method printCL = clas.getMethod("printCL", (Class<?>[]) null);
		printCL.invoke(null, new Object[0]);
	}
}