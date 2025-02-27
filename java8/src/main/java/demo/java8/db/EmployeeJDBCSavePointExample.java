/**
 * 
 */
package demo.java8.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

/**
 * @author Rishabh.Daim
 *
 */
public class EmployeeJDBCSavePointExample {
	private static final String INSERT_LOGS_QUERY = "insert into logs l (l.msg) values (?)";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection con = null;
		Savepoint savepoint = null;
		try {
			con = DBConnection.getConnection();
			// set auto commit to false
			con.setAutoCommit(false);
			EmployeeJDBCInsertExample.insertEmployeeData(con, 8, "Pankaj");
			EmployeeJDBCInsertExample.insertAddressData(con, 2, "Delhi", "India", "bhadosn street");
			// if code reached here, means main work is done successfully
			savepoint = con.setSavepoint("EmployeeSavePoint");
			insertLogData(con, 2);
			// now commit transaction
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				if (savepoint == null) {
					// SQLException occurred in saving into Employee or Address
					// tables
					con.rollback();
					System.out.println("JDBC Transaction rolled back successfully");
				} else {
					// exception occurred in inserting into Logs table
					// we can ignore it by rollback to the savepoint
					con.rollback(savepoint);
					// lets commit now
					con.commit();
				}
			} catch (SQLException e1) {
				System.out.println("SQLException in rollback" + e.getMessage());
			}
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void insertLogData(Connection con, int i)
			throws SQLException {
		PreparedStatement stmt = con.prepareStatement(INSERT_LOGS_QUERY);
		// message is very long, will throw SQLException
		stmt.setString(1, "Employee information saved successfully for ID " + i);
		stmt.executeUpdate();
		System.out.println("Logs Data inserted successfully for ID=" + i);
		stmt.close();
	}
}