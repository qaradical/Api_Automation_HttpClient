package org.api.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileUtil {

	public String readProperties(String key) throws IOException {
		FileReader reader = new FileReader(
				"src/main/java/org/api/configuration/config.properties");
		Properties p = new Properties();
		p.load(reader);
		return p.getProperty(key);
	}

	public JSONObject readJson() throws FileNotFoundException, IOException,
			ParseException {
		JSONParser parser = new JSONParser();
		Object object = parser.parse(new FileReader(
				"src/test/resources/TestData/userData.json"));

		// Convert Object to Json Object
		JSONObject jsonObject = (JSONObject) object;
		return jsonObject;
	}
}
