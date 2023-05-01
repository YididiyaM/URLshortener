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

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(urlMap.get("userURL"));
        String rawUrl = jsonNode.get("rawUrl").asText();
        //String expiration = jsonNode.get("expiration").asText();

            RedirectView redirectView = new RedirectView();
            redirectView.setUrl(rawUrl);
        System.out.println("redirected " + jsonNode);
        return redirectView;
    }

}
