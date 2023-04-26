package com.yididiya.URLshortener.model;

public class URLModel {

    private String rawUrl;
    private String MoreData;
    private String shortenedUrl;

    public URLModel(String rawUrl, String MoreData, String shortenedUrl) {
        this.rawUrl = rawUrl;
        this.MoreData = MoreData;
        this.shortenedUrl = shortenedUrl;
    }

    public String getRawUrl() {
        return rawUrl;
    }

    public String getMoreData() {
        return MoreData;
    }

    public String getShortenedUrl() {
        return shortenedUrl;
    }

   }
