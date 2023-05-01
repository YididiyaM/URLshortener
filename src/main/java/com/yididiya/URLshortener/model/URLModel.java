package com.yididiya.URLshortener.model;

public class URLModel {



    private String userUrl;
    private String shortURL;
    private Long expiration;
    public URLModel(String shortURL, Long expiration) {
        this.userUrl = userUrl;
        this.shortURL = shortURL;
        this.expiration = expiration;
    }

    public String getUserUrl() {
        return userUrl;
    }
    public String getShortURL() {
        return shortURL;
    }

    public Long getExpirationL() {
        return expiration;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public void setShortURL(String shortURL) {
        this.shortURL = shortURL;
    }

    public void setExpiration(Long expiration) {
        this.expiration = expiration;
    }
}
