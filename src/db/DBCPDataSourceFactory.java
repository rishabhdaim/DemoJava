/**
 * 
 */
package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * @author Rishabh.Daim
 *
 */
public class DBCPDataSourceFactory {
	
	public static DataSource getDataSource(String dbType) {
		Properties props = new Properties();
		FileInputStream fis = null;
		BasicDataSource ds = new BasicDataSource();
		try {
			fis = new FileInputStream("db.properties");
			props.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		if ("mysql".equals(dbType)) {
			ds.setDriverClassName(props.getProperty("MYSQL_DB_DRIVER_CLASS"));
			ds.setUrl(props.getProperty("MYSQL_DB_URL"));
			ds.setUsername(props.getProperty("MYSQL_DB_USERNAME"));
			ds.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
		} else if ("oracle".equals(dbType)) {
			ds.setDriverClassName(props.getProperty("DB_DRIVER_CLASS"));
			ds.setUrl(props.getProperty("DB_URL"));
			ds.setUsername(props.getProperty("DB_USERNAME"));
			ds.setPassword(props.getProperty("DB_PASSWORD"));
		} else {
			return null;
		}
		return ds;
	}
}
