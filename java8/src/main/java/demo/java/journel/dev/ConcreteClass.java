package demo.java.journel.dev;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rishabh.daim
 * 
 */
@Deprecated
public class ConcreteClass extends BaseClass implements BaseInterface {
	public int publicInt;
	@SuppressWarnings("unused")
	private String privateString = "private string";
	protected boolean protectedBoolean;
	Object defaultObject;

	public ConcreteClass(int i) {
		this.publicInt = i;
	}

	@Override
	public void method1() {
		System.out.println("Method1 impl.");
	}

	@Override
	public int method2(String str) {
		System.out.println("Method2 impl.");
		return 0;
	}

	@Override
	public int method4() {
		System.out.println("Method4 overriden.");
		return 0;
	}

	public int method5(int i) {
		System.out.println("Method4 overriden.");
		return 0;
	}

	// inner classes
	public class ConcreteClassPublicClass {
	}

	@SuppressWarnings("unused")
	private class ConcreteClassPrivateClass {
	}

	protected class ConcreteClassProtectedClass {
	}

	class ConcreteClassDefaultClass {
	}

	// member enum
	enum ConcreteClassDefaultEnum {
	}

	public enum ConcreteClassPublicEnum {
	}

	// member interface
	public interface ConcreteClassPublicInterface {
	}

	public static void main(String[] args) throws ClassNotFoundException,
			NoSuchFieldException, SecurityException, IllegalArgumentException,
			IllegalAccessException, NoSuchMethodException,
			InvocationTargetException, InstantiationException {
		// Get Class using reflection
		Class<?> concreteClass = ConcreteClass.class;
		concreteClass = new ConcreteClass(5).getClass();
		// below method is used most of the times in frameworks like JUnit
		// //Spring dependency injection, Tomcat web container //Eclipse auto
		// completion of method names, hibernate, Struts2 etc. //because
		// ConcreteClass is not available at compile time
		concreteClass = Class.forName("journel.dev.ConcreteClass");
		System.out.println(concreteClass.getCanonicalName()); // prints
																// com.journaldev.reflection.ConcreteClass

		// for primitive types, wrapper classes and arrays
		Class<?> booleanClass = boolean.class;
		System.out.println(booleanClass.getCanonicalName()); // prints boolean

		Class<?> cDouble = Double.TYPE;
		System.out.println(cDouble.getCanonicalName());
		// prints double
		Class<?> cDoubleArray = Class.forName("[D");
		System.out.println(cDoubleArray.getCanonicalName()); // prints double[]

		Class<?> twoDStringArray = String[][].class;
		System.out.println(twoDStringArray.getCanonicalName()); // prints
																// java.lang.String[][]

		Class<?> superClass = Class.forName("journel.dev.ConcreteClass")
				.getSuperclass();
		// prints "class com.journaldev.reflection.BaseClass"
		System.out.println(superClass);
		System.out.println(Object.class.getSuperclass());
		// prints"null"
		System.out.println(String[][].class.getSuperclass());//
		// prints "class java.lang.Object"

		Class<?>[] classes = concreteClass.getClasses();
		// [class
		// com.journaldev.reflection.ConcreteClass$ConcreteClassPublicClass,
		// //class
		// com.journaldev.reflection.ConcreteClass$ConcreteClassPublicEnum,
		// //interface
		// com.journaldev.reflection.ConcreteClass$ConcreteClassPublicInterface,//class
		// com.journaldev.reflection.BaseClass$BaseClassInnerClass,
		// //class
		// com.journaldev.reflection.BaseClass$BaseClassMemberEnum]
		System.out.println(Arrays.toString(classes));

		// getting all of the classes, interfaces, and enums that are explicitly
		// declared in ConcreteClass
		Class<?>[] explicitClasses = Class.forName("journel.dev.ConcreteClass")
				.getDeclaredClasses();
		// prints [class
		// com.journaldev.reflection.ConcreteClass$ConcreteClassDefaultClass,
		// //class
		// com.journaldev.reflection.ConcreteClass$ConcreteClassDefaultEnum,
		// //class
		// com.journaldev.reflection.ConcreteClass$ConcreteClassPrivateClass,
		// //class
		// com.journaldev.reflection.ConcreteClass$ConcreteClassProtectedClass,
		// //class
		// com.journaldev.reflection.ConcreteClass$ConcreteClassPublicClass,
		// //class
		// com.journaldev.reflection.ConcreteClass$ConcreteClassPublicEnum,
		// //interface
		// com.journaldev.reflection.ConcreteClass$ConcreteClassPublicInterface]
		System.out.println(Arrays.toString(explicitClasses));

		Class<?> innerClass = Class
				.forName("journel.dev.ConcreteClass$ConcreteClassDefaultClass");
		// prints com.journaldev.reflection.ConcreteClass
		System.out.println(innerClass.getDeclaringClass().getCanonicalName());
		System.out.println(innerClass.getEnclosingClass().getCanonicalName());

		// prints "com.journaldev.reflection"
		System.out.println(Class.forName("journel.dev.BaseInterface")
				.getPackage().getName());

		System.out.println(Modifier.toString(concreteClass.getModifiers()));
		// prints "public"
		// prints "public abstract interface"
		System.out.println(Modifier.toString(Class.forName(
				"journel.dev.BaseInterface").getModifiers()));

		// Get Type parameters (generics)
		TypeVariable<?>[] typeParameters = Class.forName("java.util.HashMap")
				.getTypeParameters();
		for (TypeVariable<?> t : typeParameters)
			System.out.print(t.getName() + ",");

		System.out.println();
		Type[] interfaces = Class.forName("java.util.HashMap")
				.getGenericInterfaces();
		// prints "1"
		System.out.println(Arrays.toString(interfaces));
		// prints
		// "[interface java.util.Map, interface java.lang.Cloneable, interface java.io.Serializable]"
		System.out.println(Arrays.toString(Class.forName("java.util.HashMap")
				.getInterfaces()));

		Method[] publicMethods = Class.forName("journel.dev.ConcreteClass")
				.getMethods();
		// prints public methods of ConcreteClass, BaseClass, Object
		System.out.println(Arrays.toString(publicMethods));

		// Get All public constructors
		Constructor<?>[] publicConstructors = Class.forName(
				"journel.dev.ConcreteClass").getConstructors();
		// prints public constructors of ConcreteClass
		System.out.println(Arrays.toString(publicConstructors));

		// Get All public fields
		Field[] publicFields = Class.forName("journel.dev.ConcreteClass")
				.getFields();
		// prints public fields of ConcreteClass, it's superclass and super
		// interfaces
		System.out.println(Arrays.toString(publicFields));

		// to get specific field..
		Annotation[] annotations = Class.forName("journel.dev.ConcreteClass")
				.getAnnotations();
		// prints [@java.lang.Deprecated()]
		System.out.println(Arrays.toString(annotations));

		Field field = Class.forName("journel.dev.ConcreteClass").getField(
				"interfaceInt");
		System.out.println(field);
		Class<?> fieldClass = field.getDeclaringClass();
		// prints com.journaldev.reflection.BaseInterface
		System.out.println(fieldClass.getCanonicalName());

		field = Class.forName("journel.dev.ConcreteClass").getField("publicInt");
		Class<?> fieldType = field.getType();
		// prints int
		System.out.println(fieldType.getCanonicalName());

		ConcreteClass obj = new ConcreteClass(5);
		System.out.println(field.get(obj));
		// prints 5
		field.setInt(obj, 10);
		// setting field value to 10 in object
		// prints 10
		System.out.println(field.get(obj));

		Field privateField = Class.forName("journel.dev.ConcreteClass")
				.getDeclaredField("privateString");
		// turning off access check with below method call
		privateField.setAccessible(true);
		ConcreteClass objTest = new ConcreteClass(1);
		System.out.println(privateField.get(objTest)); // prints
														// "private string"
		privateField.set(objTest, "private string updated");
		System.out.println(privateField.get(objTest)); // prints
														// "private string updated"

		Method method = Class.forName("java.util.HashMap").getMethod("put",
				Object.class, Object.class);
		// get method parameter types, prints
		// "[class java.lang.Object, class java.lang.Object]"
		System.out.println(Arrays.toString(method.getParameterTypes()));
		// get method return type, return "class java.lang.Object", class
		// reference for void
		System.out.println(method.getReturnType());
		// get method modifiers
		System.out.println(Modifier.toString(method.getModifiers())); // prints
																		// "public"

		Map<String, String> hm = new HashMap<String, String>();
		method.invoke(hm, "key", "value");
		System.out.println(hm); // prints {key=value}

		// invoking private method
		method = Class.forName("journel.dev.BaseClass").getDeclaredMethod(
				"method3", (Class<?>[]) null);
		method.setAccessible(true);
		method.invoke(null, (Object[]) null); // prints "Method3"

		Constructor<?> constructor = Class.forName("journel.dev.ConcreteClass")
				.getConstructor(int.class);
		// getting constructor parameters
		System.out.println(Arrays.toString(constructor.getParameterTypes())); // prints
																				// "[int]"

		// invoking constructor..

		Object myObj = constructor.newInstance(10);
		Method myObjMethod = myObj.getClass().getMethod("method1",
				(Class<?>[]) null);
		myObjMethod.invoke(myObj, (Object[]) null); // prints "Method1 impl."
		Constructor<?> hashMapConstructor = Class.forName("java.util.HashMap")
				.getConstructor((Class<?>[]) null);
		System.out.println(Arrays.toString(hashMapConstructor
				.getParameterTypes())); // prints "[]"
	}
}