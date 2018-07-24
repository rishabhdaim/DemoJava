///**
// *
// */
//package db;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import javax.sql.DataSource;
//
///**
// * @author rishabh.daim
// *
// */
//public class DataSourceTest {
//
//	/**
//	 * @param args
//	 * @throws SQLException
//	 * @throws IOException
//	 */
//	public static void main(String[] args) throws IOException, SQLException {
//		//testDataSource("mysql");
//		System.out.println("**********");
//		testDataSource("oracle");
//	}
//
//	/**
//	 * @param dbType
//	 * @throws IOException
//	 * @throws SQLException
//	 */
//	private static void testDataSource(String dbType) throws IOException, SQLException {
//		DataSource ds = null;
//		if ("mysql".equals(dbType))
//			ds = MyDataSourceFactory.getMySQLDataSource();
//		else if ("oracle".equals(dbType))
//			ds = MyDataSourceFactory.getOracleDataSource();
//		else
//			return;
//		try (Connection con = ds.getConnection(); Statement stmt = con.createStatement();) {
//			ResultSet rs = null;
//			rs = stmt.executeQuery("select * from Emp");
//			while (rs.next()) {
//				System.out.println("Employee ID=" + rs.getInt("empid") + ", Name=" + rs.getString("name"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//}