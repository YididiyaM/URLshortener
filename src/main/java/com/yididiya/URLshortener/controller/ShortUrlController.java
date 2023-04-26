package com.yididiya.URLshortener.controller;

import com.yididiya.URLshortener.model.URLModel;
import com.yididiya.URLshortener.service.ShortURLService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/shorturl")
@CrossOrigin(origins = "http://localhost:3000")
public class ShortUrlController {
    private final ShortURLService shortURLService;


    public ShortUrlController (ShortURLService shortURLService){
        this.shortURLService = shortURLService;
    }
    @GetMapping
    public List<URLModel> getUrls(){
        return shortURLService.getUrls();
    }

    @PostMapping("/data")
    public ResponseEntity<String> receiveData(@RequestBody String data) {
        // Do something with the data
        return new ResponseEntity<>("Data received", HttpStatus.OK);
    }
}
