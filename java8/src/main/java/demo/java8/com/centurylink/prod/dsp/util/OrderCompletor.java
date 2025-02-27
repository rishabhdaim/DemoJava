package demo.java8.com.centurylink.prod.dsp.util;

import static demo.java8.com.centurylink.prod.dsp.util.DbConstants.DB_CLIENT;
import static demo.java8.com.centurylink.prod.dsp.util.DbConstants.DB_SEPERATOR;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class OrderCompletor {
	private static final Logger logger = Logger.getLogger(OrderCompletor.class.getName());
	private static final Properties dbProperties = new Properties();
	private static final Properties orderIdProps = new Properties();
	private static final Properties loggerProps = new Properties();
	private static Connection dspConnection;
	private static Connection omniVueConnection;
	private static Connection osrConnection;

	static {
		try {
			loggerProps.load(Objects.requireNonNull(OrderCompletor.class.getClassLoader()
					.getResourceAsStream("logger.properties")));
			if (loggerProps.getProperty(DbConstants.LOG_LEVEL, "ALL")
					.equalsIgnoreCase("INFO"))
				logger.setLevel(Level.INFO);
			else
				logger.setLevel(Level.ALL);
			logger.finest("logger properties are loaded and lof level set to : "
					+ logger.getLevel());
			logger.finest("properties loaded from logger.properties are : "
					+ loggerProps.keySet().toString());
			Handler handler = new FileHandler(loggerProps.getProperty(
					DbConstants.LOG_PATH, "orderUpdator.log"),
					Integer.parseInt(loggerProps.getProperty(
							DbConstants.LOG_MAX_SIZE, "1024")),
					Integer.parseInt(loggerProps.getProperty(
							DbConstants.LOG_MAX_FILES, "5")), true);
			Formatter formatter = new SimpleFormatter();
			logger.addHandler(handler);
			handler.setFormatter(formatter);
			dbProperties.load(Objects.requireNonNull(OrderCompletor.class.getClassLoader()
					.getResourceAsStream("dbDetails.properties")));
			logger.finest("Db properties loaded successfully..");
			logger.finest("db properties are : "
					+ dbProperties.keySet().toString());
			Class.forName(dbProperties.getProperty(DbConstants.DB_DRIVER));
			logger.finest("Driver got registered successfully");
			String host = dbProperties.getProperty(DbConstants.DSP_PROD_HOST);
			String port = dbProperties.getProperty(DbConstants.DSP_PROD_PORT);
			String serviceName = dbProperties
					.getProperty(DbConstants.DSP_PROD_SERVICE_NAME);
			String url = DB_CLIENT + host + DB_SEPERATOR + port + DB_SEPERATOR
					+ serviceName;

			logger.finest("Dsp Db details : " + url);
			dspConnection = DriverManager.getConnection(url,
					dbProperties.getProperty(DbConstants.DSP_PROD_USER_NAME),
					dbProperties.getProperty(DbConstants.DSP_PROD_PASSWORD));

			logger.finest("dsp connection made successfully..");
			host = dbProperties.getProperty(DbConstants.OMNIVUE_PROD_HOST);
			port = dbProperties.getProperty(DbConstants.OMNIVUE_PROD_PORT);
			serviceName = dbProperties
					.getProperty(DbConstants.OMNIVUE_PROD_SERVICE_NAME);
			url = DB_CLIENT + host + DB_SEPERATOR + port + DB_SEPERATOR
					+ serviceName;

			logger.finest("OmniVue Db details : " + url);
			omniVueConnection = DriverManager
					.getConnection(
							url,
							dbProperties
									.getProperty(DbConstants.OMNIVUE_PROD_USER_NAME),
							dbProperties
									.getProperty(DbConstants.OMNIVUE_PROD_PASSWORD));

			logger.finest("OmniVue connection made successfully..");
			host = dbProperties.getProperty(DbConstants.OSR_PROD_HOST);
			port = dbProperties.getProperty(DbConstants.OSR_PROD_PORT);
			serviceName = dbProperties
					.getProperty(DbConstants.OSR_PROD_SERVICE_NAME);
			url = DB_CLIENT + host + DB_SEPERATOR + port + DB_SEPERATOR
					+ serviceName;

			logger.finest("Osr Db details : " + url);
			osrConnection = DriverManager.getConnection(url,
					dbProperties.getProperty(DbConstants.OSR_PROD_USER_NAME),
					dbProperties.getProperty(DbConstants.OSR_PROD_PASSWORD));

			logger.finest("Osr connection made successfully..");
			orderIdProps.load(Objects.requireNonNull(OrderCompletor.class.getClassLoader()
					.getResourceAsStream("orderId.properties")));

			logger.finest("order ids loaded successfully..");
			String[] orderIds = orderIdProps.getProperty(DbConstants.ORDER_IDS).split(
					",");
			logger.info("Order ids are : " + Arrays.toString(orderIds));

		} catch (IOException e) {
			logger.severe("dbDetails.properties file is missing..");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			logger.severe("odbc jar is missing..");
			e.printStackTrace();
		} catch (SQLException e) {
			logger.severe("cannot made connection with db..");
			e.printStackTrace();
		} finally {
			if (dspConnection != null)
				try {
					dspConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (omniVueConnection != null)
				try {
					omniVueConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (osrConnection != null)
				try {
					osrConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}
}
