package com.foodi.projectfoodingredientsback.searchrcp.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


// 검색 관련 컨트롤러

// 자동완성 리스트 검색 반환해줌

@RestController
public class SearchController {





    @GetMapping(value = "")
    public String findrcpName(){



        return "";
    }



}
