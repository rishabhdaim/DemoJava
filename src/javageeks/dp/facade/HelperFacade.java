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
public class HelperFacade {
	public static void generateReport(DBTypes dbType, ReportTypes reportType,
			String tableName) throws SQLException {
		Connection con = null;
		switch (dbType) {
		case MYSQL:
			con = MySqlHelper.getMySqlDBConnection();
			switch (reportType) {
			case HTML:
				MySqlHelper.generateMySqlHTMLReport(tableName, con);
				break;
			case PDF:
				MySqlHelper.generateMySqlPDFReport(tableName, con);
			}
			break;
		case ORACLE:
			con = OracleHelper.getOracleDBConnection();
			switch (reportType) {
			case HTML:
				OracleHelper.generateOracleHTMLReport(tableName, con);
				break;
			case PDF:
				OracleHelper.generateOraclePDFReport(tableName, con);
			}
			break;
		}
	}
}