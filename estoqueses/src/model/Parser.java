package model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Parser {
	// private static final String arquivoConfiguracao = "config/db.json";
	private static FileReader reader;
	private static FileWriter writer;

	public static JSONObject parseConfig(String arquivoConfiguracao, String getTag) throws ParseException {

		JSONObject temp = null;

		try {
			reader = new FileReader(arquivoConfiguracao);
			JSONParser parser = new JSONParser();
			temp = (JSONObject) parser.parse(reader);
		} catch (IOException e) {
			return (JSONObject) Parser.generateDefaultConfig().get(getTag);
		}

		return (JSONObject) temp.get(getTag);
	}

	public static boolean saveConfig(JSONObject json) {
		try {
			writer = new FileWriter("config/initials.json");
			writer.write(json.toJSONString());
			writer.flush();
			writer.close();

			return true;

		} catch (IOException e) {
			return false;
		}
	}

	public static JSONObject generateDefaultConfig() {
		JSONObject json_1 = new JSONObject();
		JSONObject json_2 = new JSONObject();

		json_1.put("config", "");
		json_2.put("configPath", json_1);

		return json_2;
	}
}
