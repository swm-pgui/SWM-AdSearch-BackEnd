package com.soma.pgui.controller;

import java.io.UnsupportedEncodingException;

import com.soma.pgui.service.openAPIService;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilder;

import java.io.UnsupportedEncodingException;

@RestController
public class MainController {

    final openAPIService openAPIService = new openAPIService();

    @GetMapping("/falseAds")
    public String falseAds() throws UnsupportedEncodingException {
        System.out.println("getFalseAdvertisements");
        // return openAPIService.getFalseAdvertisements();
        return openAPIService.foodFalsehoodEnterpriseInformationService();
    }
    
}
