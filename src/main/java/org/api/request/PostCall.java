package org.api.request;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class PostCall {

	public CloseableHttpResponse makePostCall(URI url, String payload,
			HashMap<String, String> header) throws ClientProtocolException,
			IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost postCall = new HttpPost(url);
		postCall.setEntity(new StringEntity(payload));
		for (Map.Entry<String, String> entry : header.entrySet()) {
			postCall.addHeader(entry.getKey(), entry.getValue());
		}
		CloseableHttpResponse httpResponse = httpClient.execute(postCall);
		return httpResponse;
	}

}
