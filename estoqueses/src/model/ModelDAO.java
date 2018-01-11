package model;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class ModelDAO {

	private MysqlDataSource dataSource;

	public ModelDAO() {
		dataSource = new MysqlDataSource();
	}

	public MysqlDataSource init() {
		dataSource.setServerName("localhost");
		dataSource.setPortNumber(3306); // Default
		dataSource.setDatabaseName("db_prods");
		dataSource.setUser("root");
		dataSource.setPassword("123");

		return dataSource;
	}
}
