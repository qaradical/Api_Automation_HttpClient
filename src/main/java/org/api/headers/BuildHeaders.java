package org.api.headers;

import java.util.HashMap;

public class BuildHeaders {

	public static HashMap<String, String> header(){
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("content-type", "application/json");
		return headers;
	}
}
