package com.foodi.projectfoodingredientsback.searchrcp.controller;


import com.foodi.projectfoodingredientsback.model.FoodRecip;
import com.foodi.projectfoodingredientsback.repository.FoodRecipRepository;
import com.foodi.projectfoodingredientsback.searchrcp.service.SearchRecipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


// 검색 관련 컨트롤러

// 자동완성 리스트 검색 반환해줌

// 메뉴 최대 6개를 받아내자

@RestController
@RequestMapping(value = "search-rcp")
public class SearchController {

    @Autowired
    SearchRecipService searchRecipService;



    // 리스트 형식으로 받아내기
    // 최대 6개
    @GetMapping(value = "ingred-name")
    public List<FoodRecip> findrcpName(
            @RequestParam(required = false) String ingreName1,
            @RequestParam(required = false) String ingreName2,
            @RequestParam(required = false) String ingreName3,
            @RequestParam(required = false) String ingreName4,
            @RequestParam(required = false) String ingreName5,
            @RequestParam(required = false) String ingreName6
    ){

        List<String> inputList = new ArrayList<>();

        System.out.println(ingreName1);

        inputList.add(ingreName1);
        inputList.add(ingreName2);
        inputList.add(ingreName3);
        inputList.add(ingreName4);
        inputList.add(ingreName5);
        inputList.add(ingreName6);

        return searchRecipService.searchRecipDtls(inputList);
    }



}
