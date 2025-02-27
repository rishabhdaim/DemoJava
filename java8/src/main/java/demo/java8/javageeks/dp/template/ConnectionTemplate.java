/**
 * 
 */
package demo.java8.javageeks.dp.template;

import java.util.Date;

/**
 * @author Rishabh.Daim
 *
 */
public interface ConnectionTemplate {

	public default void run() {
		setDBDriver();
		logging("Drivers set [" + new Date() + "]");
		setCredentials();
		logging("Credentails set [" + new Date() + "]");
		connect();
		logging("Conencted");
		prepareStatement();
		logging("Statement prepared [" + new Date() + "]");
		setData();
		logging("Data set [" + new Date() + "]");
		insert();
		logging("Inserted [" + new Date() + "]");
		close();
		logging("Conenctions closed [" + new Date() + "]");
		destroy();
		logging("Object destoryed [" + new Date() + "]");
	}

	public default void logging(String msg) {
		if (disableLogging()) {
			System.out.println("Logging....: " + msg);
		}
	}

	public boolean disableLogging();

	default void destroy() {
		System.out.println("Destroying connection objects...");
	}

	default void close() {
		System.out.println("Closing connections...");
	}

	default void insert() {
		System.out.println("Inserting data...");
	}

	void setData();

	default void prepareStatement() {
		System.out.println("Preparing insert statement...");
	}

	public default void connect() {
		System.out.println("Setting connection...");
	}

	public void setCredentials();

	public void setDBDriver();

}
