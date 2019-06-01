package org.api.test;

import java.io.IOException;
import java.net.URISyntaxException;

import junit.framework.Assert;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.api.configuration.BuildURI;
import org.api.configuration.GetJsonResponse;
import org.api.headers.BuildHeaders;
import org.api.request.PostCall;
import org.api.util.FileUtil;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Test;

public class VerifyPostCall {

	BuildURI buildUri;
	PostCall postCall;
	FileUtil readJson;
	CloseableHttpResponse httpResponse;
	String request;
	
	public VerifyPostCall() throws IOException{
		buildUri = new BuildURI();
		postCall = new PostCall();
		readJson = new FileUtil();
	}
	
	@Test
	public void makePostCall() throws IOException, URISyntaxException,ParseException{
		
		//Get the payload and store as string
		JSONObject obj = readJson.readJson();
		request = obj.toString();
		
		//Make POST call
		httpResponse = postCall.makePostCall(buildUri.BuildUri(), request, BuildHeaders.header());
		
		//Verify status code
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(HttpStatus.SC_CREATED, statusCode);
		
		//Store response as Json object
		JSONObject resonseJson = GetJsonResponse.getRespose(httpResponse);
		System.out.println(resonseJson);

		//To verify response
		String id = GetJsonResponse.getValueForGivenNode(resonseJson.toString(), "/id");
		System.out.println(id);
		Assert.assertEquals(Integer.parseInt(id), 101);
	}
}