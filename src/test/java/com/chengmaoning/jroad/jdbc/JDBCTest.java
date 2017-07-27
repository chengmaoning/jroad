/**
 * 
 */
package com.chengmaoning.jroad.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

import org.junit.Test;

/**
 * @author chengmaoning
 *
 */
public class JDBCTest {

	String url = "jdbc:mysql://localhost:3306/jroad";

	private static final Logger logger = Logger.getLogger("com.chengmaoning.jroad.jdbc.JDBCTest");

	@Test
	public void test() {

		Properties properties = new Properties();
		properties.put("user", "root");
		properties.put("password", "root");

		try {
			Connection connection = DriverManager.getConnection(url, properties);

			Properties clientInfos = connection.getClientInfo();

			DatabaseMetaData metaData = connection.getMetaData();

			System.out.println("network timeout: " + connection.getNetworkTimeout());

			System.out.println("schema: " + connection.getSchema());

			Map<String, Class<?>> typeMap = connection.getTypeMap();

			SQLWarning sqlWarning = connection.getWarnings();

			logger.info("mysql connection established!");
		} catch (SQLException e) {
			e.printStackTrace();
			logger.warning("mysql connection failed!");
		}

	}

}
