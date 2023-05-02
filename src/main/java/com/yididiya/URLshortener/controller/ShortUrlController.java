package com.yididiya.URLshortener.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yididiya.URLshortener.service.ShortURLService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:3000")
public class ShortUrlController {
    private final ShortURLService shortURLService;


    public ShortUrlController (ShortURLService shortURLService){
        this.shortURLService = shortURLService;
    }
       @PostMapping("/rawUrl")
       public ResponseEntity<String> recieveUserURL(@RequestBody String userURL) {
           String savedUserURL = shortURLService.receiveUrl(userURL);
           return ResponseEntity.ok(userURL);
    }

       @GetMapping("/shortUrl")
        public Map<String, String> getEndPoint(String shortURL) {
        Map<String, String> urlMap = shortURLService.getUrlMap();

        return urlMap;
    }
        @GetMapping("/{shortUrl}")
        public RedirectView redirect(@PathVariable String shortUrl) throws JsonProcessingException {
        Map<String, String> urlMap = shortURLService.getUrlMap();
        long currentTimeMillis = shortURLService.getCurrentTimeMilli();
        ObjectMapper urlObjectMapper = new ObjectMapper();
        JsonNode urlJsonNode = urlObjectMapper.readTree(urlMap.get("userURL"));
        String rawUrl = urlJsonNode.get("rawUrl").asText();

        ObjectMapper expirationObjectMapper = new ObjectMapper();
        JsonNode expirationJsonNode = expirationObjectMapper.readTree(urlMap.get("userURL"));
        Long expiration = expirationJsonNode.get("expiration").asLong();

        Long expirationTime = currentTimeMillis + (expiration * 60 * 1000);

        if (expirationTime != null && System.currentTimeMillis() > expirationTime) {
                RedirectView redirectView = new RedirectView("/expired");
                return redirectView;
            } else {
                RedirectView redirectView = new RedirectView(rawUrl);
               return redirectView;
            }
    }

}
