package demo.java8.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @author Rishabh.Daim
 *
 */
public class DBConnectionTest {

	private static final String QUERY = "select * from Users";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// using try-with-resources to avoid closing resources (boiler plate
		// code)
		try (Connection connection = DBConnection.getConnection();
				Statement statement = connection.prepareStatement(QUERY);
				ResultSet rs = statement.executeQuery(QUERY)) {
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				String password = rs.getString("password");
				System.out.println(id + "," + name + "," + email + ","
						+ country + "," + password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}