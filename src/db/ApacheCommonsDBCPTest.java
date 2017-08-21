/**
 * 
 */
package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

/**
 * @author Rishabh.Daim
 *
 */
public class ApacheCommonsDBCPTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// testDBCPDataSource("mysql");
		System.out.println("**********");
		testDBCPDataSource("oracle");
	}

	private static void testDBCPDataSource(String dbType) {
		DataSource ds = DBCPDataSourceFactory.getDataSource(dbType);
		try (Connection con = ds.getConnection(); Statement stmt = con.createStatement();) {
			ResultSet rs = null;
			rs = stmt.executeQuery("select * from Emp");
			while (rs.next())
				System.out.println("Employee ID=" + rs.getInt("empid") + ", Name=" + rs.getString("name"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
