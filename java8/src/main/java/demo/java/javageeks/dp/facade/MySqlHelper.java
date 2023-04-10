/**
 * 
 */
package demo.java.javageeks.dp.facade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import demo.java.db.DBConnection;

/**
 * @author rishabh.daim
 * 
 */
public class MySqlHelper {
	public static Connection getMySqlDBConnection() {
		return DBConnection.getConnection();
	}

	public static void generateMySqlPDFReport(String tableName, Connection con)
			throws SQLException {
		PreparedStatement pst = con.prepareStatement("select * from departments");
	//	pst.setString(1, tableName);
		ResultSet rs = pst.executeQuery();
		while (rs.next())
			System.out.println(rs.getInt(1) + " " + rs.getString(2));
	}

	public static void generateMySqlHTMLReport(String tableName, Connection con)
			throws SQLException {
		PreparedStatement pst = con.prepareStatement("select * from departments");
	//	pst.setString(1, tableName);
		ResultSet rs = pst.executeQuery();
		while (rs.next())
			System.out.println(rs.getInt(1) + " " + rs.getString(2));
	}
}
