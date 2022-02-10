package com.foodi.projectfoodingredientsback.testcon;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;


// 지금 컨트롤러는 테스트 컨트롤러로 내가 특정 api불러왔을때 받는 값들을 보기위해 만든 controller이다

@RestController
public class TestGetApi {

    @GetMapping(value = "food-api")
    public String testApi(){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity =
                restTemplate.exchange("http://211.237.50.150:7080/openapi/2c0e1e24f4f9deaf8020123574b3e935f4a1734335c032ac2445ec9b03f1214b/json/Grid_20150827000000000227_1/1/100",
                HttpMethod.GET, null ,String.class);





        return responseEntity.getBody();
    }

}
