package com.foodi.projectfoodingredientsback.searchrcp.controller;


import com.foodi.projectfoodingredientsback.model.FoodIngre;
import com.foodi.projectfoodingredientsback.repository.FoodIngreRepository;
import com.foodi.projectfoodingredientsback.searchrcp.service.SearchIngreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 재료검색 컨트롤러

@RestController
@RequestMapping(value = "search-ingre")
public class SearchIngreController {

    @Autowired
    SearchIngreService searchIngreService;

    @GetMapping(value = "name")
    public List<FoodIngre> SearchIngreName(@RequestParam String name){


        return searchIngreService.findFoodIngreName(name);
    }


}
