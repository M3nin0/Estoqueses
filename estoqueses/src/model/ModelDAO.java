package model;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class ModelDAO {

	private JSONObject parseJson;
	private MysqlDataSource dataSource;

	public ModelDAO() throws IOException, ParseException {
		parseJson = Parser.parseConfig("config/db.json", "db");

		dataSource = new MysqlDataSource();
	}

	public MysqlDataSource init() {

		dataSource.setServerName(parseJson.get("serverName").toString());
		dataSource.setPortNumber(Integer.parseInt(parseJson.get("portNumber").toString()));
		dataSource.setDatabaseName(parseJson.get("databaseName").toString());
		dataSource.setUser(parseJson.get("user").toString());
		dataSource.setPassword(parseJson.get("password").toString());

		return dataSource;
	}
}
