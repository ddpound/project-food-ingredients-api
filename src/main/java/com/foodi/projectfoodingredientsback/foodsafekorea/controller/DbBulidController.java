package com.foodi.projectfoodingredientsback.foodsafekorea.controller;

import com.foodi.projectfoodingredientsback.foodsafekorea.service.ProcessData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DbBulidController {

    @Autowired
    private  ProcessData processData;

    // foodi processController
    @GetMapping(value = "start-process-foodi")
    public String startProcessFoodi(){

        processData.rcpApiProcess();

        return "success Processing";
    }




}
