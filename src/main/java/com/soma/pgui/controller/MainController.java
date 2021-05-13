package com.soma.pgui.controller;

import java.io.UnsupportedEncodingException;

import com.soma.pgui.service.openAPIService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
