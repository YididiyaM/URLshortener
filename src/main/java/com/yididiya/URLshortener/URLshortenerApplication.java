package com.yididiya.URLshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class URLshortenerApplication {

    public static void main(String[] args) {
        SpringApplication.run(URLshortenerApplication.class, args);
    }

}
