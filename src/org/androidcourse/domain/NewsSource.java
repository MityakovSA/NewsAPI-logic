package org.androidcourse.domain;

import java.time.Instant;

class NewsSource {
    private String source;
    private String author;
    private String title;
    private String descr;
    private Instant pubAt;
    private String content;

    NewsSource() {}

    void setSource(String source) {
        this.source = source;
    }

    void setAuthor(String author) {
        this.author = author;
    }

    void setTitle(String title) {
        this.title = title;
    }

    void setDescr(String descr) {
        this.descr = descr;
    }

    void setPubAt(String pubAt) {
        this.pubAt = Instant.parse(pubAt);
    }

    void setPubAt(Instant pubAt) {
        this.pubAt = pubAt;
    }

    void setContent(String content) {
        this.content = content;
    }

    String getSource() {
        return source;
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


    Instant getPubAt() {
        return pubAt;
    }

    String getContent() {
        return content;
    }
}
