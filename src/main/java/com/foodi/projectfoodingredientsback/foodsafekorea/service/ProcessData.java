package com.foodi.projectfoodingredientsback.foodsafekorea.service;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foodi.projectfoodingredientsback.foodsafekorea.jsonmodel.Foodi;
import com.foodi.projectfoodingredientsback.model.FoodIngre;
import com.foodi.projectfoodingredientsback.repository.FoodIngreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// 해당 컴포넌트는
// 받아온 데이터들을 입맛대로 가공하는 컴포터는 입니다.


// 레시피를 재료로 만들어내는 가공 서비스가 필요함
// 그중 중복으로 리스트에 똑같은 값이 들어가지 않게 방지
@Component
public class ProcessData {


    @Autowired
    private FoodIngreRepository foodIngreRepository;

    // 한건당 최대 천건 밖에 안됨
    public Foodi getFoodiApiData(int startNum, int endNum){

        RestTemplate restTemplate = new RestTemplate();

        String getApiUrl = "http://openapi.foodsafetykorea.go.kr/api/592e8e68fa084971bce8/COOKRCP01/json/"+startNum+"/"+endNum;

        ResponseEntity<String> responseEntity =
                restTemplate.exchange(getApiUrl, HttpMethod.GET,
                        null, String.class);


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



        return foodi;
    }



    // api로 받아온 레시피를 가공하는 메소드
    // 리스트로 나눠와서 중복 재료 검토
    // 조리식품의 레시피 DB
    public void rcpApiProcess(){
        // 객체 한개의 row값은 최대 1000개임
        // dtls 가 재료

        ArrayList<String> rcpList = new ArrayList<>();

        int startNum = 1;
        int endNum = 1000;


        Foodi foodi = getFoodiApiData(startNum,endNum);

        while (foodi != null){

            for(int i =0; i< foodi.getCOOKRCP01().getRow().size() ; i++){
                rcpList.add(foodi.getCOOKRCP01().getRow().get(i).getRCP_PARTS_DTLS());
            }

            startNum += 1000;
            endNum += 1000;

            foodi = getFoodiApiData(startNum,endNum);

            if(foodi.getCOOKRCP01().getRow() == null || foodi.getCOOKRCP01().getRow().size() ==0){

                break;
            }


            System.out.println("선회중");
        }
        int indexNum =0;

        for (String i: rcpList
             ) {
           /* System.out.println("인덱스 번호"+indexNum);
            System.out.print(i+"\n");
            indexNum += 1;*/
        }

        System.out.println("\n재료의 총 크기 "+rcpList.size());


        // \n 스플릿
        ArrayList<String> firstList = new ArrayList<>();

        // , 쉼표 스플릿
        ArrayList<String> secondList = new ArrayList<>();

        // 숫자, 영어 제거한것
        ArrayList<String> thirdList = new ArrayList<>();

        // 모든 작업이 끝남 중복 작업까지 해서 마지막 제출할 리스트
        ArrayList<String > lastList = new ArrayList<>();

        for (String i: rcpList
        ) {

            // \n 으로 스플릿 한다
            String[] splitList1 = i.split("\\n");
            for (String j : splitList1
                 ) {
                firstList.add(j);
            }

        }

        for (String t : firstList
        ){
            // , 쉼표로 스플릿 한다
            String[] splitList2 = t.split(",");
            for (String i : splitList2
                 ) {
                secondList.add(i);
            }


        }

        // ()괄호, [] 대괄호 와 그 안의 문자열 제거
        // 숫자, 영어 제거

        // 숫자 ^[0-9]*$
        // 영어 ^[a-zA-Z]*$

        for (String s: secondList
             ) {

            // 1차적으로 숫자와 영어를 제거
            s = s.replaceAll("[0-9]", "");
            s = s.replaceAll("[a-zA-Z]", "");
            s= s.replaceAll("[.]", "");
            s= s.replaceAll("[-]", "");
            s = s.replaceAll("[주재료]", "");
            s = s.replaceAll("[:]", "");

            int startNumIndex =0;
            int endNumIndex = 0;

            if(s.contains("(") && s.contains(")")){
                startNumIndex = s.indexOf('(');
                endNumIndex = s.indexOf(')');

                //  substring을 통해서 () 괄호안의 값들을 찾아낸후 그걸 다시
                // replace로 통째로 공백으로 바꿔버린다
                s= s.replace(s. substring(startNumIndex, endNumIndex+1), "");

            }

            if(s.contains("[") && s.contains("]")){
                startNumIndex = s.indexOf('[');
                endNumIndex = s.indexOf(']');

                //  substring을 통해서 () 괄호안의 값들을 찾아낸후 그걸 다시
                // replace로 통째로 공백으로 바꿔버린다
                s= s.replace(s. substring(startNumIndex, endNumIndex+1), "");


            }


            // 이제 띄어쓰기를 기준으로 스트링을 나눈후 가장 첫번째 값을 가져오면 될듯


            String[] splitGap= s.split(" ");
            if(splitGap.length > 1){

                //즉 첫번째가 공백이라면
                if(splitGap[0].length() <= 1 ){
                    s = splitGap[1];
                }else{
                    s = splitGap[0];
                }

            }


            s = s.trim();
            s = s.replaceAll("[^가-힣]","");

            thirdList.add(s);


        }


        /*
        for (String i: thirdList) {
            System.out.println(i);
        }
        */


        int indexNum1 = 0;
        for (String i : thirdList
             ) {
             //System.out.println("인덱스 넘버"+ indexNum1);
            // System.out.println(i);

            if(!lastList.contains(i)){
                lastList.add(i);
            }

            //indexNum1 += 1;
        }


        for (String i: lastList
             ) {
            System.out.println("인덱스 넘버"+indexNum1);
            System.out.println(i);

            indexNum1 += 1;
        }


        /*
        *  1. \n 으로 나누기
        *  2. 짝수 줄만 리스트로 받기
        *  3. 짝수줄을 또 , 로 나누기
        *  4. 그리고 또 " "(공백) 으로 나누고 첫번째 꺼 가져오면 재료 끝
        *  5. 중복이 있는지 체크하기
        */

        SaveListFoodIngre(lastList);

    }

    @Transactional
    public void SaveListFoodIngre(ArrayList<String> inputList){

        ArrayList<FoodIngre> foodIngres = new ArrayList<>();

        for (String i : inputList
             ) {
            FoodIngre foodIngre = new FoodIngre();
            foodIngre.setFoodName(i);

            foodIngres.add(foodIngre);
        }

        // list 저장 할땐 이거
        foodIngreRepository.saveAll(foodIngres);


    }



    public ArrayList<String> resultList(ArrayList<String> inputList){

        return inputList;
    }



}
