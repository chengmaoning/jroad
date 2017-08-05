/**
 * 
 */
package com.chengmaoning.jroad.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

import org.junit.Test;

import com.mysql.cj.jdbc.MysqlDataSource;

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

	@Test
	public void testDataSource() {

		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setDatabaseName("jroad");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		dataSource.setUrl("jdbc:mysql://localhost:3306/jroad");

		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			logger.info("isolation level: " + connection.getTransactionIsolation());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		logger.info("connection initailized!");

		try {
			connection.setAutoCommit(false);
			String sql1 = "insert into teacher (name,age,sex) values ('Hanmeimei',28,'female')";

			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			statement.executeUpdate(sql1, Statement.RETURN_GENERATED_KEYS);
			ResultSet result = statement.getGeneratedKeys();

			result.next();
			long teacherId = result.getLong(1);

			String sql2 = "insert into student(name,age,address,phone,teacherId) values('ChengNing',28,'Chengdu',15882492440,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.setLong(1, teacherId);
			preparedStatement.execute();

			connection.rollback();

			String readSql = "select * from student";
			ResultSet resultSet = statement.executeQuery(readSql);

			while (resultSet.next()) {
				long id = resultSet.getLong("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String address = resultSet.getString("address");
				resultSet.updateString("address", address + ", Sichuan");
				resultSet.updateRow();
				long phone = resultSet.getLong("phone");

				long teacher = resultSet.getLong("teacherId");
				logger.info("id: " + id + ", name: " + name + ", age: " + age + ", address: " + address + ", phone: "
						+ phone + ", teacherId: " + teacher);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
