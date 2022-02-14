package com.foodi.projectfoodingredientsback.testcon.service;

import com.foodi.projectfoodingredientsback.model.TestTable;
import com.foodi.projectfoodingredientsback.repository.TestTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService {

    @Autowired
    TestTableRepository testTableRepository;

    // 인서트 넣기, 추가
    @Transactional
    public int insertTest(TestTable testTable){

        try {
            testTableRepository.save(testTable);

            return 1;
        }catch (Exception e){

            return -1;
        }

    }

    // 삭제
    @Transactional
    public int deleteTest(){

        return 1;
    }

    //읽기
    @Transactional(readOnly = true)
    public TestTable findTTest(int id){

        return null;
    }

    // 수정
    @Transactional
    public int modifyTTest(){
        return 1;
    }


}
