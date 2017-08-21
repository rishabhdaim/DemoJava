/**
 * 
 */
package javageeks.dp.facade;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author aa49442
 * 
 */
public class FacadePatternTest {

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		String tableName = "departments";

		// generating MySql HTML report and Oracle PDF report without using
		// Facade
		Connection con = MySqlHelper.getMySqlDBConnection();
		MySqlHelper.generateMySqlHTMLReport(tableName, con);

		if (con != null)
			con.close();
		con = OracleHelper.getOracleDBConnection();
		OracleHelper.generateOracleHTMLReport(tableName, con);
		if (con != null)
			con.close();

		// generating MySql HTML report and Oracle PDF report using Facade
		HelperFacade.generateReport(DBTypes.MYSQL, ReportTypes.HTML, tableName);
		HelperFacade.generateReport(DBTypes.ORACLE, ReportTypes.PDF, tableName);
	}
}