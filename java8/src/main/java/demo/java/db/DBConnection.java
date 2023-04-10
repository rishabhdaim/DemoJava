/**
 * 
 */
package demo.java.db;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author rishabh.daim
 * 
 */
public class DBConnection {

	private DBConnection() {
	}

	public static Connection getConnection() {
		return getNewConnection();
	}

	private static Connection getNewConnection() {
		Properties props = new Properties();
		FileInputStream fis = null;
		Connection con = null;
		try {
			fis = new FileInputStream("DB.properties");
			props.load(fis);
			// load the Driver Class
			Class.forName(props.getProperty("DB_DRIVER_CLASS"));
			// create the connection now
			con = DriverManager.getConnection(props.getProperty("DB_URL"),
					props.getProperty("DB_USERNAME"),
					props.getProperty("DB_PASSWORD"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}