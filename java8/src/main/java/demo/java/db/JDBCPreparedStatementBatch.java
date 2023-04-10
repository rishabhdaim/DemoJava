/**
 * 
 */
package demo.java.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author rishabh.daim
 * 
 */
public class JDBCPreparedStatementBatch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		String query = "insert into Employee (empId, name) values (?,?)";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			long start = System.currentTimeMillis();
			for (int i = 0; i < 10000; i++) {
				ps.setInt(1, i);
				ps.setString(2, "Name" + i);
				ps.addBatch();
				if (i % 1000 == 0)
					ps.executeBatch();
			}
			ps.executeBatch();
			System.out.println("Time Taken="
					+ (System.currentTimeMillis() - start));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}