/**
 * 
 */
package db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

/**
 * @author rishabh.daim
 * 
 */
public class JDBCStoredProcedureCursor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ResultSet rs = null;
		try (Connection con = DBConnection.getConnection(); CallableStatement stmt = con.prepareCall("{call getEmpByRole(?,?)}"); Scanner input = new Scanner(System.in);){
			// Read User Inputs
			System.out.println("Enter Emp Role:");
			String role = input.nextLine();
			stmt.setString(1, role);
			// register the OUT parameter before calling the stored procedure
			stmt.registerOutParameter(2, OracleTypes.CURSOR);
			stmt.execute();
			// read the OUT parameter now
			rs = (ResultSet) stmt.getObject(2);
			while (rs.next())
				System.out.println("Emp ID=" + rs.getInt("empId")
						+ ",Name=" + rs.getString("name") + ",Role=" + role
						+ ",City=" + rs.getString("city") + ",Country="
						+ rs.getString("country"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}