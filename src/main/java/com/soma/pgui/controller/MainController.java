package com.soma.pgui.controller;

import com.soma.pgui.model.FalseAdItem;
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

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/posts")
    public String postsPlain() {

        String responseString = openAPIService.getPostsPlainJSON();

        // parsing
        JSONArray jArray;
        try {
            jArray = new JSONArray(responseString);
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject jObject = jArray.getJSONObject(i);

                int userId = jObject.getInt("userId");
                int id = jObject.getInt("id");
                String title = jObject.getString("title");
                String body = jObject.getString("body");

                System.out.println("userId: " + userId);
                System.out.println("id: " + id);
                System.out.println("title: " + title);
                System.out.println("body: " + body);
                System.out.println("");
            }
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        return "Check-Out Debug Console";
    }

    @GetMapping("/singleParameter")
    public String singleParameter() {
        System.out.println("singleParameter");
        return openAPIService.singleParameter();
    }

    @GetMapping("/multipleParameters")
    public String multipleParameters() {
        System.out.println("multipleParameters");
        return openAPIService.multipleParameters();
    }

    @GetMapping("/falseAds")
    public String falseAds() {
        System.out.println("falseAds");
        // return openAPIService.getFalseAdvertisements();
        return openAPIService.getFalseAdvertisements().toString();
    }

    @GetMapping("/test")
    public String test() throws UnsupportedEncodingException {
        return openAPIService.test();
    }


}

