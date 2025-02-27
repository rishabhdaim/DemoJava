/**
 * 
 */
package demo.java8.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Rishabh.Daim
 *
 */
public class GetUserDetailsUsingPS {

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		// read user entered data
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter email id:");
		String id = scanner.nextLine();
		System.out.println("User id=" + id);
		System.out.println("Please enter password to get details:");
		String pwd = scanner.nextLine();
		System.out.println("User password=" + pwd);
		printUserData(id, pwd);
		scanner.close();
	}

	private static void printUserData(String id, String pwd)
			throws SQLException {
		String query = "select name, country, password from Users where email = ? and password = ?";
		ResultSet rs = null;
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
			// set the parameters..
			ps.setString(1, id);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("Name=" + rs.getString("name") + ",country="
						+ rs.getString("country") + ",password="
						+ rs.getString("password"));
			}
		}
	}
}
