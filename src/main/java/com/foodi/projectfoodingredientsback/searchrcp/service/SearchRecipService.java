package com.foodi.projectfoodingredientsback.searchrcp.service;


import com.foodi.projectfoodingredientsback.model.FoodRecip;
import com.foodi.projectfoodingredientsback.repository.FoodIngreRepository;
import com.foodi.projectfoodingredientsback.repository.FoodRecipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// 레시피 검색 서비스

@Service
public class SearchRecipService {


    // 모든 테이블 다 돌아야함
    @Autowired
    FoodIngreRepository foodIngreRepository;

    @Autowired
    FoodRecipRepository foodRecipRepository;


    // 레시피 검색 , 레시피 안의 재료로 검색하기
    // 재료명 리스트로 받기
    // 선택지 주기 (이재료는 필수, 이재료는 있어도 되고없어도 되고로)
    public List<FoodRecip> searchRecipDtls(List<String> ingredList){


        // 테이블 전부를 가져와야함
        List<FoodRecip>foodRecipList =  foodRecipRepository.findAll();


        // 결과값
        List<FoodRecip> resultFoodRecips = new ArrayList<>();

        // 리스트 한개씩 검색
        // 카운트 하는 식으로
        for (FoodRecip fr : foodRecipList
            ) {
            // 다음 요리로 넘어갈때 카운트 초기화
            int countNum =0;

            for (String i: ingredList
            ) {
                if (i != null){

                    if(fr.getRcpDtls().contains(i)){
                        countNum ++;
                        System.out.println(i + ", 일치 , " + countNum);
                    }
                }

                // 일치하는 메뉴가 3개 이상일때
                if(countNum >= 3){
                    resultFoodRecips.add(fr);
                    countNum=0;
                }

            }

        }









        return resultFoodRecips;
    }


}
