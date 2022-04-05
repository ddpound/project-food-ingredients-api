package com.foodi.projectfoodingredientsback.foodsafekorea.controller;

import com.foodi.projectfoodingredientsback.foodsafekorea.service.ProcessData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DbBulidController {

    @Autowired
    private  ProcessData processData;

    // 가장 먼저 하는 작업
    // 레시피에 들어간 재료를 나눠서 데베에 넣는과정임
    // foodi processController
    @GetMapping(value = "start-process-foodi")
    public String startProcessFoodi(){

        try {
            processData.rcpApiProcess();
            return "success Processing";

        }catch (Exception e){
            e.printStackTrace();
            return "Error";
        }

    }

    @GetMapping(value = "save-food-ingredi")
    public String bulidFoodDB(){

        return "Save success";
    }




}
