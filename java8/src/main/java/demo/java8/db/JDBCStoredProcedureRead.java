/**
 * 
 */
package demo.java8.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Scanner;

/**
 * @author rishabh.daim
 * 
 */
public class JDBCStoredProcedureRead {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Connection con = DBConnection.getConnection(); CallableStatement stmt = con.prepareCall("{call getEmp(?,?,?,?,?)}"); Scanner input = new Scanner(System.in);) {

			// Read User Inputs
			System.out.println("Enter Emp ID (int):");
			int id = Integer.parseInt(input.nextLine());
			stmt.setInt(1, id);
			// register the OUT parameter before calling the stored procedure
			stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(5, java.sql.Types.VARCHAR);
			stmt.execute();
			// read the OUT parameter now
			String name = stmt.getString(2);
			String role = stmt.getString(3);
			String city = stmt.getString(4);
			String country = stmt.getString(5);
			if (name != null)
				System.out.println("Emp Name=" + name + ",Role=" + role
						+ ",City=" + city + ",Country=" + country);
			else
				System.out.println("Emp Not Found with ID" + id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}