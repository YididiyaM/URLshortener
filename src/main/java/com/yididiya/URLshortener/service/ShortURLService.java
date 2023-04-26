package com.yididiya.URLshortener.service;

import com.yididiya.URLshortener.model.URLModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ShortURLService {
    private final Map<String, String> urlMap = new HashMap<>();

    public String shortenUrl(String userUrl) {
        System.out.println("Received data: " + userUrl);
        String shortUrl = generateRandomString();
        //logic to shorten here
        urlMap.put(userUrl, shortUrl);
        return shortUrl;
    }

}

