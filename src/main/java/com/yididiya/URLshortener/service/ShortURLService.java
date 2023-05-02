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
        shortenUrl(userURL);
        System.out.println("recie " + userURL);
        return userURL;
    }

    public Map<String, String> shortenUrl(String userURL){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(userURL.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            System.out.println("shorten url " + userURL);

            String hash = sb.toString();
            String shortURL = hash.substring(0, 8);
            urlMap.put("userURL", userURL);
            urlMap.put("shortURL", shortURL);
            return urlMap;
        } catch (NoSuchAlgorithmException e){
            return null;
        }
    }
    public Map<String, String> getUrlMap() {
        return urlMap;
    }

    public Long getCurrentTimeMilli(){
        long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis;
    }
}
