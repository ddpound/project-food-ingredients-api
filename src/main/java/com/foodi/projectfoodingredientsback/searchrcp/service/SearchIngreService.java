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
    @Transactional(readOnly = true)
    public List<FoodIngre> findFoodIngreName(String name){

        String searchingName = "%"+name +"%";
        return foodIngreRepository.findByIngrediNameLike(searchingName);
    }



}
