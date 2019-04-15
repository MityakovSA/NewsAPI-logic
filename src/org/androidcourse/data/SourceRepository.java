package org.androidcourse.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.androidcourse.network.newsAPI.NewsApiClient;
import org.androidcourse.network.newsAPI.constants.Categories;
import org.androidcourse.network.newsAPI.constants.Countries;
import org.androidcourse.network.newsAPI.constants.Endpoints;
import org.androidcourse.network.newsAPI.constants.Languages;

import java.util.ArrayList;

public class SourceRepository {

    private static final String ApiKey = "0bf4032f91734b81a9e21fcd00e80d54";
    private static final NewsApiClient client = new NewsApiClient(ApiKey);

    public static ArrayList<SourceDTO> getTopHeadlines(Countries country, Categories category) {
        JsonArray news = null;
        try {
            news = client.TopHeadlinesRequest(country, category);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
        ArrayList<SourceDTO> dtoArray = new ArrayList<>();
        for (JsonElement element : news) {
            dtoArray.add(getDTO(Endpoints.top_headlines, element));
        }
        return dtoArray;
    }

    /*
    public static ArrayList<SourceDTO> getEverything(Languages language, SortBys sortBy) {
    }
     */

    public static ArrayList<SourceDTO> getSources(Categories category, Languages language,
                                                  Countries country) {
        JsonArray sources = null;
        try {
            sources = client.SourcesRequest(category, language, country);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
        ArrayList<SourceDTO> dtoArray = new ArrayList<>();
        for (JsonElement element : sources) {
            dtoArray.add(getDTO(Endpoints.sources, element));
        }
        return dtoArray;
    }

    private static SourceDTO getDTO(Endpoints endpoint, JsonElement element) {
        JsonObject object = element.getAsJsonObject();
        if (endpoint == Endpoints.sources) {
            return new SourceDTO.Builder()
                    .sid(object.get("id").isJsonNull() ? null : object.get("id").getAsString())
                    .sname(object.get("name").isJsonNull() ? null : object.get("name").getAsString())
                    .descr(object.get("description").isJsonNull() ? null : object.get("description").getAsString())
                    .url(object.get("url").isJsonNull() ? null : object.get("url").getAsString())
                    .category(object.get("category").isJsonNull() ? null : object.get("category").getAsString())
                    .language(object.get("language").isJsonNull() ? null : object.get("language").getAsString())
                    .country(object.get("country").isJsonNull() ? null : object.get("country").getAsString())
                    .build();
        } else {
            JsonObject source = object.get("source").getAsJsonObject();
            return new SourceDTO.Builder()
                    .sid(source.get("id").isJsonNull() ? null : source.get("id").getAsString())
                    .sname(source.get("name").isJsonNull() ? null : source.get("name").getAsString())
                    .author(object.get("author").isJsonNull() ? null : object.get("author").getAsString())
                    .title(object.get("title").isJsonNull() ? null : object.get("title").getAsString())
                    .descr(object.get("description").isJsonNull() ? null : object.get("description").getAsString())
                    .url(object.get("url").isJsonNull() ? null : object.get("url").getAsString())
                    .url(object.get("urlToImage").isJsonNull() ? null : object.get("urlToImage").getAsString())
                    .pubAt(object.get("publishedAt").isJsonNull() ? null : object.get("publishedAt").getAsString())
                    .content(object.get("content").isJsonNull() ? null : object.get("content").getAsString())
                    .build();
        }
    }
}
