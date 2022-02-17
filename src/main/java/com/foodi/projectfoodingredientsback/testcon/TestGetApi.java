package com.foodi.projectfoodingredientsback.testcon;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.foodi.projectfoodingredientsback.testcon.testmodel.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;


// 지금 컨트롤러는 테스트 컨트롤러로 내가 특정 api불러왔을때 받는 값들을 보기위해 만든 controller이다

@RestController
public class TestGetApi {

    @GetMapping("test-json-object")
    public List<Human> testMGet(){
        String testValue= "[{\"name\":\"ysj\", \"age\":\"28\"},{\"name\":\"ods\", \"age\":\"21\"}]";

        ObjectMapper objectMapper = new ObjectMapper();
        List<Human> testM  = null;

        try {
            testM = objectMapper.readValue( testValue , new TypeReference<List<Human>>(){});
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(testM);


        return testM;
    }



    // 인증키 592e8e68fa084971bce8
    // https://www.foodsafetykorea.go.kr/apiMain.do
    // 조리식품의 레시피 DB
    // 조리식품 api
    @GetMapping(value = "food-reci-api")
    public Foodi TestFoodApi(){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));

        String getApiurl = "http://openapi.foodsafetykorea.go.kr/api/592e8e68fa084971bce8/COOKRCP01/json/2/4";


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity =
                restTemplate.exchange(getApiurl ,
                        HttpMethod.GET, null , String.class);


        ObjectMapper objectMapper = new ObjectMapper()
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        Foodi foodi = null;
        COOKRCP01 cookrcp01 = null;
        List<Row> rows = null;
        Result result =null;

        TestM testM = new TestM();



        try {

            foodi = objectMapper.readValue(responseEntity.getBody() , Foodi.class);
            //rows = objectMapper.readValue( responseEntity.getBody() , new TypeReference<List<Row>>(){});
            //result = objectMapper.readValue(responseEntity.getBody(), Result.class);

            //cookrcp01.setRow(rows);
            //cookrcp01.setRESULT(result);



        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(responseEntity.getBody());
        System.out.println(foodi.getCOOKRCP01().getRow().get(2).getRCP_PARTS_DTLS());
        return foodi;
    }



    // 원재료 api
    // https://data.mafra.go.kr/opendata/data/indexOpenDataDetail.do
    // ?data_id=20150827000000000465&filter_ty=O
    // &getBack=G&sort_id=
    // &s_data_nm=&instt_id=
    // &cl_code=&shareYn=

    @GetMapping(value = "food-api")
    public String testApi(){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity =
                restTemplate.exchange("http://211.237.50.150:7080/openapi/2c0e1e24f4f9deaf8020123574b3e935f4a1734335c032ac2445ec9b03f1214b/json/Grid_20150827000000000227_1/1/100",
                HttpMethod.GET, null , String.class);




        return responseEntity.getBody();
    }

}
