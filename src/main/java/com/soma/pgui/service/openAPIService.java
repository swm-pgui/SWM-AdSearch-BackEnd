package com.soma.pgui.service;

import java.io.*;

import com.soma.pgui.model.FalseAdItem;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilder;

@Service
public class openAPIService {

  private final RestTemplate restTemplate = new RestTemplateBuilder().build();
  private final String appKey = loadAppKey();

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
    return this.restTemplate.getForObject(url, String.class);
  }

  public String multipleParameters() {
    String url = "https://jsonplaceholder.typicode.com/posts/{id}{userId}";
    return this.restTemplate.getForObject(url, String.class, 2, 3);
  }

  public FalseAdItem getFalseAdvertisements() {
    String url = "http://apis.data.go.kr/1470000/FoodFlshdErtsInfoService/getFoodFlshdErtsItem/{ServiceKey}{pageNo}{numberOfRows}{type}";
    String ServiceKey = appKey;
    int pageNo = 1;
    int numberOfRows = 3;
    String type = "json";
    System.out.println("getFalseAdvertisements");
    // return this.restTemplate.getForObject(url, FalseAdItem.class, ServiceKey,
    // pageNo, numberOfRows, type);
    return this.restTemplate.getForObject(url, FalseAdItem.class, ServiceKey, pageNo, numberOfRows, type);
  }

  public String test() throws UnsupportedEncodingException {
    String ServiceKey = appKey;
    int pageNo = 1;
    int numbOfRows = 3;
    String type = "json";


    RestTemplate restTemplate = new RestTemplateBuilder().build();

    String callUri = "http://apis.data.go.kr";

    DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(callUri);
    uriBuilderFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);

    UriBuilder uriBuilder = uriBuilderFactory.builder();
    uriBuilder
            .path("/1470000/FoodFlshdErtsInfoService/getFoodFlshdErtsItem")
            .queryParam("ServiceKey", ServiceKey)
            .queryParam("pageNo", "1")
            .queryParam("numOfRows", "10")
            .queryParam("type", "json");

    ResponseEntity responseEntity = restTemplate.exchange(uriBuilder.build(), HttpMethod.GET, null, String.class);
    String response = (String) responseEntity.getBody();
    System.out.println(response);
    return response;
  }
}