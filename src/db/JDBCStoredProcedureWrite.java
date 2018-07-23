/**
 * 
 */
package db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Scanner;

/**
 * @author rishabh.daim
 * 
 */
public class JDBCStoredProcedureWrite {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Connection con = DBConnection.getConnection(); CallableStatement stmt = con.prepareCall("{call insertEmp(?,?,?,?,?,?)}"); Scanner input = new Scanner(System.in);) {
			// Read User Inputs
			System.out.println("Enter Emp ID (int):");
			int id = Integer.parseInt(input.nextLine());
			System.out.println("Enter Emp Name:");
			String name = input.nextLine();
			System.out.println("Enter Emp Role:");
			String role = input.nextLine();
			System.out.println("Enter Emp City:");
			String city = input.nextLine();
			System.out.println("Enter Emp Country:");
			String country = input.nextLine();
			
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setString(3, role);
			stmt.setString(4, city);
			stmt.setString(5, country);
			// register the OUT parameter before calling the stored procedure
			stmt.registerOutParameter(6, java.sql.Types.VARCHAR);
			stmt.executeUpdate();
			// read the OUT parameter now
			String result = stmt.getString(6);
			System.out.println("Emp Record Save Success::" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}