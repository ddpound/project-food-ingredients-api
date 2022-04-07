package com.foodi.projectfoodingredientsback;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainCotroller {

    @GetMapping("/")
    public String mainController(){
        return "서버가 켜져있습니다";
    }


}
