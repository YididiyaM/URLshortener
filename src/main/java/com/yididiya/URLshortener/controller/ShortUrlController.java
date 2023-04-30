package com.yididiya.URLshortener.controller;

import com.yididiya.URLshortener.service.ShortURLService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/shorturl")
    public String redirect( String shortUrl){
       return "get hash here";
    }

}
