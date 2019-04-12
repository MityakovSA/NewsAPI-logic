package org.androidcourse.network.newsAPI;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.androidcourse.network.newsAPI.constants.*;

import java.io.IOException;
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

    private HttpRequest BuildHttpRequest(Endpoints endpoint, Countries country, Categories category,
                                         Languages language, SortBys sortBy) {
        StringBuilder uri = new StringBuilder(BASE_URL);
        boolean multParam = false;
        switch (endpoint) {
            case top_headlines:
                uri.append("top-headlines?");
                break;
                /*
            case everything:
                uri.append("everything?");
                if (sortBy != null) {
                    uri.append("sortBy=");
                    uri.append(sortBy.toString());
                    multParam = true;
                }
                break;
                */
            case sources:
                uri.append("sources?");
                break;
        }
        if (country != null) {
            if (multParam)
                uri.append("&");
            uri.append("country=");
            uri.append(country.toString());
            multParam = true;
        }
        if (category != null) {
            if (multParam)
                uri.append("&");
            uri.append("category=");
            uri.append(category.toString());
            multParam = true;
        }
        if (language != null) {
            if (multParam)
                uri.append("&");
            uri.append("language=");
            uri.append(language.toString());
        }
        return HttpRequest.newBuilder()
                .uri(URI.create(uri.toString()))
                .header("x-api-key", ApiKey)
                .build();
    }

    private JsonArray SendAndParse(HttpRequest request, Endpoints endpoint) throws IOException, InterruptedException {
        HttpResponse<String> response = Client.send(request, HttpResponse.BodyHandlers.ofString());
        JsonElement element = new JsonParser().parse(response.body());
        if (element.isJsonObject()) {
            JsonObject object = element.getAsJsonObject();
            if (endpoint == Endpoints.sources)
                return object.getAsJsonArray("sources");
            else
                return object.getAsJsonArray("articles");
        }
        return null;
    }

    public JsonArray TopHeadlinesRequest(Countries country, Categories category) throws IOException,
                                                            InterruptedException, NullPointerException {
        if ((country == null) && (category == null))
            throw new NullPointerException("At least one parameter mustn't be null!");
        HttpRequest request = BuildHttpRequest(Endpoints.top_headlines, country, category, null, null);
        return SendAndParse(request, Endpoints.top_headlines);
    }

    /*
    public JsonArray EverythingRequest(Languages language, SortBys sortBy) {
    }
    */

    public JsonArray SourcesRequest(Categories category, Languages language, Countries country)
                                                        throws IOException, InterruptedException {
        HttpRequest request = BuildHttpRequest(Endpoints.sources, country, category, language, null);
        return SendAndParse(request, Endpoints.sources);
    }
}
