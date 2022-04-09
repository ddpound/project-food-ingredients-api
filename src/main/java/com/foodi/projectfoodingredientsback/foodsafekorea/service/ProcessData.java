package com.foodi.projectfoodingredientsback.foodsafekorea.service;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foodi.projectfoodingredientsback.foodsafekorea.jsonmodel.Foodi;
import com.foodi.projectfoodingredientsback.model.FoodIngre;
import com.foodi.projectfoodingredientsback.model.FoodRecip;
import com.foodi.projectfoodingredientsback.repository.FoodIngreRepository;
import com.foodi.projectfoodingredientsback.repository.FoodRecipRepository;
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

    @Autowired
    private FoodRecipRepository foodRecipRepository;

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

        // 레시피 재료명들을 가공하는 리스트
        ArrayList<String> rcpList = new ArrayList<>();

        // 레시피 통째로 담아내는 리스트
        ArrayList<FoodRecip> rcpAllList = new ArrayList<>();

        int startNum = 1;
        int endNum = 1000;

        // 여기서 동시에 DB에 담아주면 된다

        Foodi foodi = getFoodiApiData(startNum,endNum);
        FoodRecip foodRecip ;

        while (foodi != null){

            for(int i =0; i< foodi.getCOOKRCP01().getRow().size() ; i++){
                rcpList.add(foodi.getCOOKRCP01().getRow().get(i).getRCP_PARTS_DTLS());

                foodRecip = new FoodRecip();

                foodRecip.setRcpName(foodi.getCOOKRCP01().getRow().get(i).getRCP_NM());
                foodRecip.setRcpDtls(foodi.getCOOKRCP01().getRow().get(i).getRCP_PARTS_DTLS());
                foodRecip.setHashTag(foodi.getCOOKRCP01().getRow().get(i).getHASH_TAG());
                foodRecip.setAttFileNoMk(foodi.getCOOKRCP01().getRow().get(i).getATT_FILE_NO_MK());

                foodRecip.setManual01(foodi.getCOOKRCP01().getRow().get(i).getMANUAL01());
                foodRecip.setManual02(foodi.getCOOKRCP01().getRow().get(i).getMANUAL02());
                foodRecip.setManual03(foodi.getCOOKRCP01().getRow().get(i).getMANUAL03());
                foodRecip.setManual04(foodi.getCOOKRCP01().getRow().get(i).getMANUAL04());
                foodRecip.setManual05(foodi.getCOOKRCP01().getRow().get(i).getMANUAL05());
                foodRecip.setManual06(foodi.getCOOKRCP01().getRow().get(i).getMANUAL06());
                foodRecip.setManual07(foodi.getCOOKRCP01().getRow().get(i).getMANUAL07());
                foodRecip.setManual08(foodi.getCOOKRCP01().getRow().get(i).getMANUAL08());
                foodRecip.setManual09(foodi.getCOOKRCP01().getRow().get(i).getMANUAL09());
                foodRecip.setManual10(foodi.getCOOKRCP01().getRow().get(i).getMANUAL10());
                foodRecip.setManual11(foodi.getCOOKRCP01().getRow().get(i).getMANUAL11());
                foodRecip.setManual12(foodi.getCOOKRCP01().getRow().get(i).getMANUAL12());
                foodRecip.setManual13(foodi.getCOOKRCP01().getRow().get(i).getMANUAL13());
                foodRecip.setManual14(foodi.getCOOKRCP01().getRow().get(i).getMANUAL14());
                foodRecip.setManual15(foodi.getCOOKRCP01().getRow().get(i).getMANUAL15());
                foodRecip.setManual16(foodi.getCOOKRCP01().getRow().get(i).getMANUAL16());
                foodRecip.setManual17(foodi.getCOOKRCP01().getRow().get(i).getMANUAL17());
                foodRecip.setManual18(foodi.getCOOKRCP01().getRow().get(i).getMANUAL18());
                foodRecip.setManual19(foodi.getCOOKRCP01().getRow().get(i).getMANUAL19());
                foodRecip.setManual20(foodi.getCOOKRCP01().getRow().get(i).getMANUAL20());

                foodRecip.setManualImg01(foodi.getCOOKRCP01().getRow().get(i).getMANUAL_IMG01());
                foodRecip.setManualImg02(foodi.getCOOKRCP01().getRow().get(i).getMANUAL_IMG02());
                foodRecip.setManualImg03(foodi.getCOOKRCP01().getRow().get(i).getMANUAL_IMG03());
                foodRecip.setManualImg04(foodi.getCOOKRCP01().getRow().get(i).getMANUAL_IMG04());
                foodRecip.setManualImg05(foodi.getCOOKRCP01().getRow().get(i).getMANUAL_IMG05());
                foodRecip.setManualImg06(foodi.getCOOKRCP01().getRow().get(i).getMANUAL_IMG06());
                foodRecip.setManualImg07(foodi.getCOOKRCP01().getRow().get(i).getMANUAL_IMG07());
                foodRecip.setManualImg08(foodi.getCOOKRCP01().getRow().get(i).getMANUAL_IMG08());
                foodRecip.setManualImg09(foodi.getCOOKRCP01().getRow().get(i).getMANUAL_IMG09());
                foodRecip.setManualImg10(foodi.getCOOKRCP01().getRow().get(i).getMANUAL_IMG10());
                foodRecip.setManualImg11(foodi.getCOOKRCP01().getRow().get(i).getMANUAL_IMG11());
                foodRecip.setManualImg12(foodi.getCOOKRCP01().getRow().get(i).getMANUAL_IMG12());
                foodRecip.setManualImg13(foodi.getCOOKRCP01().getRow().get(i).getMANUAL_IMG13());
                foodRecip.setManualImg14(foodi.getCOOKRCP01().getRow().get(i).getMANUAL_IMG14());
                foodRecip.setManualImg15(foodi.getCOOKRCP01().getRow().get(i).getMANUAL_IMG15());
                foodRecip.setManualImg16(foodi.getCOOKRCP01().getRow().get(i).getMANUAL_IMG16());
                foodRecip.setManualImg17(foodi.getCOOKRCP01().getRow().get(i).getMANUAL_IMG17());
                foodRecip.setManualImg18(foodi.getCOOKRCP01().getRow().get(i).getMANUAL_IMG18());
                foodRecip.setManualImg19(foodi.getCOOKRCP01().getRow().get(i).getMANUAL_IMG19());
                foodRecip.setManualImg20(foodi.getCOOKRCP01().getRow().get(i).getMANUAL_IMG20());

                rcpAllList.add(foodRecip);
            }

            startNum += 1000;
            endNum += 1000;

            foodi = getFoodiApiData(startNum,endNum);

            if(foodi.getCOOKRCP01().getRow() == null || foodi.getCOOKRCP01().getRow().size() ==0){

                break;
            }


            System.out.println("선회중");
        }

        // 레시피 테이블 통째로 저장
        SaveListFoodRcp(rcpAllList);

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

        //마지막으로 잘들어갔는지확인
        /*for (String i: lastList
             ) {
            System.out.println("인덱스 넘버"+indexNum1);
            System.out.println(i);

            indexNum1 += 1;
        }*/


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
    public void SaveListFoodRcp(ArrayList<FoodRecip> foodRecips){

        foodRecipRepository.saveAll(foodRecips);

    }


    @Transactional
    public void SaveListFoodIngre(ArrayList<String> inputList){

        ArrayList<FoodIngre> foodIngres = new ArrayList<>();

        for (String i : inputList
             ) {
            FoodIngre foodIngre = new FoodIngre();

            if (i.trim().equals("")){
                System.out.println("빈값입니다");
            }else{
                foodIngre.setIngrediName(i);
                foodIngres.add(foodIngre);
            }
        }
        // list 저장 할땐 이거
        foodIngreRepository.saveAll(foodIngres);
    }

    public ArrayList<String> resultList(ArrayList<String> inputList){

        return inputList;
    }



}
