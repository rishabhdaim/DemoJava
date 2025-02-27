package demo.java8.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStmtExample {
	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection(
				"mysql:\\localhost:1520", "root", "root");

		PreparedStatement preparedStatement = connection
				.prepareStatement("select distinct loan_type from loan where bank=?");

		preparedStatement.setString(1, "HSBC");

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next())
			System.out.println(resultSet.getString("loan_type"));
	}
}
