package org.api.test;

import java.io.IOException;
import java.net.URISyntaxException;

import junit.framework.Assert;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.api.configuration.BuildURI;
import org.api.configuration.GetJsonResponse;
import org.api.headers.BuildHeaders;
import org.api.request.GetCall;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Test;

public class VerifyGetCall {

	BuildURI buildUri;
	GetCall getCall;
	CloseableHttpResponse httpResponse;
	
	public VerifyGetCall() throws IOException{
		buildUri = new BuildURI();
		getCall = new GetCall();
	}
	
	@Test
	public void makeGetCall() throws IOException, URISyntaxException,ParseException{
		//Make Get Call
		httpResponse = getCall.makeGetCall(buildUri.BuildUri(), BuildHeaders.header());
		
		//Verify Status code
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(HttpStatus.SC_OK, statusCode);
		
		JSONObject resonseJson = GetJsonResponse.getRespose(httpResponse);
		System.out.println(resonseJson);

		//To verify value of Json object
		String total = GetJsonResponse.getValueForGivenNode(resonseJson.toString(), "/total");
		System.out.println(total);
		Assert.assertEquals(Integer.parseInt(total), 12);

		//To verify value Json object of Json array
		String name = GetJsonResponse.getValueForGivenNode(resonseJson.toString(), "/data/0/name");
		System.out.println(name);
		Assert.assertEquals(name, "cerulean");
	}
}