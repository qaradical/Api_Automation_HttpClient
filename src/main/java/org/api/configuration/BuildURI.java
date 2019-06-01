package org.api.configuration;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.utils.URIBuilder;
import org.api.util.FileUtil;

public class BuildURI {

	String host;
	String endPoint;
	String scheme;
	FileUtil fileReader;
	URI uri;

	public BuildURI() throws IOException {
		fileReader = new FileUtil();
		host = fileReader.readProperties("host");
		endPoint = fileReader.readProperties("endPoint");
		scheme = fileReader.readProperties("scheme");
	}

	public URI BuildUri() throws URISyntaxException {
		uri = new URIBuilder()
				.setScheme(scheme)
				.setHost(host)
				.setPath(endPoint)
				.build();

		return uri;
	}
	
	public URI buildUriWithParameter() throws URISyntaxException {
		uri = new URIBuilder()
				.setScheme(scheme)
				.setHost(host)
				.setPath(endPoint)
				.setParameter("id", "1")
				.setParameter("name", "testing")
				.build();

		return uri;
	}
}
