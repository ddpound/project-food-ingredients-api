package com.foodi.projectfoodingredientsback.testinvironment;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    /*@Autowired
    TestService testService;*/
    // 목 테스트 때문에 주석처리함

    @GetMapping("/test2")
    @ResponseBody
    public String testReturn(){

        return "{\"wow\" : \"test\"}";
    }

    @GetMapping("/test1")
    public String testReturn1(@RequestParam("testValue")int i){
        System.out.println("받은 값"+i);
        return "Test임임임";
    }

    @GetMapping("test3")
    public String testReturn2(){
        return "test야";
    }



}
