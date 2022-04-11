package com.foodi.projectfoodingredientsback.searchrcp.service;


import com.foodi.projectfoodingredientsback.model.FoodIngre;
import com.foodi.projectfoodingredientsback.repository.FoodIngreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SearchIngreService {

    @Autowired
    FoodIngreRepository foodIngreRepository;

    //간단한 검색 메소드
    // 보통 엔터키 들어가기 전에 아래 추천으로 둠
    //  길이가 딱 한글자여야 함 (한글만)
    @Transactional(readOnly = true)
    public List<FoodIngre> foodIngreAutomaticSearch(String name){

        String searchingName = "%"+name +"%";
        return foodIngreRepository.findByIngrediNameLike(searchingName);
    }

    // 정확한 검색
    @Transactional(readOnly = true)
    public List<FoodIngre> findFoodIngreName(String name){

        // 아마 하나만 (name 은 중복될수 없기 때문에)
        return foodIngreRepository.findByIngrediNameLike(name);
    }






}
