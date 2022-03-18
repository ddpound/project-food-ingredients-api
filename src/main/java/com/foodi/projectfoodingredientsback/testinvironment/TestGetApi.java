package com.foodi.projectfoodingredientsback.testinvironment;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.foodi.projectfoodingredientsback.foodsafekorea.jsonmodel.Foodi;
import com.foodi.projectfoodingredientsback.model.FoodIngre;
import com.foodi.projectfoodingredientsback.testinvironment.service.TestService;
import com.foodi.projectfoodingredientsback.testinvironment.testmodel.*;
import com.foodi.projectfoodingredientsback.testinvironment.testmodel.recipeingre.Root;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    TestService testService;

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

    @GetMapping("test-foodi")
    public String testResponseBody(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));

        String getApiurl = "http://openapi.foodsafetykorea.go.kr/api/592e8e68fa084971bce8/COOKRCP01/json/2/4";


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity =
                restTemplate.exchange(getApiurl ,
                        HttpMethod.GET, null , String.class);

        return responseEntity.getBody();
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

        try {
            foodi = objectMapper.readValue(responseEntity.getBody() , Foodi.class);
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

    // 음식재료이름
    // Recipe ingredient information (레시피 재료정보)
    @GetMapping(value = "food-api")
    public String testApi(){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));


        ObjectMapper objectMapper = new ObjectMapper()
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        Root root = null;


        try {

            // 한번에 1000밖에 안됨
            int startNum = 1;
            int endNum = 1000;
            String apiUrl = "http://211.237.50.150:7080/openapi/2c0e1e24f4f9deaf8020123574b3e935f4a1734335c032ac2445ec9b03f1214b/json/Grid_20150827000000000227_1/"+startNum+"/"+endNum;


            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> responseEntity =
                    restTemplate.exchange(apiUrl,
                            HttpMethod.GET, null , String.class);

            root = objectMapper.readValue(responseEntity.getBody() , Root.class);
            FoodIngre foodIngre = new FoodIngre();

            while(root.getGrid_20150827000000000227_1().getRow().size() != 0){
                System.out.println("루틴 시작");

                for(int i=0; i<root.getGrid_20150827000000000227_1().getRow().size();i++){
                    foodIngre.setROW_NUM(root.getGrid_20150827000000000227_1().getRow().get(i).getROW_NUM());
                    foodIngre.setIRDNT_NM(root.getGrid_20150827000000000227_1().getRow().get(i).getIRDNT_NM());


                    testService.insertFoodiIngre(foodIngre);

                }

                startNum +=1000;
                endNum += 1000;
                apiUrl = "http://211.237.50.150:7080/openapi/2c0e1e24f4f9deaf8020123574b3e935f4a1734335c032ac2445ec9b03f1214b/json/Grid_20150827000000000227_1/"+startNum+"/"+endNum;

                responseEntity =
                        restTemplate.exchange(apiUrl,
                                HttpMethod.GET, null , String.class);

                root = objectMapper.readValue(responseEntity.getBody() , Root.class);
                System.out.println(apiUrl);
                System.out.println("루틴한번끝냄");
            }

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(root);

        return "succed";
    }

}
