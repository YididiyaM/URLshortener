package com.yididiya.URLshortener.service;

import com.yididiya.URLshortener.model.URLModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ShortURLService {
// so there are two data sets I need, the raw and short url, those are in model
    // The constructor currently only uses raw Url because that is all I need in the beginning (should change that to
    // only the short one since literally all logic is on the short one
    //the controller had the get and post and other "contollers" but it also had the logic were the raw url was instantiated
    // moved that logic to service since that is where logic should be
    // but then need that logic in the controller so created a new service object to get acces to the methods and what not

    @GetMapping()
    public List<URLModel> getUrls(){
        return List.of(new URLModel("reddit.com",
                "more data baby",
                "localhost"));
    }
}

