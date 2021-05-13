package com.soma.pgui.service;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.soma.pgui.domain.products.Products;

import com.soma.pgui.dto.products.ProductsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilder;

@Service
@RequiredArgsConstructor
public class openAPIService {

  // 기본 설정들
  final int MAXIMUM_NUMBER_ROWS_PER_PAGE = 100; // 최대 100개 입니다.
  final String responseType = "json"; // 결과를 json 으로 받아봅니다.
  final String callUri = "http://apis.data.go.kr"; // 공공데이터 API base URI
  static boolean isOk = false;

  private final String serviceKey = loadServiceKeyFromResource();

  static ArrayList<Products> products = new ArrayList<Products>();
  private final ProductsService productsService;

//  /// 최대 100개씩 허위광고정보를 가져와서 묶어주는 함수이다
//  public String foodFalsehoodEnterpriseInformationService() throws UnsupportedEncodingException {
//
//    RestTemplate restTemplate = new RestTemplateBuilder().build();
//
//    DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(callUri);
//    uriBuilderFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);
//
//    int currentPageNumber = 1;
//
//    int countAddedProducts = 0;
//    int countTotalProducts = -1;
//    while (countAddedProducts == 0 || (countAddedProducts < countTotalProducts)) {
//
//      UriBuilder uriBuilder = uriBuilderFactory.builder();
//      uriBuilder.path("/1470000/FoodFlshdErtsInfoService/getFoodFlshdErtsItem").queryParam("ServiceKey", serviceKey)
//          .queryParam("pageNo", Integer.toString(currentPageNumber))
//          .queryParam("numOfRows", Integer.toString(MAXIMUM_NUMBER_ROWS_PER_PAGE)).queryParam("type", "json");
//
//      // send request 요청 전송, 응답 수신
//      ResponseEntity responseEntity = restTemplate.exchange(uriBuilder.build(), HttpMethod.GET, null, String.class);
//      String responseString = (String) responseEntity.getBody();
//
//      // parsing response
//      int numOfRows = MAXIMUM_NUMBER_ROWS_PER_PAGE;
//      try {
//        JSONObject jObject = new JSONObject(responseString);
//        JSONObject jHeadObject = jObject.getJSONObject("header");
//        JSONObject jBodyObject = jObject.getJSONObject("body");
//
//        // parsing body
//        int pageRequested = jBodyObject.getInt("pageNo");
//        int totalCount = jBodyObject.getInt("totalCount");
//        numOfRows = jBodyObject.getInt("numOfRows");
//
//        if (countTotalProducts == -1) {
//          countTotalProducts = totalCount;
//          System.out.println("countTotalProducts set to : " + countTotalProducts);
//        }
//
//        JSONArray jItemsArray = jBodyObject.getJSONArray("items");
//
//        for (int i = 0; i < jItemsArray.length(); i++) {
//          JSONObject jItemObject = jItemsArray.getJSONObject(i);
//
//          String name = jItemObject.getString("PRDUCT");
//          String company = jItemObject.getString("ENTRPS");
//          String address = jItemObject.getString("ADRES1");
//          String disposalCommand = jItemObject.getString("DSPS_CMMND");
//          String violationDetail = jItemObject.getString("FOUND_CN");
//          String violationStatue = jItemObject.getString("VIOLT");
//          String disposalDate = jItemObject.getString("DSPS_DT");
//
//
//
//          ProductsSaveRequestDto productsSaveRequestDto = ProductsSaveRequestDto.builder()
//                  .name(name)
//                  .company(company)
//                  .address(address)
//                  .disposalCommand(disposalCommand)
//                  .disposalDate(disposalDate)
//                  .violationDetail(violationDetail)
//                  .violationStatue(violationStatue)
//                  .build();
////          if(isOk)
////            System.out.println(productsSaveRequestDto.toString());
//          Long id = productsService.save(productsSaveRequestDto);
////          if(id >= 2771){
////              isOk = true;
////          }else{
//            System.out.println(id);
////          }
//
//        }
//      } catch (JSONException | ParseException e1) {
//        e1.printStackTrace();
//      }
//
//      currentPageNumber += 1;
//      countAddedProducts += numOfRows;
//    }
//    System.out.println(products.size());
//
//
//    return "success";
//  }

  // utility
  public String loadServiceKeyFromResource() {
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

  public String test() throws ParseException {
    ProductsSaveRequestDto productsSaveRequestDto = ProductsSaveRequestDto.builder()
            .name("t이름")
            .company("tcompany")
            .address("taddress")
            .disposalCommand("tdisposalCommand")
            .disposalDate("tdisposalDate")
            .violationDetail("tviolationDetail")
            .violationStatue("tviolationStatue")
            .build();

    System.out.println(productsService.save(productsSaveRequestDto));
    return "su";
  }
}