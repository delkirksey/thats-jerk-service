package com.del.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;

@RestController
public class YelpController {

    @Autowired
    public YelpController() {
        
    }

    @Autowired
    private Environment env;

    @ModelAttribute
    public void setCORSResponseHeader(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
    }

    @GetMapping(value = "/yelpreviews", produces = "application/json")
    public String getYelpReviews() {
        final String uri = "https://api.yelp.com/v3/businesses/just-jerks-enas-jamaican-grill-loveland/reviews";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("authorization", env.getProperty("yelp.api.key"));
        
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        String result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class).getBody();

        return result;
    }
}
