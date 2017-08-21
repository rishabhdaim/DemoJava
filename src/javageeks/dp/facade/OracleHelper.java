/**
 * 
 */
package javageeks.dp.facade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBConnection;

/**
 * @author aa49442
 * 
 */
public class OracleHelper {

	public static Connection getOracleDBConnection() {
		// get MySql DB connection using connection parameters return null;
		return DBConnection.getConnection();
	}

	public static void generateOraclePDFReport(String tableName, Connection con)
			throws SQLException {
		PreparedStatement pst = con
				.prepareStatement("select * from ?");
		pst.setString(1, tableName);
		ResultSet rs = pst.executeQuery();
		while (rs.next())
			System.out.println(rs.getInt(1) + " " + rs.getString(2));
	}

	public static void generateOracleHTMLReport(String tableName, Connection con)
			throws SQLException {
		PreparedStatement pst = con
				.prepareStatement("select * from ?");
		pst.setString(1, tableName);
		ResultSet rs = pst.executeQuery();
		while (rs.next())
			System.out.println(rs.getInt(1) + " " + rs.getString(2));
	}
}
