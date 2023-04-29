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
         //  if (!isValidUrl(userURL)) {
              // return ResponseEntity.badRequest().body("Invalid URL");
          // }

           String savedUserURL = shortURLService.recieveUrl(userURL);
           return ResponseEntity.ok(userURL);
    }

      //  @GetMapping("/shorturl")
      //public List<URLModel> getUrls(){
      //  return shortURLService.getUrls();
      //}

}
