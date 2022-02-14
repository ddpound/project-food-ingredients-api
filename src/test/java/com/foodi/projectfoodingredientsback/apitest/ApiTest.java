package com.foodi.projectfoodingredientsback.apitest;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

// mockit
// mockit처리
@ExtendWith(MockitoExtension.class)
public class ApiTest {

    @Test
    public void testHello(){
        System.out.println("Hello TEST");
    }
}
