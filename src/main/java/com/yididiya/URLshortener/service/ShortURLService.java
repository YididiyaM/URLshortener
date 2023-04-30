package com.yididiya.URLshortener.service;

import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ShortURLService {
    private final Map<String, String> urlMap = new HashMap<>();

    public String receiveUrl(String userURL) {
        System.out.println("Received data: " + userURL);
        String shortUrl = shortenUrl(userURL);
        return userURL;
    }

    public String shortenUrl(String userURL){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(userURL.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }

            String hash = sb.toString();

            String shortURL = hash.substring(0, 8);
            urlMap.put(userURL, shortURL);
            System.out.println("short url" + shortURL);
           return shortURL;
        } catch (NoSuchAlgorithmException e){
            return null;
        }
    }
}

