package org.androidcourse.network.newsAPI;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class NewsApiClient {

    private String BASE_URL = "https://newsapi.org/v2/";

    private HttpClient Client;

    private String ApiKey;

    public NewsApiClient(String apiKey) {
        ApiKey = apiKey;
        Client = HttpClient.newHttpClient();
    }

    public String TopHeadlinesRequest() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL+"top-headlines?country=us"))
                .header("x-api-key", ApiKey)
                .build();
        HttpResponse<String> response = Client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
