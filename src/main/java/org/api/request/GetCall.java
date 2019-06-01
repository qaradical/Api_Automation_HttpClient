package org.api.request;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class GetCall {
	public CloseableHttpResponse makeGetCall(URI uri,HashMap<String, String> header) throws ClientProtocolException,IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet getCall = new HttpGet(uri);
		for (Map.Entry<String, String> entry : header.entrySet()) {
			getCall.addHeader(entry.getKey(), entry.getValue());
		}
		CloseableHttpResponse httpResponse = httpClient.execute(getCall);
		return httpResponse;
	}
}
