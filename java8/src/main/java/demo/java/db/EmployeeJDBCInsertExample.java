/**
 * 
 */
package demo.java.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Rishabh.Daim
 *
 */
public class EmployeeJDBCInsertExample {
	
	private static final String INSERT_EMPLOYEE_QUERY = "insert into Emp (empId, name) values (?,?)";
	private static final String INSERT_ADDRESS_QUERY = "insert into EmpAddress (empId, city, country, address) values (?,?,?,?)";

	public static void main(String[] args) {
		try (Connection con = DBConnection.getConnection();) {
			insertEmployeeData(con, 6, "umesh");
			insertAddressData(con, 4, "New Delhi", "India", "bhadosn street");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertAddressData(Connection con, int id, String city, String country, String address) throws SQLException {
		PreparedStatement stmt = con.prepareStatement(INSERT_ADDRESS_QUERY);
		stmt.setInt(1, id);
		stmt.setString(2, city);
		stmt.setString(3, country);
		stmt.setString(4, address);
		stmt.executeUpdate();
		System.out.println("EmpAddress Data inserted successfully for ID=" + id);
		stmt.close();
	}

	public static void insertEmployeeData(Connection con, int id, String name) throws SQLException {
		PreparedStatement stmt = con.prepareStatement(INSERT_EMPLOYEE_QUERY);
		stmt.setInt(1, id);
		stmt.setString(2, name);
		stmt.executeUpdate();
		System.out.println("Emp Data inserted successfully for ID=" + id);
		stmt.close();
	}
}
