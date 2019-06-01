package org.api.configuration;

import java.io.IOException;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class GetJsonResponse {

	public static JSONObject getRespose(CloseableHttpResponse httpResponse) throws ParseException, IOException, org.json.simple.parser.ParseException{
		String responseString = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
		JSONParser parser = new JSONParser();
		JSONObject jsonResponse = (JSONObject)parser.parse(responseString);
	
		return jsonResponse;	
	}
	
	public static String getValueForGivenNode(String jsonArray, String key) throws JsonProcessingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		JsonNode pageData = mapper.readTree(jsonArray);
		String value = pageData.at(key).toString();
		if(value.contains("\"")){
			return value.replace("\"", "");
		}
		return value;
	}
}
