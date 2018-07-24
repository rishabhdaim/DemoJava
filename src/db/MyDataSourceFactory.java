///**
// *
// */
//package db;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import oracle.jdbc.pool.OracleDataSource;
//
//import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
//
///**
// * @author Rishabh.Daim
// *
// */
//public class MyDataSourceFactory {
//
//	public static DataSource getMySQLDataSource() throws IOException {
//		Properties props = new Properties();
//		FileInputStream fis = new FileInputStream("DB.properties");
//		props.load(fis);
//		MysqlDataSource mySqlDS = new MysqlDataSource();
//		mySqlDS.setURL(props.getProperty("MYSQL_DB_URL"));
//		mySqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
//		mySqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
//		return mySqlDS;
//	}
//
//	public static DataSource getOracleDataSource() throws IOException, SQLException {
//		Properties props = new Properties();
//		FileInputStream fis = new FileInputStream("DB.properties");
//		props.load(fis);
//		OracleDataSource oracleDS = new OracleDataSource();
//		oracleDS.setURL(props.getProperty("DB_URL"));
//		oracleDS.setUser(props.getProperty("DB_USERNAME"));
//		oracleDS.setPassword(props.getProperty("DB_PASSWORD"));
//		return oracleDS;
//	}
//}
