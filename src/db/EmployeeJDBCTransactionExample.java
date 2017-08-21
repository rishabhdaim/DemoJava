/**
 * 
 */
package db;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author aa49442
 * 
 */
public class EmployeeJDBCTransactionExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection con = null;
		try {
			con = DBConnection.getConnection();
			// set auto commit to false
			con.setAutoCommit(false);
			EmployeeJDBCInsertExample.insertEmployeeData(con, 7, "Pankaj");
			EmployeeJDBCInsertExample.insertAddressData(con, 1, "Delhi", "India", "bhadosn street");
			// now commit transaction
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
				System.out.println("JDBC Transaction rolled back successfully");
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

}
