package com.yididiya.URLshortener.controller;

import com.yididiya.URLshortener.model.URLModel;
import com.yididiya.URLshortener.service.ShortURLService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:3000")
public class ShortUrlController {
    private final ShortURLService shortURLService;


    public ShortUrlController (ShortURLService shortURLService){
        this.shortURLService = shortURLService;
    }
    @GetMapping("/shorturl")
    public List<URLModel> getUrls(){
        return shortURLService.getUrls();
    }

    @PostMapping("/rawUrl")
    public void recieveUserURL(@RequestBody String userURL) {

        System.out.println("Received data: " + userURL.toString());
    }
}
