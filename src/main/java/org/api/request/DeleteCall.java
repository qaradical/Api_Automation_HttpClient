package org.api.request;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class DeleteCall {

	public static CloseableHttpResponse makeDeleteCall(URI uri,
			HashMap<String, String> header) throws ClientProtocolException,
			IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpDelete deleteCall = new HttpDelete(uri);
		for (Map.Entry<String, String> entry : header.entrySet()) {
			deleteCall.addHeader(entry.getKey(), entry.getValue());
		}
		CloseableHttpResponse httpResponse = httpClient.execute(deleteCall);
		return httpResponse;
	}
}
