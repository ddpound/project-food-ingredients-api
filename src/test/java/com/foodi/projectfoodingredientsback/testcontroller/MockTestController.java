package com.foodi.projectfoodingredientsback.testcontroller;

import com.foodi.projectfoodingredientsback.testinvironment.TestController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

// 원하는 컨트롤러 클래스만 아랫줄 처럼 등록시킬 수 있다
@WebMvcTest(TestController.class)
@AutoConfigureWebMvc
//@Import({TestService.class, TestTableRepository.class, FoodIngreRepository.class}) // 시켜줘야함
public class MockTestController {


    @Autowired
    private MockMvc mockMvc;

    // 여기서 주의할점은 등록한 컨트롤러 안의 여러 클래스들이 있다면 같이 등록해줘야한다

    @Test
    @DisplayName("이건 테스트이름을 붙이기위한 단순 어노테이션")
    public void controllerTest1() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("http://localhost:5000/test3")
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andExpect(
                MockMvcResultMatchers.content().string("test야")
        ).andDo(MockMvcResultHandlers.print());
    }



}
