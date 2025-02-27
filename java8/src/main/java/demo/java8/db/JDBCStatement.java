/**
 * 
 */
package demo.java8.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author rishabh.daim
 * 
 */
public class JDBCStatement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String query = null;
		try (Connection con = DBConnection.getConnection(); Statement stmt = con.createStatement();) {
			long start = System.currentTimeMillis();
			for (int i = 0; i < 10000; i++) {
				query = "insert into Employee values (" + i + ",'Name"
						+ i + "')";
				stmt.execute(query);
			}
			System.out.println("Time Taken="
					+ (System.currentTimeMillis() - start));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}