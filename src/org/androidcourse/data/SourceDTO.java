package org.androidcourse.data;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Instant;

public class SourceDTO {
    private String sid;
    private String sname;
    private String author;
    private String title;
    private String descr;
    private URL url;
    private URL urlToImg;
    private Instant pubAt;
    private String content;

    SourceDTO() {}

//    SourceDTO(String sid, String sname, String author, String title, String descr,
//              URL url, URL urlToImg, Instant pubAt, String content) {
//        this.sid = sid;
//        this.sname = sname;
//        this.author = author;
//        this.title = title;
//        this.descr = descr;
//        this.url = url;
//        this.urlToImg = urlToImg;
//        this.pubAt = pubAt;
//        this.content = content;
//    }

    void setSid(String sid) {
        this.sid = sid;
    }

    void setSname(String sname) {
        this.sname = sname;
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

    void setUrl(String url) {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }

    void setUrl(URL url) {
        this.url = url;
    }

    void setUrlToImg(String urlToImg) {
        try {
            this.urlToImg = new URL(urlToImg);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }

    void setUrlToImg(URL urlToImg) {
        this.urlToImg = urlToImg;
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
}
