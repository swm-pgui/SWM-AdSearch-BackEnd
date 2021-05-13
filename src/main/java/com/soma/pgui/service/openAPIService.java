package com.soma.pgui.service;

import java.io.*;

import com.soma.pgui.model.FalseAdItem;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
}