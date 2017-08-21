/**
 * 
 */
package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author Rishabh.Daim
 *
 */
public class GetUserDetails {

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
		String query = "select name, country, password from Users where email = '"
				+ id + "' and password='" + pwd + "'";
		System.out.println(query);
		try (Connection connection = DBConnection.getConnection();
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(query)) {
			while (rs.next())
				System.out.println("Name=" + rs.getString("name") + ",country="
						+ rs.getString("country") + ",password="
						+ rs.getString("password"));
		}
	}
}