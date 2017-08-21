/**
 * 
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Rishabh.Daim
 *
 */
public class JDBCPreparedStatementSingle {
	
	private static final String QUERY = "select * from Employee where id = ?";

	public static void printData(int[] ids) {
		ResultSet rs = null;
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(QUERY);) {
			for (int empid : ids) {
				ps.setInt(1, empid);
				rs = ps.executeQuery();
				while (rs.next())
					System.out.println("Employee ID=" + rs.getInt("id") + ", Name=" + rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}