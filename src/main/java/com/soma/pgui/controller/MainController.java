package com.soma.pgui.controller;

import com.soma.pgui.service.openAPIService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
        return openAPIService.getFalseAdvertisements();
    }

}

