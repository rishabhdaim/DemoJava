package journel.dev;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class AnnotationExample {

	@Override
	@MethodInfo(comments = "overriding toString()", date = "Apr 23 14", revision = 2)
	public String toString() {
		System.out.println("overriding toString()");
		return super.toString();
	}

	@Deprecated
	@MethodInfo(comments = "deprecated method", date = "Nov 17 2012")
	public static void oldMethod() {
		System.out.println("old method, don't use it.");
	}

	@SuppressWarnings({ "unchecked" })
	@MethodInfo(author = "Pankaj", comments = "genericsTest()", date = "Nov 17 2012", revision = 10)
	private static void genericsTest() throws FileNotFoundException {
		@SuppressWarnings("rawtypes")
		List l = new ArrayList();
		l.add("abc");
		oldMethod();
	}
}