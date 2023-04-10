package demo.java.threads;

public class Singleton {

	private Singleton() {
	}

	public static final Singleton SINGLETON = new Singleton();

	private static final Singleton SINGLETON2 = new Singleton();

	public static Singleton getSingleton() {
		return SINGLETON2;
	}

	private enum EnumSingleton {
		INSTANCE
	}

	public static void main(String[] args) {
		Singleton singleton = Singleton.SINGLETON;
		System.out.println(singleton);

		singleton = Singleton.SINGLETON;
		System.out.println(singleton);
		singleton = Singleton.SINGLETON;
		System.out.println(singleton);
		singleton = Singleton.SINGLETON;
		System.out.println(singleton);

		singleton = Singleton.getSingleton();
		System.out.println(singleton);
		singleton = Singleton.getSingleton();
		System.out.println(singleton);
		singleton = Singleton.getSingleton();
		System.out.println(singleton);

		EnumSingleton enumSingleton = Singleton.EnumSingleton.INSTANCE;
		System.out.println(enumSingleton.toString());

	}

}
