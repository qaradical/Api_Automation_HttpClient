package org.api.test;

import java.io.IOException;
import java.net.URISyntaxException;

import junit.framework.Assert;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.api.configuration.BuildURI;
import org.api.configuration.GetJsonResponse;
import org.api.headers.BuildHeaders;
import org.api.request.DeleteCall;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Test;

public class VerifyDeleteCall {

	BuildURI buildUri;
	DeleteCall deleteCall;
	CloseableHttpResponse httpResponse;
	
	public VerifyDeleteCall() throws IOException{
		buildUri = new BuildURI();
		deleteCall = new DeleteCall();
	}
	
	@Test
	public void makeGetCall() throws IOException, URISyntaxException,ParseException{
		httpResponse = DeleteCall.makeDeleteCall(buildUri.BuildUri(), BuildHeaders.header());
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(HttpStatus.SC_OK, statusCode);		
		JSONObject resonseJson = GetJsonResponse.getRespose(httpResponse);
		System.out.println(resonseJson);
	}
}
