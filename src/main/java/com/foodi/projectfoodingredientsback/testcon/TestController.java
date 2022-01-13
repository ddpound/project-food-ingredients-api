package com.foodi.projectfoodingredientsback.testcon;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test2")
    @ResponseBody
    public String testReturn(){

        return "{\"wow\" : \"test\"}";
    }

    @GetMapping("/test1")
    @ResponseBody
    public String testReturn1(){

        return "Test임";
    }





}
