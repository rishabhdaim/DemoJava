package demo.java.journel.dev;

import java.io.Console;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class SystemDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Console console = System.console();
		if (console != null) {
			Calendar c = new GregorianCalendar();
			console.printf("Welcome %1$s%n", "Pankaj");
			// prints "Welcome Pankaj"
			console.printf("Current time is: %1$tm %1$te,%1$tY%n", c);
			// prints "Current time is: 08 5,2013"
			console.flush();
		} else
			// No console is attached when run through Eclipse, background
			// process
			System.out.println("No Console attached");

		SecurityManager secManager = System.getSecurityManager();
		if (secManager == null)
			System.out.println("SecurityManager is not configured");
		SecurityManager mySecManager = new SecurityManager();
		System.setSecurityManager(mySecManager);
		secManager = System.getSecurityManager();
		if (secManager != null)
			System.out.println("SecurityManager is configured");
	}
}