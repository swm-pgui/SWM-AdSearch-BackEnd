package com.soma.pgui.service;

import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class openAPIService {

  private final RestTemplate restTemplate = new RestTemplateBuilder().build();
  private final String serviceKey = loadAppKey();
  final String baseURL = "http://apis.data.go.kr/1470000/FoodFlshdErtsInfoService/getFoodFlshdErtsItem";
  final int numberOfRows = 3;
  final String responseType = "json";

  public String loadAppKey() {
    System.out.println("loading App Key");
    String filePath = new File("").getAbsolutePath();
    filePath = filePath + "/src/main/resources/appKey";
    File file = new File(filePath);
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = br.readLine()) != null) {
        return line.trim();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "";
  }

  public String getPostsPlainJSON() {
    String url = "https://jsonplaceholder.typicode.com/posts";
    return this.restTemplate.getForObject(url, String.class);
  }

  public String singleParameter() {
    String url = "https://jsonplaceholder.typicode.com/posts?userId=3";
    int userId = 3;
    return this.restTemplate.getForObject(url, String.class);
  }

  public String multipleParameters() {
    String url = "https://jsonplaceholder.typicode.com/posts/{id}{userId}";
    return this.restTemplate.getForObject(url, String.class, 2, 3);
  }

  public String getFalseAdvertisements() {
    int currentPageNumber = 1;
    int pageNumber = 1;
    String responseString = "";
    try {
      StringBuilder urlBuilder = new StringBuilder(baseURL);
      System.out.println(serviceKey);
      String serviceKeyDecoded = URLDecoder.decode(serviceKey, "UTF-8");
      System.out.println(serviceKeyDecoded);
      urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + URLEncoder.encode(serviceKey, "UTF-8"));
      urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); // pageNumber
      urlBuilder.append("&" + URLEncoder.encode("numberOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); // numberOfRows
      urlBuilder.append("&" + URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); // responseType
      responseString = this.restTemplate.getForObject(urlBuilder.toString(), String.class);
    } catch (Exception e) {
      e.printStackTrace();
    }

    // url appending
    // String url = baseURL;
    // // url += "?ServiceKey=\"" + serviceKey.trim() + "\"";
    // url += "?ServiceKey=" + serviceKeyDecoded;
    // url += "&" + "numberOfRows=" + numberOfRows;
    // url += "&" + "pageNo=" + pageNumber;
    // url += "&" + "type=" + responseType;
    // System.out.println("url: " + url);
    // String responseString = this.restTemplate.getForObject(url, String.class);
    // , serviceKey, pageNumber, numberOfRows,
    // responseType);
    // String toReturn = "";
    System.out.println(responseString);
    // parsing
    JSONArray jArray;
    try {
      JSONObject jObject = new JSONObject(responseString);
      JSONObject jHeadObject = jObject.getJSONObject("header");
      JSONObject jBodyObject = jObject.getJSONObject("body");

      // parsing body
      int pageRequested = jBodyObject.getInt("pageNo");
      int totalCount = jBodyObject.getInt("totalCount");
      int numOfRows = jBodyObject.getInt("numOfRows");

      JSONObject jPageNoObject = jObject.getJSONObject("body");
      JSONArray jItemsArray = jBodyObject.getJSONArray("items");

      for (int i = 0; i < jItemsArray.length(); i++) {
        JSONObject jItemObject = jItemsArray.getJSONObject(i);

        String name = jItemObject.getString("PRDUCT");
        String company = jItemObject.getString("ENTRPS");
        String address = jItemObject.getString("ADRES1");
        // String found_cn = jItemObject.getString("FOUND_CN");
        String disposalDate = jItemObject.getString("DSPS_DT");
        String disposalCommnand = jItemObject.getString("DSPS_CMMND");
        String violationDetail = jItemObject.getString("VIOLT");
        // String violationStatue = jItemObject.getString("?");
        String evidenceFile = jItemObject.getString("EVDNC_FILE");

        // System.out.println("PRDUCT: " + found_cn);
        // System.out.println("ENTRPS: " + entrps);
        // System.out.println("ADRES1: " + adres1);
        // System.out.println("FOUND_CN: " + found_cn);
        // System.out.println("DSPS_DT: " + dsps_dt);
        // System.out.println("DSPS_CMMND: " + dsps_cmmnd);
        // System.out.println("VIOLT: " + violt);
        // System.out.println("EVDNC_FILE: " + evdnc_file);
        // System.out.println("");
      }
    } catch (JSONException e1) {
      e1.printStackTrace();
    }
    return "Success. Check-Out Debug Console";
  }
}