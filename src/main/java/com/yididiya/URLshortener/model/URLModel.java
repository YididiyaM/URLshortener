package com.yididiya.URLshortener.model;

public class URLModel {

    private String rawUrl;
    public URLModel(String rawUrl) {
        this.rawUrl = rawUrl;
    }

    public String getRawUrl() {
        return rawUrl;
    }
}
