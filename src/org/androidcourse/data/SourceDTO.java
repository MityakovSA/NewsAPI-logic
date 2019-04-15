package org.androidcourse.data;

import org.androidcourse.network.newsAPI.constants.Categories;
import org.androidcourse.network.newsAPI.constants.Countries;
import org.androidcourse.network.newsAPI.constants.Languages;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Instant;

public final class SourceDTO {
    private final String sid;
    private final String sname;
    private final String author;
    private final String title;
    private final String descr;
    private final URL url;
    private final URL urlToImg;
    private final Instant pubAt;
    private final String content;
    private final Categories category;
    private final Languages language;
    private final Countries country;

    public static class Builder {
        private String sid = null;
        private String sname = null;
        private String author = null;
        private String title = null;
        private String descr = null;
        private URL url = null;
        private URL urlToImg = null;
        private Instant pubAt = null;
        private String content = null;
        private Categories category = null;
        private Languages language = null;
        private Countries country = null;

        public Builder sid(String val) {
            sid = val;
            return this;
        }

        public Builder sname(String val) {
            sname = val;
            return this;
        }

        public Builder author(String val) {
            author = val;
            return this;
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder descr(String val) {
            descr = val;
            return this;
        }

        public Builder url(String val) {
            try {
                url = new URL(val);
            } catch (MalformedURLException e) {
                url = null;
                System.err.println(e.getMessage());
            }
            return this;
        }

        public Builder urlToImg(String val) {
            try {
                urlToImg = new URL(val);
            } catch (MalformedURLException e) {
                urlToImg = null;
                System.err.println(e.getMessage());
            }
            return this;
        }

        public Builder pubAt(String val) {
            pubAt = Instant.parse(val);
            return this;
        }

        public Builder content(String val) {
            content = val;
            return this;
        }

        public Builder category(String val) {
            category = Categories.valueOf(val);
            return this;
        }

        public Builder language(String val) {
            language = Languages.valueOf(val);
            return this;
        }

        public Builder country(String val) {
            country = Countries.valueOf(val);
            return this;
        }

        public SourceDTO build() {
            return new SourceDTO(this);
        }
    }

    SourceDTO(Builder builder) {
        sid = builder.sid;
        sname = builder.sname;
        author = builder.author;
        title = builder.title;
        descr = builder.descr;
        url = builder.url;
        urlToImg = builder.urlToImg;
        pubAt = builder.pubAt;
        content = builder.content;
        category = builder.category;
        language = builder.language;
        country = builder.country;
    }

    String getSid() {
        return sid;
    }

    String getSname() {
        return sname;
    }

    String getAuthor() {
        return author;
    }

    String getTitle() {
        return title;
    }

    String getDescr() {
        return descr;
    }

    URL getUrl() {
        return url;
    }

    URL getUrlToImg() {
        return urlToImg;
    }

    Instant getPubAt() {
        return pubAt;
    }

    String getContent() {
        return content;
    }

    Categories getCategory() {
        return category;
    }

    Languages getLanguage() {
        return language;
    }

    Countries getCountry() {
        return country;
    }
}
