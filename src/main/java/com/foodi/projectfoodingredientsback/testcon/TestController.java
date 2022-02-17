package com.foodi.projectfoodingredientsback.testcon;


import com.foodi.projectfoodingredientsback.model.TestTable;
import com.foodi.projectfoodingredientsback.testcon.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class TestController {

    @Autowired
    TestService testService;


    @GetMapping("/test2")
    @ResponseBody
    public String testReturn(){

        return "{\"wow\" : \"test\"}";
    }

    @GetMapping("/test1")
    @ResponseBody
    public String testReturn1(@RequestParam("testValue")int i){
        System.out.println("받은 값"+i);
        return "Test임임임";
    }



}
