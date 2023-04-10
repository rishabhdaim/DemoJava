/**
 * 
 */
package demo.java.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author rishabh.daim
 * 
 */
public class JDBCPreparedStatementDynamic {
	public static void printData(int[] ids) {
		String query = createQuery(ids.length);
		System.out.println("Query=" + query);
		ResultSet rs = null;
		try (Connection con = DBConnection.getConnection();PreparedStatement ps = con.prepareStatement(query);) {
			for (int i = 1; i <= ids.length; i++) 
				ps.setInt(i, ids[i - 1]);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("Employee ID=" + rs.getInt("id")
						+ ", Name=" + rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static String createQuery(int length) {
		String query = "select * from Employee where id in (";
		StringBuilder queryBuilder = new StringBuilder(query);
		for (int i = 0; i < length; i++) {
			queryBuilder.append(" ?");
			if (i != length - 1)
				queryBuilder.append(",");
		}
		queryBuilder.append(")");
		return queryBuilder.toString();
	}
}