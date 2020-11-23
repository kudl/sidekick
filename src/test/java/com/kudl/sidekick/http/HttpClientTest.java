package com.kudl.sidekick.http;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientTest {

	@Test
	public void syncRequest() throws IOException, InterruptedException {
		final var request = HttpRequest.newBuilder()
				.uri(URI.create("https://google.com"))
				.build();
		final var client = HttpClient.newHttpClient();

		final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
	}

	@Test
	public void asyncRequest() {
		final var request = HttpRequest.newBuilder()
				.uri(URI.create("https://google.com"))
				.build();
		final var client = HttpClient.newHttpClient();

		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.thenAccept(System.out::println);
	}
}
